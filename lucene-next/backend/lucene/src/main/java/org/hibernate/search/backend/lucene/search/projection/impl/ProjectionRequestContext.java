/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.projection.impl;

import java.util.Collection;
import java.util.Map;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.search.extraction.impl.ExtractionRequirements;
import org.hibernate.search.backend.lucene.search.highlighter.impl.LuceneAbstractSearchHighlighter;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementTypeKey;
import org.hibernate.search.engine.search.query.spi.QueryParameters;

public final class ProjectionRequestContext {

    private final ExtractionRequirements.Builder extractionRequirementsBuilder;

    private final String absoluteCurrentNestedFieldPath;

    private final String absoluteCurrentFieldPath;

    private final LuceneAbstractSearchHighlighter globalHighlighter;

    private final Map<String, LuceneAbstractSearchHighlighter> namedHighlighters;

    private final QueryParameters parameters;

    public ProjectionRequestContext(ExtractionRequirements.Builder extractionRequirementsBuilder, LuceneAbstractSearchHighlighter globalHighlighter, Map<String, LuceneAbstractSearchHighlighter> namedHighlighters, QueryParameters parameters) {
        this(extractionRequirementsBuilder, globalHighlighter, namedHighlighters, parameters, null, null);
    }

    private ProjectionRequestContext(ExtractionRequirements.Builder extractionRequirementsBuilder, LuceneAbstractSearchHighlighter globalHighlighter, Map<String, LuceneAbstractSearchHighlighter> namedHighlighters, QueryParameters parameters, String absoluteCurrentFieldPath, String absoluteCurrentNestedFieldPath) {
        this.extractionRequirementsBuilder = extractionRequirementsBuilder;
        this.globalHighlighter = globalHighlighter;
        this.namedHighlighters = namedHighlighters;
        this.parameters = parameters;
        this.absoluteCurrentNestedFieldPath = absoluteCurrentNestedFieldPath;
        this.absoluteCurrentFieldPath = absoluteCurrentFieldPath;
    }

    public void requireAllStoredFields() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void requireNestedObjects(Collection<String> paths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void requireStoredField(String absoluteFieldPath, String nestedDocumentPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void requireScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void checkValidField(String absoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void checkNotNested(SearchQueryElementTypeKey<?> projectionKey, String hint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ProjectionRequestContext root() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ProjectionRequestContext forField(String absoluteFieldPath, boolean nestedObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String absoluteCurrentNestedFieldPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean projectionCardinalityCorrectlyAddressed(String requiredContextAbsoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String absoluteCurrentFieldPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public LuceneAbstractSearchHighlighter highlighter(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public NamedValues queryParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
