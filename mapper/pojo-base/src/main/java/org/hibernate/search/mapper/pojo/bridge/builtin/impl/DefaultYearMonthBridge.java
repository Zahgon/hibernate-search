/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import org.hibernate.search.engine.cfg.spi.ParseUtils;

public final class DefaultYearMonthBridge extends AbstractPassThroughDefaultBridge<YearMonth> {

    public static final DefaultYearMonthBridge INSTANCE = new DefaultYearMonthBridge();

    // The DateTimeFormatter class does not expose a public constant for the ISO format, so we need to do it ourselves.
    private static final DateTimeFormatter FORMATTER = ParseUtils.ISO_YEAR_MONTH;

    private DefaultYearMonthBridge() {
    }

    @Override
    protected String toString(YearMonth value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected YearMonth fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
