/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.spi;

import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.impl.ConfigurationPropertySourceScopeUtils;
import org.hibernate.search.engine.cfg.spi.ConfigurationPropertyChecker;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.bean.impl.BeanResolverImpl;
import org.hibernate.search.engine.environment.bean.spi.BeanProvider;
import org.hibernate.search.engine.environment.classpath.spi.AggregatedClassLoader;
import org.hibernate.search.engine.environment.classpath.spi.ClassResolver;
import org.hibernate.search.engine.environment.classpath.spi.DefaultClassResolver;
import org.hibernate.search.engine.environment.classpath.spi.DefaultResourceResolver;
import org.hibernate.search.engine.environment.classpath.spi.DefaultServiceResolver;
import org.hibernate.search.engine.environment.classpath.spi.ResourceResolver;
import org.hibernate.search.engine.environment.classpath.spi.ServiceResolver;

/**
 * The environment of a search integration,
 * i.e. the configuration properties, classes, resources, services and beans.
 */
public final class SearchIntegrationEnvironment implements AutoCloseable {

    public static final String CONFIGURATION_PROPERTIES_MASK = "hibernate.search";

    public static ConfigurationPropertySource rootPropertySource(ConfigurationPropertySource propertySource, BeanResolver beanResolver) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final ConfigurationPropertySource propertySource;

    private final ConfigurationPropertyChecker propertyChecker;

    private final ClassResolver classResolver;

    private final ResourceResolver resourceResolver;

    private final ServiceResolver serviceResolver;

    private final BeanResolver beanResolver;

    private final BeanProvider beanProvider;

    private SearchIntegrationEnvironment(Builder builder) {
        AggregatedClassLoader aggregatedClassLoader = null;
        if (builder.classResolver != null) {
            classResolver = builder.classResolver;
        } else {
            aggregatedClassLoader = AggregatedClassLoader.createDefault();
            classResolver = DefaultClassResolver.create(aggregatedClassLoader);
        }
        if (builder.resourceResolver != null) {
            resourceResolver = builder.resourceResolver;
        } else {
            if (aggregatedClassLoader == null) {
                aggregatedClassLoader = AggregatedClassLoader.createDefault();
            }
            resourceResolver = DefaultResourceResolver.create(aggregatedClassLoader);
        }
        if (builder.serviceResolver != null) {
            serviceResolver = builder.serviceResolver;
        } else {
            if (aggregatedClassLoader == null) {
                aggregatedClassLoader = AggregatedClassLoader.createDefault();
            }
            serviceResolver = DefaultServiceResolver.create(aggregatedClassLoader);
        }
        propertyChecker = builder.propertyChecker;
        beanProvider = builder.beanProvider;
        // This is the property source without any mask or ConfigurationProvider defaults applied.
        ConfigurationPropertySource rawPropertySource = builder.propertySource;
        beanResolver = BeanResolverImpl.create(classResolver, serviceResolver, beanProvider, // BeanResolverImpl.create() will apply its own, limited, fallback configuration.
        rawPropertySource);
        propertySource = rootPropertySource(rawPropertySource, beanResolver);
    }

    private SearchIntegrationEnvironment(SearchIntegrationEnvironment source, ConfigurationPropertySource propertySource, ConfigurationPropertyChecker checker) {
        this.propertyChecker = checker;
        this.classResolver = source.classResolver;
        this.resourceResolver = source.resourceResolver;
        this.serviceResolver = source.serviceResolver;
        beanProvider = source.beanProvider;
        beanResolver = source.beanResolver;
        this.propertySource = rootPropertySource(propertySource, beanResolver);
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationPropertySource propertySource() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationPropertyChecker propertyChecker() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ClassResolver classResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ResourceResolver resourceResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ServiceResolver serviceResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BeanResolver beanResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BeanProvider beanProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchIntegrationEnvironment override(ConfigurationPropertySource propertySource, ConfigurationPropertyChecker propertyChecker) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Builder builder(ConfigurationPropertySource propertySource, ConfigurationPropertyChecker propertyChecker) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class Builder {

        private final ConfigurationPropertySource propertySource;

        private final ConfigurationPropertyChecker propertyChecker;

        private ClassResolver classResolver;

        private ResourceResolver resourceResolver;

        private ServiceResolver serviceResolver;

        private BeanProvider beanProvider;

        private Builder(ConfigurationPropertySource propertySource, ConfigurationPropertyChecker propertyChecker) {
            this.propertySource = propertySource;
            this.propertyChecker = propertyChecker;
        }

        public Builder classResolver(ClassResolver classResolver) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder resourceResolver(ResourceResolver resourceResolver) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder serviceResolver(ServiceResolver serviceResolver) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder beanProvider(BeanProvider beanProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchIntegrationEnvironment build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
