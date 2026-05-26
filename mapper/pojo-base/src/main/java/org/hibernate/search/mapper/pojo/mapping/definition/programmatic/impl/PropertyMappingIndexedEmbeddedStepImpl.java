/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.engine.common.tree.TreeFilterDefinition;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoIndexMappingCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoPropertyMetadataContributor;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingIndexedEmbeddedStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.util.common.annotation.Search5DeprecatedAPI;

class PropertyMappingIndexedEmbeddedStepImpl extends DelegatingPropertyMappingStep implements PropertyMappingIndexedEmbeddedStep, PojoPropertyMetadataContributor {

    private final PojoRawTypeIdentifier<?> definingType;

    private final String relativeFieldName;

    private String prefix;

    private ObjectStructure structure = ObjectStructure.DEFAULT;

    private Integer includeDepth;

    private final Set<String> includePaths = new HashSet<>();

    private final Set<String> excludePaths = new HashSet<>();

    private boolean includeEmbeddedObjectId = false;

    private Class<?> targetType;

    private ContainerExtractorPath extractorPath = ContainerExtractorPath.defaultExtractors();

    PropertyMappingIndexedEmbeddedStepImpl(PropertyMappingStep parent, PojoRawTypeIdentifier<?> definingType, String relativeFieldName) {
        super(parent);
        this.definingType = definingType;
        if (relativeFieldName != null && relativeFieldName.contains(FieldPaths.PATH_SEPARATOR_STRING)) {
            throw MappingLog.INSTANCE.invalidFieldNameDotNotAllowed(relativeFieldName);
        }
        this.relativeFieldName = relativeFieldName;
    }

    @Override
    public void contributeIndexMapping(PojoIndexMappingCollectorPropertyNode collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Deprecated(since = "6.0")
    @Search5DeprecatedAPI
    public PropertyMappingIndexedEmbeddedStep prefix(String prefix) {
        if (relativeFieldName != null && prefix != null) {
            throw MappingLog.INSTANCE.cannotSetBothIndexedEmbeddedNameAndPrefix(relativeFieldName, prefix);
        }
        this.prefix = prefix;
        return this;
    }

    @Override
    public PropertyMappingIndexedEmbeddedStep structure(ObjectStructure structure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingIndexedEmbeddedStep includeDepth(Integer depth) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingIndexedEmbeddedStep includePaths(Collection<String> paths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingIndexedEmbeddedStep excludePaths(Collection<String> paths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingIndexedEmbeddedStep includeEmbeddedObjectId(boolean include) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingIndexedEmbeddedStep extractors(ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingIndexedEmbeddedStep targetType(Class<?> targetType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
