/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.jakarta.batch.core.context.jpa.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.search.jakarta.batch.core.context.jpa.spi.EntityManagerFactoryRegistry;
import org.hibernate.search.jakarta.batch.core.logging.impl.JakartaBatchLog;

/**
 * A registry containing all the currently active (non-closed) session factories
 * that use the same classloader.
 * <p>
 * This implementation has the advantage of not relying on external frameworks
 * (like a dependency injection framework), but has two downsides:
 * <ul>
 * <li>Session factories cannot be instantiated on demand: they must
 * be created <strong>before</strong> being retrieved from the registry.
 * <li>Only session factories created from the same classloader are
 * visible in the registry.
 * </ul>
 *
 * @author Yoann Rodiere
 */
public class ActiveSessionFactoryRegistry implements EntityManagerFactoryRegistry {

    private static final ActiveSessionFactoryRegistry INSTANCE = new ActiveSessionFactoryRegistry();

    private static final String PERSISTENCE_UNIT_NAME_NAMESPACE = "persistence-unit-name";

    private static final String SESSION_FACTORY_NAME_NAMESPACE = "session-factory-name";

    public static ActiveSessionFactoryRegistry getInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Collection<SessionFactoryImplementor> sessionFactories = new HashSet<>();

    private final ConcurrentMap<String, SessionFactoryImplementor> sessionFactoriesByPUName = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, SessionFactoryImplementor> sessionFactoriesByName = new ConcurrentHashMap<>();

    private ActiveSessionFactoryRegistry() {
        // Use getInstance()
    }

    public synchronized void register(SessionFactoryImplementor sessionFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public synchronized void unregister(SessionFactoryImplementor sessionFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized EntityManagerFactory useDefault() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EntityManagerFactory get(String reference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EntityManagerFactory get(String namespace, String reference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
