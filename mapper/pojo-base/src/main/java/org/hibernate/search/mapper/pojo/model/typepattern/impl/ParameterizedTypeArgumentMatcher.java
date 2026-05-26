/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.typepattern.impl;

import java.lang.reflect.TypeVariable;
import java.util.Optional;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

class ParameterizedTypeArgumentMatcher implements ExtractingTypePatternMatcher {

    private final Class<?> matchedRawType;

    private final int resultTypeParameterIndex;

    ParameterizedTypeArgumentMatcher(Class<?> matchedRawType, int resultTypeParameterIndex) {
        this.matchedRawType = matchedRawType;
        this.resultTypeParameterIndex = resultTypeParameterIndex;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<? extends PojoTypeModel<?>> extract(PojoTypeModel<?> typeToInspect) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
