/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.VectorSimilarity;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFactory;
import org.hibernate.search.mapper.pojo.bridge.binding.spi.FieldModelContributorContext;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoPropertyMetadataContributor;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingVectorFieldOptionsStep;

class PropertyMappingVectorFieldOptionsStepImpl extends AbstractPropertyMappingFieldOptionsStep<PropertyMappingVectorFieldOptionsStep> implements PropertyMappingVectorFieldOptionsStep, PojoPropertyMetadataContributor {

    PropertyMappingVectorFieldOptionsStepImpl(PropertyMappingStep parent, Integer dimension, String relativeFieldName) {
        super(parent, relativeFieldName, IndexFieldTypeFactory::asVector, FieldModelContributorContext::vectorTypeOptionsStep);
        if (dimension != null) {
            fieldModelContributor.add(c -> c.vectorTypeOptionsStep().dimension(dimension));
        }
        extractors(ContainerExtractorPath.noExtractors());
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep projectable(Projectable projectable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep searchable(Searchable searchable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep vectorSimilarity(VectorSimilarity vectorSimilarity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep efConstruction(int efConstruction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep m(int m) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep indexNullAs(String indexNullAs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep extractors(ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    PropertyMappingVectorFieldOptionsStepImpl thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
