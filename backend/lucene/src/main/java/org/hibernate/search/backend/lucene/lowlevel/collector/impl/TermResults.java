/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.search.backend.lucene.types.aggregation.impl.BucketOrder;
import org.hibernate.search.backend.lucene.types.aggregation.impl.LongBucket;
import com.carrotsearch.hppc.LongObjectHashMap;
import com.carrotsearch.hppc.procedures.LongObjectProcedure;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.CollectorManager;
import org.apache.lucene.util.PriorityQueue;

public class TermResults {

    @SuppressWarnings("unchecked")
    static final TermResults EMPTY = new TermResults(new CollectorKey[0], new CollectorManager[0]);

    private final CollectorKey<?, ?>[] collectorKeys;

    private final CollectorManager<Collector, ?>[] managers;

    private final LongObjectHashMap<LongBucket> buckets = new LongObjectHashMap<>();

    TermResults(CollectorKey<?, ?>[] collectorKeys, CollectorManager<Collector, ?>[] managers) {
        this.collectorKeys = collectorKeys;
        this.managers = managers;
    }

    public List<LongBucket> counts(BucketOrder order, int topN, int minDocCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void add(LongObjectHashMap<TermCollectorSegmentValue> segmentValues) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void merge(LongObjectHashMap<LongBucket> values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CollectorKey<?, ?>[] collectorKeys() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CollectorManager<Collector, ?>[] collectorManagers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class HibernateSearchBucketOrderQueue extends PriorityQueue<LongBucket> {

        private final Comparator<LongBucket> comparator;

        public HibernateSearchBucketOrderQueue(BucketOrder order, int maxSize) {
            super(maxSize);
            this.comparator = order.toLongBucketComparator();
        }

        @Override
        protected boolean lessThan(LongBucket t1, LongBucket t2) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
