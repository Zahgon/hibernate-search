/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.alternative.impl;

import org.hibernate.search.mapper.pojo.bridge.binding.MarkerBindingContext;
import org.hibernate.search.mapper.pojo.bridge.builtin.programmatic.AlternativeDiscriminatorBinder;

public final class AlternativeDiscriminatorBinderImpl implements AlternativeDiscriminatorBinder {

    private String id;

    @Override
    public AlternativeDiscriminatorBinder id(String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void bind(MarkerBindingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class Marker {

        private final String id;

        private Marker(String id) {
            this.id = id;
        }

        public String id() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
