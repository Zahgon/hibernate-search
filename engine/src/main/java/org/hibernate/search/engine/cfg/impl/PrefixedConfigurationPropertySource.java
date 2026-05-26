/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.Optional;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.util.common.impl.Contracts;

public class PrefixedConfigurationPropertySource implements ConfigurationPropertySource {

    private final ConfigurationPropertySource propertiesToPrefix;

    private final String radix;

    private final int radixLength;

    public PrefixedConfigurationPropertySource(ConfigurationPropertySource propertiesToPrefix, String prefix) {
        Contracts.assertNotNull(propertiesToPrefix, "propertiesToPrefix");
        Contracts.assertNotNull(prefix, "prefix");
        this.propertiesToPrefix = propertiesToPrefix;
        this.radix = prefix + ".";
        this.radixLength = radix.length();
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
    public ConfigurationPropertySource withPrefix(String prefix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
