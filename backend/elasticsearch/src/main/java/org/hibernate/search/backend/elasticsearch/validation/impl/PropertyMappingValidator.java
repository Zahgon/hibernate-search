/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.ElasticsearchDenseVectorIndexOptions;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.OpenSearchVectorTypeMethod;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchValidationMessages;
import org.hibernate.search.engine.backend.analysis.AnalyzerNames;
import org.hibernate.search.util.common.impl.CollectionHelper;
import com.google.gson.JsonElement;

abstract class PropertyMappingValidator extends AbstractTypeMappingValidator<PropertyMapping> {

    private static final List<String> DEFAULT_DATE_FORMAT;

    static {
        List<String> formats = new ArrayList<>();
        formats.add("strict_date_optional_time");
        formats.add("epoch_millis");
        DEFAULT_DATE_FORMAT = CollectionHelper.toImmutableList(formats);
    }

    @Override
    protected Validator<PropertyMapping> getPropertyMappingValidator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void validate(ValidationErrorCollector errorCollector, PropertyMapping expectedMapping, PropertyMapping actualMapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void validateAnalyzerOptions(ValidationErrorCollector errorCollector, PropertyMapping expectedMapping, PropertyMapping actualMapping) {
        LeafValidators.EQUAL.validateWithDefault(errorCollector, ValidationContextType.MAPPING_ATTRIBUTE, "analyzer", expectedMapping.getAnalyzer(), actualMapping.getAnalyzer(), AnalyzerNames.DEFAULT);
        LeafValidators.EQUAL.validateWithDefault(errorCollector, ValidationContextType.MAPPING_ATTRIBUTE, "search_analyzer", expectedMapping.getSearchAnalyzer(), actualMapping.getSearchAnalyzer(), expectedMapping.getAnalyzer() == null ? AnalyzerNames.DEFAULT : expectedMapping.getAnalyzer(), actualMapping.getAnalyzer() == null ? AnalyzerNames.DEFAULT : actualMapping.getAnalyzer());
        LeafValidators.EQUAL.validate(errorCollector, ValidationContextType.MAPPING_ATTRIBUTE, "normalizer", expectedMapping.getNormalizer(), actualMapping.getNormalizer());
    }

    private void validateIndexOptions(ValidationErrorCollector errorCollector, PropertyMapping expectedMapping, PropertyMapping actualMapping) {
        Boolean expectedIndex = expectedMapping.getIndex();
        if (Boolean.TRUE.equals(expectedIndex)) {
            // If we don't need an index, we don't care
            LeafValidators.EQUAL.validateWithDefault(errorCollector, ValidationContextType.MAPPING_ATTRIBUTE, "index", expectedIndex, actualMapping.getIndex(), true);
        }
        Boolean expectedNorms = expectedMapping.getNorms();
        if (Boolean.TRUE.equals(expectedNorms)) {
            // If we don't need norms, we don't care
            // From ES 5.0 on, norms are enabled by default on text fields only
            Boolean normsDefault = DataTypes.TEXT.equals(expectedMapping.getType()) ? Boolean.TRUE : Boolean.FALSE;
            LeafValidators.EQUAL.validateWithDefault(errorCollector, ValidationContextType.MAPPING_ATTRIBUTE, "norms", expectedNorms, actualMapping.getNorms(), normsDefault);
        }
        Boolean expectedDocValues = expectedMapping.getDocValues();
        if (Boolean.TRUE.equals(expectedDocValues)) {
            // If we don't need doc_values, we don't care
            // From ES 5.0 on, all indexable doc_values is true by default
            LeafValidators.EQUAL.validateWithDefault(errorCollector, ValidationContextType.MAPPING_ATTRIBUTE, "doc_values", expectedDocValues, actualMapping.getDocValues(), true);
        }
    }

    protected abstract void validateVectorMapping(ValidationErrorCollector errorCollector, PropertyMapping expectedMapping, PropertyMapping actualMapping);

    static class Elasticsearch7PropertyMappingValidator extends PropertyMappingValidator {

        @Override
        protected void validateVectorMapping(ValidationErrorCollector errorCollector, PropertyMapping expectedMapping, PropertyMapping actualMapping) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class Elasticsearch812PropertyMappingValidator extends Elasticsearch8xPropertyMappingValidator {
    }

    static class Elasticsearch814PropertyMappingValidator extends Elasticsearch8xPropertyMappingValidator {

        @Override
        protected boolean indexOptionsRequireValidation(ElasticsearchDenseVectorIndexOptions expected, ElasticsearchDenseVectorIndexOptions actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class Elasticsearch8xPropertyMappingValidator extends PropertyMappingValidator {

        private final ElasticsearchDenseVectorIndexOptionsValidator indexOptionsValidator = new ElasticsearchDenseVectorIndexOptionsValidator();

        @Override
        protected void validateVectorMapping(ValidationErrorCollector errorCollector, PropertyMapping expectedMapping, PropertyMapping actualMapping) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected boolean indexOptionsRequireValidation(ElasticsearchDenseVectorIndexOptions expected, ElasticsearchDenseVectorIndexOptions actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class OpenSearch1PropertyMappingValidator extends PropertyMappingValidator {

        @Override
        protected void validateVectorMapping(ValidationErrorCollector errorCollector, PropertyMapping expectedMapping, PropertyMapping actualMapping) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class OpenSearch2PropertyMappingValidator extends PropertyMappingValidator {

        private final OpenSearchVectorTypeMethodValidator methodValidator = new OpenSearchVectorTypeMethodValidator();

        @Override
        protected void validateVectorMapping(ValidationErrorCollector errorCollector, PropertyMapping expectedMapping, PropertyMapping actualMapping) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class ElasticsearchDenseVectorIndexOptionsValidator extends AbstractVectorAttributesValidator<ElasticsearchDenseVectorIndexOptions> {

        @Override
        protected String propertyName() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void doValidate(ValidationErrorCollector errorCollector, ElasticsearchDenseVectorIndexOptions expected, ElasticsearchDenseVectorIndexOptions actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Map<String, JsonElement> expectedMappingExtraAttributes(ElasticsearchDenseVectorIndexOptions expected) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Map<String, JsonElement> actualMappingExtraAttributes(ElasticsearchDenseVectorIndexOptions actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class OpenSearchVectorTypeMethodValidator extends AbstractVectorAttributesValidator<OpenSearchVectorTypeMethod> {

        private final OpenSearchVectorTypeMethodParametersValidator parametersValidator = new OpenSearchVectorTypeMethodParametersValidator();

        @Override
        protected String propertyName() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void doValidate(ValidationErrorCollector errorCollector, OpenSearchVectorTypeMethod expected, OpenSearchVectorTypeMethod actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Map<String, JsonElement> expectedMappingExtraAttributes(OpenSearchVectorTypeMethod expected) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Map<String, JsonElement> actualMappingExtraAttributes(OpenSearchVectorTypeMethod actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class OpenSearchVectorTypeMethodParametersValidator extends AbstractVectorAttributesValidator<OpenSearchVectorTypeMethod.Parameters> {

        @Override
        protected String propertyName() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void doValidate(ValidationErrorCollector errorCollector, OpenSearchVectorTypeMethod.Parameters expected, OpenSearchVectorTypeMethod.Parameters actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Map<String, JsonElement> expectedMappingExtraAttributes(OpenSearchVectorTypeMethod.Parameters expected) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Map<String, JsonElement> actualMappingExtraAttributes(OpenSearchVectorTypeMethod.Parameters actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    abstract static class AbstractVectorAttributesValidator<T> implements Validator<T> {

        private final Validator<JsonElement> extraAttributeValidator = new JsonElementValidator(new JsonElementEquivalence());

        @Override
        public final void validate(ValidationErrorCollector errorCollector, T expected, T actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected abstract String propertyName();

        protected abstract void doValidate(ValidationErrorCollector errorCollector, T expected, T actual);

        protected abstract Map<String, JsonElement> expectedMappingExtraAttributes(T expected);

        protected abstract Map<String, JsonElement> actualMappingExtraAttributes(T actual);
    }
}
