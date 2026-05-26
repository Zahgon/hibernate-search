/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.logging.impl;

import java.util.Collection;

public final class CommaSeparatedClassesFormatter {

    public static String format(Class<?>[] classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String formatHighlighted(Class<?>[] classes, int position) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Class<?>[] classes;

    public CommaSeparatedClassesFormatter(Collection<Class<?>> classes) {
        this.classes = classes.toArray(new Class<?>[0]);
    }

    public CommaSeparatedClassesFormatter(Class<?>[] classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
