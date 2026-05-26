/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.aggregation.impl;

import java.util.Comparator;

public enum BucketOrder {

    COUNT_ASC {

        @Override
        <F, R> Comparator<Bucket<F, R>> toBucketComparatorInternal(Comparator<F> termComparator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        Comparator<LongBucket> toLongBucketComparatorInternal() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , COUNT_DESC {

        @Override
        <F, R> Comparator<Bucket<F, R>> toBucketComparatorInternal(Comparator<F> termComparator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        Comparator<LongBucket> toLongBucketComparatorInternal() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , TERM_ASC {

        @Override
        <F, R> Comparator<Bucket<F, R>> toBucketComparatorInternal(Comparator<F> termComparator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        Comparator<LongBucket> toLongBucketComparatorInternal() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , TERM_DESC {

        @Override
        boolean isTermOrderDescending() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        <F, R> Comparator<Bucket<F, R>> toBucketComparatorInternal(Comparator<F> termComparator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        Comparator<LongBucket> toLongBucketComparatorInternal() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ;

    public <F, R> Comparator<Bucket<F, R>> toBucketComparator(Comparator<F> termAscendingComparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Comparator<LongBucket> toLongBucketComparator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract <F, R> Comparator<Bucket<F, R>> toBucketComparatorInternal(Comparator<F> termComparator);

    abstract Comparator<LongBucket> toLongBucketComparatorInternal();

    boolean isTermOrderDescending() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
