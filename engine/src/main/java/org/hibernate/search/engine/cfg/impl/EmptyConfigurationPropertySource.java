/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.Optional;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;

public class EmptyConfigurationPropertySource implements ConfigurationPropertySource {

    private static final EmptyConfigurationPropertySource INSTANCE = new EmptyConfigurationPropertySource();

    public static ConfigurationPropertySource get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private EmptyConfigurationPropertySource() {
        // Private constructor, use get() instead
    }

    @Override
    public Optional<Object> get(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<String> resolve(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfigurationPropertySource withMask(String mask) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfigurationPropertySource withFallback(ConfigurationPropertySource fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
