/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.document.model.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.types.spi.AbstractIndexCompositeNodeType;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;
import org.hibernate.search.engine.search.common.spi.SearchIndexScope;

public abstract class AbstractIndexObjectField<S extends AbstractIndexObjectField<S, SC, NT, C, F>, SC extends SearchIndexScope<?>, NT extends AbstractIndexCompositeNodeType<SC, ? super S>, C extends IndexCompositeNode<SC, NT, F>, F extends IndexField<SC, ?>> extends AbstractIndexField<S, SC, NT, C> implements IndexObjectField<SC, NT, C, F> {

    private final List<String> nestedPathHierarchy;

    private final Map<String, F> staticChildrenByName;

    public AbstractIndexObjectField(C parent, String relativeFieldName, NT type, TreeNodeInclusion inclusion, boolean multiValued, Map<String, F> notYetInitializedStaticChildren) {
        super(parent, relativeFieldName, type, inclusion, multiValued);
        // at the root object level the nestedPathHierarchy is empty
        List<String> theNestedPathHierarchy = parent.nestedPathHierarchy();
        if (type.nested()) {
            // if we found a nested object, we add it to the nestedPathHierarchy
            theNestedPathHierarchy = new ArrayList<>(theNestedPathHierarchy);
            theNestedPathHierarchy.add(absolutePath);
        }
        this.nestedPathHierarchy = Collections.unmodifiableList(theNestedPathHierarchy);
        // We expect the children to be added to the list externally, just after the constructor call.
        this.staticChildrenByName = Collections.unmodifiableMap(notYetInitializedStaticChildren);
    }

    @Override
    public final boolean isRoot() {
        throw new UnsupportedOperationException("STUB: not implemented");
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
    public final S toObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexValueField<SC, ?, C> toValueField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String absolutePath(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    final SearchIndexSchemaElementContextHelper helper() {
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
}
