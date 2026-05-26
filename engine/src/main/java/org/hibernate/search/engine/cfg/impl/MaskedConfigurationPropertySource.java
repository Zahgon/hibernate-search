/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.Optional;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.util.common.impl.Contracts;

public class MaskedConfigurationPropertySource implements ConfigurationPropertySource {

    private final ConfigurationPropertySource propertiesToMask;

    private final String radix;

    public MaskedConfigurationPropertySource(ConfigurationPropertySource propertiesToMask, String mask) {
        Contracts.assertNotNull(propertiesToMask, "propertiesToMask");
        Contracts.assertNotNull(mask, "mask");
        this.propertiesToMask = propertiesToMask;
        this.radix = mask + ".";
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
    public ConfigurationPropertySource withMask(String mask) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
