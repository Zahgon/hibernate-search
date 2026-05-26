/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.session.impl;

import java.util.Optional;
import java.util.function.Function;
import jakarta.transaction.Synchronization;
import org.hibernate.Transaction;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.mapper.orm.automaticindexing.impl.AutomaticIndexingStrategyStartContext;
import org.hibernate.search.mapper.orm.automaticindexing.impl.HibernateOrmIndexingQueueEventSendingPlan;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingEventSendingSessionContext;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingQueueEventSendingPlan;
import org.hibernate.search.mapper.orm.cfg.HibernateOrmMapperSettings;
import org.hibernate.search.mapper.orm.event.impl.HibernateOrmListenerContextProvider;
import org.hibernate.search.mapper.orm.event.impl.HibernateSearchEventListener;
import org.hibernate.search.mapper.orm.logging.impl.ConfigurationLog;
import org.hibernate.search.mapper.orm.logging.impl.DeprecationLog;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.spi.ConfiguredIndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventProcessingPlan;
import org.hibernate.search.util.common.impl.Closer;

public final class ConfiguredAutomaticIndexingStrategy {

    @SuppressWarnings("deprecation")
    private static final OptionalConfigurationProperty<Boolean> AUTOMATIC_INDEXING_ENABLED = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.AUTOMATIC_INDEXING_ENABLED).asBoolean().build();

    private static final OptionalConfigurationProperty<Boolean> INDEXING_LISTENERS_ENABLED = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.INDEXING_LISTENERS_ENABLED).asBoolean().build();

    @SuppressWarnings("deprecation")
    private static final OptionalConfigurationProperty<Boolean> AUTOMATIC_INDEXING_ENABLED_LEGACY_STRATEGY = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.AUTOMATIC_INDEXING_STRATEGY).as(Boolean.class, v -> !org.hibernate.search.mapper.orm.automaticindexing.AutomaticIndexingStrategyName.NONE.equals(org.hibernate.search.mapper.orm.automaticindexing.AutomaticIndexingStrategyName.of(v))).build();

    @SuppressWarnings("deprecation")
    private static final OptionalConfigurationProperty<BeanReference<? extends org.hibernate.search.mapper.orm.automaticindexing.session.AutomaticIndexingSynchronizationStrategy>> AUTOMATIC_INDEXING_SYNCHRONIZATION_STRATEGY = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.AUTOMATIC_INDEXING_SYNCHRONIZATION_STRATEGY).asBeanReference(org.hibernate.search.mapper.orm.automaticindexing.session.AutomaticIndexingSynchronizationStrategy.class).build();

    private static final OptionalConfigurationProperty<BeanReference<? extends IndexingPlanSynchronizationStrategy>> INDEXING_PLAN_SYNCHRONIZATION_STRATEGY = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.INDEXING_PLAN_SYNCHRONIZATION_STRATEGY).asBeanReference(IndexingPlanSynchronizationStrategy.class).build();

    @SuppressWarnings("deprecation")
    private static final ConfigurationProperty<Boolean> AUTOMATIC_INDEXING_ENABLE_DIRTY_CHECK = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.AUTOMATIC_INDEXING_ENABLE_DIRTY_CHECK).asBoolean().withDefault(HibernateOrmMapperSettings.Defaults.AUTOMATIC_INDEXING_ENABLE_DIRTY_CHECK).build();

    private final Function<AutomaticIndexingEventSendingSessionContext, AutomaticIndexingQueueEventSendingPlan> senderFactory;

    private final boolean enlistsInTransaction;

    private HibernateOrmSearchSessionMappingContext mappingContext;

    private BeanHolder<? extends IndexingPlanSynchronizationStrategy> defaultSynchronizationStrategyHolder;

    private ConfiguredIndexingPlanSynchronizationStrategy defaultSynchronizationStrategy;

    public ConfiguredAutomaticIndexingStrategy(Function<AutomaticIndexingEventSendingSessionContext, AutomaticIndexingQueueEventSendingPlan> senderFactory, boolean enlistsInTransaction) {
        this.senderFactory = senderFactory;
        this.enlistsInTransaction = enlistsInTransaction;
    }

    public boolean usesAsyncProcessing() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Do everything related to runtime configuration or that doesn't involve I/O
    public void start(HibernateOrmSearchSessionMappingContext mappingContext, AutomaticIndexingStrategyStartContext startContext, HibernateOrmListenerContextProvider contextProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void resolveDefaultSyncStrategyHolder(AutomaticIndexingStrategyStartContext startContext) {
        ConfigurationPropertySource configurationSource = startContext.configurationPropertySource();
        boolean legacyStrategySet = AUTOMATIC_INDEXING_SYNCHRONIZATION_STRATEGY.get(configurationSource).isPresent();
        boolean newStrategySet = INDEXING_PLAN_SYNCHRONIZATION_STRATEGY.get(configurationSource).isPresent();
        if (legacyStrategySet && newStrategySet) {
            throw DeprecationLog.INSTANCE.bothNewAndOldConfigurationPropertiesForIndexingPlanSyncAreUsed(INDEXING_PLAN_SYNCHRONIZATION_STRATEGY.resolveOrRaw(configurationSource), AUTOMATIC_INDEXING_SYNCHRONIZATION_STRATEGY.resolveOrRaw(configurationSource));
        }
        if (usesAsyncProcessing()) {
            if (legacyStrategySet || newStrategySet) {
                // If we send events to a queue, we're mostly asynchronous
                // and thus configuring the synchronization strategy does not make sense.
                throw ConfigurationLog.INSTANCE.cannotConfigureSynchronizationStrategyWithIndexingEventQueue();
            }
            // We force the synchronization strategy to sync.
            // The commit/refresh strategies will be ignored,
            // but we're only interested in the future handler:
            // we need it to block until the sender is done pushing events to the queue.
            defaultSynchronizationStrategyHolder = BeanHolder.of(IndexingPlanSynchronizationStrategy.writeSync());
        } else if (legacyStrategySet) {
            @SuppressWarnings("deprecation")
            BeanHolder<? extends org.hibernate.search.mapper.orm.automaticindexing.session.AutomaticIndexingSynchronizationStrategy> holder = // Going through the config property source again in order to get context if an error occurs.
            AUTOMATIC_INDEXING_SYNCHRONIZATION_STRATEGY.getAndMap(configurationSource, reference -> {
                DeprecationLog.INSTANCE.automaticIndexingSynchronizationStrategyIsDeprecated(AUTOMATIC_INDEXING_SYNCHRONIZATION_STRATEGY.resolveOrRaw(configurationSource), INDEXING_PLAN_SYNCHRONIZATION_STRATEGY.resolveOrRaw(configurationSource));
                return startContext.beanResolver().resolve(reference);
            }).// We know this optional is not empty
            get();
            defaultSynchronizationStrategyHolder = BeanHolder.of(new HibernateOrmIndexingPlanSynchronizationStrategyAdapter(holder.get())).withDependencyAutoClosing(holder);
        } else {
            // Going through the config property source again in order to get context if an error occurs.
            defaultSynchronizationStrategyHolder = INDEXING_PLAN_SYNCHRONIZATION_STRATEGY.getAndTransform(configurationSource, referenceOptional -> startContext.beanResolver().resolve(referenceOptional.orElse(HibernateOrmMapperSettings.Defaults.INDEXING_PLAN_SYNCHRONIZATION_STRATEGY)));
        }
    }

    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfiguredIndexingPlanSynchronizationStrategy defaultIndexingPlanSynchronizationStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfiguredIndexingPlanSynchronizationStrategy configureOverriddenSynchronizationStrategy(IndexingPlanSynchronizationStrategy synchronizationStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoIndexingPlan createIndexingPlan(HibernateOrmSearchSession context, ConfiguredIndexingPlanSynchronizationStrategy synchronizationStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Synchronization createTransactionWorkQueueSynchronization(PojoIndexingPlan indexingPlan, HibernateOrmSearchSessionExtension sessionExtension, Transaction transactionIdentifier, ConfiguredIndexingPlanSynchronizationStrategy synchronizationStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoIndexingQueueEventProcessingPlan createIndexingQueueEventProcessingPlan(HibernateOrmSearchSession context, ConfiguredIndexingPlanSynchronizationStrategy synchronizationStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ConfiguredIndexingPlanSynchronizationStrategy configure(IndexingPlanSynchronizationStrategy synchronizationStrategy) {
        ConfiguredIndexingPlanSynchronizationStrategy.Builder builder = new ConfiguredIndexingPlanSynchronizationStrategy.Builder(mappingContext.failureHandler());
        synchronizationStrategy.apply(builder);
        return builder.build();
    }
}
