/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.Optional;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;

/**
 * This class is very similar to {@link FallbackConfigurationPropertySource}.
 * We could actually use {@link FallbackConfigurationPropertySource} wherever we use this class,
 * simply by inverting the constructor parameters, if it wasn't for one detail:
 * the implementation of {@link #resolve(String)} would not work as expected,
 * returning the key resolved using the wrong source.
 */
public class OverriddenConfigurationPropertySource implements ConfigurationPropertySource {

    private final ConfigurationPropertySource main;

    private final ConfigurationPropertySource override;

    public OverriddenConfigurationPropertySource(ConfigurationPropertySource main, ConfigurationPropertySource override) {
        this.main = main;
        this.override = override;
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
