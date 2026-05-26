/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.bootstrap.impl;

import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.hibernate.boot.registry.classloading.spi.ClassLoadingException;
import org.hibernate.search.engine.environment.classpath.spi.AggregatedClassLoader;
import org.hibernate.search.engine.environment.classpath.spi.ClassResolver;
import org.hibernate.search.engine.environment.classpath.spi.DefaultClassResolver;
import org.hibernate.search.engine.environment.classpath.spi.DefaultResourceResolver;
import org.hibernate.search.engine.environment.classpath.spi.DefaultServiceResolver;
import org.hibernate.search.engine.environment.classpath.spi.ResourceResolver;
import org.hibernate.search.engine.environment.classpath.spi.ServiceResolver;

/**
 * An implementation of {@link ClassResolver} which delegates to the ORM-provided {@code ClassResolver}.
 * If class, resource or service loading fails in ORM class loader, the current class loader is checked.
 *
 * @author Hardy Ferentschik
 */
final class HibernateOrmClassLoaderServiceClassAndResourceAndServiceResolver implements ClassResolver, ResourceResolver, ServiceResolver {

    /**
     * {@code ClassResolver] as provided by Hibernate ORM. This is the class loader which we attempt to use first.
     */
    private final org.hibernate.boot.registry.classloading.spi.ClassLoaderService hibernateClassLoaderService;

    /*
	 * Search internal class loader and resource loader resolvers
	 * which in particular try to use the current class loader.
	 * These can be necessary in case the ORM class loader can due to modularity
	 * not access the required resources.
	 */
    private final ClassResolver internalClassResolver;

    private final ResourceResolver internalResourceResolver;

    private final ServiceResolver internalServiceResolver;

    HibernateOrmClassLoaderServiceClassAndResourceAndServiceResolver(org.hibernate.boot.registry.classloading.spi.ClassLoaderService hibernateClassLoaderService) {
        this.hibernateClassLoaderService = hibernateClassLoaderService;
        AggregatedClassLoader aggregatedClassLoader = AggregatedClassLoader.createDefault();
        this.internalClassResolver = DefaultClassResolver.create(aggregatedClassLoader);
        this.internalResourceResolver = DefaultResourceResolver.create(aggregatedClassLoader);
        this.internalServiceResolver = DefaultServiceResolver.create(aggregatedClassLoader);
    }

    @Override
    public Class<?> classForName(String className) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Package packageForName(String packageName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public URL locateResource(String resourceName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public InputStream locateResourceStream(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Collection<T> loadJavaServices(Class<T> serviceContract) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <T> void addAllServices(Iterable<T> services, Map<String, T> combined) {
        for (T service : services) {
            combined.put(service.getClass().getName(), service);
        }
    }
}
