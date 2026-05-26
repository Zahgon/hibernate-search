/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl;

import com.google.gson.JsonElement;

public class PropertyMappingJsonAdapterFactory extends AbstractTypeMappingJsonAdapterFactory {

    @Override
    protected <T> void addFields(Builder<T> builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
