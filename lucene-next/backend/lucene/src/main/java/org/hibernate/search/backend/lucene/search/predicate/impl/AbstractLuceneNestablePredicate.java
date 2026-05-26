/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import java.util.List;
import java.util.Objects;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.apache.lucene.search.Query;

abstract class AbstractLuceneNestablePredicate extends AbstractLuceneSearchPredicate {

    AbstractLuceneNestablePredicate(AbstractBuilder builder) {
        super(builder);
    }

    @Override
    public void checkNestableWithin(String expectedParentNestedPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Query toQuery(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract List<String> getNestedPathHierarchy();

    protected abstract List<String> getFieldPathsForErrorMessage();
}
