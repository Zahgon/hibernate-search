/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.reporting.impl;

import java.util.Objects;
import org.hibernate.search.util.common.reporting.EventContextElement;

/**
 * An abstract base for simple event context elements based on a single parameter
 * passed to a rendering function.
 *
 * @param <T> The type of the parameter.
 */
public abstract class AbstractSimpleEventContextElement<T> implements EventContextElement {

    private final T param;

    protected AbstractSimpleEventContextElement(T param) {
        this.param = param;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String render() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract String render(T param);
}
