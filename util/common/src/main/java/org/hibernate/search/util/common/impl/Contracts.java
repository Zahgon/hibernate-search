/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.impl;

import java.util.Collection;
import org.hibernate.search.util.common.logging.impl.CommonMiscLog;

public final class Contracts {

    private Contracts() {
    }

    public static void assertNotNull(Object object, String objectDescription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void assertNotNullNorEmpty(Collection<?> object, String objectDescription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void assertNotNullNorEmpty(Object[] object, String objectDescription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void assertPositiveOrZero(int number, String objectDescription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void assertStrictlyPositive(int number, String objectDescription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void assertStrictlyPositive(long number, String objectDescription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void assertNotNullNorEmpty(String object, String objectDescription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void assertNoNullElement(Collection<?> collection, String collectionDescription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
