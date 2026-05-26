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
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.mapper.pojo.processing.impl.PojoIndexingProcessor;
import org.hibernate.search.mapper.pojo.processing.impl.PojoIndexingProcessorOriginalTypeNode;

/**
 * A builder of {@link org.hibernate.search.mapper.pojo.processing.impl.PojoIndexingProcessorCastedTypeNode}.
 *
 * @param <T> The processed type
 */
public class PojoIndexingProcessorOriginalTypeNodeBuilder<T> extends AbstractPojoIndexingProcessorTypeNodeBuilder<T, T> {

    private final BoundPojoModelPathTypeNode<T> modelPath;

    public PojoIndexingProcessorOriginalTypeNodeBuilder(BoundPojoModelPathTypeNode<T> modelPath, PojoMappingHelper mappingHelper, IndexBindingContext bindingContext, PojoIdentityMappingCollector identityMappingCollector, Collection<IndexObjectFieldReference> parentIndexObjectReferences) {
        super(mappingHelper, bindingContext, identityMappingCollector, parentIndexObjectReferences);
        this.modelPath = modelPath;
    }

    @Override
    public BoundPojoModelPathTypeNode<T> getModelPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected PojoIndexingDependencyCollectorTypeNode<T> toType(AbstractPojoIndexingDependencyCollectorDirectValueNode<?, T> valueDependencyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected PojoIndexingProcessor<T> doBuild(Collection<IndexObjectFieldReference> parentIndexObjectReferences, PojoIndexingProcessor<? super T> nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
