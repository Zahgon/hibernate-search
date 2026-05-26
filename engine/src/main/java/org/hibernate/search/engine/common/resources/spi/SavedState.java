/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.resources.spi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.hibernate.search.engine.logging.impl.EngineMiscLog;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.Contracts;
import org.hibernate.search.util.common.impl.Throwables;
import org.hibernate.search.util.common.spi.ClosingOperator;

public class SavedState implements AutoCloseable {

    private static final SavedState EMPTY = new SavedState.Builder().build();

    public static SavedState empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Map<Key<?>, SavedValue<?, ?>> content;

    private SavedState(Builder builder) {
        this.content = builder.content;
    }

    // values have always the corresponding key generic type
    @SuppressWarnings("unchecked")
    public <T> Optional<T> get(Key<T> key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Key<T> key(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class Key<T> {

        private final String name;

        private Key(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object o) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void closeAll(Map<?, SavedState> map) {
        try (Closer<RuntimeException> closer = new Closer<>()) {
            closer.pushAll(entry -> {
                try {
                    entry.getValue().close();
                } catch (RuntimeException e) {
                    throw EngineMiscLog.INSTANCE.unableToCloseSavedValue(Throwables.safeToString(e, entry.toString()), e.getMessage(), e);
                }
            }, map.entrySet());
        }
    }

    public static final class Builder {

        private final Map<Key<?>, SavedValue<?, ?>> content = new LinkedHashMap<>();

        private Builder() {
        }

        public Builder put(Key<SavedState> key, SavedState value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder put(SavedState.Key<Map<String, SavedState>> key, Map<String, SavedState> value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        // values have always the corresponding key generic type
        public <T> Builder put(Key<T> key, T value, ClosingOperator<T, ? extends Exception> closingOperator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SavedState build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class SavedValue<T, E extends Exception> {

        private final T value;

        private final ClosingOperator<T, ? extends Exception> closingOperator;

        private boolean close = true;

        public SavedValue(T value, ClosingOperator<T, ? extends Exception> closingOperator) {
            this.value = value;
            this.closingOperator = closingOperator;
        }

        public T value() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void close(Key<?> key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
