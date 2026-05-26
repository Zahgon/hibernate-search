/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.time.Period;
import java.util.Locale;
import org.hibernate.search.engine.cfg.spi.ParseUtils;
import org.hibernate.search.mapper.pojo.logging.impl.FormattingLog;

public final class DefaultPeriodBridge extends AbstractConvertingDefaultBridge<Period, String> {

    private static final int PADDING = 11;

    private static final String INDEXED_FORMAT = "%+0" + PADDING + "d%+0" + PADDING + "d%+0" + PADDING + "d";

    public static final DefaultPeriodBridge INSTANCE = new DefaultPeriodBridge();

    private DefaultPeriodBridge() {
    }

    @Override
    protected String toString(Period value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Period fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected String toConvertedValue(Period value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Period fromConvertedValue(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
