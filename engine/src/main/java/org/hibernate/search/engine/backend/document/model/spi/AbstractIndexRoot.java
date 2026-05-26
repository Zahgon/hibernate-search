/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.document.model.spi;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.hibernate.search.engine.backend.types.spi.AbstractIndexCompositeNodeType;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;
import org.hibernate.search.engine.search.common.spi.SearchIndexScope;
import org.hibernate.search.util.common.reporting.EventContext;

public abstract class AbstractIndexRoot<S extends AbstractIndexRoot<S, SC, NT, F>, SC extends SearchIndexScope<?>, NT extends AbstractIndexCompositeNodeType<SC, ? super S>, F extends IndexField<SC, ?>> extends AbstractIndexNode<S, SC, NT> implements IndexCompositeNode<SC, NT, F> {

    private final Map<String, F> staticChildrenByName;

    public AbstractIndexRoot(NT type, Map<String, F> notYetInitializedStaticChildren) {
        super(type);
        // We expect the children to be added to the list externally, just after the constructor call.
        this.staticChildrenByName = Collections.unmodifiableMap(notYetInitializedStaticChildren);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final EventContext relativeEventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isComposite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isRoot() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isValueField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S toComposite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexObjectField<SC, ?, ?, ?> toObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String absolutePath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String absolutePath(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String[] absolutePathComponents() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final TreeNodeInclusion inclusion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final List<String> nestedPathHierarchy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Map<String, F> staticChildrenByName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean multiValued() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean multiValuedInRoot() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String closestMultiValuedParentAbsolutePath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    final SearchIndexSchemaElementContextHelper helper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
