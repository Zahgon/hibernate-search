/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.identity.impl;

import java.util.Map;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.engine.common.tree.TreeFilterDefinition;
import org.hibernate.search.mapper.pojo.bridge.binding.spi.FieldModelContributor;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.ValueBinder;
import org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMappingHelper;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoIndexMappingCollectorValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;

class IdentityMappingCollectorValueNode extends AbstractIdentityMappingCollectorNode implements PojoIndexMappingCollectorValueNode {

    private final BoundPojoModelPathValueNode<?, ?, ?> modelPath;

    IdentityMappingCollectorValueNode(BoundPojoModelPathValueNode<?, ?, ?> modelPath, PojoMappingHelper mappingHelper) {
        super(mappingHelper);
        this.modelPath = modelPath;
    }

    @Override
    BoundPojoModelPathValueNode<?, ?, ?> getModelPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void valueBinder(ValueBinder binder, Map<String, Object> params, String relativeFieldName, FieldModelContributor fieldModelContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void indexedEmbedded(PojoRawTypeIdentifier<?> definingType, String relativePrefix, ObjectStructure structure, TreeFilterDefinition filterDefinition, boolean includeEmbeddedObjectId, Class<?> targetType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
