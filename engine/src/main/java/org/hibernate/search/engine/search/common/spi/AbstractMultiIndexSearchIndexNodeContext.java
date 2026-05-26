/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.common.spi;

import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.reporting.EventContext;

public abstract class AbstractMultiIndexSearchIndexNodeContext<S extends SearchIndexNodeContext<SC>, SC extends SearchIndexScope<?>, NT extends SearchIndexNodeTypeContext<SC, S>> implements SearchIndexNodeContext<SC>, SearchIndexNodeTypeContext<SC, S> {

    protected final SC scope;

    protected final String absolutePath;

    protected final List<? extends S> nodeForEachIndex;

    AbstractMultiIndexSearchIndexNodeContext(SC scope, String absolutePath, List<? extends S> nodeForEachIndex) {
        this.scope = scope;
        this.absolutePath = absolutePath;
        this.nodeForEachIndex = nodeForEachIndex;
    }

    protected abstract S self();

    protected abstract NT selfAsNodeType();

    protected abstract NT typeOf(S indexElement);

    @Override
    public final String absolutePath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String[] absolutePathComponents() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final List<String> nestedPathHierarchy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String nestedDocumentPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String closestMultiValuedParentAbsolutePath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean multiValued() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean multiValuedInRoot() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final EventContext indexesEventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final EventContext relativeEventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final <T> T queryElement(SearchQueryElementTypeKey<T> key, SC scope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchException cannotUseQueryElement(SearchQueryElementTypeKey<?> key, String hint, Exception causeOrNull) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract SearchIndexSchemaElementContextHelper helper();

    @Override
    public final <T> SearchQueryElementFactory<? extends T, ? super SC, ? super S> queryElementFactory(SearchQueryElementTypeKey<T> key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final <T> T fromNodeIfCompatible(Function<S, T> getter, BiPredicate<T, T> compatibilityChecker, String attributeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final <T> T fromTypeIfCompatible(Function<NT, T> getter, BiPredicate<T, T> compatibilityChecker, String attributeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <T> void checkFactoryCompatibility(SearchQueryElementTypeKey<T> key, SearchQueryElementFactory<? extends T, ? super SC, ? super S> factory1, SearchQueryElementFactory<? extends T, ? super SC, ? super S> factory2) {
        if (factory1 == null && factory2 == null) {
            return;
        }
        try {
            if (factory1 == null || factory2 == null) {
                throw QueryLog.INSTANCE.partialSupportForQueryElement(key, helper().partialSupportHint());
            }
            factory1.checkCompatibleWith(factory2);
        } catch (SearchException e) {
            SearchException inconsistentSupportException = QueryLog.INSTANCE.inconsistentSupportForQueryElement(key, e.getMessage(), e);
            throw QueryLog.INSTANCE.inconsistentConfigurationInContextForSearch(relativeEventContext(), inconsistentSupportException.getMessage(), indexesEventContext(), inconsistentSupportException);
        }
    }

    final <T> void checkAttributeCompatibility(BiPredicate<T, T> compatibilityChecker, String attributeName, T attribute1, T attribute2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
