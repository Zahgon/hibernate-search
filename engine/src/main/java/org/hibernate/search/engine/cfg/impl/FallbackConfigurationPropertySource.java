/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.Optional;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;

public class FallbackConfigurationPropertySource implements ConfigurationPropertySource {

    private final ConfigurationPropertySource main;

    private final ConfigurationPropertySource fallback;

    public FallbackConfigurationPropertySource(ConfigurationPropertySource main, ConfigurationPropertySource fallback) {
        this.main = main;
        this.fallback = fallback;
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
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
