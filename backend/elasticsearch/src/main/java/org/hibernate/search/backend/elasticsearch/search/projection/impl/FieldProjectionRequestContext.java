/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.impl;

import java.util.Arrays;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementTypeKey;

public class FieldProjectionRequestContext implements ProjectionRequestContext {

    private final ProjectionRequestRootContext root;

    private final String absoluteCurrentFieldPath;

    private final String[] absoluteCurrentFieldPathComponents;

    private final String[] relativeCurrentFieldPathComponents;

    public FieldProjectionRequestContext(ProjectionRequestRootContext root, String absoluteCurrentFieldPath, String[] absoluteCurrentFieldPathComponents) {
        this(root, absoluteCurrentFieldPath, absoluteCurrentFieldPathComponents, absoluteCurrentFieldPathComponents);
    }

    private FieldProjectionRequestContext(ProjectionRequestRootContext root, String absoluteCurrentFieldPath, String[] absoluteCurrentFieldPathComponents, String[] relativeCurrentFieldPathComponents) {
        this.root = root;
        this.absoluteCurrentFieldPath = absoluteCurrentFieldPath;
        this.absoluteCurrentFieldPathComponents = absoluteCurrentFieldPathComponents;
        this.relativeCurrentFieldPathComponents = relativeCurrentFieldPathComponents;
    }

    @Override
    public void checkValidField(String absoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void checkNotNested(SearchQueryElementTypeKey<?> projectionKey, String hint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionRequestRootContext root() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionRequestContext forField(String absoluteFieldPath, String[] absoluteFieldPathComponents) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String absoluteCurrentFieldPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String[] relativeCurrentFieldPathComponents() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NamedValues queryParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean projectionCardinalityCorrectlyAddressed(String requiredContextAbsoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
