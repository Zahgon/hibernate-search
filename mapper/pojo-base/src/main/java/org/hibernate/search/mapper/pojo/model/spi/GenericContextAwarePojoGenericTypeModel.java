/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.spi;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.hibernate.search.util.common.reflect.impl.GenericTypeContext;

/**
 * An implementation of {@link PojoTypeModel} that takes advantage of the context
 * in which a given property appears to derive more precise type information.
 * <p>
 * Instances wrap a {@link PojoRawTypeModel}, and propagate generics information to properties
 * and their type by wrapping the property models as well.
 * <p>
 * For instance, given the following model:
 * <pre><code>
 * class A&lt;T extends C&gt; {
 *   GenericType&lt;T&gt; propertyOfA;
 * }
 * class B extends A&lt;D&gt; {
 * }
 * class C {
 * }
 * class D extends C {
 * }
 * class GenericType&lt;T&gt; {
 *   T propertyOfGenericType;
 * }
 * </code></pre>
 *
 * ... if an instance of this implementation was used to model the type of {@code B.propertyOfA},
 * then the property {@code B.propertyOfA} would appear to have type {@code List<D>} as one would expect,
 * instead of type {@code T extends C} if we inferred the type solely based on generics information from type {@code A}.
 *
 * This will also be true for more deeply nested references to a type variable,
 * for instance the type of property {@code B.propertyOfA.propertyOfGenericType} will correctly be inferred as D.
 */
public final class GenericContextAwarePojoGenericTypeModel<T> extends AbstractPojoGenericTypeModel<T> implements PojoTypeModel<T> {

    private static Optional<PojoTypeModel<?>> typeArgument(Helper helper, GenericTypeContext selfTypeContext, Class<?> rawSuperType, int typeParameterIndex) {
        return selfTypeContext.resolveTypeArgument(rawSuperType, typeParameterIndex).map(type -> new GenericContextAwarePojoGenericTypeModel<>(helper, new GenericTypeContext(selfTypeContext.declaringContext(), type)));
    }

    private static Optional<PojoTypeModel<?>> arrayElementType(Helper helper, GenericTypeContext selfTypeContext) {
        return selfTypeContext.resolveArrayElementType().map(type -> new GenericContextAwarePojoGenericTypeModel<>(helper, new GenericTypeContext(selfTypeContext.declaringContext(), type)));
    }

    private final Helper helper;

    private final GenericTypeContext genericTypeContext;

    private final Map<Object, PojoPropertyModel<?>> genericPropertyCache = new HashMap<>();

    public interface Helper {

        <T> PojoRawTypeModel<T> rawTypeModel(Class<T> clazz);

        Object propertyCacheKey(PojoPropertyModel<?> rawPropertyModel);

        Type propertyGenericType(PojoPropertyModel<?> rawPropertyModel);
    }

    public static class RawTypeDeclaringContext<T> {

        private final Helper helper;

        private final GenericTypeContext genericTypeContext;

        public RawTypeDeclaringContext(Helper helper, Class<T> rawType) {
            this.helper = helper;
            this.genericTypeContext = new GenericTypeContext(rawType);
        }

        public Optional<PojoTypeModel<?>> typeArgument(Class<?> rawSuperType, int typeParameterIndex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Optional<PojoTypeModel<?>> arrayElementType() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * @param declaredType The type to create a generic type model for.
         * @return A generic type model for {@code declaredType} in this context.
         * The type parameter can safely be assumed to be exactly the type {@code declaredType}.
         * For instance if {@code declaredType} is {@code String.class},
         * the returned type model will be an instance of {@code PojoGenericTypeModel<String>}.
         * If {@code declaredType} is {@code List<String>}, it will be {@code PojoGenericTypeModel<List<String>>},
         * and so on.
         */
        public PojoTypeModel<?> memberTypeReference(Type declaredType) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // Can't do better here, this code is all about reflection
    @SuppressWarnings("unchecked")
    private GenericContextAwarePojoGenericTypeModel(Helper helper, GenericTypeContext genericTypeContext) {
        super(helper.rawTypeModel((Class<? super T>) genericTypeContext.rawType()));
        this.helper = helper;
        this.genericTypeContext = genericTypeContext;
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoPropertyModel<?> property(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <U> Optional<PojoTypeModel<? extends U>> castTo(Class<U> target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<PojoTypeModel<?>> typeArgument(Class<?> rawSuperType, int typeParameterIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<PojoTypeModel<?>> arrayElementType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <U> PojoPropertyModel<? extends U> wrapProperty(PojoPropertyModel<U> rawPropertyModel) {
        Object cacheKey = helper.propertyCacheKey(rawPropertyModel);
        // See how we add values to the cache
        @SuppressWarnings("unchecked")
        PojoPropertyModel<? extends U> cached = (PojoPropertyModel<? extends U>) genericPropertyCache.get(cacheKey);
        if (cached != null) {
            return cached;
        }
        Type propertyType = helper.propertyGenericType(rawPropertyModel);
        GenericTypeContext propertyGenericTypeContext = new GenericTypeContext(genericTypeContext, propertyType);
        GenericContextAwarePojoGenericTypeModel<? extends U> genericPropertyTypeModel = new GenericContextAwarePojoGenericTypeModel<>(helper, propertyGenericTypeContext);
        PojoPropertyModel<? extends U> propertyModel = new GenericContextAwarePojoPropertyModel<>(rawPropertyModel, genericPropertyTypeModel);
        genericPropertyCache.put(cacheKey, propertyModel);
        return propertyModel;
    }
}
