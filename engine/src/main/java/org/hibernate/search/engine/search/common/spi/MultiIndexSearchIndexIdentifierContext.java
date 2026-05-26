/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.common.spi;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.hibernate.search.engine.backend.scope.spi.AbstractSearchIndexScope;
import org.hibernate.search.engine.backend.types.converter.spi.DslConverter;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.reporting.EventContext;

public class MultiIndexSearchIndexIdentifierContext implements SearchIndexIdentifierContext {

    private final SearchIndexScope<?> scope;

    private final List<SearchIndexIdentifierContext> contextByIndex;

    public MultiIndexSearchIndexIdentifierContext(AbstractSearchIndexScope<?, ?, ?, ?, ?> scope, List<SearchIndexIdentifierContext> contextByIndex) {
        this.scope = scope;
        this.contextByIndex = contextByIndex;
    }

    @Override
    public EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EventContext relativeEventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DslConverter<?, String> mappingDslConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DslConverter<?, String> parserDslConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionConverter<String, ?> mappingProjectionConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final <T> T fromContextsIfCompatible(Function<SearchIndexIdentifierContext, T> getter, BiPredicate<T, T> compatibilityChecker, String attributeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <T> void checkAttributeCompatibility(BiPredicate<T, T> compatibilityChecker, String attributeName, T attribute1, T attribute2) {
        try {
            if (!compatibilityChecker.test(attribute1, attribute2)) {
                throw QueryLog.INSTANCE.differentAttribute(attributeName, attribute1, attribute2);
            }
        } catch (SearchException e) {
            throw QueryLog.INSTANCE.inconsistentConfigurationInContextForSearch(relativeEventContext(), e.getMessage(), scope.eventContext(), e);
        }
    }
}
