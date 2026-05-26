/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.reporting.impl;

import org.hibernate.search.util.common.reporting.EventContext;
import org.hibernate.search.util.common.reporting.impl.AbstractSimpleEventContextElement;

public final class ElasticsearchEventContexts {

    private static final ElasticsearchEventContextMessages MESSAGES = ElasticsearchEventContextMessages.INSTANCE;

    private ElasticsearchEventContexts() {
    }

    public static EventContext fromMappingAttribute(String attributeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromAnalysisDefinitionParameter(String parameterName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromAliasDefinition(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromAliasDefinitionAttribute(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromFieldTemplateAttribute(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromCustomIndexSettingAttribute(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromCustomIndexMappingAttribute(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
