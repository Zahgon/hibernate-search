/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationConfigurationContext;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationStrategy;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationStrategyPreStopContext;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationStrategyStartContext;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.HibernateOrmMapperOutboxPollingSettings;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.OutboxEventProcessingOrder;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.UuidGenerationStrategy;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.impl.HibernateOrmMapperOutboxPollingImplSettings;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentRepositoryProvider;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.DefaultAgentRepository;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.OutboxPollingAgentAdditionalMappingProducer;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.ShardAssignmentDescriptor;
import org.hibernate.search.mapper.orm.outboxpolling.event.impl.DefaultOutboxEventFinder;
import org.hibernate.search.mapper.orm.outboxpolling.event.impl.OutboxEventFinderProvider;
import org.hibernate.search.mapper.orm.outboxpolling.event.impl.OutboxEventOrder;
import org.hibernate.search.mapper.orm.outboxpolling.event.impl.OutboxPollingEventProcessor;
import org.hibernate.search.mapper.orm.outboxpolling.event.impl.OutboxPollingMassIndexerAgent;
import org.hibernate.search.mapper.orm.outboxpolling.event.impl.OutboxPollingOutboxEventAdditionalMappingProducer;
import org.hibernate.search.mapper.orm.outboxpolling.event.impl.OutboxPollingOutboxEventSendingPlan;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.ConfigurationLog;
import org.hibernate.search.mapper.orm.outboxpolling.mapping.impl.OutboxPollingSearchMappingImpl;
import org.hibernate.search.mapper.orm.tenancy.spi.TenancyConfiguration;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgent;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgentCreateContext;
import org.hibernate.search.util.common.impl.Closer;

public class OutboxPollingCoordinationStrategy implements CoordinationStrategy {

    private static final ConfigurationProperty<Boolean> EVENT_PROCESSOR_ENABLED = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_ENABLED).asBoolean().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_EVENT_PROCESSOR_ENABLED).build();

    private static final OptionalConfigurationProperty<Integer> EVENT_PROCESSOR_SHARDS_TOTAL_COUNT = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_SHARDS_TOTAL_COUNT).asIntegerStrictlyPositive().build();

    private static final OptionalConfigurationProperty<List<Integer>> EVENT_PROCESSOR_SHARDS_ASSIGNED = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_SHARDS_ASSIGNED).asIntegerPositiveOrZero().multivalued().build();

    private static final ConfigurationProperty<OutboxEventProcessingOrder> EVENT_PROCESSOR_ORDER = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_ORDER).as(OutboxEventProcessingOrder.class, OutboxEventProcessingOrder::of).withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_EVENT_PROCESSOR_ORDER).build();

    private static final ConfigurationProperty<BeanReference<? extends OutboxPollingInternalConfigurer>> INTERNAL_CONFIGURER = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingImplSettings.CoordinationRadicals.INTERNAL_CONFIGURER).asBeanReference(OutboxPollingInternalConfigurer.class).withDefault(BeanReference.ofInstance(OutboxPollingInternalConfigurer.DEFAULT)).build();

    private OutboxEventFinderProvider finderProvider;

    private AgentRepositoryProvider agentRepositoryProvider;

    private TenancyConfiguration tenancyConfiguration;

    private final Map<String, TenantDelegate> tenantDelegates = new LinkedHashMap<>();

    private OutboxPollingSearchMappingImpl outboxPollingSearchMapping;

    @Override
    public void configure(CoordinationConfigurationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> start(CoordinationStrategyStartContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassIndexerAgent createMassIndexerAgent(PojoMassIndexerAgentCreateContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private TenantDelegate tenantDelegate(String tenantId) {
        TenantDelegate tenantDelegate = tenantDelegates.get(tenantId);
        if (tenantDelegate == null) {
            throw tenancyConfiguration.invalidTenantId(tenantId);
        }
        return tenantDelegate;
    }

    @Override
    public CompletableFuture<?> completion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> preStop(CoordinationStrategyPreStopContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public OutboxPollingSearchMappingImpl outboxPollingSearchMapping() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class TenantDelegate {

        private final String tenantId;

        private ScheduledExecutorService eventProcessorExecutor;

        private List<OutboxPollingEventProcessor> eventProcessors;

        private OutboxPollingMassIndexerAgent.Factory massIndexerAgentFactory;

        private TenantDelegate(String tenantId) {
            this.tenantId = tenantId;
        }

        void start(CoordinationStrategyStartContext context, ConfigurationPropertySource configurationSource) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void initializeEventProcessors(CoordinationStrategyStartContext context, ConfigurationPropertySource configurationSource) {
            OutboxPollingEventProcessor.Factory factory = OutboxPollingEventProcessor.factory(context.mapping(), context.clock(), tenantId, configurationSource);
            boolean shardsStatic = EVENT_PROCESSOR_SHARDS_TOTAL_COUNT.get(configurationSource).isPresent() || EVENT_PROCESSOR_SHARDS_ASSIGNED.get(configurationSource).isPresent();
            List<ShardAssignmentDescriptor> shardAssignmentOrNulls;
            if (shardsStatic) {
                int totalShardCount = EVENT_PROCESSOR_SHARDS_TOTAL_COUNT.getAndMapOrThrow(configurationSource, this::checkTotalShardCount, () -> ConfigurationLog.INSTANCE.missingPropertyForStaticSharding(EVENT_PROCESSOR_SHARDS_ASSIGNED.resolveOrRaw(configurationSource)));
                shardAssignmentOrNulls = EVENT_PROCESSOR_SHARDS_ASSIGNED.getAndMapOrThrow(configurationSource, shardIndices -> toStaticShardAssignments(configurationSource, totalShardCount, shardIndices), () -> ConfigurationLog.INSTANCE.missingPropertyForStaticSharding(EVENT_PROCESSOR_SHARDS_TOTAL_COUNT.resolveOrRaw(configurationSource)));
            } else {
                shardAssignmentOrNulls = Collections.singletonList(null);
            }
            eventProcessorExecutor = context.threadPoolProvider().newScheduledExecutor(shardAssignmentOrNulls.size(), OutboxPollingEventProcessor.namePrefix(tenantId));
            eventProcessors = new ArrayList<>();
            for (ShardAssignmentDescriptor shardAssignmentOrNull : shardAssignmentOrNulls) {
                eventProcessors.add(factory.create(eventProcessorExecutor, finderProvider, agentRepositoryProvider, shardAssignmentOrNull));
            }
            for (OutboxPollingEventProcessor eventProcessor : eventProcessors) {
                eventProcessor.start();
            }
        }

        private Integer checkTotalShardCount(Integer totalShardCount) {
            if (totalShardCount <= 0) {
                throw ConfigurationLog.INSTANCE.invalidTotalShardCount();
            }
            return totalShardCount;
        }

        private List<ShardAssignmentDescriptor> toStaticShardAssignments(ConfigurationPropertySource configurationPropertySource, int totalShardCount, List<Integer> shardIndices) {
            // Remove duplicates
            Set<Integer> uniqueShardIndices = new HashSet<>(shardIndices);
            for (Integer shardIndex : uniqueShardIndices) {
                if (!(0 <= shardIndex && shardIndex < totalShardCount)) {
                    throw ConfigurationLog.INSTANCE.invalidShardIndex(totalShardCount, EVENT_PROCESSOR_SHARDS_TOTAL_COUNT.resolveOrRaw(configurationPropertySource));
                }
            }
            List<ShardAssignmentDescriptor> shardAssignment = new ArrayList<>();
            for (Integer shardIndex : uniqueShardIndices) {
                shardAssignment.add(new ShardAssignmentDescriptor(totalShardCount, shardIndex));
            }
            return shardAssignment;
        }
    }
}
