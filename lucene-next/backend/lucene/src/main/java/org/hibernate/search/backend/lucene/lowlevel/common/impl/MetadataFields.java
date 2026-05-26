/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.common.impl;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.DocValuesType;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.util.BytesRef;

public class MetadataFields {

    private static final FieldType METADATA_FIELD_TYPE_WITH_INDEX;

    private static final FieldType METADATA_FIELD_TYPE_WITH_DOCVALUES;

    static {
        METADATA_FIELD_TYPE_WITH_INDEX = new FieldType();
        METADATA_FIELD_TYPE_WITH_INDEX.setTokenized(false);
        METADATA_FIELD_TYPE_WITH_INDEX.setOmitNorms(true);
        METADATA_FIELD_TYPE_WITH_INDEX.setIndexOptions(IndexOptions.DOCS);
        METADATA_FIELD_TYPE_WITH_INDEX.freeze();
        METADATA_FIELD_TYPE_WITH_DOCVALUES = new FieldType();
        METADATA_FIELD_TYPE_WITH_DOCVALUES.setTokenized(false);
        METADATA_FIELD_TYPE_WITH_DOCVALUES.setOmitNorms(true);
        METADATA_FIELD_TYPE_WITH_DOCVALUES.setIndexOptions(IndexOptions.NONE);
        METADATA_FIELD_TYPE_WITH_DOCVALUES.setDocValuesType(DocValuesType.BINARY);
        METADATA_FIELD_TYPE_WITH_DOCVALUES.freeze();
    }

    private static final String INTERNAL_FIELD_PREFIX = "__HSEARCH_";

    private static final String ID_FIELD_NAME = internalFieldName("id");

    private static final String ID_DOCVALUE_FIELD_NAME = internalFieldName("id_docvalue");

    private static final String ROUTING_KEY_FIELD_NAME = internalFieldName("routing_key");

    private static final String TENANT_ID_FIELD_NAME = internalFieldName("tenantId");

    private static final String TYPE_FIELD_NAME = internalFieldName("type");

    private static final String FIELD_NAMES_FIELD_NAME = internalFieldName("field_names");

    public static final String TYPE_MAIN_DOCUMENT = "main";

    public static final String TYPE_CHILD_DOCUMENT = "child";

    private static final String NESTED_DOCUMENT_PATH = internalFieldName("nested_document_path");

    private MetadataFields() {
    }

    public static String internalFieldName(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static IndexableField searchableMetadataField(String name, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static IndexableField retrievableMetadataField(String name, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String idFieldName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String idDocValueFieldName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String routingKeyFieldName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String tenantIdFieldName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String typeFieldName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String fieldNamesFieldName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String nestedDocumentPathFieldName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
