/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.building.impl;

import java.util.Collection;
import org.hibernate.search.engine.backend.document.IndexObjectFieldReference;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexBindingContext;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.AbstractPojoIndexingDependencyCollectorDirectValueNode;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorTypeNode;
import org.hibernate.search.mapper.pojo.identity.impl.PojoIdentityMappingCollector;
import org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMappingHelper;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathCastedTypeNode;
import org.hibernate.search.mapper.pojo.processing.impl.PojoIndexingProcessor;
import org.hibernate.search.mapper.pojo.processing.impl.PojoIndexingProcessorCastedTypeNode;

/**
 * A builder of {@link PojoIndexingProcessorCastedTypeNode}.
 *
 * @param <T> The processed type received as input.
 * @param <U> The type the input objects will be casted to.
 */
public class PojoIndexingProcessorCastedTypeNodeBuilder<T, U> extends AbstractPojoIndexingProcessorTypeNodeBuilder<T, U> {

    private final BoundPojoModelPathCastedTypeNode<T, U> modelPath;

    public PojoIndexingProcessorCastedTypeNodeBuilder(BoundPojoModelPathCastedTypeNode<T, U> modelPath, PojoMappingHelper mappingHelper, IndexBindingContext bindingContext, PojoIdentityMappingCollector identityMappingCollector, Collection<IndexObjectFieldReference> parentIndexObjectReferences) {
        super(mappingHelper, bindingContext, identityMappingCollector, parentIndexObjectReferences);
        this.modelPath = modelPath;
    }

    @Override
    public BoundPojoModelPathCastedTypeNode<T, U> getModelPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected PojoIndexingDependencyCollectorTypeNode<U> toType(AbstractPojoIndexingDependencyCollectorDirectValueNode<?, T> valueDependencyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected PojoIndexingProcessor<T> doBuild(Collection<IndexObjectFieldReference> parentIndexObjectReferences, PojoIndexingProcessor<? super U> nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
