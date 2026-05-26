/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl;

import java.util.Map;
import org.hibernate.search.backend.elasticsearch.gson.impl.SerializeExtraProperties;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * An object representing an Elasticsearch dynamic template.
 * <p>
 * This is the inner object in the array of templates, wrapped in a {@link NamedDynamicTemplate}.
 * See https://www.elastic.co/guide/en/elasticsearch/reference/current/dynamic-templates.html
 */
@JsonAdapter(DynamicTemplateJsonAdapterFactory.class)
public class DynamicTemplate {

    @SerializedName("match_mapping_type")
    private String matchMappingType;

    @SerializedName("path_match")
    private String pathMatch;

    private PropertyMapping mapping;

    @SerializeExtraProperties
    private Map<String, JsonElement> extraAttributes;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getMatchMappingType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMatchMappingType(String matchMappingType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getPathMatch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPathMatch(String pathMatch) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PropertyMapping getMapping() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMapping(PropertyMapping mapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, JsonElement> getExtraAttributes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExtraAttributes(Map<String, JsonElement> extraAttributes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
