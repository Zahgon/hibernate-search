/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.pattern.spi;

import java.util.Objects;
import java.util.Optional;

/**
 * A simple glob pattern implementation that only supports the {@code *} wildcard.
 * <p>
 * Crucially, this implementation:
 * <ul>
 *     <li>does not rely on regexps and thus does not require any escaping of the pattern string;</li>
 *     <li>allows easily prepending a literal to a given pattern, which is convenient when working with index schemas.</li>
 * </ul>
 */
public abstract class SimpleGlobPattern {

    private static final char WILDCARD_MANY = '*';

    public static SimpleGlobPattern compile(String patternString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private SimpleGlobPattern() {
    }

    public boolean matches(String candidate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SimpleGlobPattern prependLiteral(String literal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SimpleGlobPattern prependMany() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<String> toLiteral() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract String toPatternString();

    protected abstract int minLength();

    protected abstract boolean matches(String candidate, int startIndex);

    private static final class EmptyGlobPattern extends SimpleGlobPattern {

        static final EmptyGlobPattern INSTANCE = new EmptyGlobPattern();

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toPatternString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected boolean matches(String candidate, int startIndex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected int minLength() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class LiteralGlobPattern extends SimpleGlobPattern {

        private final String literal;

        private final SimpleGlobPattern next;

        private LiteralGlobPattern(String literal, SimpleGlobPattern next) {
            this.literal = literal;
            this.next = next;
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
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected boolean matches(String candidate, int startIndex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SimpleGlobPattern prependLiteral(String literal) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Optional<String> toLiteral() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toPatternString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected int minLength() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class ManyGlobPattern extends SimpleGlobPattern {

        private final SimpleGlobPattern next;

        private final int minTailLength;

        private ManyGlobPattern(SimpleGlobPattern next) {
            this.next = next;
            this.minTailLength = next.minLength();
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
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected boolean matches(String candidate, int startIndex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SimpleGlobPattern prependMany() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toPatternString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected int minLength() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
