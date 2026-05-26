/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.logging.impl;

import java.lang.invoke.MethodHandles.Lookup;
import java.util.Locale;
import org.jboss.logging.Logger;

public final class LoggerFactory {

    private LoggerFactory() {
        //not allowed
    }

    public static <T> T make(Class<T> logClass, Lookup creationContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> T make(Class<T> logClass, String category, Lookup creationContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
