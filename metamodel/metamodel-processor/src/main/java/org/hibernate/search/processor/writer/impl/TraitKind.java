/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.writer.impl;

enum TraitKind {

    UNTYPED(false, false, false), TYPED_INPUT(true, true, false), TYPED_OUTPUT(true, false, true);

    private final boolean requiresValueModel;

    private final boolean requiresInputType;

    private final boolean requiresOutputType;

    TraitKind(boolean requiresValueModel, boolean requiresInputType, boolean requiresOutputType) {
        this.requiresValueModel = requiresValueModel;
        this.requiresInputType = requiresInputType;
        this.requiresOutputType = requiresOutputType;
    }

    public boolean requiresValueModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean requiresInputType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean requiresOutputType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
