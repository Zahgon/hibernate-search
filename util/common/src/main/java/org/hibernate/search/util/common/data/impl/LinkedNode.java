/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.data.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.hibernate.search.util.common.impl.Contracts;

/**
 * A very simple, immutable data structure to represent singly linked lists.
 *
 * @param <T> The type of values stored in the list.
 */
public final class LinkedNode<T> implements Iterable<T> {

    public static <T> LinkedNode<T> of(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    public static <T> LinkedNode<T> of(T... values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final T value;

    private final LinkedNode<T> tail;

    // For quick access
    public final LinkedNode<T> last;

    private LinkedNode(T value, LinkedNode<T> tail) {
        this.value = value;
        this.tail = tail;
        this.last = tail == null ? this : tail.last;
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

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Stream<T> stream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public LinkedNode<T> withHead(T headValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param valuePredicate A predicate to apply to node values.
     * @return An optional containing the path from the found node to the current head,
     * i.e. a reversed list of all values
     * from the first node to match the given predicate to the current head
     * (note: the list is purposely in reversed order compared to {@code this}),
     * or an empty optional if no matching value was found.
     */
    public Optional<LinkedNode<T>> findAndReverse(Predicate<T> valuePredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<LinkedNode<T>> findAndReverse(Predicate<T> valuePredicate, LinkedNode<T> head) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param newTail The tail of the new "reversed" node.
     * @param lastIncludedNode The last node to include in the reversed list;
     * must be in the tail of {@code this}.
     * @return A list including all values from {@code lastNode} to {@code this},
     * in reversed order.
     */
    private LinkedNode<T> reverse(LinkedNode<T> newTail, LinkedNode<T> lastIncludedNode) {
        LinkedNode<T> thisWithNewTail = new LinkedNode<>(value, newTail);
        if (lastIncludedNode == this) {
            return thisWithNewTail;
        } else {
            return tail.reverse(thisWithNewTail, lastIncludedNode);
        }
    }
}
