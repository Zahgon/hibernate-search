/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.building.impl;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.IdentifierBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.identifiertovalue.impl.IdentifierBinderToValueBinderAdapter;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.identity.impl.PojoIdentityMappingCollector;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMappingHelper;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;

class PojoIndexedEmbeddedIdentityMappingCollector<E> implements PojoIdentityMappingCollector {

    private final PojoRawTypeModel<E> typeModel;

    private final PojoMappingHelper mappingHelper;

    private BoundPojoModelPathPropertyNode<?, ?> identifierModelPath;

    private IdentifierBinder identifierBinder;

    private Map<String, Object> params = Collections.emptyMap();

    PojoIndexedEmbeddedIdentityMappingCollector(PojoRawTypeModel<E> typeModel, PojoMappingHelper mappingHelper) {
        this.typeModel = typeModel;
        this.mappingHelper = mappingHelper;
    }

    @Override
    public <T> void identifierBridge(BoundPojoModelPathPropertyNode<?, T> modelPath, IdentifierBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void contributeIdentifierField(AbstractPojoIndexingProcessorTypeNodeBuilder<?, ?> embeddedTypeNodeBuilder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
