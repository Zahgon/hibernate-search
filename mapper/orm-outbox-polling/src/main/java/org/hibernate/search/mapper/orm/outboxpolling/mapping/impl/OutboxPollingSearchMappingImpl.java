/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.mapping.impl;

import static org.hibernate.search.mapper.orm.outboxpolling.event.impl.OutboxPollingOutboxEventAdditionalMappingProducer.ENTITY_NAME;
import java.util.Set;
import java.util.function.Function;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.hibernate.search.mapper.orm.common.spi.TransactionHelper;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationStrategyStartContext;
import org.hibernate.search.mapper.orm.outboxpolling.event.impl.OutboxEvent;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.ConfigurationLog;
import org.hibernate.search.mapper.orm.outboxpolling.mapping.OutboxPollingSearchMapping;
import org.hibernate.search.mapper.orm.tenancy.spi.TenancyConfiguration;

public class OutboxPollingSearchMappingImpl implements OutboxPollingSearchMapping {

    private static final String COUNT_EVENTS_WITH_STATUS = "select count(e) from " + ENTITY_NAME + " e where e.status = :status";

    private static final String UPDATE_EVENTS_WITH_STATUS = "update " + ENTITY_NAME + " e set e.status = :newStatus where e.status = :status";

    private static final String DELETE_EVENTS_WITH_STATUS = "delete " + ENTITY_NAME + " e where e.status = :status";

    private final TransactionHelper transactionHelper;

    private final SessionFactoryImplementor sessionFactory;

    private final TenancyConfiguration tenancyConfiguration;

    private final Set<String> tenantIds;

    public OutboxPollingSearchMappingImpl(CoordinationStrategyStartContext context, TenancyConfiguration tenancyConfiguration) {
        this.sessionFactory = context.mapping().sessionFactory();
        this.transactionHelper = new TransactionHelper(sessionFactory, null);
        this.tenancyConfiguration = tenancyConfiguration;
        this.tenantIds = this.tenancyConfiguration.tenantIdsOrFail();
    }

    @Override
    public long countAbortedEvents() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("removal")
    public long countAbortedEvents(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long countAbortedEvents(Object tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private long doCountAbortedEvents(Function<SessionFactory, SessionBuilder> sessionCreator) {
        try (Session session = sessionCreator.apply(sessionFactory).openSession()) {
            return transactionHelper.inTransaction((SharedSessionContractImplementor) session, () -> {
                Query<Long> query = session.createQuery(COUNT_EVENTS_WITH_STATUS, Long.class);
                query.setParameter("status", OutboxEvent.Status.ABORTED);
                return query.getSingleResult();
            });
        }
    }

    @Override
    public int reprocessAbortedEvents() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("removal")
    public int reprocessAbortedEvents(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int reprocessAbortedEvents(Object tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private int doReprocessAbortedEvents(Function<SessionFactory, SessionBuilder> sessionCreator) {
        try (Session session = sessionCreator.apply(sessionFactory).openSession()) {
            return transactionHelper.inTransaction((SharedSessionContractImplementor) session, () -> {
                MutationQuery query = session.createMutationQuery(UPDATE_EVENTS_WITH_STATUS);
                query.setParameter("status", OutboxEvent.Status.ABORTED);
                query.setParameter("newStatus", OutboxEvent.Status.PENDING);
                return query.executeUpdate();
            });
        }
    }

    @Override
    public int clearAllAbortedEvents() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("removal")
    public int clearAllAbortedEvents(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int clearAllAbortedEvents(Object tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private int doClearAllAbortedEvents(Function<SessionFactory, SessionBuilder> sessionCreator) {
        try (Session session = sessionCreator.apply(sessionFactory).openSession()) {
            return transactionHelper.inTransaction((SharedSessionContractImplementor) session, () -> {
                MutationQuery query = session.createMutationQuery(DELETE_EVENTS_WITH_STATUS);
                query.setParameter("status", OutboxEvent.Status.ABORTED);
                return query.executeUpdate();
            });
        }
    }

    private void checkNoTenant() {
        if (!tenantIds.isEmpty()) {
            throw ConfigurationLog.INSTANCE.noTenantIdSpecified(tenantIds);
        }
    }

    private void checkTenant(Object tenantId) {
        checkTenant(tenancyConfiguration.convert(tenantId));
    }

    private void checkTenant(String tenantId) {
        if (tenantIds.isEmpty()) {
            throw ConfigurationLog.INSTANCE.multiTenancyNotEnabled(tenantId);
        }
        if (!tenantIds.contains(tenantId)) {
            throw tenancyConfiguration.invalidTenantId(tenantId);
        }
    }
}
