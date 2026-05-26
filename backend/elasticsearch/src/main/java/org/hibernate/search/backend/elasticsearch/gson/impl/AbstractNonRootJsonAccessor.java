/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import com.google.gson.JsonElement;

abstract class AbstractNonRootJsonAccessor<P extends JsonElement, T> implements JsonAccessor<T> {

    private final JsonAccessor<P> parentAccessor;

    public AbstractNonRootJsonAccessor(JsonAccessor<P> parentAccessor) {
        super();
        this.parentAccessor = parentAccessor;
    }

    protected JsonAccessor<P> getParentAccessor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract void appendRuntimeRelativePath(StringBuilder path);

    protected abstract void appendStaticRelativePath(StringBuilder path, boolean first);
}
