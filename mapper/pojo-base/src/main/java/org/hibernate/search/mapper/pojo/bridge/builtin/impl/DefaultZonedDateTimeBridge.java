/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.hibernate.search.engine.cfg.spi.ParseUtils;

public final class DefaultZonedDateTimeBridge extends AbstractPassThroughDefaultBridge<ZonedDateTime> {

    public static final DefaultZonedDateTimeBridge INSTANCE = new DefaultZonedDateTimeBridge();

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    private DefaultZonedDateTimeBridge() {
    }

    @Override
    protected String toString(ZonedDateTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ZonedDateTime fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
