/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import org.hibernate.search.engine.cfg.spi.AllAwareConfigurationPropertySource;

public class MapConfigurationPropertySource implements AllAwareConfigurationPropertySource {

    private final Map<String, ?> map;

    public MapConfigurationPropertySource(Map<String, ?> map) {
        this.map = map;
    }

    @Override
    public Optional<?> get(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<String> resolve(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> resolveAll(BiPredicate<String, Object> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
