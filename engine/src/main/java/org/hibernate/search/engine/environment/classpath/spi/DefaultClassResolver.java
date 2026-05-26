/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.classpath.spi;

import org.hibernate.search.engine.logging.impl.EngineMiscLog;
import org.hibernate.search.util.common.annotation.Incubating;

/**
 * Default implementation of {@code ClassResolver} relying on an {@link AggregatedClassLoader}.
 *
 * @author Hardy Ferentschik
 */
public final class DefaultClassResolver implements ClassResolver {

    private final AggregatedClassLoader aggregatedClassLoader;

    public static ClassResolver create(AggregatedClassLoader aggregatedClassLoader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private DefaultClassResolver(AggregatedClassLoader aggregatedClassLoader) {
        this.aggregatedClassLoader = aggregatedClassLoader;
    }

    @Override
    public Class<?> classForName(String className) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Package packageForName(String packageName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Incubating
    public AggregatedClassLoader aggregatedClassLoader() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
