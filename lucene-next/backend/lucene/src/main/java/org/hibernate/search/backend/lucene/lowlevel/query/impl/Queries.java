/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.query.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;

public class Queries {

    private static final Query MAIN_DOCUMENT_QUERY = new TermQuery(new Term(MetadataFields.typeFieldName(), MetadataFields.TYPE_MAIN_DOCUMENT));

    private static final Query CHILD_DOCUMENT_QUERY = new TermQuery(new Term(MetadataFields.typeFieldName(), MetadataFields.TYPE_CHILD_DOCUMENT));

    private Queries() {
    }

    public static Query mainDocumentQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Query childDocumentQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Query nestedDocumentPathQuery(String absoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Query boolFilter(Query must, Query filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Query boolFilter(Query must, List<Query> filters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Query term(String absoluteFieldPath, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Query anyTerm(String absoluteFieldPath, Set<String> values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Query parentsFilterQuery(String parentNestedDocumentPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Users of this query will target a specific parent ID which is guaranteed to already match the main Lucene query,
    // so we don't need to filter parent documents nor to use a ToChildBlockJoinQuery.
    public static BooleanQuery childDocumentsQuery(Set<String> nestedDocumentPaths, Query nestedFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
