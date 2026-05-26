/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.identity.impl;

import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMappingHelper;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.reporting.spi.PojoEventContexts;

abstract class AbstractIdentityMappingCollectorNode {

    final PojoMappingHelper mappingHelper;

    AbstractIdentityMappingCollectorNode(PojoMappingHelper mappingHelper) {
        this.mappingHelper = mappingHelper;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract BoundPojoModelPath getModelPath();

    public final ContextualFailureCollector failureCollector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
