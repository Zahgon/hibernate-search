/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.document.model.spi;

import java.util.List;
import org.hibernate.search.engine.backend.types.spi.AbstractIndexValueFieldType;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;
import org.hibernate.search.engine.search.common.spi.SearchIndexScope;
import org.hibernate.search.engine.search.common.spi.SearchIndexValueFieldContext;

public abstract class AbstractIndexValueField<S extends AbstractIndexValueField<S, SC, FT, C, F>, SC extends SearchIndexScope<?>, FT extends AbstractIndexValueFieldType<SC, ? super S, F>, C extends IndexCompositeNode<SC, ?, ?>, F> extends AbstractIndexField<S, SC, FT, C> implements IndexValueField<SC, FT, C>, SearchIndexValueFieldContext<SC> {

    public AbstractIndexValueField(C parent, String relativeFieldName, FT type, TreeNodeInclusion inclusion, boolean multiValued) {
        super(parent, relativeFieldName, type, inclusion, multiValued);
    }

    @Override
    public final boolean isComposite() {
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
    public final C toComposite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexObjectField<SC, ?, C, ?> toObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final S toValueField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<String> nestedPathHierarchy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    final SearchIndexSchemaElementContextHelper helper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
