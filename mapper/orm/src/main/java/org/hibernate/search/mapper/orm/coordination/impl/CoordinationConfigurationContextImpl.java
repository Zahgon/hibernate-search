/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.coordination.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingEventSendingSessionContext;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingQueueEventSendingPlan;
import org.hibernate.search.mapper.orm.bootstrap.spi.HibernateSearchOrmMappingProducer;
import org.hibernate.search.mapper.orm.cfg.HibernateOrmMapperSettings;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationConfigurationContext;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationStrategy;
import org.hibernate.search.mapper.orm.session.impl.ConfiguredAutomaticIndexingStrategy;
import org.hibernate.search.util.common.impl.SuppressingCloser;

public final class CoordinationConfigurationContextImpl implements CoordinationConfigurationContext, AutoCloseable {

    private static final ConfigurationProperty<BeanReference<? extends CoordinationStrategy>> COORDINATION_STRATEGY = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.COORDINATION_STRATEGY).asBeanReference(CoordinationStrategy.class).withDefault(HibernateOrmMapperSettings.Defaults.COORDINATION_STRATEGY).build();

    public static CoordinationConfigurationContextImpl configure(ConfigurationPropertySource propertySource, BeanResolver beanResolver) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final BeanHolder<? extends CoordinationStrategy> strategyHolder;

    private final List<HibernateSearchOrmMappingProducer> mappingProducers = new ArrayList<>();

    private Function<AutomaticIndexingEventSendingSessionContext, AutomaticIndexingQueueEventSendingPlan> senderFactory;

    private boolean enlistsInTransaction = false;

    public CoordinationConfigurationContextImpl(BeanHolder<? extends CoordinationStrategy> strategyHolder) {
        this.strategyHolder = strategyHolder;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reindexInSession() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void sendIndexingEventsTo(Function<AutomaticIndexingEventSendingSessionContext, AutomaticIndexingQueueEventSendingPlan> senderFactory, boolean enlistsInTransaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void mappingProducer(HibernateSearchOrmMappingProducer producer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BeanHolder<? extends CoordinationStrategy> strategyHolder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfiguredAutomaticIndexingStrategy createAutomaticIndexingStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<HibernateSearchOrmMappingProducer> mappingProducers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
