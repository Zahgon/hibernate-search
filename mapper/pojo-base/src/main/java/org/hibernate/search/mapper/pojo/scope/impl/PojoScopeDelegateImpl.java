/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.scope.impl;

import static org.hibernate.search.util.common.impl.CollectionHelper.asSetIgnoreNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.search.engine.backend.scope.IndexScopeExtension;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.mapper.scope.spi.MappedIndexScope;
import org.hibernate.search.engine.mapper.scope.spi.MappedIndexScopeBuilder;
import org.hibernate.search.engine.search.aggregation.dsl.TypedSearchAggregationFactory;
import org.hibernate.search.engine.search.highlighter.dsl.SearchHighlighterFactory;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.projection.dsl.TypedSearchProjectionFactory;
import org.hibernate.search.engine.search.query.dsl.SearchQuerySelectStep;
import org.hibernate.search.engine.search.sort.dsl.TypedSearchSortFactory;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingContextBuilder;
import org.hibernate.search.mapper.pojo.massindexing.impl.PojoDefaultMassIndexer;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexer;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexingContext;
import org.hibernate.search.mapper.pojo.schema.management.impl.PojoScopeSchemaManagerImpl;
import org.hibernate.search.mapper.pojo.schema.management.spi.PojoScopeSchemaManager;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeDelegate;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeMappingContext;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeSessionContext;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeTypeExtendedContextProvider;
import org.hibernate.search.mapper.pojo.search.loading.impl.PojoSearchLoadingContextBuilder;
import org.hibernate.search.mapper.pojo.search.loading.impl.PojoSearchLoadingIndexedTypeContext;
import org.hibernate.search.mapper.pojo.work.impl.PojoScopeWorkspaceImpl;
import org.hibernate.search.mapper.pojo.work.spi.PojoScopeWorkspace;

public final class PojoScopeDelegateImpl<SR, R extends EntityReference, E, C> implements PojoScopeDelegate<SR, R, E, C> {

    public static <SR, R extends EntityReference, E, C> PojoScopeDelegate<SR, R, E, C> create(PojoScopeMappingContext mappingContext, Class<SR> rootScope, PojoScopeTypeContextProvider typeContextProvider, Set<? extends PojoScopeIndexedTypeContext<?, ? extends E>> targetedTypeContexts, PojoScopeTypeExtendedContextProvider<E, C> indexedTypeExtendedContextProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final PojoScopeMappingContext mappingContext;

    private final Class<SR> rootScope;

    private final PojoScopeTypeContextProvider indexedTypeContextProvider;

    private final Set<? extends PojoScopeIndexedTypeContext<?, ? extends E>> targetedTypeContexts;

    private final Set<C> targetedTypeExtendedContexts;

    private MappedIndexScope<SR, R, E> delegate;

    private PojoScopeDelegateImpl(PojoScopeMappingContext mappingContext, Class<SR> rootScope, PojoScopeTypeContextProvider indexedTypeContextProvider, Set<? extends PojoScopeIndexedTypeContext<?, ? extends E>> targetedTypeContexts, Set<C> targetedTypeExtendedContexts) {
        this.mappingContext = mappingContext;
        this.rootScope = rootScope;
        this.indexedTypeContextProvider = indexedTypeContextProvider;
        this.targetedTypeContexts = targetedTypeContexts;
        this.targetedTypeExtendedContexts = Collections.unmodifiableSet(targetedTypeExtendedContexts);
    }

    @Override
    public Set<C> includedIndexedTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <LOS> SearchQuerySelectStep<SR, ?, R, E, LOS, TypedSearchProjectionFactory<SR, R, E>, ?> search(PojoScopeSessionContext sessionContext, PojoSelectionLoadingContextBuilder<LOS> loadingContextBuilder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypedSearchPredicateFactory<SR> predicate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypedSearchSortFactory<SR> sort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypedSearchProjectionFactory<SR, R, E> projection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypedSearchAggregationFactory<SR> aggregation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchHighlighterFactory highlighter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoScopeWorkspace workspace(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoScopeWorkspace workspace(Set<String> tenantIds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoScopeSchemaManager schemaManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassIndexer massIndexer(PojoMassIndexingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T extension(IndexScopeExtension<T> extension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private MappedIndexScope<SR, R, E> getIndexScope() {
        if (delegate == null) {
            Iterator<? extends PojoScopeIndexedTypeContext<?, ? extends E>> iterator = targetedTypeContexts.iterator();
            MappedIndexScopeBuilder<SR, R, E> builder = iterator.next().createScopeBuilder(mappingContext, rootScope);
            while (iterator.hasNext()) {
                iterator.next().addTo(builder);
            }
            delegate = builder.build();
        }
        return delegate;
    }
}
