/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.predicate.impl;

import java.util.List;
import java.util.Objects;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import com.google.gson.JsonObject;

public abstract class AbstractElasticsearchNestablePredicate extends AbstractElasticsearchPredicate {

    AbstractElasticsearchNestablePredicate(AbstractElasticsearchPredicate.AbstractBuilder builder) {
        super(builder);
    }

    @Override
    public void checkNestableWithin(PredicateNestingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject toJsonQuery(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract List<String> getNestedPathHierarchy();

    protected abstract List<String> getFieldPathsForErrorMessage();
}
