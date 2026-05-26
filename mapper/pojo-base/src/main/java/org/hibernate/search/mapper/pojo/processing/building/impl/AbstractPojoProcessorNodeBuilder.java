/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.building.impl;

import java.util.Collection;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexBindingContext;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMappingHelper;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.processing.impl.PojoIndexingProcessor;
import org.hibernate.search.mapper.pojo.processing.impl.PojoIndexingProcessorMultiNode;
import org.hibernate.search.mapper.pojo.reporting.spi.PojoEventContexts;

abstract class AbstractPojoProcessorNodeBuilder {

    final PojoMappingHelper mappingHelper;

    final IndexBindingContext bindingContext;

    AbstractPojoProcessorNodeBuilder(PojoMappingHelper mappingHelper, IndexBindingContext bindingContext) {
        this.mappingHelper = mappingHelper;
        this.bindingContext = bindingContext;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract BoundPojoModelPath getModelPath();

    abstract void closeOnFailure();

    public final ContextualFailureCollector failureCollector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final <T> PojoIndexingProcessor<? super T> createNested(Collection<? extends PojoIndexingProcessor<? super T>> elements) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
