/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProvider;
import org.hibernate.search.engine.cfg.spi.ConfigurationScope;
import org.hibernate.search.engine.cfg.spi.ConfigurationScopeNamespaces;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.logging.impl.ConfigurationLog;
import org.hibernate.search.util.common.annotation.Incubating;

/**
 * Provides shortcuts to create scopes, as well as a quick way to create a fallback property source for a given scope.
 */
@Incubating
public final class ConfigurationPropertySourceScopeUtils {

    private static final Comparator<ConfigurationProvider> CONFIGURATION_PROVIDER_COMPARATOR = Comparator.comparing(ConfigurationProvider::priority).thenComparing(cp -> cp.getClass().getName());

    private ConfigurationPropertySourceScopeUtils() {
    }

    public static ConfigurationScope global() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ConfigurationScope backend() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ConfigurationScope backend(String backendName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ConfigurationScope index(String backendName, String indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Helps to create the fallback from the configuration providers for an exact scope.
     * If multiple providers are available, they will be sorted and configurations from them
     * will be added one by one as fallbacks.
     */
    public static ConfigurationPropertySource fallback(BeanResolver beanResolver, ConfigurationScope scope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
