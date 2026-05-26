/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.highlighter.dsl.spi;

import org.hibernate.search.engine.search.common.spi.SearchIndexScope;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterFastVectorHighlighterOptionsStep;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterPlainOptionsStep;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterUnifiedOptionsStep;
import org.hibernate.search.engine.search.highlighter.dsl.SearchHighlighterFactory;
import org.hibernate.search.engine.search.highlighter.dsl.impl.HighlighterFastVectorHighlighterOptionsStepImpl;
import org.hibernate.search.engine.search.highlighter.dsl.impl.HighlighterPlainOptionsStepImpl;
import org.hibernate.search.engine.search.highlighter.dsl.impl.HighlighterUnifiedOptionsStepImpl;
import org.hibernate.search.engine.search.highlighter.spi.SearchHighlighterBuilder;

public abstract class AbstractSearchHighlighterFactory<SC extends SearchIndexScope<?>> implements SearchHighlighterFactory {

    private final SC scope;

    protected AbstractSearchHighlighterFactory(SC scope) {
        this.scope = scope;
    }

    @Override
    public HighlighterUnifiedOptionsStep unified() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HighlighterPlainOptionsStep plain() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HighlighterFastVectorHighlighterOptionsStep fastVector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract SearchHighlighterBuilder highlighterBuilder(SC scope);
}
