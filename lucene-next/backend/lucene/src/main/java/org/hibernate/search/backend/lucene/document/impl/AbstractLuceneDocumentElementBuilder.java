/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexCompositeNode;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexField;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexModel;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexObjectField;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexValueField;
import org.hibernate.search.backend.lucene.logging.impl.IndexingLog;
import org.hibernate.search.backend.lucene.multitenancy.impl.MultiTenancyStrategy;
import org.hibernate.search.backend.lucene.types.impl.LuceneIndexValueFieldType;
import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.engine.backend.document.IndexFieldReference;
import org.hibernate.search.engine.backend.document.IndexObjectFieldReference;
import org.hibernate.search.engine.backend.document.model.spi.IndexFieldFilter;
import org.hibernate.search.engine.backend.document.spi.NoOpDocumentElement;
import org.apache.lucene.document.Document;

abstract class AbstractLuceneDocumentElementBuilder implements DocumentElement {

    protected final LuceneIndexModel model;

    protected final LuceneIndexCompositeNode schemaNode;

    protected final LuceneDocumentContentImpl documentContent;

    private List<LuceneFlattenedObjectFieldBuilder> flattenedObjectDocumentBuilders;

    private List<LuceneNestedObjectFieldBuilder> nestedObjectDocumentBuilders;

    AbstractLuceneDocumentElementBuilder(LuceneIndexModel model, LuceneIndexCompositeNode schemaNode, LuceneDocumentContentImpl documentContent) {
        this.model = model;
        this.schemaNode = schemaNode;
        this.documentContent = documentContent;
    }

    @Override
    public <F> void addValue(IndexFieldReference<F> fieldReference, F value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentElement addObject(IndexObjectFieldReference fieldReference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addNullObject(IndexObjectFieldReference fieldReference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addValue(String relativeFieldName, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentElement addObject(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addNullObject(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void checkNoValueYetForSingleValued(String absoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void addNestedObjectDocumentBuilder(LuceneNestedObjectFieldBuilder nestedObjectDocumentBuilder) {
        if (nestedObjectDocumentBuilders == null) {
            nestedObjectDocumentBuilders = new ArrayList<>();
        }
        nestedObjectDocumentBuilders.add(nestedObjectDocumentBuilder);
    }

    private void addFlattenedObjectDocumentBuilder(LuceneFlattenedObjectFieldBuilder flattenedObjectDocumentBuilder) {
        if (flattenedObjectDocumentBuilders == null) {
            flattenedObjectDocumentBuilders = new ArrayList<>();
        }
        flattenedObjectDocumentBuilders.add(flattenedObjectDocumentBuilder);
    }

    private void checkTreeConsistency(LuceneIndexCompositeNode expectedParentNode) {
        if (!Objects.equals(expectedParentNode, schemaNode)) {
            throw IndexingLog.INSTANCE.invalidFieldForDocumentElement(expectedParentNode.absolutePath(), schemaNode.absolutePath());
        }
    }

    void contribute(MultiTenancyStrategy multiTenancyStrategy, String tenantId, String routingKey, String rootId, List<Document> nestedDocuments) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * When executing an exists() predicate on an object field that contains dynamic value field,
     * we don't necessarily know all the possible child value fields,
     * so we cannot just execute {@code exists(childField1) OR exists(childField2) OR ... OR exists(childFieldN)}.
     * That's why we keep track of the fact that
     * "for this document, this object field exists because it contains at least one dynamic value".
     * This is done by adding the path of the object field to the "fieldNames" field.
     */
    abstract void ensureDynamicValueDetectedByExistsPredicateOnObjectField();

    private <F> void addValue(LuceneIndexValueField<F> node, F value) {
        LuceneIndexCompositeNode expectedParentNode = node.parent();
        checkTreeConsistency(expectedParentNode);
        LuceneIndexValueFieldType<F> type = node.type();
        String absolutePath = node.absolutePath();
        if (!node.multiValued()) {
            checkNoValueYetForSingleValued(absolutePath);
        }
        type.codec().addToDocument(documentContent, absolutePath, value);
        if (value != null && node.dynamic()) {
            ensureDynamicValueDetectedByExistsPredicateOnObjectField();
        }
    }

    private DocumentElement addObject(LuceneIndexObjectField node, boolean nullObject) {
        LuceneIndexCompositeNode expectedParentNode = node.parent();
        checkTreeConsistency(expectedParentNode);
        String absolutePath = node.absolutePath();
        if (!node.multiValued()) {
            checkNoValueYetForSingleValued(absolutePath);
        }
        if (nullObject) {
            return NoOpDocumentElement.get();
        }
        if (node.type().nested()) {
            LuceneNestedObjectFieldBuilder nestedDocumentBuilder = new LuceneNestedObjectFieldBuilder(model, node, this);
            addNestedObjectDocumentBuilder(nestedDocumentBuilder);
            return nestedDocumentBuilder;
        } else {
            LuceneFlattenedObjectFieldBuilder flattenedDocumentBuilder = new LuceneFlattenedObjectFieldBuilder(model, node, this, documentContent);
            addFlattenedObjectDocumentBuilder(flattenedDocumentBuilder);
            return flattenedDocumentBuilder;
        }
    }

    // We check types explicitly using reflection
    @SuppressWarnings("unchecked")
    private void addValueUnknownType(LuceneIndexValueField<?> node, Object value) {
        if (value == null) {
            addValue(node, null);
        } else {
            @SuppressWarnings("rawtypes")
            LuceneIndexValueField typeCheckedNode = node.withValueType(value.getClass(), model.eventContext());
            addValue(typeCheckedNode, value);
        }
    }
}
