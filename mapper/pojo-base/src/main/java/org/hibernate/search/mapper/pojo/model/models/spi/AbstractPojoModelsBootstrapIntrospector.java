/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.models.spi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.hibernate.models.spi.AnnotationTarget;
import org.hibernate.models.spi.ClassDetails;
import org.hibernate.models.spi.ClassDetailsRegistry;
import org.hibernate.models.spi.ClassLoading;
import org.hibernate.models.spi.MemberDetails;
import org.hibernate.models.spi.MethodDetails;
import org.hibernate.models.spi.ModelsConfiguration;
import org.hibernate.search.engine.environment.classpath.spi.ClassLoadingException;
import org.hibernate.search.engine.environment.classpath.spi.ClassResolver;
import org.hibernate.search.engine.environment.classpath.spi.DefaultClassResolver;
import org.hibernate.search.engine.environment.classpath.spi.ResourceResolver;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.StreamHelper;
import org.hibernate.search.util.common.reflect.spi.ValueCreateHandle;
import org.hibernate.search.util.common.reflect.spi.ValueHandleFactory;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;
import org.jboss.jandex.IndexView;

public abstract class AbstractPojoModelsBootstrapIntrospector implements PojoBootstrapIntrospector {

    private static final String INDEX_MODELS_CONFIG_PARAM = "hibernate.models.jandex.index";

    private final PojoModelsClassOrdering typeOrdering;

    protected final ValueHandleFactory valueHandleFactory;

    private final ClassDetailsRegistry classDetailsRegistry;

    protected AbstractPojoModelsBootstrapIntrospector(ClassResolver classResolver, ResourceResolver resourceResolver, IndexView indexView, ValueHandleFactory valueHandleFactory) {
        this(simpleClassDetailsRegistry(classResolver, resourceResolver, indexView), valueHandleFactory);
    }

    protected AbstractPojoModelsBootstrapIntrospector(ClassDetailsRegistry classDetailsRegistry, ValueHandleFactory valueHandleFactory) {
        this.classDetailsRegistry = classDetailsRegistry;
        this.typeOrdering = new PojoModelsClassOrdering(classDetailsRegistry);
        this.valueHandleFactory = valueHandleFactory;
    }

    private static ClassDetailsRegistry simpleClassDetailsRegistry(ClassResolver classResolver, ResourceResolver resourceResolver, IndexView indexView) {
        ModelsConfiguration configuration = new ModelsConfiguration();
        configuration.setClassLoading(new HibernateSearchClassLoading(classResolver, resourceResolver));
        configuration.setConfigValue(INDEX_MODELS_CONFIG_PARAM, indexView);
        return configuration.bootstrap().getClassDetailsRegistry();
    }

    @Override
    public ValueHandleFactory annotationValueHandleFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Stream<? extends Annotation> annotations(AnnotationTarget annotationTarget) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ClassDetails toModelsClass(Class<?> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, MemberDetails> declaredFieldAccessPropertiesByName(ClassDetails classDetails) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, List<MemberDetails>> declaredMethodAccessPropertiesByName(ClassDetails classDetails) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Stream<Class<?>> ascendingSuperClasses(ClassDetails classDetails) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Stream<Class<?>> descendingSuperClasses(ClassDetails classDetails) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected <T> ValueCreateHandle<T> createValueCreateHandle(Constructor<T> constructor) throws IllegalAccessException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected ValueReadHandle<?> createValueReadHandle(Member member) throws IllegalAccessException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<?> toClass(ClassDetails xClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Collector<MemberDetails, ?, Map<String, MemberDetails>> propertiesByNameNoDuplicate() {
        return StreamHelper.toMap(MemberDetails::getName, Function.identity(), // Sort properties by name for deterministic iteration
        TreeMap::new);
    }

    private static Collector<MemberDetails, ?, Map<String, List<MemberDetails>>> propertiesByName() {
        return Collectors.groupingBy(AbstractPojoModelsBootstrapIntrospector::noPrefix, // Sort properties by name for deterministic iteration
        TreeMap::new, Collectors.toList());
    }

    private static String noPrefix(MemberDetails details) {
        return PojoBootstrapIntrospector.noPrefix(details.getName());
    }

    private record HibernateSearchClassLoading(ClassResolver classResolver, ResourceResolver resourceResolver) implements ClassLoading {

        @SuppressWarnings("unchecked")
        @Override
        public <T> Class<T> classForName(String name) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> Class<T> findClassForName(String name) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public URL locateResource(String resourceName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public <S> Collection<S> loadJavaServices(Class<S> serviceType) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
