/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.time.Duration;
import org.hibernate.search.engine.cfg.spi.ParseUtils;
import org.hibernate.search.mapper.pojo.logging.impl.FormattingLog;

public final class DefaultDurationBridge extends AbstractConvertingDefaultBridge<Duration, Long> {

    public static final DefaultDurationBridge INSTANCE = new DefaultDurationBridge();

    private DefaultDurationBridge() {
    }

    @Override
    protected String toString(Duration value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Duration fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Long toConvertedValue(Duration value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Duration fromConvertedValue(Long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
