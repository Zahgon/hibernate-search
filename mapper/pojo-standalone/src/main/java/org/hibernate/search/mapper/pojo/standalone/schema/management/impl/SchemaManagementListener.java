/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.schema.management.impl;

import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.mapper.mapping.spi.MappingPreStopContext;
import org.hibernate.search.engine.mapper.mapping.spi.MappingStartContext;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import org.hibernate.search.mapper.pojo.schema.management.spi.PojoScopeSchemaManager;
import org.hibernate.search.mapper.pojo.standalone.schema.management.SchemaManagementStrategyName;
import org.hibernate.search.util.common.AssertionFailure;

public class SchemaManagementListener {

    private final SchemaManagementStrategyName strategyName;

    public SchemaManagementListener(SchemaManagementStrategyName strategyName) {
        this.strategyName = strategyName;
    }

    public CompletableFuture<?> onStart(MappingStartContext context, PojoScopeSchemaManager manager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<?> onStop(MappingPreStopContext context, PojoScopeSchemaManager manager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
