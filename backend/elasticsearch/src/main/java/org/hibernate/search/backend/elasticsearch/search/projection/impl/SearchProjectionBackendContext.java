/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.impl;

import java.util.Set;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;

public final class SearchProjectionBackendContext {

    private final ProjectionExtractionHelper<String> complexMappedTypeNameProjectionExtractionHelper;

    private final ProjectionExtractionHelper<String> idProjectionExtractionHelper;

    public SearchProjectionBackendContext(ProjectionExtractionHelper<String> complexMappedTypeNameProjectionExtractionHelper, ProjectionExtractionHelper<String> idProjectionExtractionHelper) {
        this.complexMappedTypeNameProjectionExtractionHelper = complexMappedTypeNameProjectionExtractionHelper;
        this.idProjectionExtractionHelper = idProjectionExtractionHelper;
    }

    ProjectionExtractionHelper<String> createMappedTypeNameExtractionHelper(ElasticsearchSearchIndexScope<?> scope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    DocumentReferenceExtractionHelper createDocumentReferenceExtractionHelper(ProjectionExtractionHelper<String> mappedTypeNameExtractionHelper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ProjectionExtractionHelper<String> idProjectionExtractionHelper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
