/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.impl;

import java.sql.Connection;
import java.time.Instant;
import java.util.TimeZone;
import java.util.function.UnaryOperator;
import org.hibernate.CacheMode;
import org.hibernate.ConnectionAcquisitionMode;
import org.hibernate.ConnectionReleaseMode;
import org.hibernate.FlushMode;
import org.hibernate.Interceptor;
import org.hibernate.SessionEventListener;
import org.hibernate.SharedSessionBuilder;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.FullTextSharedSessionBuilder;
import org.hibernate.search.Search;

/**
 * @author Emmanuel Bernard
 */
class FullTextSharedSessionBuilderDelegator implements FullTextSharedSessionBuilder {

    private final SharedSessionBuilder builder;

    public FullTextSharedSessionBuilderDelegator(SharedSessionBuilder builder) {
        this.builder = builder;
    }

    @Override
    public FullTextSharedSessionBuilder interceptor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder connection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated
    @Override
    public FullTextSharedSessionBuilder connectionReleaseMode() {
        builder.connectionReleaseMode();
        return this;
    }

    @Override
    public FullTextSharedSessionBuilder autoJoinTransactions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder autoClose() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SharedSessionBuilder asOf(Instant instant) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SharedSessionBuilder atChangeset(Object changesetId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder interceptor(Interceptor interceptor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder noInterceptor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder noSessionInterceptorCreation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder connection(Connection connection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder autoJoinTransactions(boolean autoJoinTransactions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated
    @Override
    public FullTextSharedSessionBuilder autoClose(boolean autoClose) {
        builder.autoClose(autoClose);
        return this;
    }

    @Override
    public FullTextSharedSessionBuilder identifierRollback(boolean identifierRollback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder defaultBatchFetchSize(int defaultBatchFetchSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder subselectFetchEnabled(boolean subselectFetchEnabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSession openSession() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated(forRemoval = true)
    @Override
    public FullTextSharedSessionBuilder tenantIdentifier(String tenantIdentifier) {
        builder.tenantIdentifier(tenantIdentifier);
        return this;
    }

    @Override
    public FullTextSharedSessionBuilder tenantIdentifier(Object tenantIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder readOnly(boolean readOnly) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder initialCacheMode(CacheMode cacheMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder clearEventListeners() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder eventListeners(SessionEventListener... listeners) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder statementInspector(StatementInspector statementInspector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder statementInspector(UnaryOperator<String> operator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder statementInspector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder noStatementInspector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder connectionHandlingMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder flushMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder connectionHandlingMode(PhysicalConnectionHandlingMode mode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder connectionHandling(ConnectionAcquisitionMode acquisitionMode, ConnectionReleaseMode releaseMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder autoClear(boolean autoClear) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder flushMode(FlushMode flushMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FullTextSharedSessionBuilder jdbcTimeZone(TimeZone timeZone) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
