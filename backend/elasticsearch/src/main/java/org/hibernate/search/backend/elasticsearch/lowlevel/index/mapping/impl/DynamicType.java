/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl;

import org.hibernate.search.backend.elasticsearch.index.DynamicMapping;
import org.hibernate.search.util.common.AssertionFailure;
import com.google.gson.annotations.SerializedName;

/**
 * An enum for Elasticsearch "dynamic" attribute values.
 *
 * See https://www.elastic.co/guide/en/elasticsearch/reference/current/dynamic.html
 */
public enum DynamicType {

    @SerializedName("true")
    TRUE, @SerializedName("false")
    FALSE, @SerializedName("strict")
    STRICT;

    public static DynamicType create(DynamicMapping dynamicMapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
