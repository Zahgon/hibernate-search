/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.util.impl;

import java.lang.reflect.Field;

public final class DefaultBackendVersionUtils {

    private DefaultBackendVersionUtils() {
    }

    public static String latestElasticsearchVersion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String latestLuceneVersion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
