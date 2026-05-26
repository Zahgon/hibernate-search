/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.reporting.spi;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import org.hibernate.search.engine.mapper.model.spi.MappableTypeModel;
import org.hibernate.search.engine.reporting.impl.EngineEventContextMessages;
import org.hibernate.search.util.common.impl.CollectionHelper;
import org.hibernate.search.util.common.reporting.EventContext;
import org.hibernate.search.util.common.reporting.EventContextElement;
import org.hibernate.search.util.common.reporting.impl.AbstractSimpleEventContextElement;

public class EventContexts {

    private static final EngineEventContextMessages MESSAGES = EngineEventContextMessages.INSTANCE;

    private static final EventContext DEFAULT = singleton(MESSAGES::defaultOnMissingContextElement);

    private static final EventContext DEFAULT_BACKEND = singleton(MESSAGES::defaultBackend);

    private static final EventContext INDEX_SCHEMA_ROOT = singleton(MESSAGES::indexSchemaRoot);

    private static final EventContext INDEX_SCHEMA_IDENTIFIER = singleton(MESSAGES::indexSchemaIdentifier);

    private EventContexts() {
    }

    public static EventContext singleton(Supplier<String> render) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext defaultContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext indexSchemaRoot() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromType(MappableTypeModel typeModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromType(Object typeIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext defaultBackend() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromBackendName(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromIndexName(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromIndexNames(String... indexNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromIndexNames(Set<String> indexNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromIndexNameAndShardId(String name, Optional<String> shardId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromShardId(String shardId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromIndexFieldAbsolutePath(String absolutePath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext indexSchemaIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromIndexFieldAbsolutePaths(List<String> absolutePaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromFieldTemplateAbsolutePath(String templateAbsolutePath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromAnalyzer(String analyzerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromNormalizer(String normalizerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromCharFilter(String charFilterName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromTokenizer(String tokenizerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromTokenFilter(String tokenFilterName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
