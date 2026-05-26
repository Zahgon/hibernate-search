/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.bean.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.logging.impl.EngineMiscLog;
import org.hibernate.search.util.common.AssertionFailure;

/**
 * A registry for beans of a given exposed type that were explicitly registered through a
 * {@link org.hibernate.search.engine.environment.bean.spi.BeanConfigurer}.
 *
 * @param <T> The type exposed by beans in this registry.
 */
public class BeanReferenceRegistryForType<T> {

    private final Class<T> exposedType;

    private final List<BeanReference<T>> all = new ArrayList<>();

    private final Map<String, BeanReference<T>> named = new TreeMap<>();

    public BeanReferenceRegistryForType(Class<T> exposedType) {
        this.exposedType = exposedType;
    }

    public final List<BeanReference<T>> all() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, BeanReference<T>> named() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BeanReference<T> single() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BeanReference<T> named(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Safe cast from BeanReference<? extends T> to BeanReference<T> as BeanReference is covariant in T
    @SuppressWarnings("unchecked")
    void add(BeanReference<? extends T> reference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Safe cast from BeanReference<? extends T> to BeanReference<T> as BeanReference is covariant in T
    @SuppressWarnings("unchecked")
    void add(String name, BeanReference<? extends T> reference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
