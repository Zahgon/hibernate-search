/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine;

import org.hibernate.search.util.common.annotation.Search5DeprecatedAPI;

/**
 * @author Emmanuel Bernard
 * @author Hardy Ferentschik
 */
public final class Version {

    private Version() {
        //not allowed
    }

    /**
     * @return A string representation of the version of Hibernate Search.
     */
    public static String versionString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A string representation of the version of Hibernate Search.
     * @deprecated Use {@link #versionString()} instead.
     */
    @Deprecated(since = "6.0")
    @Search5DeprecatedAPI
    public static String getVersionString() {
        return versionString();
    }
}
