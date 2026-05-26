/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.common.spi;

import java.util.function.Supplier;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.Status;
import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;
import org.hibernate.search.mapper.orm.common.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.logging.impl.OrmMiscLog;
import org.hibernate.service.spi.ServiceRegistryImplementor;

/**
 * A helper to abstract away all the complexity of starting transactions in different environments
 * (JTA/non-JTA in particular),
 * while accepting some JTA-specific settings (transaction timeout) on a best-effort basis.
 */
public final class TransactionHelper {

    private final TransactionManager transactionManager;

    private final boolean useJta;

    private final Integer transactionTimeout;

    public TransactionHelper(SessionFactoryImplementor sessionFactory, Integer transactionTimeout) {
        ServiceRegistryImplementor serviceRegistry = sessionFactory.getServiceRegistry();
        transactionManager = HibernateOrmUtils.getServiceOrFail(serviceRegistry, JtaPlatform.class).retrieveTransactionManager();
        TransactionCoordinatorBuilder transactionCoordinatorBuilder = HibernateOrmUtils.getServiceOrFail(serviceRegistry, TransactionCoordinatorBuilder.class);
        this.useJta = shouldUseJta(transactionManager, transactionCoordinatorBuilder);
        this.transactionTimeout = transactionTimeout;
    }

    public void inTransaction(SharedSessionContractImplementor session, Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> T inTransaction(SharedSessionContractImplementor session, Supplier<T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void begin(SharedSessionContractImplementor session) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void commit(SharedSessionContractImplementor session) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void rollbackSafely(SharedSessionContractImplementor session, Throwable t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void rollback(SharedSessionContractImplementor session) {
        try {
            if (useJta) {
                transactionManager.rollback();
            } else {
                session.accessTransaction().rollback();
            }
        } catch (Exception e) {
            throw OrmMiscLog.INSTANCE.transactionHandlingException(e.getMessage(), e);
        }
    }

    private static boolean shouldUseJta(TransactionManager transactionManager, TransactionCoordinatorBuilder transactionCoordinatorBuilder) {
        if (!transactionCoordinatorBuilder.isJta()) {
            //Today we only require a TransactionManager on JTA based transaction factories
            OrmMiscLog.INSTANCE.transactionManagerNotRequired();
            return false;
        }
        if (transactionManager == null) {
            //no TM, nothing to do OR configuration mistake
            OrmMiscLog.INSTANCE.transactionManagerNotFound();
            return false;
        }
        try {
            if (transactionManager.getStatus() == Status.STATUS_NO_TRANSACTION) {
                OrmMiscLog.INSTANCE.noInProgressTransaction();
                return true;
            }
        } catch (SystemException e) {
            OrmMiscLog.INSTANCE.cannotGuessTransactionStatus(e);
            return false;
        }
        OrmMiscLog.INSTANCE.transactionAlreadyInProgress();
        return false;
    }
}
