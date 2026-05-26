/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.spi;

import org.hibernate.search.util.common.logging.impl.CommaSeparatedClassesFormatter;

public final class PojoConstructorIdentifier {

    private final String name;

    private final Class<?>[] parametersJavaTypes;

    public PojoConstructorIdentifier(PojoConstructorModel<?> constructor) {
        this.name = constructor.typeModel().name();
        this.parametersJavaTypes = constructor.parametersJavaTypes();
    }

    public String toHighlightedString(int position) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
