/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.impl;

import java.io.InputStream;
import org.hibernate.search.backend.lucene.logging.impl.LuceneMiscLog;
import org.hibernate.search.engine.environment.classpath.spi.ClassLoaderHelper;
import org.hibernate.search.engine.environment.classpath.spi.ClassResolver;
import org.hibernate.search.engine.environment.classpath.spi.ResourceResolver;
import org.apache.lucene.util.ResourceLoader;

/**
 * Hibernate Search specific implementation of Lucene's {@code ResourceLoader} interface.
 *
 * @author Emmanuel Bernard
 * @author Sanne Grinovero (C) 2011 Red Hat Inc.
 * @author Hardy Ferentschik
 */
final class HibernateSearchResourceLoader implements ResourceLoader {

    private final ClassResolver classResolver;

    private final ResourceResolver resourceResolver;

    HibernateSearchResourceLoader(ClassResolver classResolver, ResourceResolver resourceResolver) {
        this.classResolver = classResolver;
        this.resourceResolver = resourceResolver;
    }

    @Override
    public InputStream openResource(String resource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Class<? extends T> findClass(String className, Class<T> expectedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T newInstance(String className, Class<T> expectedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
