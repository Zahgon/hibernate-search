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
 * An object representing OpenSearch K-NN vector Method attributes.
 *
 * See https://opensearch.org/docs/latest/field-types/supported-field-types/knn-vector/
 */
/*
 * CAUTION:
 * 1. JSON serialization is controlled by a specific adapter, which must be
 * updated whenever fields of this class are added, renamed or removed.
 *
 * 2. Whenever adding more properties consider adding property validation to PropertyMappingValidator.
 */
@JsonAdapter(OpenSearchVectorTypeMethodJsonAdapterFactory.class)
public class OpenSearchVectorTypeMethod {

    private String name;

    @SerializedName("space_type")
    private String spaceType;

    private String engine;

    private Parameters parameters;

    @SerializeExtraProperties
    private Map<String, JsonElement> extraAttributes;

    public String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setName(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getSpaceType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSpaceType(String spaceType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getEngine() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEngine(String engine) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Parameters getParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setParameters(Parameters parameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, JsonElement> getExtraAttributes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExtraAttributes(Map<String, JsonElement> extraAttributes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @JsonAdapter(OpenSearchVectorTypeMethodJsonAdapterFactory.ParametersJsonAdapterFactory.class)
    public static class Parameters {

        @SerializedName("ef_construction")
        private Integer efConstruction;

        private Integer m;

        @SerializeExtraProperties
        private Map<String, JsonElement> extraAttributes;

        public Integer getEfConstruction() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void setEfConstruction(Integer efConstruction) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Integer getM() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void setM(Integer m) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Map<String, JsonElement> getExtraAttributes() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void setExtraAttributes(Map<String, JsonElement> extraAttributes) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
