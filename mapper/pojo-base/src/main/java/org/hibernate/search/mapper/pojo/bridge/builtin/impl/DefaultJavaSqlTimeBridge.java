/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.sql.Time;
import java.time.Instant;

public final class DefaultJavaSqlTimeBridge extends AbstractConvertingDelegatingDefaultBridge<Time, Instant> {

    public static final DefaultJavaSqlTimeBridge INSTANCE = new DefaultJavaSqlTimeBridge();

    public DefaultJavaSqlTimeBridge() {
        super(DefaultInstantBridge.INSTANCE);
    }

    @Override
    protected Instant toConvertedValue(Time value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Time fromConvertedValue(Instant value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
