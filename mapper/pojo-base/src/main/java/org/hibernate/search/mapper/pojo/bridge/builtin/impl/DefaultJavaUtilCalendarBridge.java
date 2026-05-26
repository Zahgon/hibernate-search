/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public final class DefaultJavaUtilCalendarBridge extends AbstractConvertingDelegatingDefaultBridge<Calendar, ZonedDateTime> {

    public static final DefaultJavaUtilCalendarBridge INSTANCE = new DefaultJavaUtilCalendarBridge();

    public DefaultJavaUtilCalendarBridge() {
        super(DefaultZonedDateTimeBridge.INSTANCE);
    }

    @Override
    protected ZonedDateTime toConvertedValue(Calendar value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Calendar fromConvertedValue(ZonedDateTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
