/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.dsl.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.search.engine.backend.reporting.spi.BackendMappingHints;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.EntityProjectionOptionsStep;
import org.hibernate.search.engine.search.projection.dsl.TypedSearchProjectionFactory;
import org.hibernate.search.engine.search.projection.dsl.spi.SearchProjectionDslContext;
import org.hibernate.search.engine.search.projection.spi.ProjectionMappedTypeContext;
import org.hibernate.search.engine.search.projection.spi.SearchProjectionIndexScope;

public final class EntityProjectionOptionsStepImpl<SR, E> implements EntityProjectionOptionsStep<EntityProjectionOptionsStepImpl<SR, E>, E> {

    private final SearchProjectionIndexScope<?> scope;

    private final TypedSearchProjectionFactory<SR, ?, ?> projectionFactory;

    private final Class<E> requestedEntityType;

    public EntityProjectionOptionsStepImpl(SearchProjectionDslContext<?> dslContext, TypedSearchProjectionFactory<SR, ?, ?> projectionFactory, Class<E> requestedEntityType) {
        this.scope = dslContext.scope();
        this.projectionFactory = projectionFactory;
        this.requestedEntityType = requestedEntityType;
    }

    @Override
    public SearchProjection<E> toProjection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // The casts are safe because a query making use of this projection can only target entity types extending E
    @SuppressWarnings({ "unchecked" })
    private SearchProjection<E> toProjection(ProjectionMappedTypeContext mappedTypeContext) {
        if (requestedEntityType != null && !requestedEntityType.isAssignableFrom(mappedTypeContext.javaClass())) {
            throw QueryLog.INSTANCE.invalidTypeForEntityProjection(mappedTypeContext.name(), mappedTypeContext.javaClass(), requestedEntityType);
        }
        if (mappedTypeContext.loadingAvailable()) {
            return scope.projectionBuilders().entityLoading();
        } else {
            Class<?> javaClass = mappedTypeContext.javaClass();
            if (scope.projectionRegistry().compositeOptional(javaClass).isPresent()) {
                return scope.projectionBuilders().entityComposite((SearchProjection<E>) projectionFactory.composite().as(javaClass).toProjection());
            }
        }
        // If the projection is impossible, we delay the exception until we actually have to project a document.
        // The entity projection is the default projection so if we threw the exception immediately,
        // we would prevent use cases such as .search(MyEntity.class).where(...).fetchTotalHitCount(),
        // where the projection is impossible but it's just the default so it's not the user's fault,
        // and in the end does not matter because the projection is never executed anyway.
        BackendMappingHints hints = scope.mappingContext().hints();
        return scope.projectionBuilders().throwing(() -> QueryLog.INSTANCE.cannotCreateEntityProjection(mappedTypeContext.name(), mappedTypeContext.javaClass(), hints.noEntityProjectionAvailable()));
    }
}
