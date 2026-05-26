/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.document.model.spi;

import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.types.spi.AbstractIndexNodeType;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.common.spi.SearchIndexScope;
import org.hibernate.search.util.common.reporting.EventContext;

public abstract class AbstractIndexField<S extends AbstractIndexField<S, SC, ?, C>, SC extends SearchIndexScope<?>, NT extends AbstractIndexNodeType<SC, ? super S>, C extends IndexCompositeNode<SC, ?, ?>> extends AbstractIndexNode<S, SC, NT> implements IndexField<SC, C> {

    protected final C parent;

    protected final String absolutePath;

    protected final String[] absolutePathComponents;

    protected final String relativeName;

    protected final TreeNodeInclusion inclusion;

    protected final boolean multiValued;

    private final String closestMultiValuedParentAbsolutePath;

    public AbstractIndexField(C parent, String relativeFieldName, NT type, TreeNodeInclusion inclusion, boolean multiValued) {
        super(type);
        this.parent = parent;
        this.absolutePath = parent.absolutePath(relativeFieldName);
        this.absolutePathComponents = FieldPaths.split(absolutePath);
        this.relativeName = relativeFieldName;
        this.inclusion = inclusion;
        this.multiValued = multiValued;
        this.closestMultiValuedParentAbsolutePath = parent.multiValued() ? parent.absolutePath() : parent.closestMultiValuedParentAbsolutePath();
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
    public final C parent() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String absolutePath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String[] absolutePathComponents() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String relativeName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final TreeNodeInclusion inclusion() {
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
    public String closestMultiValuedParentAbsolutePath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
