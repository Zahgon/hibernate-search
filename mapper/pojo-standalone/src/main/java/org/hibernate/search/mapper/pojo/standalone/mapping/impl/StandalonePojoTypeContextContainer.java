/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.mapping.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.standalone.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.standalone.session.impl.StandalonePojoSearchSessionTypeContextProvider;
import org.hibernate.search.util.common.data.spi.KeyValueProvider;

public class StandalonePojoTypeContextContainer implements StandalonePojoSearchSessionTypeContextProvider {

    private final KeyValueProvider<PojoRawTypeIdentifier<?>, AbstractStandalonePojoTypeContext<?>> byTypeIdentifier;

    private final KeyValueProvider<PojoRawTypeIdentifier<?>, StandalonePojoIndexedTypeContext<?>> indexedByTypeIdentifier;

    private final KeyValueProvider<Class<?>, AbstractStandalonePojoTypeContext<?>> byExactClass;

    private final KeyValueProvider<Class<?>, StandalonePojoIndexedTypeContext<?>> indexedByExactClass;

    private final KeyValueProvider<String, StandalonePojoIndexedTypeContext<?>> indexedByEntityName;

    private StandalonePojoTypeContextContainer(Builder builder) {
        // Use a LinkedHashMap for deterministic iteration
        Map<PojoRawTypeIdentifier<?>, AbstractStandalonePojoTypeContext<?>> byTypeIdentifierContent = new LinkedHashMap<>();
        Map<PojoRawTypeIdentifier<?>, StandalonePojoIndexedTypeContext<?>> indexedByTypeIdentifierContent = new LinkedHashMap<>();
        Map<Class<?>, AbstractStandalonePojoTypeContext<?>> byExactClassContent = new LinkedHashMap<>();
        Map<Class<?>, StandalonePojoIndexedTypeContext<?>> indexedByExactClassContent = new LinkedHashMap<>();
        Map<String, StandalonePojoIndexedTypeContext<?>> indexedByEntityNameContent = new LinkedHashMap<>();
        for (StandalonePojoIndexedTypeContext.Builder<?> contextBuilder : builder.indexedTypeContextBuilders) {
            StandalonePojoIndexedTypeContext<?> typeContext = contextBuilder.build();
            PojoRawTypeIdentifier<?> typeIdentifier = typeContext.typeIdentifier();
            byTypeIdentifierContent.put(typeIdentifier, typeContext);
            indexedByTypeIdentifierContent.put(typeIdentifier, typeContext);
            byExactClassContent.put(typeContext.javaClass(), typeContext);
            indexedByExactClassContent.put(typeContext.javaClass(), typeContext);
            indexedByEntityNameContent.put(typeContext.name(), typeContext);
        }
        for (StandalonePojoContainedTypeContext.Builder<?> contextBuilder : builder.containedTypeContextBuilders) {
            StandalonePojoContainedTypeContext<?> typeContext = contextBuilder.build();
            PojoRawTypeIdentifier<?> typeIdentifier = typeContext.typeIdentifier();
            byTypeIdentifierContent.put(typeIdentifier, typeContext);
            byExactClassContent.put(typeContext.javaClass(), typeContext);
        }
        this.byTypeIdentifier = new KeyValueProvider<>(byTypeIdentifierContent, MappingLog.INSTANCE::unknownTypeIdentifierForMappedEntityType);
        this.indexedByTypeIdentifier = new KeyValueProvider<>(indexedByTypeIdentifierContent, MappingLog.INSTANCE::unknownTypeIdentifierForIndexedEntityType);
        this.byExactClass = new KeyValueProvider<>(byExactClassContent, MappingLog.INSTANCE::unknownClassForMappedEntityType);
        this.indexedByExactClass = new KeyValueProvider<>(indexedByExactClassContent, MappingLog.INSTANCE::unknownClassForIndexedEntityType);
        this.indexedByEntityName = new KeyValueProvider<>(indexedByEntityNameContent, MappingLog.INSTANCE::unknownEntityNameForIndexedEntityType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> AbstractStandalonePojoTypeContext<E> forExactType(PojoRawTypeIdentifier<E> typeIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public <E> StandalonePojoIndexedTypeContext<E> indexedForExactType(PojoRawTypeIdentifier<E> typeIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> AbstractStandalonePojoTypeContext<E> forExactClass(Class<E> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public <E> StandalonePojoIndexedTypeContext<E> indexedForExactClass(Class<E> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KeyValueProvider<String, StandalonePojoIndexedTypeContext<?>> indexedByEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Collection<? extends StandalonePojoIndexedTypeContext<?>> allIndexed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class Builder {

        private final List<StandalonePojoIndexedTypeContext.Builder<?>> indexedTypeContextBuilders = new ArrayList<>();

        private final List<StandalonePojoContainedTypeContext.Builder<?>> containedTypeContextBuilders = new ArrayList<>();

        <E> StandalonePojoIndexedTypeContext.Builder<E> addIndexed(PojoRawTypeModel<E> typeModel, String entityName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        <E> StandalonePojoContainedTypeContext.Builder<E> addContained(PojoRawTypeModel<E> typeModel, String entityName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        StandalonePojoTypeContextContainer build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
