/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import java.util.LinkedHashSet;
import java.util.Set;
import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoPropertyMetadataContributor;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.IndexingDependencyOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorValueNode;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;

class IndexingDependencyOptionsStepImpl extends DelegatingPropertyMappingStep implements IndexingDependencyOptionsStep, PojoPropertyMetadataContributor {

    private ContainerExtractorPath extractorPath = ContainerExtractorPath.defaultExtractors();

    private ReindexOnUpdate reindexOnUpdate = ReindexOnUpdate.DEFAULT;

    // Use a LinkedHashSet for deterministic iteration
    private Set<PojoModelPathValueNode> derivedFrom = null;

    IndexingDependencyOptionsStepImpl(PropertyMappingStep delegate) {
        super(delegate);
    }

    @Override
    public void contributeAdditionalMetadata(PojoAdditionalMetadataCollectorPropertyNode collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexingDependencyOptionsStep reindexOnUpdate(ReindexOnUpdate reindexOnUpdate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexingDependencyOptionsStep derivedFrom(PojoModelPathValueNode pojoModelPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexingDependencyOptionsStep extractors(ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
