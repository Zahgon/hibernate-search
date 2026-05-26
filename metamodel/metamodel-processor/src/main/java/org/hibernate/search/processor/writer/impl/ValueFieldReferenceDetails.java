/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.writer.impl;

import java.util.Locale;

record ValueFieldReferenceDetails(TypedFieldReferenceDetails typedField) {

    public String formatted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String formattedWithTypedField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String name() {
        return "ValueFieldReference" + typedField.identifier();
    }

    public String asType(String scopeType, String inputType, String outputType, String indexType, String rawType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String constructorCall(String name, String scopeType, String inputType, String outputType, String indexType, String rawType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
