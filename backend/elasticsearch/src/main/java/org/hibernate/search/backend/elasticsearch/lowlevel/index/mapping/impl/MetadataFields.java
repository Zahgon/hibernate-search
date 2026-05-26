/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl;

public final class MetadataFields {

    private static final String INTERNAL_FIELD_PREFIX = "_";

    private MetadataFields() {
    }

    public static String internalFieldName(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
