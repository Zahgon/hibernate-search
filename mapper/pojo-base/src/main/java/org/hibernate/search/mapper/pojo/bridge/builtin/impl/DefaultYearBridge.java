/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.time.Year;
import java.time.format.DateTimeFormatter;
import org.hibernate.search.engine.cfg.spi.ParseUtils;

public final class DefaultYearBridge extends AbstractPassThroughDefaultBridge<Year> {

    public static final DefaultYearBridge INSTANCE = new DefaultYearBridge();

    // The DateTimeFormatter class does not expose a public constant for the ISO format, so we need to do it ourselves.
    private static final DateTimeFormatter FORMATTER = ParseUtils.ISO_YEAR;

    private DefaultYearBridge() {
    }

    @Override
    protected String toString(Year value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Year fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
