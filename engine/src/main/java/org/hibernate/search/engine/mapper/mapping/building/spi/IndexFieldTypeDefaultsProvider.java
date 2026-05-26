/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.mapper.mapping.building.spi;

public class IndexFieldTypeDefaultsProvider {

    private final Integer decimalScale;

    public IndexFieldTypeDefaultsProvider() {
        this(null);
    }

    public IndexFieldTypeDefaultsProvider(Integer decimalScale) {
        this.decimalScale = decimalScale;
    }

    public Integer decimalScale() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
