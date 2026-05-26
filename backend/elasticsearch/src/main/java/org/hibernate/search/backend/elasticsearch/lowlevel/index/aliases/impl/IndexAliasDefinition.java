/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.aliases.impl;

import java.util.Map;
import org.hibernate.search.backend.elasticsearch.gson.impl.SerializeExtraProperties;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * An alias definition for an Elasticsearch index.
 */
/*
 * CAUTION: JSON serialization is controlled by this specific adapter, which must be
 * updated whenever fields of this class are added, renamed or removed.
 */
@JsonAdapter(IndexAliasDefinitionJsonAdapterFactory.class)
public class IndexAliasDefinition {

    @SerializedName("is_write_index")
    private Boolean isWriteIndex;

    @SerializeExtraProperties
    private Map<String, JsonElement> extraAttributes;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getWriteIndex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setWriteIndex(Boolean writeIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, JsonElement> getExtraAttributes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExtraAttributes(Map<String, JsonElement> extraAttributes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
