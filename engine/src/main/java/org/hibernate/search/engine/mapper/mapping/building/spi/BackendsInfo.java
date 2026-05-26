/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.mapper.mapping.building.spi;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.hibernate.search.engine.logging.impl.ConfigurationLog;
import org.hibernate.search.engine.tenancy.spi.TenancyMode;

public final class BackendsInfo {

    // Using a linked hash map to preserve the order
    private final Map<Optional<String>, BackendInfo> backendsByNames = new LinkedHashMap<>();

    public Collection<BackendInfo> values() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void collect(Optional<String> name, TenancyMode tenancyMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class BackendInfo {

        // {@code Optional.empty()} means "the default backend"
        private final Optional<String> name;

        private final TenancyMode tenancyMode;

        public BackendInfo(Optional<String> name, TenancyMode tenancyMode) {
            this.name = name;
            this.tenancyMode = tenancyMode;
        }

        public Optional<String> name() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public TenancyMode tenancyStrategy() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
