/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.binding.impl;

import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorTypeNode;
import org.hibernate.search.mapper.pojo.bridge.RoutingBridge;
import org.hibernate.search.mapper.pojo.model.dependency.impl.PojoRoutingIndexingDependencyConfigurationContextImpl;
import org.hibernate.search.mapper.pojo.model.impl.PojoModelTypeRootElement;

public class BoundRoutingBridge<T> {

    private final BeanHolder<? extends RoutingBridge<? super T>> bridgeHolder;

    private final PojoModelTypeRootElement<T> pojoModelRootElement;

    private final PojoRoutingIndexingDependencyConfigurationContextImpl<T> pojoDependencyContext;

    BoundRoutingBridge(BeanHolder<? extends RoutingBridge<? super T>> bridgeHolder, PojoModelTypeRootElement<T> pojoModelRootElement, PojoRoutingIndexingDependencyConfigurationContextImpl<T> pojoDependencyContext) {
        this.bridgeHolder = bridgeHolder;
        this.pojoModelRootElement = pojoModelRootElement;
        this.pojoDependencyContext = pojoDependencyContext;
    }

    public BeanHolder<? extends RoutingBridge<? super T>> getBridgeHolder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RoutingBridge<? super T> getBridge() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void contributeDependencies(PojoIndexingDependencyCollectorTypeNode<T> dependencyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
