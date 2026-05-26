/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.binding.impl;

import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeOptionsStep;
import org.hibernate.search.engine.backend.types.dsl.ScaledNumberIndexFieldTypeOptionsStep;
import org.hibernate.search.engine.backend.types.dsl.SearchableProjectableIndexFieldTypeOptionsStep;
import org.hibernate.search.engine.backend.types.dsl.StandardIndexFieldTypeOptionsStep;
import org.hibernate.search.engine.backend.types.dsl.StringIndexFieldTypeOptionsStep;
import org.hibernate.search.engine.backend.types.dsl.VectorFieldTypeOptionsStep;
import org.hibernate.search.mapper.pojo.bridge.ValueBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.spi.FieldModelContributorContext;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;

final class FieldModelContributorContextImpl<F> implements FieldModelContributorContext {

    private final ValueBridge<?, F> bridge;

    private final IndexFieldTypeOptionsStep<?, ? super F> fieldTypeOptionsStep;

    FieldModelContributorContextImpl(ValueBridge<?, F> bridge, IndexFieldTypeOptionsStep<?, ? super F> fieldTypeOptionsStep) {
        this.bridge = bridge;
        this.fieldTypeOptionsStep = fieldTypeOptionsStep;
    }

    @Override
    public void indexNullAs(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * If fieldTypeOptionsStep is an instance of IndexFieldTypeOptionsStep<?, ? super F>
	 * and StandardIndexFieldTypeOptionsStep,
	 * it's an instance of StandardIndexFieldTypeOptionsStep<?, ? super F>
	 */
    @SuppressWarnings("unchecked")
    @Override
    public StandardIndexFieldTypeOptionsStep<?, ? super F> standardTypeOptionsStep() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StringIndexFieldTypeOptionsStep<?> stringTypeOptionsStep() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ScaledNumberIndexFieldTypeOptionsStep<?, ?> scaledNumberTypeOptionsStep() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public VectorFieldTypeOptionsStep<?, ?> vectorTypeOptionsStep() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public SearchableProjectableIndexFieldTypeOptionsStep<?, ? super F> searchableProjectableIndexFieldTypeOptionsStep() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void checkNonStandardTypeOptionsStep() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
