/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.util.Arrays;
import org.hibernate.search.engine.cfg.spi.ParseUtils;

public final class DefaultFloatArrayBridge extends AbstractPassThroughDefaultBridge<float[]> {

    public static final DefaultFloatArrayBridge INSTANCE = new DefaultFloatArrayBridge();

    private DefaultFloatArrayBridge() {
    }

    @Override
    protected String toString(float[] value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected float[] fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
