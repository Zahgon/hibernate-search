/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import static org.hibernate.search.util.common.impl.CollectionHelper.isSubset;
import static org.hibernate.search.util.common.impl.CollectionHelper.notInTheOtherSet;
import java.util.Set;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.apache.lucene.search.Query;

public interface LuceneSearchPredicate extends SearchPredicate {

    Set<String> indexNames();

    void checkNestableWithin(String expectedParentNestedPath);

    Query toQuery(PredicateRequestContext context);

    static LuceneSearchPredicate from(LuceneSearchIndexScope<?> scope, SearchPredicate predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
