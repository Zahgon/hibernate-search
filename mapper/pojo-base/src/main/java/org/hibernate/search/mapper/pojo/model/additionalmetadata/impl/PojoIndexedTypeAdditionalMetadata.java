/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.additionalmetadata.impl;

import java.util.Map;
import java.util.Optional;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.RoutingBinder;

public class PojoIndexedTypeAdditionalMetadata {

    private final Optional<String> backendName;

    private final Optional<String> indexName;

    private final Optional<RoutingBinder> routingBinder;

    private final Map<String, Object> routingBinderParams;

    public PojoIndexedTypeAdditionalMetadata(Optional<String> backendName, Optional<String> indexName, Optional<RoutingBinder> routingBinder, Map<String, Object> routingBinderParams) {
        this.backendName = backendName;
        this.indexName = indexName;
        this.routingBinder = routingBinder;
        this.routingBinderParams = routingBinderParams;
    }

    public Optional<String> backendName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<String> indexName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<RoutingBinder> routingBinder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, Object> routingBinderParams() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
