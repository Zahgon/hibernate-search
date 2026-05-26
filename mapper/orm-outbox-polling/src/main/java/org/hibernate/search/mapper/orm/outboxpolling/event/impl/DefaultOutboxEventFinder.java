/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

public final class DefaultOutboxEventFinder implements OutboxEventFinder {

    private static final OutboxEventAndPredicate BASE_PREDICATE_FILTER = OutboxEventAndPredicate.of(new ProcessAfterFilter(), new ProcessPendingFilter());

    public static final class Provider extends OutboxEventFinderProvider {

        private final OutboxEventOrder order;

        public Provider(OutboxEventOrder order) {
            this.order = order;
        }

        @Override
        public void appendTo(ToStringTreeAppender appender) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public DefaultOutboxEventFinder create(Optional<OutboxEventPredicate> predicate) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public DefaultOutboxEventFinder createWithoutStatusOrProcessAfterFilter() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private final String queryString;

    private final Optional<OutboxEventPredicate> predicate;

    private final OutboxEventOrder order;

    private DefaultOutboxEventFinder(Optional<OutboxEventPredicate> predicate, OutboxEventOrder order) {
        this.queryString = createQueryString(predicate, alias -> alias, order);
        this.predicate = predicate;
        this.order = order;
    }

    @Override
    public List<OutboxEvent> findOutboxEvents(Session session, int maxResults) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Query<OutboxEvent> createOutboxEventQuery(Session session) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Query<T> createOutboxEventQueryForTests(Session session, Function<String, String> selectClauseFunction, Class<T> resultType, OutboxEventOrder order) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String createQueryString(Optional<OutboxEventPredicate> predicate, Function<String, String> selectClauseFunction, OutboxEventOrder order) {
        return "select " + selectClauseFunction.apply("e") + " from " + OutboxPollingOutboxEventAdditionalMappingProducer.ENTITY_NAME + " e " + (predicate.isPresent() ? " where " + predicate.get().queryPart("e") : "") + order.queryPart("e");
    }

    private static class ProcessAfterFilter implements OutboxEventPredicate {

        @Override
        public String queryPart(String eventAlias) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void setParams(Query<?> query) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class ProcessPendingFilter implements OutboxEventPredicate {

        @Override
        public String queryPart(String eventAlias) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void setParams(Query<?> query) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
