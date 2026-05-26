/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.common.spi;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.util.common.SearchException;

public abstract class AbstractMultiIndexSearchIndexCompositeNodeContext<S extends SearchIndexCompositeNodeContext<SC>, SC extends SearchIndexScope<?>, NT extends SearchIndexCompositeNodeTypeContext<SC, S>, F extends SearchIndexNodeContext<SC>> extends AbstractMultiIndexSearchIndexNodeContext<S, SC, NT> implements SearchIndexCompositeNodeContext<SC>, SearchIndexCompositeNodeTypeContext<SC, S> {

    private Map<String, F> staticChildrenByName;

    public AbstractMultiIndexSearchIndexCompositeNodeContext(SC scope, String absolutePath, List<? extends S> nodeForEachIndex) {
        super(scope, absolutePath, nodeForEachIndex);
    }

    @Override
    public final NT type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isComposite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isValueField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final S toComposite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S toObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIndexValueFieldContext<SC> toValueField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String absolutePath(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean nested() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Map<String, F> staticChildrenByName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract F childInScope(String childRelativeName);

    @Override
    final SearchIndexSchemaElementContextHelper helper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
