/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl;

import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * An object representing Elasticsearch property mappings, i.e. the mappings of properties inside a type mapping.
 *
 * See https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping.html#mapping-type
 */
/*
 * CAUTION:
 * 1. JSON serialization is controlled by a specific adapter, which must be
 * updated whenever fields of this class are added, renamed or removed.
 *
 * 2. Whenever adding more properties consider adding property validation to PropertyMappingValidator.
 */
@JsonAdapter(PropertyMappingJsonAdapterFactory.class)
public class PropertyMapping extends AbstractTypeMapping {

    private String type;

    /*
	 * Attributes common to multiple datatypes
	 */
    private Boolean index;

    private Boolean norms;

    @SerializedName("doc_values")
    private Boolean docValues;

    /**
     * The null-value replacement, which can be a string (real string or formatted date), a boolean
     * or a numeric value, depending on the data type.
     *
     * <p>Using JsonPrimitive here instead of Object allows us to take advantage of lazily parsed numbers,
     * so that long values are not arbitrarily parsed as doubles, which would involve losing some
     * information. See the difference in behavior between those adapters when parsing numbers:
     * <ul>
     * <li>com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT
     * <li> and com.google.gson.internal.bind.ObjectTypeAdapter
     * </ul>
     */
    @SerializedName("null_value")
    private JsonElement nullValue;

    /*
	 * Text datatype
	 * https://www.elastic.co/guide/en/elasticsearch/reference/current/text.html
	 */
    private String analyzer;

    /*
	 * Text datatype
	 * https://www.elastic.co/guide/en/elasticsearch/reference/current/search-analyzer.html
	 */
    @SerializedName("search_analyzer")
    private String searchAnalyzer;

    /*
	 * Keyword datatype
	 * https://www.elastic.co/guide/en/elasticsearch/reference/current/keyword.html
	 */
    private String normalizer;

    /*
	 * Date datatype
	 * https://www.elastic.co/guide/en/elasticsearch/reference/current/date.html
	 */
    private List<String> format;

    @SerializedName("scaling_factor")
    private Double scalingFactor;

    @SerializedName("term_vector")
    private String termVector;

    /*
	 * Dense vector datatype
	 * https://www.elastic.co/guide/en/elasticsearch/reference/current/dense-vector.html
	 */
    @SerializedName("element_type")
    private String elementType;

    /*
	 * Dense vector datatype
	 * https://www.elastic.co/guide/en/elasticsearch/reference/current/dense-vector.html
	 */
    private Integer dims;

    /*
	 * Dense vector datatype
	 * https://www.elastic.co/guide/en/elasticsearch/reference/current/dense-vector.html
	 */
    private String similarity;

    /*
	 * Dense vector datatype
	 * https://www.elastic.co/guide/en/elasticsearch/reference/current/dense-vector.html
	 */
    @SerializedName("index_options")
    private ElasticsearchDenseVectorIndexOptions indexOptions;

    /*
	 * k-NN vector datatype
	 * https://opensearch.org/docs/latest/field-types/supported-field-types/knn-vector/
	 */
    private Integer dimension;

    /*
	 * k-NN vector datatype
	 * https://opensearch.org/docs/latest/field-types/supported-field-types/knn-vector/
	 */
    private OpenSearchVectorTypeMethod method;

    /*
	 * k-NN vector datatype
	 * https://opensearch.org/docs/latest/field-types/supported-field-types/knn-vector/
	 */
    @SerializedName("data_type")
    private String dataType;

    public String getType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setType(String type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> getFormat() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setFormat(List<String> format) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getIndex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setIndex(Boolean index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getNorms() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setNorms(Boolean norms) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getDocValues() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDocValues(Boolean docValues) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public JsonElement getNullValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setNullValue(JsonElement nullValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getAnalyzer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAnalyzer(String analyzer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getSearchAnalyzer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSearchAnalyzer(String searchAnalyzer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getNormalizer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setNormalizer(String normalizer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Double getScalingFactor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setScalingFactor(Double scalingFactor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getTermVector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTermVector(String termVector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getElementType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setElementType(String elementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getDims() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDims(Integer dims) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getSimilarity() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSimilarity(String similarity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ElasticsearchDenseVectorIndexOptions getIndexOptions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setIndexOptions(ElasticsearchDenseVectorIndexOptions indexOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getDimension() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDimension(Integer dimension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public OpenSearchVectorTypeMethod getMethod() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMethod(OpenSearchVectorTypeMethod method) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getDataType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDataType(String dataType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
