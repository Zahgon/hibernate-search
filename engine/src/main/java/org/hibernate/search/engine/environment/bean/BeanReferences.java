/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.bean;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import org.hibernate.search.engine.logging.impl.EngineMiscLog;
import org.hibernate.search.util.common.impl.Contracts;

final class BeanReferences {

    private BeanReferences() {
    }

    public static <T> BeanReference<T> parse(Class<T> expectedType, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
