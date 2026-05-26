/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.reporting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import org.hibernate.search.util.common.reporting.impl.CommonEventContextMessages;

/**
 * A sequence of {@link EventContextElement}.
 */
public final class EventContext {

    private static final CommonEventContextMessages MESSAGES = CommonEventContextMessages.INSTANCE;

    public static EventContext create(EventContextElement firstElement, EventContextElement... otherElements) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext concat(EventContext first, EventContext... others) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final EventContext parent;

    private final EventContextElement appendedElement;

    private EventContext(EventContext parent, EventContextElement appendedElement) {
        this.parent = parent;
        this.appendedElement = appendedElement;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The elements of this context. Never empty, does not contain {@code null} values.
     */
    public List<EventContextElement> elements() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A human-readable representation of this context.
     * This representation may change without prior notice in new versions of Hibernate Search:
     * callers should not try to parse it.
     */
    public String render() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A human-readable representation of this context, with a "Context: " prefix.
     * This representation may change without prior notice in new versions of Hibernate Search:
     * callers should not try to parse it.
     */
    public String renderWithPrefix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public EventContext append(EventContextElement other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public EventContext append(EventContext other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private EventContext appendTo(EventContext other) {
        EventContext result = other;
        if (parent != null) {
            result = parent.appendTo(result);
        }
        result = new EventContext(result, appendedElement);
        return result;
    }

    private void addTo(List<EventContextElement> list) {
        if (parent != null) {
            parent.addTo(list);
        }
        list.add(appendedElement);
    }
}
