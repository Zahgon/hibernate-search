/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.highlighter.dsl.impl;

import org.hibernate.search.engine.search.highlighter.SearchHighlighter;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterEncoder;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterFinalStep;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterOptionsStep;
import org.hibernate.search.engine.search.highlighter.spi.SearchHighlighterBuilder;

public class HighlighterOptionsStepImpl<T extends HighlighterOptionsStep<T>> implements HighlighterOptionsStep<T>, HighlighterFinalStep {

    protected final SearchHighlighterBuilder highlighterBuilder;

    public HighlighterOptionsStepImpl(SearchHighlighterBuilder highlighterBuilder) {
        this.highlighterBuilder = highlighterBuilder;
    }

    @Override
    public T encoder(HighlighterEncoder encoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T fragmentSize(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T noMatchSize(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T numberOfFragments(int number) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T orderByScore(boolean enable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T tag(String preTag, String postTag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private T thisAsT() {
        return (T) this;
    }

    @Override
    public SearchHighlighter toHighlighter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
