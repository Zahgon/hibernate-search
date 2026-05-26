/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.search.backend.lucene.search.predicate.impl.LuceneSearchPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.lucene.search.sort.impl.LuceneSearchSort;
import org.hibernate.search.backend.lucene.search.sort.impl.LuceneSearchSortCollector;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;

public final class LuceneMigrationUtils {

    private LuceneMigrationUtils() {
    }

    public static Query toLuceneQuery(SearchPredicate predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Sort toLuceneSort(SearchSort sort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
