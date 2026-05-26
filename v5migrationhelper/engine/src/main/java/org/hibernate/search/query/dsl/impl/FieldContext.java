/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.predicate.dsl.MultiFieldPredicateFieldBoostStep;

/**
 * @author Emmanuel Bernard
 */
public class FieldContext {

    private final String field;

    private boolean ignoreAnalyzer;

    private float fieldBoost = 1.0f;

    private boolean ignoreFieldBridge;

    public FieldContext(String field) {
        this.field = field;
    }

    public String getField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean skipAnalysis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setIgnoreAnalyzer(boolean ignoreAnalyzer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <S> S applyBoost(MultiFieldPredicateFieldBoostStep<S> step) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ValueModel getValueModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setIgnoreFieldBridge(boolean ignoreFieldBridge) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
