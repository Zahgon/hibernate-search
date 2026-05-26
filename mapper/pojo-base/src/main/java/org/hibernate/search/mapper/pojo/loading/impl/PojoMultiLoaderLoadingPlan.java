/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.loading.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import org.hibernate.search.engine.common.timing.Deadline;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingStrategy;

public final class PojoMultiLoaderLoadingPlan<T> implements PojoLoadingPlan<T> {

    private final PojoSelectionLoadingContext context;

    private final Map<PojoLoadingTypeContext<? extends T>, PojoSingleLoaderLoadingPlan<?>> planByType = new LinkedHashMap<>();

    private final Map<PojoSelectionLoadingStrategy<?>, PojoSingleLoaderLoadingPlan<?>> planByLoadingStrategy = new LinkedHashMap<>();

    public PojoMultiLoaderLoadingPlan(PojoSelectionLoadingContext context) {
        this.context = context;
    }

    @Override
    public <T2 extends T> int planLoading(PojoLoadingTypeContext<T2> expectedType, Object identifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void loadBlocking(Deadline deadline) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T2 extends T> T2 retrieve(PojoLoadingTypeContext<T2> expectedType, int ordinal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private <T2 extends T> PojoSingleLoaderLoadingPlan<? super T2> delegate(PojoLoadingTypeContext<T2> type) {
        PojoSingleLoaderLoadingPlan<? super T2> delegate = (PojoSingleLoaderLoadingPlan<? super T2>) planByType.get(type);
        if (delegate != null) {
            return delegate;
        }
        PojoSelectionLoadingStrategy<? super T2> loadingStrategy = type.selectionLoadingStrategy();
        delegate = (PojoSingleLoaderLoadingPlan<? super T2>) planByLoadingStrategy.get(loadingStrategy);
        if (delegate != null) {
            planByType.put(type, delegate);
            return delegate;
        }
        delegate = new PojoSingleLoaderLoadingPlan<>(context, loadingStrategy);
        planByType.put(type, delegate);
        planByLoadingStrategy.put(loadingStrategy, delegate);
        return delegate;
    }
}
