/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.building.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.engine.mapper.mapping.building.spi.BackendsInfo;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappedIndexManagerBuilder;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappedIndexManagerFactory;
import org.hibernate.search.engine.mapper.mapping.building.spi.Mapper;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingAbortedException;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingBuildContext;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingPartialBuildState;
import org.hibernate.search.engine.mapper.model.spi.MappableTypeModel;
import org.hibernate.search.engine.mapper.model.spi.TypeMetadataContributorProvider;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.tenancy.spi.TenancyMode;
import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoImplicitReindexingResolverBuildingHelper;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolver;
import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.BoundRoutingBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.RoutingBindingContextImpl;
import org.hibernate.search.mapper.pojo.bridge.mapping.impl.BridgeResolver;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.RoutingBinder;
import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorBinder;
import org.hibernate.search.mapper.pojo.identity.impl.IdentityMappingMode;
import org.hibernate.search.mapper.pojo.identity.impl.PojoRootIdentityMappingCollector;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoIndexMappingCollectorTypeNode;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoMapperDelegate;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoTypeMetadataContributor;
import org.hibernate.search.mapper.pojo.mapping.impl.AbstractPojoTypeManager;
import org.hibernate.search.mapper.pojo.mapping.impl.PojoIndexedTypeManager;
import org.hibernate.search.mapper.pojo.mapping.impl.PojoMappingDelegateImpl;
import org.hibernate.search.mapper.pojo.mapping.impl.PojoTypeManagerContainer;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoMappingDelegate;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl.PojoTypeAdditionalMetadataProvider;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoEntityTypeAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoIndexedTypeAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoTypeAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.dependency.impl.PojoRoutingIndexingDependencyConfigurationContextImpl;
import org.hibernate.search.mapper.pojo.model.impl.PojoModelTypeRootElement;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.processing.building.impl.PojoIndexingProcessorOriginalTypeNodeBuilder;
import org.hibernate.search.mapper.pojo.reporting.spi.PojoEventContexts;
import org.hibernate.search.mapper.pojo.search.definition.impl.PojoSearchQueryElementRegistry;
import org.hibernate.search.mapper.pojo.search.definition.impl.PojoSearchQueryElementRegistryBuilder;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.SuppressingCloser;

public class PojoMapper<MPBS extends MappingPartialBuildState> implements Mapper<MPBS> {

    private final ContextualFailureCollector failureCollector;

    private final TypeMetadataContributorProvider<PojoTypeMetadataContributor> contributorProvider;

    private final BeanReference<? extends IdentifierBridge<Object>> providedIdentifierBridge;

    private final IdentityMappingMode containedEntityIdentityMappingMode;

    private final TenancyMode tenancyMode;

    private final ReindexOnUpdate defaultReindexOnUpdate;

    private final FailureHandler failureHandler;

    private final ThreadPoolProvider threadPoolProvider;

    private final PojoMapperDelegate<MPBS> delegate;

    private final PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider;

    private final ContainerExtractorBinder extractorBinder;

    private final PojoMappingHelper mappingHelper;

    // Use a LinkedHashSet for deterministic iteration
    private final Set<PojoRawTypeModel<?>> entityTypes = new LinkedHashSet<>();

    private final Set<PojoRawTypeModel<?>> indexedEntityTypes = new LinkedHashSet<>();

    private final Set<PojoRawTypeModel<?>> initialMappedTypes = new LinkedHashSet<>();

    private final PojoTypeManagerContainer.Builder typeManagerContainerBuilder = PojoTypeManagerContainer.builder();

    private PojoSearchQueryElementRegistry searchQueryElementRegistry;

    private boolean closed = false;

    public PojoMapper(MappingBuildContext buildContext, TypeMetadataContributorProvider<PojoTypeMetadataContributor> contributorProvider, PojoBootstrapIntrospector introspector, ContainerExtractorBinder extractorBinder, BridgeResolver bridgeResolver, BeanReference<? extends IdentifierBridge<Object>> providedIdentifierBridge, IdentityMappingMode containedEntityIdentityMappingMode, TenancyMode tenancyMode, ReindexOnUpdate defaultReindexOnUpdate, PojoMapperDelegate<MPBS> delegate) {
        this.failureCollector = buildContext.failureCollector();
        this.contributorProvider = contributorProvider;
        this.containedEntityIdentityMappingMode = containedEntityIdentityMappingMode;
        this.tenancyMode = tenancyMode;
        this.defaultReindexOnUpdate = defaultReindexOnUpdate;
        this.failureHandler = buildContext.failureHandler();
        this.threadPoolProvider = buildContext.threadPoolProvider();
        this.delegate = delegate;
        this.providedIdentifierBridge = providedIdentifierBridge;
        typeAdditionalMetadataProvider = new PojoTypeAdditionalMetadataProvider(buildContext.beanResolver(), contributorProvider);
        this.extractorBinder = extractorBinder;
        PojoIndexModelBinder indexModelBinder = new PojoIndexModelBinder(buildContext, introspector, extractorBinder, bridgeResolver, typeAdditionalMetadataProvider);
        mappingHelper = new PojoMappingHelper(buildContext.beanResolver(), failureCollector, contributorProvider, introspector, typeAdditionalMetadataProvider, indexModelBinder);
    }

    @Override
    public void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void prepareMappedTypes(BackendsInfo backendsInfo) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void prepareEntityOrIndexedType(PojoRawTypeModel<?> rawTypeModel, BackendsInfo backendsInfo) {
        PojoTypeAdditionalMetadata metadata = typeAdditionalMetadataProvider.get(rawTypeModel);
        if (metadata.isEntity()) {
            entityTypes.add(rawTypeModel);
        }
        Optional<PojoIndexedTypeAdditionalMetadata> indexedTypeMetadataOptional = metadata.getIndexedTypeMetadata();
        // Ignore abstract types: indexing will be handled for concrete subtypes.
        if (!rawTypeModel.isAbstract() && indexedTypeMetadataOptional.isPresent()) {
            if (!metadata.getEntityTypeMetadata().isPresent()) {
                throw MappingLog.INSTANCE.missingEntityTypeMetadata(rawTypeModel);
            }
            PojoIndexedTypeAdditionalMetadata indexedTypeMetadata = indexedTypeMetadataOptional.get();
            backendsInfo.collect(indexedTypeMetadata.backendName(), tenancyMode);
            indexedEntityTypes.add(rawTypeModel);
        }
    }

    @Override
    public void mapTypes(MappedIndexManagerFactory indexManagerFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <E> void mapIndexedType(PojoRawTypeModel<E> indexedEntityType, MappedIndexManagerFactory indexManagerFactory) {
        PojoTypeAdditionalMetadata metadata = typeAdditionalMetadataProvider.get(indexedEntityType);
        // This metadata is guaranteed to exist; see prepareEntityOrIndexedType()
        PojoEntityTypeAdditionalMetadata entityTypeMetadata = metadata.getEntityTypeMetadata().get();
        PojoIndexedTypeAdditionalMetadata indexedTypeMetadata = metadata.getIndexedTypeMetadata().get();
        String entityName = entityTypeMetadata.getEntityName();
        String indexName = indexedTypeMetadata.indexName().orElse(entityName);
        MappedIndexManagerBuilder indexManagerBuilder = indexManagerFactory.createMappedIndexManager(mappingHelper, delegate, indexedTypeMetadata.backendName(), indexName, entityName);
        Optional<RoutingBinder> routingBinderOptional = indexedTypeMetadata.routingBinder();
        BoundRoutingBridge<E> routingBridge = null;
        if (routingBinderOptional.isPresent()) {
            PojoBootstrapIntrospector introspector = mappingHelper.introspector();
            PojoModelTypeRootElement<E> pojoModelRootElement = new PojoModelTypeRootElement<>(BoundPojoModelPath.root(indexedEntityType), introspector, typeAdditionalMetadataProvider);
            PojoRoutingIndexingDependencyConfigurationContextImpl<E> dependencyContext = new PojoRoutingIndexingDependencyConfigurationContextImpl<>(introspector, extractorBinder, typeAdditionalMetadataProvider, indexedEntityType);
            routingBridge = new RoutingBindingContextImpl<>(mappingHelper.beanResolver(), introspector, indexedEntityType, pojoModelRootElement, dependencyContext, indexedTypeMetadata.routingBinderParams()).applyBinder(routingBinderOptional.get());
        }
        var identityMappingCollector = new PojoRootIdentityMappingCollector<>(indexedEntityType, mappingHelper, Optional.of(indexManagerBuilder.rootBindingContext()), providedIdentifierBridge);
        var indexingProcessorBuilder = new PojoIndexingProcessorOriginalTypeNodeBuilder<>(BoundPojoModelPath.root(indexedEntityType), mappingHelper, indexManagerBuilder.rootBindingContext(), identityMappingCollector, Collections.emptyList());
        var extendedMappingCollector = delegate.createIndexedTypeExtendedMappingCollector(indexedEntityType, entityName);
        typeManagerContainerBuilder.addIndexed(indexedEntityType, entityName, entityTypeMetadata.getSecondaryEntityName(), identityMappingCollector, extendedMappingCollector, routingBridge, indexingProcessorBuilder, indexManagerBuilder);
        collectIndexMapping(indexedEntityType, indexingProcessorBuilder);
    }

    @Override
    public MPBS prepareBuild() throws MappingAbortedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <T> void collectIndexMapping(PojoRawTypeModel<T> type, PojoIndexMappingCollectorTypeNode collector) {
        for (PojoTypeMetadataContributor contributor : contributorProvider.get(type)) {
            contributor.contributeIndexMapping(collector);
        }
    }

    private <E> void preBuildIndexingProcessorAndCollectDependencies(PojoIndexedTypeManager.Builder<E> builder, PojoImplicitReindexingResolverBuildingHelper helper) {
        var dependencyCollector = helper.createDependencyCollector(builder.typeModel);
        if (builder.routingBridge != null) {
            builder.routingBridge.contributeDependencies(dependencyCollector);
        }
        builder.preBuildIndexingProcessor(dependencyCollector);
    }

    private <E> void preBuildIndexed(PojoIndexedTypeManager.Builder<E> builder, PojoImplicitReindexingResolverBuildingHelper helper) {
        builder.preBuildIdentifierMapping(IdentityMappingMode.REQUIRED);
        builder.reindexingResolver(helper.build(builder.typeModel));
        preBuildOtherMetadata(builder, helper);
        builder.preBuildIndexManager();
    }

    private <E> void preBuildOtherMetadata(AbstractPojoTypeManager.Builder<E> builder, PojoImplicitReindexingResolverBuildingHelper helper) {
        PojoRawTypeModel<E> typeModel = builder.typeModel;
        var loadingBinderRefOptional = typeModel.ascendingSuperTypes().map(superType -> typeAdditionalMetadataProvider.get(superType).getEntityTypeMetadata().map(PojoEntityTypeAdditionalMetadata::getLoadingBinderRef).orElse(null)).filter(Objects::nonNull).findFirst();
        builder.preBuildOtherMetadata(mappingHelper.beanResolver(), mappingHelper.introspector(), helper.isSingleConcreteTypeInEntityHierarchy(typeModel), helper.runtimePathsBuildingHelper(typeModel).pathOrdinals(), loadingBinderRefOptional);
    }

    private <E> void preBuildIfContained(PojoRawTypeModel<E> entityType, PojoImplicitReindexingResolverBuildingHelper reindexingResolverBuildingHelper) {
        // Ignore abstract classes: we create one manager per concrete subclass, which is enough.
        if (entityType.isAbstract() || // Ignore indexed types: those are already taken care of elsewhere.
        typeManagerContainerBuilder.indexed.containsKey(entityType)) {
            return;
        }
        PojoEntityTypeAdditionalMetadata entityTypeMetadata = typeAdditionalMetadataProvider.get(entityType).getEntityTypeMetadata().// This should not be possible since this method is only called for entity types (see caller)
        orElseThrow(() -> new AssertionFailure("Missing metadata for entity type '" + entityType));
        Optional<? extends PojoImplicitReindexingResolver<E>> reindexingResolverOptional = reindexingResolverBuildingHelper.buildOptional(entityType);
        // Ignore types that are not actually contained.
        if (reindexingResolverOptional.isEmpty()) {
            return;
        }
        String entityName = entityTypeMetadata.getEntityName();
        var extendedMappingCollector = delegate.createContainedTypeExtendedMappingCollector(entityType, entityName);
        var identityMappingCollector = new PojoRootIdentityMappingCollector<>(entityType, mappingHelper, Optional.empty(), providedIdentifierBridge);
        var builder = typeManagerContainerBuilder.addContained(entityType, entityName, entityTypeMetadata.getSecondaryEntityName(), identityMappingCollector, extendedMappingCollector);
        collectIndexMapping(entityType, identityMappingCollector.toMappingCollectorRootNode());
        builder.preBuildIdentifierMapping(containedEntityIdentityMappingMode);
        builder.reindexingResolver(reindexingResolverOptional.get());
        preBuildOtherMetadata(builder, reindexingResolverBuildingHelper);
    }
}
