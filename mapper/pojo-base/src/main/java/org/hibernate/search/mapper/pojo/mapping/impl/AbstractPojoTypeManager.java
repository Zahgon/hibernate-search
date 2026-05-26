/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.bean.spi.ParameterizedBeanReference;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolver;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverRootContext;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoReindexingCollector;
import org.hibernate.search.mapper.pojo.identity.impl.BoundIdentifierMapping;
import org.hibernate.search.mapper.pojo.identity.impl.IdentifierMappingImplementor;
import org.hibernate.search.mapper.pojo.identity.impl.IdentityMappingMode;
import org.hibernate.search.mapper.pojo.identity.impl.PojoRootIdentityMappingCollector;
import org.hibernate.search.mapper.pojo.loading.definition.spi.PojoEntityLoadingBindingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassLoadingStrategy;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingStrategy;
import org.hibernate.search.mapper.pojo.logging.impl.IndexingLog;
import org.hibernate.search.mapper.pojo.logging.impl.PojoMapperMiscLog;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoTypeExtendedMappingCollector;
import org.hibernate.search.mapper.pojo.model.PojoModelElement;
import org.hibernate.search.mapper.pojo.model.impl.PojoModelValueElement;
import org.hibernate.search.mapper.pojo.model.path.impl.PojoPathOrdinals;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoCaster;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;
import org.hibernate.search.mapper.pojo.work.impl.CachingCastingEntitySupplier;
import org.hibernate.search.mapper.pojo.work.impl.PojoWorkTypeContext;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.Contracts;
import org.hibernate.search.util.common.spi.ToStringTreeAppendable;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * @param <I> The identifier type for the entity type.
 * @param <E> The entity type.
 */
public abstract class AbstractPojoTypeManager<I, E> implements AutoCloseable, ToStringTreeAppendable, PojoWorkTypeContext<I, E> {

    protected final PojoRawTypeIdentifier<E> typeIdentifier;

    private final List<PojoRawTypeIdentifier<? super E>> ascendingSuperTypes;

    protected final PojoCaster<E> caster;

    protected final String entityName;

    protected final String secondaryEntityName;

    private final boolean singleConcreteTypeInEntityHierarchy;

    protected final IdentifierMappingImplementor<I, E> identifierMapping;

    private final PojoPathOrdinals pathOrdinals;

    protected final PojoImplicitReindexingResolver<E> reindexingResolver;

    private final Optional<PojoSelectionLoadingStrategy<? super E>> selectionLoadingStrategyOptional;

    private final Optional<PojoMassLoadingStrategy<? super E, ?>> massLoadingStrategyOptional;

    private final boolean hasNonIndexedConcreteSubtypes;

    public AbstractPojoTypeManager(Builder<E> builder, IdentifierMappingImplementor<I, E> identifierMapping) {
        this.typeIdentifier = builder.typeModel.typeIdentifier();
        this.ascendingSuperTypes = builder.typeModel.ascendingSuperTypes().map(PojoRawTypeModel::typeIdentifier).collect(Collectors.toUnmodifiableList());
        this.caster = builder.typeModel.caster();
        this.entityName = builder.entityName;
        this.secondaryEntityName = builder.secondaryEntityName;
        this.singleConcreteTypeInEntityHierarchy = builder.singleConcreteTypeInEntityHierarchy;
        this.identifierMapping = identifierMapping;
        this.pathOrdinals = builder.pathOrdinals;
        this.reindexingResolver = builder.reindexingResolver;
        this.selectionLoadingStrategyOptional = Optional.ofNullable(builder.selectionLoadingStrategy);
        this.massLoadingStrategyOptional = Optional.ofNullable(builder.massLoadingStrategy);
        this.hasNonIndexedConcreteSubtypes = builder.hasNonIndexedConcreteSubtypes;
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PojoRawTypeIdentifier<E> typeIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final List<PojoRawTypeIdentifier<? super E>> ascendingSuperTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<PojoIndexedTypeManager<I, E>> asIndexed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<PojoContainedTypeManager<I, E>> asContained() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String entityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String secondaryEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<?> javaClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean loadingAvailable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isSingleConcreteTypeInEntityHierarchy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IdentifierMappingImplementor<I, E> identifierMapping() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toDocumentIdentifier(PojoWorkSessionContext sessionContext, I identifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoPathOrdinals pathOrdinals() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoImplicitReindexingResolver<E> reindexingResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public E toEntity(Object unproxiedEntity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Supplier<E> toEntitySupplier(PojoWorkSessionContext sessionContext, Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void resolveEntitiesToReindex(PojoReindexingCollector collector, PojoWorkSessionContext sessionContext, Object identifier, Supplier<E> entitySupplier, PojoImplicitReindexingResolverRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoSelectionLoadingStrategy<? super E> selectionLoadingStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<PojoSelectionLoadingStrategy<? super E>> selectionLoadingStrategyOptional() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassLoadingStrategy<? super E, ?> massLoadingStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<PojoMassLoadingStrategy<? super E, ?>> massLoadingStrategyOptional() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasNonIndexedConcreteSubtypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract static class Builder<E> {

        public final PojoRawTypeModel<E> typeModel;

        private final String entityName;

        private final String secondaryEntityName;

        private PojoRootIdentityMappingCollector<E> identityMappingCollector;

        protected BoundIdentifierMapping<?, E> identifierMapping;

        private PojoImplicitReindexingResolver<E> reindexingResolver;

        private Boolean singleConcreteTypeInEntityHierarchy;

        private PojoPathOrdinals pathOrdinals;

        private PojoSelectionLoadingStrategy<? super E> selectionLoadingStrategy;

        private PojoMassLoadingStrategy<? super E, ?> massLoadingStrategy;

        private boolean hasNonIndexedConcreteSubtypes = false;

        protected boolean closed = false;

        Builder(PojoRawTypeModel<E> typeModel, String entityName, String secondaryEntityName, PojoRootIdentityMappingCollector<E> identityMappingCollector) {
            this.typeModel = typeModel;
            this.entityName = entityName;
            this.secondaryEntityName = secondaryEntityName;
            this.identityMappingCollector = identityMappingCollector;
        }

        public final void closeOnFailure() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected void doCloseOnFailure(Closer<RuntimeException> closer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected abstract PojoTypeExtendedMappingCollector extendedMappingCollector();

        public void preBuildIdentifierMapping(IdentityMappingMode identityMappingMode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void reindexingResolver(PojoImplicitReindexingResolver<E> reindexingResolver) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void preBuildOtherMetadata(BeanResolver beanResolver, PojoBootstrapIntrospector introspector, boolean singleConcreteTypeInEntityHierarchy, PojoPathOrdinals pathOrdinals, Optional<? extends ParameterizedBeanReference<?>> loadingBinderRefOptional) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void preBuildLoadingConfiguration(BeanResolver beanResolver, PojoBootstrapIntrospector introspector, Optional<? extends ParameterizedBeanReference<?>> loadingBinderRefOptional) {
            if (loadingBinderRefOptional.isEmpty()) {
                return;
            }
            var entityType = new PojoModelValueElement<>(introspector, typeModel);
            var identifierType = new PojoModelValueElement<>(introspector, identifierMapping.identifierType);
            try (BeanHolder<?> loadingBinderHolder = loadingBinderRefOptional.get().reference().resolve(beanResolver)) {
                Map<String, ?> params = loadingBinderRefOptional.get().params();
                extendedMappingCollector().applyLoadingBinder(loadingBinderHolder.get(), new PojoEntityLoadingBindingContext() {

                    @Override
                    public PojoModelElement entityType() {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public PojoModelElement identifierType() {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    // Checked using reflection
                    @SuppressWarnings("unchecked")
                    public <E2> void selectionLoadingStrategy(Class<E2> expectedEntitySuperType, PojoSelectionLoadingStrategy<? super E2> strategy) {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    // Checked using reflection
                    @SuppressWarnings("unchecked")
                    public <E2> void massLoadingStrategy(Class<E2> expectedEntitySuperType, PojoMassLoadingStrategy<? super E2, ?> strategy) {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    private <E2> void checkEntitySuperType(Class<E2> expectedEntitySuperType) {
                        if (!expectedEntitySuperType.isAssignableFrom(typeModel.typeIdentifier().javaClass())) {
                            throw IndexingLog.INSTANCE.loadingConfigurationTypeMismatch(typeModel, expectedEntitySuperType);
                        }
                    }

                    @Override
                    public BeanResolver beanResolver() {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public <T> T param(String name, Class<T> paramType) {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }

                    @Override
                    public <T> Optional<T> paramOptional(String name, Class<T> paramType) {
                        throw new UnsupportedOperationException("STUB: not implemented");
                    }
                });
            }
        }

        public void hasNonIndexedConcreteSubtypes(boolean hasNonIndexedConcreteSubtypes) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public abstract AbstractPojoTypeManager<?, E> build();
    }
}
