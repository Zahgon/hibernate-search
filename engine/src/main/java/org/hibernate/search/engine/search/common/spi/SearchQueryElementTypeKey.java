/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.common.spi;

import java.util.Objects;

@SuppressWarnings("unused")
public final class SearchQueryElementTypeKey<T> {

    public static <T> SearchQueryElementTypeKey<T> of(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final String name;

    private SearchQueryElementTypeKey(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
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

    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
