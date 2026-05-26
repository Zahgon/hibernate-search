/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.util.Optional;
import org.hibernate.query.Query;
import org.hibernate.search.util.common.data.Range;
import org.hibernate.search.util.common.data.RangeBoundInclusion;

public final class EntityIdHashRangeOutboxEventPredicate implements OutboxEventPredicate {

    private static final String LOWER_BOUND_PARAM_NAME = "lowerHash";

    private static final String UPPER_BOUND_PARAM_NAME = "upperHash";

    private final Integer lowerBoundIncluded;

    private final Integer upperBoundIncluded;

    public EntityIdHashRangeOutboxEventPredicate(Range<Integer> range) {
        Optional<Integer> lowerBound = range.lowerBoundValue();
        if (lowerBound.isPresent()) {
            Integer lowerBoundValue = lowerBound.get();
            if (range.lowerBoundInclusion() == RangeBoundInclusion.EXCLUDED) {
                ++lowerBoundValue;
            }
            lowerBoundIncluded = lowerBoundValue;
        } else {
            lowerBoundIncluded = null;
        }
        Optional<Integer> upperBound = range.upperBoundValue();
        if (upperBound.isPresent()) {
            Integer upperBoundValue = upperBound.get();
            if (range.upperBoundInclusion() == RangeBoundInclusion.EXCLUDED) {
                --upperBoundValue;
            }
            upperBoundIncluded = upperBoundValue;
        } else {
            upperBoundIncluded = null;
        }
    }

    @Override
    public String queryPart(String eventAlias) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setParams(Query<?> query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
