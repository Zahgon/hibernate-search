/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.OutboxEventProcessingOrder;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.UuidGenerationStrategy;
import org.hibernate.search.util.common.AssertionFailure;

public enum OutboxEventOrder {

    NONE {

        @Override
        String queryPart(String eventAlias) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , TIME {

        @Override
        String queryPart(String eventAlias) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , ID {

        @Override
        String queryPart(String eventAlias) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ;

    abstract String queryPart(String eventAlias);

    public static OutboxEventOrder of(OutboxEventProcessingOrder order, UuidGenerationStrategy uuidGenerationStrategy, Dialect dialect) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
