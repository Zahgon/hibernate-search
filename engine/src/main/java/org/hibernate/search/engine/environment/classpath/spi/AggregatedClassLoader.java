/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.classpath.spi;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * A classloader which keeps an ordered list of aggregated classloaders.
 * <p>
 * This is especially useful in modular environments such as WildFly
 * where some classes may not be accessible from Hibernate Search's classloader,
 * for example custom user components such as bridges.
 *
 * @author Steve Ebersole
 * @author Hardy Ferentschik
 * @author Sanne Grinovero
 */
public final class AggregatedClassLoader extends ClassLoader {

    private ClassLoader[] individualClassLoaders;

    public static AggregatedClassLoader createDefault() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private AggregatedClassLoader(ClassLoader... classLoaders) {
        super(null);
        individualClassLoaders = classLoaders;
    }

    @Override
    public Enumeration<URL> getResources(String name) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected URL findResource(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void addAllTo(Collection<ClassLoader> classLoaders) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static ClassLoader locateSystemClassLoader() {
        try {
            return ClassLoader.getSystemClassLoader();
        } catch (Exception e) {
            return null;
        }
    }

    private static ClassLoader locateTCCL() {
        try {
            return Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            return null;
        }
    }
}
