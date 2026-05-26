/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.common.spi;

import java.util.Objects;
import org.hibernate.search.engine.logging.impl.MappingLog;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.reporting.impl.EngineHints;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.reporting.EventContext;

public abstract class SearchIndexSchemaElementContextHelper {

    public static <T extends SearchIndexCompositeNodeContext<?>> T throwingToComposite(SearchIndexNodeContext<?> element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends SearchIndexCompositeNodeContext<?>> T throwingToObjectField(SearchIndexNodeContext<?> element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends SearchIndexValueFieldContext<?>> T throwingToValueField(SearchIndexNodeContext<?> element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void checkNestedDocumentPathCompatibility(SearchIndexNodeContext<?> left, SearchIndexNodeContext<?> right) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static EventContext pathEventContext(String path) {
        return path == null ? EventContexts.indexSchemaRoot() : EventContexts.fromIndexFieldAbsolutePath(path);
    }

    private SearchIndexSchemaElementContextHelper() {
    }

    public static final SearchIndexSchemaElementContextHelper VALUE_FIELD = new SearchIndexSchemaElementContextHelper() {

        @Override
        protected String missingSupportHint(SearchQueryElementTypeKey<?> key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String partialSupportHint() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final SearchIndexSchemaElementContextHelper COMPOSITE = new SearchIndexSchemaElementContextHelper() {

        @Override
        protected String missingSupportHint(SearchQueryElementTypeKey<?> key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String partialSupportHint() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public <T, SC extends SearchIndexScope<?>, N extends SearchIndexNodeContext<SC>> T queryElement(SearchQueryElementTypeKey<T> key, SearchQueryElementFactory<? extends T, ? super SC, ? super N> factory, SC scope, N node) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T, SC extends SearchIndexScope<?>, N extends SearchIndexNodeContext<SC>> SearchException cannotUseQueryElement(SearchQueryElementTypeKey<T> key, N node, String hint, Exception causeOrNull) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract String missingSupportHint(SearchQueryElementTypeKey<?> key);

    public abstract String partialSupportHint();
}
