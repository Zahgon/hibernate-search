/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.classpath.spi;

import java.io.InputStream;
import java.net.URL;
import org.hibernate.search.util.common.annotation.impl.SuppressForbiddenApis;

/**
 * Default implementation of {@code ClassResolver} relying on an {@link AggregatedClassLoader}.
 *
 * @author Hardy Ferentschik
 */
public final class DefaultResourceResolver implements ResourceResolver {

    private final AggregatedClassLoader aggregatedClassLoader;

    public static ResourceResolver create(AggregatedClassLoader aggregatedClassLoader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private DefaultResourceResolver(AggregatedClassLoader aggregatedClassLoader) {
        this.aggregatedClassLoader = aggregatedClassLoader;
    }

    @Override
    @SuppressForbiddenApis(reason = "URL constructors are deprecated in JDK 20+ in favor of using URI.toURL()," + " but we want to preserve backward compatibility for now (see below).")
    public InputStream locateResourceStream(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public URL locateResource(String resourceName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
