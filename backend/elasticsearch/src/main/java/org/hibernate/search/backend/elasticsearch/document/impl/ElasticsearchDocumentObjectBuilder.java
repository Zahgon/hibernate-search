/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.document.impl;

import java.util.Objects;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexCompositeNode;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexField;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexModel;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexObjectField;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexValueField;
import org.hibernate.search.backend.elasticsearch.gson.impl.GsonUtils;
import org.hibernate.search.backend.elasticsearch.logging.impl.IndexingLog;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexValueFieldType;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.engine.backend.document.IndexFieldReference;
import org.hibernate.search.engine.backend.document.IndexObjectFieldReference;
import org.hibernate.search.engine.backend.document.model.spi.IndexFieldFilter;
import org.hibernate.search.engine.backend.document.spi.NoOpDocumentElement;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import com.google.gson.JsonObject;

public class ElasticsearchDocumentObjectBuilder implements DocumentElement {

    private final ElasticsearchIndexModel model;

    private final ElasticsearchIndexCompositeNode schemaNode;

    private final JsonObject content;

    public ElasticsearchDocumentObjectBuilder(ElasticsearchIndexModel model) {
        this(model, model.root(), new JsonObject());
    }

    ElasticsearchDocumentObjectBuilder(ElasticsearchIndexModel model, ElasticsearchIndexCompositeNode schemaNode, JsonObject content) {
        this.model = model;
        this.schemaNode = schemaNode;
        this.content = content;
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

    public JsonObject build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <F> void addValue(ElasticsearchIndexValueField<F> node, F value) {
        ElasticsearchIndexCompositeNode expectedParentNode = node.parent();
        checkTreeConsistency(expectedParentNode);
        if (TreeNodeInclusion.EXCLUDED.equals(node.inclusion())) {
            return;
        }
        ElasticsearchIndexValueFieldType<F> type = node.type();
        String jsonPropertyName = node.relativeName();
        if (!node.multiValued() && content.has(jsonPropertyName)) {
            throw IndexingLog.INSTANCE.multipleValuesForSingleValuedField(node.absolutePath());
        }
        GsonUtils.setOrAppendToArray(content, jsonPropertyName, type.codec().encode(value));
    }

    // We check types explicitly using reflection
    @SuppressWarnings("unchecked")
    private void addValueUnknownType(ElasticsearchIndexValueField<?> node, Object value) {
        if (value == null) {
            addValue(node, null);
        } else {
            @SuppressWarnings("rawtypes")
            ElasticsearchIndexValueField typeCheckedNode = node.withValueType(value.getClass(), model.eventContext());
            addValue(typeCheckedNode, value);
        }
    }

    private DocumentElement addObject(ElasticsearchIndexObjectField node, JsonObject value) {
        ElasticsearchIndexCompositeNode expectedParentNode = node.parent();
        checkTreeConsistency(expectedParentNode);
        if (TreeNodeInclusion.EXCLUDED.equals(node.inclusion())) {
            return NoOpDocumentElement.get();
        }
        String jsonPropertyName = node.relativeName();
        if (!node.multiValued() && content.has(jsonPropertyName)) {
            throw IndexingLog.INSTANCE.multipleValuesForSingleValuedField(node.absolutePath());
        }
        GsonUtils.setOrAppendToArray(content, jsonPropertyName, value);
        if (value == null) {
            // Will not be used
            return NoOpDocumentElement.get();
        } else {
            return new ElasticsearchDocumentObjectBuilder(model, node, value);
        }
    }

    private void checkTreeConsistency(ElasticsearchIndexCompositeNode expectedParentNode) {
        if (!Objects.equals(expectedParentNode, schemaNode)) {
            throw ElasticsearchClientLog.INSTANCE.invalidFieldForDocumentElement(expectedParentNode.absolutePath(), schemaNode.absolutePath());
        }
    }
}
