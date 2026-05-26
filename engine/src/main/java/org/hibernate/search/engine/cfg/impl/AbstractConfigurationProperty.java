/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.Optional;
import java.util.function.Function;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.ConvertUtils;
import org.hibernate.search.engine.logging.impl.ConfigurationLog;

abstract class AbstractConfigurationProperty<T> implements ConfigurationProperty<T> {

    private final String key;

    AbstractConfigurationProperty(String key) {
        this.key = key;
    }

    @Override
    public T get(ConfigurationPropertySource source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <R> R getAndTransform(ConfigurationPropertySource source, Function<T, R> transform) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract <R> R convert(Optional<?> rawValue, Function<T, R> transform);

    <R> R doGet(ConfigurationPropertySource source, Function<T, R> transform) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<String> resolve(ConfigurationPropertySource source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String resolveOrRaw(ConfigurationPropertySource source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
