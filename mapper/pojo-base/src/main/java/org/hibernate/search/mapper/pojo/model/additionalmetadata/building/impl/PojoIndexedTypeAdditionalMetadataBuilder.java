/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl;

import java.util.Map;
import java.util.Optional;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.RoutingBinder;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorIndexedTypeNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoIndexedTypeAdditionalMetadata;

class PojoIndexedTypeAdditionalMetadataBuilder implements PojoAdditionalMetadataCollectorIndexedTypeNode {

    private Optional<String> backendName = Optional.empty();

    private Optional<String> indexName = Optional.empty();

    private boolean enabled = true;

    private Optional<RoutingBinder> routingBinder = Optional.empty();

    private Map<String, Object> params;

    @Override
    public void backendName(String backendName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void indexName(String indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void enabled(boolean enabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void routingBinder(RoutingBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<PojoIndexedTypeAdditionalMetadata> build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
