/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.building.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.hibernate.search.engine.common.tree.TreeFilterDefinition;
import org.hibernate.search.engine.common.tree.spi.TreeFilterPathTracker;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexedEntityBindingMapperContext;
import org.hibernate.search.engine.mapper.model.spi.MappingElement;
import org.hibernate.search.engine.mapper.model.spi.TypeMetadataContributorProvider;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import org.hibernate.search.engine.reporting.spi.FailureCollector;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoTypeMetadataContributor;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl.PojoTypeAdditionalMetadataProvider;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;

public class PojoMappingHelper implements IndexedEntityBindingMapperContext {

    private final BeanResolver beanResolver;

    private final ContextualFailureCollector failureCollector;

    private final TypeMetadataContributorProvider<PojoTypeMetadataContributor> contributorProvider;

    private final PojoBootstrapIntrospector introspector;

    private final PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider;

    private final PojoIndexModelBinder indexModelBinder;

    // Use a LinkedHashMap for deterministic iteration
    private final Map<MappingElement, TreeFilterPathTracker> pathTrackers = new LinkedHashMap<>();

    PojoMappingHelper(BeanResolver beanResolver, ContextualFailureCollector failureCollector, TypeMetadataContributorProvider<PojoTypeMetadataContributor> contributorProvider, PojoBootstrapIntrospector introspector, PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider, PojoIndexModelBinder indexModelBinder) {
        this.beanResolver = beanResolver;
        this.failureCollector = failureCollector;
        this.contributorProvider = contributorProvider;
        this.introspector = introspector;
        this.typeAdditionalMetadataProvider = typeAdditionalMetadataProvider;
        this.indexModelBinder = indexModelBinder;
    }

    public BeanResolver beanResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public FailureCollector failureCollector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TypeMetadataContributorProvider<PojoTypeMetadataContributor> contributorProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoBootstrapIntrospector introspector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoIndexModelBinder indexModelBinder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TreeFilterPathTracker getOrCreatePathTracker(MappingElement mappingElement, TreeFilterDefinition filterDefinition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void checkPathTrackers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
