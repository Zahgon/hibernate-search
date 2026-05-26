/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.massindexing.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.hibernate.CacheMode;
import org.hibernate.search.engine.tenancy.spi.TenancyMode;
import org.hibernate.search.mapper.orm.loading.impl.HibernateOrmMassLoadingContext;
import org.hibernate.search.mapper.orm.loading.spi.ConditionalExpression;
import org.hibernate.search.mapper.orm.tenancy.spi.TenancyConfiguration;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingDefaultCleanOperation;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexingContext;

public final class HibernateOrmMassIndexingContext implements PojoMassIndexingContext, HibernateOrmMassLoadingContext {

    private final HibernateOrmMassIndexingMappingContext mapping;

    private final Map<Class<?>, ConditionalExpression> conditionalExpressions = new HashMap<>();

    private final Set<String> actualTenantIds;

    private CacheMode cacheMode = CacheMode.IGNORE;

    private Integer idLoadingTransactionTimeout;

    //reasonable default as we only load IDs
    private int idFetchSize = 100;

    private int objectLoadingBatchSize = 10;

    //means no limit at all
    private long objectsLimit = 0;

    public HibernateOrmMassIndexingContext(HibernateOrmMassIndexingMappingContext mapping, Set<String> actualTenantIds) {
        this.mapping = mapping;
        this.actualTenantIds = actualTenantIds;
    }

    @Override
    public HibernateOrmMassIndexingMappingContext mapping() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void idLoadingTransactionTimeout(int timeoutInSeconds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer idLoadingTransactionTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void cacheMode(CacheMode cacheMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheMode cacheMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void objectLoadingBatchSize(int batchSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int objectLoadingBatchSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void objectsLimit(long maximum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long objectsLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void idFetchSize(int idFetchSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int idFetchSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ConditionalExpression reindexOnly(Class<?> type, String conditionalExpression) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<ConditionalExpression> conditionalExpression(PojoLoadingTypeContext<?> typeContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TenancyConfiguration tenancyConfiguration() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> tenantIds() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TenancyMode tenancyMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexingDefaultCleanOperation massIndexingDefaultCleanOperation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
