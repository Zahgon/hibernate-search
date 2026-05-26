/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import java.util.Optional;
import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoModelPathBinder;
import org.hibernate.search.util.common.data.impl.LinkedNode;

/**
 * A node representing a value in a dependency collector,
 * and considering that the type holding the property/value
 * has the same metadata from its subtypes.
 *
 * @param <P> The property type
 * @param <V> The extracted value type
 *
 * @see AbstractPojoIndexingDependencyCollectorDirectValueNode
 * @see PojoIndexingDependencyCollectorTypeNode
 */
public class PojoIndexingDependencyCollectorMonomorphicDirectValueNode<P, V> extends AbstractPojoIndexingDependencyCollectorDirectValueNode<P, V> {

    static <P, V> PojoIndexingDependencyCollectorMonomorphicDirectValueNode<P, V> create(PojoIndexingDependencyCollectorPropertyNode<?, P> parentNode, BoundPojoModelPathValueNode<?, P, V> modelPathFromLastEntityNode, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PojoIndexingDependencyCollectorMonomorphicDirectValueNode(PojoIndexingDependencyCollectorPropertyNode<?, P> parentNode, BoundPojoModelPathValueNode<?, P, V> modelPathFromLastEntityNode, Metadata metadata, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        super(parentNode, modelPathFromLastEntityNode, metadata, buildingHelper);
    }

    @Override
    public PojoIndexingDependencyCollectorTypeNode<V> type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void collectDependency() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void collectDependency(BoundPojoModelPathValueNode<?, ?, ?> dirtyPathFromEntityType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void doCollectDependency(LinkedNode<DerivedDependencyWalkingInfo> derivedDependencyPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void checkForDerivedDependencyCycle(LinkedNode<DerivedDependencyWalkingInfo> derivedDependencyPath, DerivedDependencyWalkingInfo newDerivedDependencyInfo) {
        Optional<LinkedNode<DerivedDependencyWalkingInfo>> cycle = derivedDependencyPath.findAndReverse(other -> newDerivedDependencyInfo.definingTypeModel.equals(other.definingTypeModel) && newDerivedDependencyInfo.derivedFromPath.equals(other.derivedFromPath));
        if (cycle.isPresent()) {
            /*
			 * We found a cycle in the derived dependency path.
			 * This can happen for example if:
			 * - property "foo" on type A is marked as derived from itself
			 * - property "foo" on type A is marked as derived from property "bar" on type B,
			 *   which is marked as derived from property "foo" on type "A".
			 * - property "foo" on type A is marked as derived from property "bar" on type B,
			 *   which is marked as derived from property "foobar" on type "C".
			 *   which is marked as derived from property "bar" on type "B".
			 * Even if such a dependency might work in practice at runtime,
			 * for example because the link A => B never leads to a B that refers to the same A,
			 * even indirectly,
			 * we cannot support it here because we need to model dependencies as a static tree,
			 * which in such case would have an infinite depth.
			 */
            throw MappingLog.INSTANCE.infiniteRecursionForDerivedFrom(newDerivedDependencyInfo.definingTypeModel, cycle.get());
        }
    }
}
