/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import java.util.Map;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.MarkerBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.PropertyBinder;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.AssociationInverseSideOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.IndexingDependencyOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingDocumentIdOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingFullTextFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingGenericFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingIndexedEmbeddedStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingKeywordFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingScaledNumberFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingVectorFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.TypeMappingStep;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;

class DelegatingPropertyMappingStep implements PropertyMappingStep {

    private final PropertyMappingStep delegate;

    DelegatingPropertyMappingStep(PropertyMappingStep delegate) {
        this.delegate = delegate;
    }

    @Override
    public TypeMappingStep hostingType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingDocumentIdOptionsStep documentId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingStep binder(PropertyBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingStep marker(MarkerBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingGenericFieldOptionsStep genericField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingGenericFieldOptionsStep genericField(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingFullTextFieldOptionsStep fullTextField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingFullTextFieldOptionsStep fullTextField(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingKeywordFieldOptionsStep keywordField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingKeywordFieldOptionsStep keywordField(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingScaledNumberFieldOptionsStep scaledNumberField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingScaledNumberFieldOptionsStep scaledNumberField(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingFieldOptionsStep<?> nonStandardField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingFieldOptionsStep<?> nonStandardField(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingIndexedEmbeddedStep indexedEmbedded() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingIndexedEmbeddedStep indexedEmbedded(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AssociationInverseSideOptionsStep associationInverseSide(PojoModelPathValueNode inversePath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexingDependencyOptionsStep indexingDependency() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep vectorField(int dimension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep vectorField(int dimension, String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep vectorField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingVectorFieldOptionsStep vectorField(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
