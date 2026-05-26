/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.dsl.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.hibernate.search.engine.logging.impl.EngineMiscLog;

/**
 * A utility class holding the state of the extension contexts found in several DSLs.
 *
 * @param <R> The result type to expect from functions applied to extended contexts.
 */
public final class DslExtensionState<R> {

    public static <E> E returnIfSupported(Object extension, Optional<E> extendedContextOptional) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean appliedAtLeastOneExtension = false;

    private boolean appliedOrElse = false;

    private R result = null;

    private List<Object> unsupportedExtensions;

    public <E> void ifSupported(Object extension, Optional<E> extendedContextOptional, Function<E, ? extends R> extendedContextFunction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> R orElse(T defaultContext, Consumer<T> defaultContextConsumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> R orElse(T defaultContext, Function<T, ? extends R> defaultContextFunction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public R orElseFail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
