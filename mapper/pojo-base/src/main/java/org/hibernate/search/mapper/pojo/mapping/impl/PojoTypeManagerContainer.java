/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappedIndexManagerBuilder;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoImplicitReindexingResolverBuildingHelper;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.BoundRoutingBridge;
import org.hibernate.search.mapper.pojo.identity.impl.PojoRootIdentityMappingCollector;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContextProvider;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoContainedTypeExtendedMappingCollector;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoIndexedTypeExtendedMappingCollector;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoRawTypeIdentifierResolver;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.processing.building.impl.PojoIndexingProcessorOriginalTypeNodeBuilder;
import org.hibernate.search.mapper.pojo.scope.impl.PojoScopeTypeContextProvider;
import org.hibernate.search.mapper.pojo.work.impl.PojoWorkTypeContext;
import org.hibernate.search.mapper.pojo.work.impl.PojoWorkTypeContextProvider;
import org.hibernate.search.util.common.data.spi.KeyValueProvider;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.CollectionHelper;

public class PojoTypeManagerContainer implements AutoCloseable, PojoWorkTypeContextProvider, PojoScopeTypeContextProvider, PojoRawTypeIdentifierResolver, PojoLoadingTypeContextProvider {

    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final KeyValueProvider<PojoRawTypeIdentifier<?>, AbstractPojoTypeManager<?, ?>> byExactType;

    private final KeyValueProvider<PojoRawTypeIdentifier<?>, PojoIndexedTypeManager<?, ?>> indexedByExactType;

    private final KeyValueProvider<String, AbstractPojoTypeManager<?, ?>> byEntityName;

    private final KeyValueProvider<String, PojoIndexedTypeManager<?, ?>> indexedByEntityName;

    private final KeyValueProvider<String, PojoRawTypeIdentifier<?>> typeIdentifierByEntityName;

    private final KeyValueProvider<String, PojoRawTypeIdentifier<?>> typeIdentifierBySecondaryEntityName;

    private final KeyValueProvider<PojoRawTypeIdentifier<?>, Set<? extends AbstractPojoTypeManager<?, ?>>> byNonInterfaceSuperType;

    private final KeyValueProvider<String, PojoRawTypeIdentifier<?>> nonInterfaceSuperTypeIdentifierByEntityName;

    private final KeyValueProvider<Class<?>, PojoRawTypeIdentifier<?>> nonInterfaceSuperTypeIdentifierByClass;

    private final KeyValueProvider<PojoRawTypeIdentifier<?>, Set<? extends PojoIndexedTypeManager<?, ?>>> indexedBySuperType;

    private final KeyValueProvider<Class<?>, Set<? extends PojoIndexedTypeManager<?, ?>>> indexedBySuperTypeClass;

    private final KeyValueProvider<String, Set<? extends PojoIndexedTypeManager<?, ?>>> indexedBySuperTypeEntityName;

    private final Set<PojoIndexedTypeManager<?, ?>> allIndexed;

    private final Set<PojoRawTypeIdentifier<?>> allIndexedAndContainedTypes;

    private PojoTypeManagerContainer(Builder builder, PojoImplicitReindexingResolverBuildingHelper reindexingResolverBuildingHelper) {
        // Use a LinkedHashMap for deterministic iteration in the "all" set
        Map<PojoRawTypeIdentifier<?>, AbstractPojoTypeManager<?, ?>> byExactTypeContent = new LinkedHashMap<>();
        Map<PojoRawTypeIdentifier<?>, PojoIndexedTypeManager<?, ?>> indexedByExactTypeContent = new LinkedHashMap<>();
        Map<PojoRawTypeIdentifier<?>, Set<AbstractPojoTypeManager<?, ?>>> bySuperTypeContent = new LinkedHashMap<>();
        Map<PojoRawTypeIdentifier<?>, Set<PojoIndexedTypeManager<?, ?>>> indexedBySuperTypeContent = new LinkedHashMap<>();
        Map<String, AbstractPojoTypeManager<?, ?>> byEntityNameContent = new LinkedHashMap<>();
        Map<String, PojoIndexedTypeManager<?, ?>> indexedByEntityNameContent = new LinkedHashMap<>();
        Set<PojoIndexedTypeManager.Builder<?>> hasNonIndexedConcreteSubtypesSet = createHasNonIndexedConcreteSubtypesSet(builder, reindexingResolverBuildingHelper);
        for (PojoIndexedTypeManager.Builder<?> typeManagerBuilder : builder.indexed.values()) {
            PojoRawTypeModel<?> typeModel = typeManagerBuilder.typeModel;
            PojoRawTypeIdentifier<?> typeIdentifier = typeModel.typeIdentifier();
            typeManagerBuilder.hasNonIndexedConcreteSubtypes(hasNonIndexedConcreteSubtypesSet.contains(typeManagerBuilder));
            var typeManager = typeManagerBuilder.build();
            MappingLog.INSTANCE.indexedTypeManager(typeModel, typeManager);
            byExactTypeContent.put(typeIdentifier, typeManager);
            indexedByExactTypeContent.put(typeIdentifier, typeManager);
            String entityName = typeManager.name();
            byEntityNameContent.put(entityName, typeManager);
            indexedByEntityNameContent.put(entityName, typeManager);
            registerSuperTypes(bySuperTypeContent, typeModel, typeManager);
            registerSuperTypes(indexedBySuperTypeContent, typeModel, typeManager);
        }
        for (PojoContainedTypeManager.Builder<?> typeManagerBuilder : builder.contained.values()) {
            PojoRawTypeModel<?> typeModel = typeManagerBuilder.typeModel;
            PojoRawTypeIdentifier<?> typeIdentifier = typeModel.typeIdentifier();
            var typeManager = typeManagerBuilder.build();
            MappingLog.INSTANCE.containedTypeManager(typeModel, typeManager);
            byExactTypeContent.put(typeIdentifier, typeManager);
            byEntityNameContent.put(typeManager.name(), typeManager);
            registerSuperTypes(bySuperTypeContent, typeModel, typeManager);
        }
        this.byExactType = new KeyValueProvider<>(byExactTypeContent, MappingLog.INSTANCE::unknownTypeIdentifierForMappedEntityType);
        this.indexedByExactType = new KeyValueProvider<>(indexedByExactTypeContent, MappingLog.INSTANCE::unknownTypeIdentifierForIndexedEntityType);
        this.byEntityName = new KeyValueProvider<>(byEntityNameContent, MappingLog.INSTANCE::unknownEntityNameForMappedEntityType);
        this.indexedByEntityName = new KeyValueProvider<>(indexedByEntityNameContent, MappingLog.INSTANCE::unknownEntityNameForIndexedEntityType);
        indexedBySuperTypeContent.replaceAll((k, v) -> Collections.unmodifiableSet(v));
        this.indexedBySuperType = KeyValueProvider.createWithMultiKeyException(indexedBySuperTypeContent, MappingLog.INSTANCE::invalidIndexedSuperTypes);
        Map<String, PojoRawTypeIdentifier<?>> typeIdentifierByEntityNameContent = new LinkedHashMap<>();
        Map<String, PojoRawTypeIdentifier<?>> typeIdentifierBySecondaryEntityNameContent = new LinkedHashMap<>();
        for (Map.Entry<String, PojoRawTypeModel<?>> entry : builder.allEntitiesByName.entrySet()) {
            PojoRawTypeIdentifier<?> typeIdentifier = entry.getValue().typeIdentifier();
            typeIdentifierByEntityNameContent.put(entry.getKey(), typeIdentifier);
        }
        for (Map.Entry<String, PojoRawTypeModel<?>> entry : builder.allEntitiesBySecondaryName.entrySet()) {
            PojoRawTypeIdentifier<?> typeIdentifier = entry.getValue().typeIdentifier();
            typeIdentifierBySecondaryEntityNameContent.put(entry.getKey(), typeIdentifier);
            // Take secondary names into account in the primary map, too
            // ... but resolve conflicts in favor of primary names.
            typeIdentifierByEntityNameContent.putIfAbsent(entry.getKey(), typeIdentifier);
        }
        this.typeIdentifierByEntityName = new KeyValueProvider<>(typeIdentifierByEntityNameContent, MappingLog.INSTANCE::unknownEntityName);
        this.typeIdentifierBySecondaryEntityName = new KeyValueProvider<>(typeIdentifierBySecondaryEntityNameContent, MappingLog.INSTANCE::unknownEntityName);
        Map<String, Set<PojoIndexedTypeManager<?, ?>>> indexedBySuperTypeEntityNameContent = new LinkedHashMap<>();
        Map<Class<?>, Set<PojoIndexedTypeManager<?, ?>>> indexedBySuperTypeClassContent = new LinkedHashMap<>();
        for (Map.Entry<PojoRawTypeIdentifier<?>, Set<PojoIndexedTypeManager<?, ?>>> entry : indexedBySuperTypeContent.entrySet()) {
            PojoRawTypeIdentifier<?> typeIdentifier = entry.getKey();
            Set<String> entityNames = builder.allEntityNamesByTypeIdentifier.get(typeIdentifier);
            if (entityNames != null) {
                for (String entityName : entityNames) {
                    indexedBySuperTypeEntityNameContent.put(entityName, entry.getValue());
                }
            }
            // Multiple named types can share a single java class, so those wouldn't work here.
            if (!typeIdentifier.isNamed()) {
                indexedBySuperTypeClassContent.put(typeIdentifier.javaClass(), entry.getValue());
            }
        }
        indexedBySuperTypeEntityNameContent.replaceAll((k, v) -> Collections.unmodifiableSet(v));
        this.indexedBySuperTypeEntityName = KeyValueProvider.createWithMultiKeyException(indexedBySuperTypeEntityNameContent, MappingLog.INSTANCE::invalidIndexedSuperTypeEntityNames);
        indexedBySuperTypeClassContent.replaceAll((k, v) -> Collections.unmodifiableSet(v));
        this.indexedBySuperTypeClass = KeyValueProvider.createWithMultiKeyException(indexedBySuperTypeClassContent, MappingLog.INSTANCE::invalidIndexedSuperTypeClasses);
        Map<Class<?>, PojoRawTypeIdentifier<?>> nonInterfaceSuperTypeIdentifierByClassContent = new LinkedHashMap<>();
        Map<String, PojoRawTypeIdentifier<?>> nonInterfaceSuperTypeIdentifierByEntityNameContent = new LinkedHashMap<>();
        Map<PojoRawTypeIdentifier<?>, Set<AbstractPojoTypeManager<?, ?>>> byNonInterfaceSuperTypeContent = new LinkedHashMap<>();
        for (Map.Entry<PojoRawTypeIdentifier<?>, Set<AbstractPojoTypeManager<?, ?>>> entry : bySuperTypeContent.entrySet()) {
            PojoRawTypeIdentifier<?> typeIdentifier = entry.getKey();
            // for these, we want to skip any interfaces since this set should only be used to report an error when we cannot
            // find a type by a class, and that should only be a case when we are looking up non-named types.
            if (typeIdentifier.isNamed() || !typeIdentifier.javaClass().isInterface()) {
                byNonInterfaceSuperTypeContent.put(typeIdentifier, entry.getValue());
                Set<String> entityNames = builder.allEntityNamesByTypeIdentifier.get(typeIdentifier);
                if (entityNames != null) {
                    for (String entityName : entityNames) {
                        nonInterfaceSuperTypeIdentifierByEntityNameContent.put(entityName, typeIdentifier);
                    }
                }
                // Multiple named types can share a single java class, so those wouldn't work here.
                if (!typeIdentifier.isNamed()) {
                    nonInterfaceSuperTypeIdentifierByClassContent.put(typeIdentifier.javaClass(), typeIdentifier);
                }
            }
        }
        this.byNonInterfaceSuperType = new KeyValueProvider<>(byNonInterfaceSuperTypeContent, MappingLog.INSTANCE::unknownNonInterfaceSuperTypeIdentifier);
        this.nonInterfaceSuperTypeIdentifierByEntityName = new KeyValueProvider<>(nonInterfaceSuperTypeIdentifierByEntityNameContent, MappingLog.INSTANCE::unknownEntityNameForNonInterfaceSuperType);
        this.nonInterfaceSuperTypeIdentifierByClass = new KeyValueProvider<>(nonInterfaceSuperTypeIdentifierByClassContent, MappingLog.INSTANCE::unknownClassForNonInterfaceSuperType);
        this.allIndexed = Collections.unmodifiableSet(new LinkedHashSet<>(indexedByExactTypeContent.values()));
        this.allIndexedAndContainedTypes = Collections.unmodifiableSet(byExactTypeContent.keySet());
    }

    private static Set<PojoIndexedTypeManager.Builder<?>> createHasNonIndexedConcreteSubtypesSet(Builder builder, PojoImplicitReindexingResolverBuildingHelper reindexingResolverBuildingHelper) {
        Set<PojoRawTypeIdentifier<?>> indexedIdentifiers = new HashSet<>();
        for (PojoIndexedTypeManager.Builder<?> typeManagerBuilder : builder.indexed.values()) {
            indexedIdentifiers.add(typeManagerBuilder.typeModel.typeIdentifier());
        }
        Set<PojoIndexedTypeManager.Builder<?>> hasNonIndexedConcreteSubtypesSet = new HashSet<>();
        for (PojoIndexedTypeManager.Builder<?> typeManagerBuilder : builder.indexed.values()) {
            boolean hasNonIndexedConcreteSubtypes = false;
            Set<? extends PojoRawTypeModel<?>> concreteSubTypes = reindexingResolverBuildingHelper.getConcreteEntitySubTypesForEntitySuperType(typeManagerBuilder.typeModel);
            for (PojoRawTypeModel<?> subtype : concreteSubTypes) {
                if (!indexedIdentifiers.contains(subtype.typeIdentifier())) {
                    hasNonIndexedConcreteSubtypes = true;
                    break;
                }
            }
            if (hasNonIndexedConcreteSubtypes) {
                hasNonIndexedConcreteSubtypesSet.add(typeManagerBuilder);
            }
        }
        return hasNonIndexedConcreteSubtypesSet;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> AbstractPojoTypeManager<?, E> forExactType(PojoRawTypeIdentifier<E> typeIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> PojoIndexedTypeManager<?, E> indexedForExactType(PojoRawTypeIdentifier<E> typeIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<PojoRawTypeIdentifier<?>> allNonInterfaceSuperTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<PojoRawTypeIdentifier<?>> allIndexedAndContainedTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> Set<? extends PojoIndexedTypeManager<?, ? extends E>> indexedForSuperTypes(Collection<? extends PojoRawTypeIdentifier<? extends E>> typeIdentifiers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> Optional<? extends Set<? extends PojoIndexedTypeManager<?, ? extends E>>> indexedForSuperType(PojoRawTypeIdentifier<E> typeIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public <T> Set<? extends PojoIndexedTypeManager<?, ? extends T>> indexedForSuperTypeClasses(Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<? extends PojoIndexedTypeManager<?, ?>> indexedForSuperTypeEntityNames(Collection<String> entityNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> Set<? extends PojoWorkTypeContext<?, ? extends E>> forNonInterfaceSuperType(PojoRawTypeIdentifier<E> typeIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KeyValueProvider<String, PojoRawTypeIdentifier<?>> nonInterfaceSuperTypeIdentifierByEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> PojoRawTypeIdentifier<E> nonInterfaceSuperTypeIdentifierForClass(Class<E> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KeyValueProvider<String, ? extends PojoWorkTypeContext<?, ?>> byEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public KeyValueProvider<String, PojoIndexedTypeManager<?, ?>> indexedByEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KeyValueProvider<String, PojoRawTypeIdentifier<?>> typeIdentifierByEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KeyValueProvider<String, PojoRawTypeIdentifier<?>> typeIdentifierBySecondaryEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Set<PojoIndexedTypeManager<?, ?>> allIndexed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> void registerSuperTypes(Map<PojoRawTypeIdentifier<?>, Set<T>> bySuperType, PojoRawTypeModel<?> entityType, T value) {
        entityType.descendingSuperTypes().map(PojoRawTypeModel::typeIdentifier).forEach(superTypeIdentifier -> bySuperType.computeIfAbsent(superTypeIdentifier, ignored -> new LinkedHashSet<>()).add(value));
    }

    public static class Builder {

        // Use a LinkedHashMap for deterministic iteration
        public final Map<PojoRawTypeModel<?>, PojoIndexedTypeManager.Builder<?>> indexed = new LinkedHashMap<>();

        public final Map<PojoRawTypeModel<?>, PojoContainedTypeManager.Builder<?>> contained = new LinkedHashMap<>();

        private final Map<PojoRawTypeIdentifier<?>, Set<PojoRawTypeIdentifier<?>>> entityTypeIdentifiersBySuperType = new LinkedHashMap<>();

        private final Map<PojoRawTypeIdentifier<?>, Set<String>> allEntityNamesByTypeIdentifier = new LinkedHashMap<>();

        private final Map<String, PojoRawTypeModel<?>> allEntitiesByName = new LinkedHashMap<>();

        private final Map<String, PojoRawTypeModel<?>> allEntitiesBySecondaryName = new LinkedHashMap<>();

        private Builder() {
        }

        public <E> PojoIndexedTypeManager.Builder<E> addIndexed(PojoRawTypeModel<E> typeModel, String entityName, String secondaryEntityName, PojoRootIdentityMappingCollector<E> identityMappingCollector, PojoIndexedTypeExtendedMappingCollector extendedMappingCollector, BoundRoutingBridge<E> routingBridge, PojoIndexingProcessorOriginalTypeNodeBuilder<E> indexingProcessorBuilder, MappedIndexManagerBuilder indexManagerBuilder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public <E> PojoContainedTypeManager.Builder<E> addContained(PojoRawTypeModel<E> typeModel, String entityName, String secondaryEntityName, PojoRootIdentityMappingCollector<E> identityMappingCollector, PojoContainedTypeExtendedMappingCollector extendedMappingCollector) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void addEntity(PojoRawTypeModel<?> entityType, String entityName, String secondaryEntityName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void closeOnFailure() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public PojoTypeManagerContainer build(PojoImplicitReindexingResolverBuildingHelper reindexingResolverBuildingHelper) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
