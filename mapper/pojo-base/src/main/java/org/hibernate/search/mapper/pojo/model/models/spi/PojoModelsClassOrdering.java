/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.models.spi;

import java.util.stream.Stream;
import org.hibernate.models.spi.ClassBasedTypeDetails;
import org.hibernate.models.spi.ClassDetails;
import org.hibernate.models.spi.ClassDetailsRegistry;
import org.hibernate.models.spi.TypeDetails;
import org.hibernate.search.util.common.reflect.spi.AbstractTypeOrdering;

final class PojoModelsClassOrdering extends AbstractTypeOrdering<ClassDetails> {

    private final ClassDetailsRegistry classDetailsRegistry;

    PojoModelsClassOrdering(ClassDetailsRegistry classDetailsRegistry) {
        this.classDetailsRegistry = classDetailsRegistry;
    }

    @Override
    protected ClassDetails superClass(ClassDetails subType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Stream<ClassDetails> declaredInterfaces(ClassDetails subType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
