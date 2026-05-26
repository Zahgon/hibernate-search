/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.bridge.builtin.impl;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.util.common.AssertionFailure;

public class DateResolutionUtil {

    private DateResolutionUtil() {
    }

    public static TemporalUnit getLowestTemporalUnit(Resolution resolution) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
