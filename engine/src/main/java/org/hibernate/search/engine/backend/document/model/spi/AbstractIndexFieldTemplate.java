/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.document.model.spi;

import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.common.spi.FieldPaths.RelativizedPath;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.util.common.pattern.spi.SimpleGlobPattern;

public abstract class AbstractIndexFieldTemplate<M extends AbstractIndexModel<?, ?, F>, F extends IndexField<?, C>, C extends IndexCompositeNode<?, ?, ?>, FT> {

    private final FT type;

    private final TreeNodeInclusion inclusion;

    private final SimpleGlobPattern absolutePathGlob;

    private final boolean multiValued;

    public AbstractIndexFieldTemplate(C declaringParent, SimpleGlobPattern absolutePathGlob, FT type, TreeNodeInclusion inclusion, boolean multiValued) {
        this.absolutePathGlob = absolutePathGlob;
        this.type = type;
        this.inclusion = declaringParent.inclusion().compose(inclusion);
        this.multiValued = multiValued;
    }

    public final FT type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final TreeNodeInclusion inclusion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    F createNodeIfMatching(M model, C root, String absolutePath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract F createNode(C parent, String relativePath, FT type, TreeNodeInclusion inclusion, boolean multiValued);
}
