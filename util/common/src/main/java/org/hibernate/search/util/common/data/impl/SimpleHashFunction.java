/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.data.impl;

/**
 * A fast, but cryptographically insecure hash function,
 * based on Java's {@link String#toString()}.
 */
public final class SimpleHashFunction implements HashFunction {

    public static final SimpleHashFunction INSTANCE = new SimpleHashFunction();

    private SimpleHashFunction() {
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Hashes a {@code key}, i.e. turns it into an integer for use in a {@link HashTable}.
     * <p>
     * This implementation is the same hash function as Java's String.toString().
     * <p>
     * It does not delegate to String.toString() in order to protect against
     * future changes in the JDK (?) or different JDK implementations,
     * so that the resulting hash can safely be used for persistence
     * (e.g. to route data to a file).
     *
     * @param key A key to hash.
     * @return A hash.
     */
    @Override
    public int hash(CharSequence key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
