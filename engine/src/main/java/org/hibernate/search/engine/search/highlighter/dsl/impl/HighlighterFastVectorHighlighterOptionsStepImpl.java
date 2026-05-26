/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.highlighter.dsl.impl;

import java.util.Collection;
import java.util.Locale;
import java.util.function.Consumer;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterBoundaryScannerFastVectorHighlighterOptionsStep;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterBoundaryScannerTypeFastVectorHighlighterStep;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterFastVectorHighlighterOptionsStep;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterTagSchema;
import org.hibernate.search.engine.search.highlighter.spi.BoundaryScannerType;
import org.hibernate.search.engine.search.highlighter.spi.SearchHighlighterBuilder;
import org.hibernate.search.engine.search.highlighter.spi.SearchHighlighterType;
import org.hibernate.search.util.common.impl.Contracts;

public class HighlighterFastVectorHighlighterOptionsStepImpl extends HighlighterOptionsStepImpl<HighlighterFastVectorHighlighterOptionsStep> implements HighlighterFastVectorHighlighterOptionsStep {

    public HighlighterFastVectorHighlighterOptionsStepImpl(SearchHighlighterBuilder highlightBuilder) {
        super(highlightBuilder);
        this.highlighterBuilder.type(SearchHighlighterType.FAST_VECTOR);
    }

    @Override
    public HighlighterFastVectorHighlighterOptionsStep phraseLimit(int limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HighlighterFastVectorHighlighterOptionsStep tags(Collection<String> preTags, String postTag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HighlighterFastVectorHighlighterOptionsStep tags(Collection<String> preTags, Collection<String> postTags) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HighlighterFastVectorHighlighterOptionsStep tagSchema(HighlighterTagSchema tagSchema) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HighlighterBoundaryScannerTypeFastVectorHighlighterStep<? extends HighlighterFastVectorHighlighterOptionsStep> boundaryScanner() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HighlighterFastVectorHighlighterOptionsStep boundaryScanner(Consumer<? super HighlighterBoundaryScannerTypeFastVectorHighlighterStep<?>> boundaryScannerContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class HighlighterBoundaryScannerTypeFastVectorHighlighterStepImpl implements HighlighterBoundaryScannerTypeFastVectorHighlighterStep<HighlighterFastVectorHighlighterOptionsStep> {

        @Override
        public HighlighterBoundaryScannerFastVectorHighlighterOptionsStep<HighlighterFastVectorHighlighterOptionsStep> chars() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HighlighterBoundaryScannerFastVectorHighlighterOptionsStep<HighlighterFastVectorHighlighterOptionsStep> sentence() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HighlighterBoundaryScannerFastVectorHighlighterOptionsStep<HighlighterFastVectorHighlighterOptionsStep> word() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private class HighlighterBoundaryScannerFastVectorHighlighterOptionsStepImpl implements HighlighterBoundaryScannerFastVectorHighlighterOptionsStep<HighlighterFastVectorHighlighterOptionsStep> {

        @Override
        public HighlighterBoundaryScannerFastVectorHighlighterOptionsStep<HighlighterFastVectorHighlighterOptionsStep> boundaryMaxScan(int max) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HighlighterBoundaryScannerFastVectorHighlighterOptionsStep<HighlighterFastVectorHighlighterOptionsStep> boundaryChars(String boundaryChars) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HighlighterBoundaryScannerFastVectorHighlighterOptionsStep<HighlighterFastVectorHighlighterOptionsStep> boundaryChars(char... boundaryChars) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HighlighterBoundaryScannerFastVectorHighlighterOptionsStep<HighlighterFastVectorHighlighterOptionsStep> locale(Locale locale) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HighlighterFastVectorHighlighterOptionsStep end() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
