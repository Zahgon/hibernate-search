/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.reporting.spi;

import static org.hibernate.search.engine.logging.impl.EngineMiscLog.INSTANCE;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.hibernate.search.engine.reporting.impl.EngineEventContextMessages;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.data.impl.InsertionOrder;
import org.hibernate.search.util.common.impl.ToStringStyle;
import org.hibernate.search.util.common.impl.ToStringTreeBuilder;
import org.hibernate.search.util.common.reporting.EventContext;
import org.hibernate.search.util.common.reporting.EventContextElement;

public final class RootFailureCollector implements FailureCollector {

    /**
     * This prevents Hibernate Search from trying too hard to collect errors,
     * which could be a problem when there is something fundamentally wrong
     * that will cause almost every operation to fail.
     */
    // Exposed for tests
    static final int FAILURE_LIMIT = 100;

    private final String process;

    private final NonRootFailureCollector delegate;

    private final AtomicInteger failureCount = new AtomicInteger();

    public RootFailureCollector(String process) {
        this.process = process;
        this.delegate = new NonRootFailureCollector(this);
    }

    public void checkNoFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ContextualFailureCollector withContext(EventContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ContextualFailureCollector withContext(EventContextElement contextElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean shouldAddFailure() {
        return failureCount.incrementAndGet() <= FAILURE_LIMIT;
    }

    private static class NonRootFailureCollector implements FailureCollector {

        protected final RootFailureCollector root;

        private final InsertionOrder<EventContextElement> childrenInsertionOrder = new InsertionOrder<>();

        // Avoiding blocking implementations because we access this from reactive event loops
        private final Map<InsertionOrder.Key<EventContextElement>, ContextualFailureCollectorImpl> children = new ConcurrentSkipListMap<>();

        private NonRootFailureCollector(RootFailureCollector root) {
            this.root = root;
        }

        protected NonRootFailureCollector(NonRootFailureCollector parent) {
            this.root = parent.root;
        }

        @Override
        public ContextualFailureCollectorImpl withContext(EventContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public ContextualFailureCollectorImpl withContext(EventContextElement contextElement) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        ContextualFailureCollectorImpl withDefaultContext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        EventContext createEventContext(EventContextElement contextElement) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        final void appendChildrenFailuresTo(List<Throwable> failures, ToStringTreeBuilder builder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        final Collection<ContextualFailureCollectorImpl> children() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class ContextualFailureCollectorImpl extends NonRootFailureCollector implements ContextualFailureCollector {

        private final NonRootFailureCollector parent;

        private final EventContextElement contextElement;

        // Avoiding blocking implementations because we access this from reactive event loops
        private final Collection<Throwable> failures = new ConcurrentLinkedDeque<>();

        private final Collection<String> failureMessages = new ConcurrentLinkedDeque<>();

        private ContextualFailureCollectorImpl(NonRootFailureCollector parent, EventContextElement contextElement) {
            super(parent);
            this.parent = parent;
            this.contextElement = contextElement;
        }

        @Override
        public boolean hasFailure() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void add(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void add(String failureMessage) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        ContextualFailureCollectorImpl withDefaultContext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public EventContext eventContext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        EventContext createEventContext(EventContextElement contextElement) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void appendFailuresTo(List<Throwable> failures, ToStringTreeBuilder builder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void doAdd(Throwable failure, String failureMessage) {
            INSTANCE.newCollectedFailure(root.process, this, failure);
            if (root.shouldAddFailure()) {
                failureMessages.add(failureMessage);
                if (failure != null) {
                    failures.add(failure);
                }
            }
        }
    }
}
