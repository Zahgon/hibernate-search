/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.data.impl;

/**
 * A fast, but cryptographically insecure hash function,
 * implementing Murmur3.
 * <p>
 * See MurmurHash3_x86_32 in <a
 * href="https://github.com/aappleby/smhasher/blob/master/src/MurmurHash3.cpp">the C++
 * implementation</a>.
 * <p>
 * This function is more complex than {@link SimpleHashFunction}, but is suitable for use in {@link RangeHashTable},
 * because it produces a more uniform hash distribution,
 * even for datasets with very similar strings (same length, small character set, ...).
 * <p>
 * MurmurHash3 was written by Austin Appleby, and is placed in the public
 * domain. The author hereby disclaims copyright to this source code.
 * <p>
 * Original source code:
 * http://code.google.com/p/smhasher/source/browse/trunk/MurmurHash3.cpp
 * (Modified to adapt to Guava coding conventions and to use Guava's HashFunction interface,
 * then modified again to adapt to Hibernate Search's coding conventions
 * and to remove code that is unnecessary in Hibernate Search).
 *
 * @author Austin Appleby
 * @author Dimitris Andreou
 * @author Kurt Alfred Kluever
 */
public final class Murmur3HashFunction implements RangeCompatibleHashFunction {

    public static final Murmur3HashFunction INSTANCE = new Murmur3HashFunction(0);

    private static final int BYTES_PER_CHAR = Character.SIZE / Byte.SIZE;

    private static final int C1 = 0xcc9e2d51;

    private static final int C2 = 0x1b873593;

    private final int seed;

    private Murmur3HashFunction(int seed) {
        this.seed = seed;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hash(CharSequence input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static int mixK1(int k1) {
        k1 *= C1;
        k1 = Integer.rotateLeft(k1, 15);
        k1 *= C2;
        return k1;
    }

    private static int mixH1(int h1, int k1) {
        h1 ^= k1;
        h1 = Integer.rotateLeft(h1, 13);
        h1 = h1 * 5 + 0xe6546b64;
        return h1;
    }

    // Finalization mix - force all bits of a hash block to avalanche
    private static int fmix(int h1, int length) {
        h1 ^= length;
        h1 ^= h1 >>> 16;
        h1 *= 0x85ebca6b;
        h1 ^= h1 >>> 13;
        h1 *= 0xc2b2ae35;
        h1 ^= h1 >>> 16;
        return h1;
    }
}
