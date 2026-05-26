/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import org.hibernate.search.engine.cfg.spi.ParseUtils;

public final class DefaultFloatBridge extends AbstractPassThroughDefaultBridge<Float> {

    public static final DefaultFloatBridge INSTANCE = new DefaultFloatBridge();

    private DefaultFloatBridge() {
    }

    @Override
    protected String toString(Float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Float fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
