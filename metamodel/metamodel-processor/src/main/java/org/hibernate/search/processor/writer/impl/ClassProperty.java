/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.writer.impl;

import java.util.Locale;

record ClassProperty(String type, String name) implements Comparable<ClassProperty> {

    public String asParameter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String asSetInConstructor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String asGetter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int compareTo(ClassProperty o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
