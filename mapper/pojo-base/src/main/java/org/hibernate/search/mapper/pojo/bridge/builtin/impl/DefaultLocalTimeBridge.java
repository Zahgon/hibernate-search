/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.hibernate.search.engine.cfg.spi.ParseUtils;

public final class DefaultLocalTimeBridge extends AbstractPassThroughDefaultBridge<LocalTime> {

    public static final DefaultLocalTimeBridge INSTANCE = new DefaultLocalTimeBridge();

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME;

    private DefaultLocalTimeBridge() {
    }

    @Override
    protected String toString(LocalTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LocalTime fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
