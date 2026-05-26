/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.dsl.impl;

import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.DistanceToFieldProjectionOptionsStep;
import org.hibernate.search.engine.search.projection.spi.DistanceToFieldProjectionBuilder;
import org.hibernate.search.engine.spatial.DistanceUnit;
import org.hibernate.search.util.common.impl.Contracts;

public class DistanceToFieldProjectionOptionsStepImpl<P> implements DistanceToFieldProjectionOptionsStep<DistanceToFieldProjectionOptionsStepImpl<P>, P> {

    protected final DistanceToFieldProjectionBuilder distanceFieldProjectionBuilder;

    private final ProjectionCollector.Provider<Double, P> collectorProvider;

    DistanceToFieldProjectionOptionsStepImpl(DistanceToFieldProjectionBuilder distanceFieldProjectionBuilder, ProjectionCollector.Provider<Double, P> collectorProvider) {
        this.distanceFieldProjectionBuilder = distanceFieldProjectionBuilder;
        this.collectorProvider = collectorProvider;
    }

    @Override
    public DistanceToFieldProjectionOptionsStepImpl<P> unit(DistanceUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchProjection<P> toProjection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
