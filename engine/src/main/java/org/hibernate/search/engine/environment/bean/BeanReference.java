/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.bean;

import org.hibernate.search.util.common.impl.StringHelper;

/**
 * A reference to a bean, allowing the retrieval of that bean
 * when {@link #resolve(BeanResolver) passed} a {@link BeanResolver}.
 *
 * @param <T> The type of the referenced bean.
 */
public interface BeanReference<T> {

    /**
     * Resolve this reference into a bean using the given resolver.
     *
     * @param beanResolver A resolver to resolve this reference with.
     * @return The bean instance.
     */
    BeanHolder<T> resolve(BeanResolver beanResolver);

    /**
     * Cast this reference into a reference whose {@link #resolve(BeanResolver)} method is is guaranteed to
     * either fail or return an instance of the given type.
     *
     * @param expectedType The expected bean type.
     * @param <U> The expected bean type.
     * @return A bean reference.
     * @throws ClassCastException If this reference is certain to never return an instance of the given type.
     */
    default <U> BeanReference<? extends U> asSubTypeOf(Class<U> expectedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link BeanReference} referencing a bean by its type only.
     *
     * @param type The bean type. Must not be null.
     * @param <T> The bean type.
     * @return The corresponding {@link BeanReference}.
     */
    static <T> BeanReference<T> of(Class<T> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link BeanReference} referencing a bean by its type only.
     *
     * @param type The bean type. Must not be null.
     * @param retrieval How to retrieve the bean. See {@link BeanRetrieval}.
     * @param <T> The bean type.
     * @return The corresponding {@link BeanReference}.
     */
    static <T> BeanReference<T> of(Class<T> type, BeanRetrieval retrieval) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link BeanReference} referencing a bean by type and name.
     *
     * @param type The bean type. Must not be null.
     * @param name The bean name. May be null or empty.
     * @param <T> The bean type.
     * @return The corresponding {@link BeanReference}.
     */
    static <T> BeanReference<T> of(Class<T> type, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link BeanReference} referencing a bean by type and name.
     *
     * @param type The bean type. Must not be null.
     * @param name The bean name. May be null or empty.
     * @param retrieval How to retrieve the bean. See {@link BeanRetrieval}.
     * @param <T> The bean type.
     * @return The corresponding {@link BeanReference}.
     */
    static <T> BeanReference<T> of(Class<T> type, String name, BeanRetrieval retrieval) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link BeanReference} referencing a bean instance directly.
     *
     * @param instance The bean instance. Must not be null.
     * @param <T> The bean type.
     * @return The corresponding {@link BeanReference}.
     */
    static <T> BeanReference<T> ofInstance(T instance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // This method conforms to the MicroProfile Config specification. Do not change its signature.
    static BeanReference<?> parse(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> BeanReference<T> parse(Class<T> expectedType, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
