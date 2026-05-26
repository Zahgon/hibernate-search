/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.AbstractConfiguredExtraPropertiesJsonAdapterFactory;

public class OpenSearchVectorTypeMethodJsonAdapterFactory extends AbstractConfiguredExtraPropertiesJsonAdapterFactory {

    @Override
    protected <T> void addFields(Builder<T> builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class ParametersJsonAdapterFactory extends AbstractConfiguredExtraPropertiesJsonAdapterFactory {

        @Override
        protected <T> void addFields(Builder<T> builder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
