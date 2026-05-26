/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import org.hibernate.search.engine.cfg.spi.ParseUtils;

public final class DefaultIntegerBridge extends AbstractPassThroughDefaultBridge<Integer> {

    public static final DefaultIntegerBridge INSTANCE = new DefaultIntegerBridge();

    private DefaultIntegerBridge() {
    }

    @Override
    protected String toString(Integer value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Integer fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
