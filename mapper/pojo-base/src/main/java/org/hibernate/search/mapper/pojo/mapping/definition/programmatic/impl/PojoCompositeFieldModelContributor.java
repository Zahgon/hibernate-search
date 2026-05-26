/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFactory;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeOptionsStep;
import org.hibernate.search.mapper.pojo.bridge.binding.spi.FieldModelContributor;
import org.hibernate.search.mapper.pojo.bridge.binding.spi.FieldModelContributorContext;

class PojoCompositeFieldModelContributor implements FieldModelContributor {

    public interface DefaultInitiator {

        <F> IndexFieldTypeOptionsStep<?, F> initiate(IndexFieldTypeFactory factory, Class<F> clazz);
    }

    public interface Contributor {

        void contribute(FieldModelContributorContext context);
    }

    private final DefaultInitiator defaultInitiator;

    private final List<Contributor> delegates = new ArrayList<>();

    PojoCompositeFieldModelContributor(DefaultInitiator defaultInitiator) {
        this.defaultInitiator = defaultInitiator;
    }

    @Override
    public <F> IndexFieldTypeOptionsStep<?, F> inferDefaultFieldType(IndexFieldTypeFactory factory, Class<F> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void add(Contributor delegate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contribute(FieldModelContributorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
