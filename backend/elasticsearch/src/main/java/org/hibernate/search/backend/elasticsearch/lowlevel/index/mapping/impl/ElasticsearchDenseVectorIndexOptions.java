/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl;

import java.util.Map;
import org.hibernate.search.backend.elasticsearch.gson.impl.SerializeExtraProperties;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * An object representing Elasticsearch dense vector-specific index options attributes.
 *
 * See https://www.elastic.co/guide/en/elasticsearch/reference/current/dense-vector.html
 */
/*
 * CAUTION:
 * 1. JSON serialization is controlled by a specific adapter, which must be
 * updated whenever fields of this class are added, renamed or removed.
 *
 * 2. Whenever adding more properties consider adding property validation to PropertyMappingValidator#ElasticsearchDenseVectorIndexOptionsValidator.
 */
@JsonAdapter(ElasticsearchDenseVectorIndexOptionsJsonAdapterFactory.class)
public class ElasticsearchDenseVectorIndexOptions {

    private String type;

    private Integer m;

    @SerializedName("ef_construction")
    private Integer efConstruction;

    @SerializeExtraProperties
    private Map<String, JsonElement> extraAttributes;

    public String getType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setType(String type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getM() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setM(Integer m) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getEfConstruction() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEfConstruction(Integer efConstruction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, JsonElement> getExtraAttributes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExtraAttributes(Map<String, JsonElement> extraAttributes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
