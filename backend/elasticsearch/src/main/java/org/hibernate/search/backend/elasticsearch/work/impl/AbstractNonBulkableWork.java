/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.impl.Futures;
import org.hibernate.search.util.common.impl.Throwables;

/**
 * @author Gunnar Morling
 */
public abstract class AbstractNonBulkableWork<R> implements NonBulkableWork<R> {

    private static final CompletableFuture<Void> SUCCESSFUL_FUTURE = CompletableFuture.completedFuture(null);

    protected final ElasticsearchRequest request;

    protected final ElasticsearchRequestSuccessAssessor resultAssessor;

    protected AbstractNonBulkableWork(AbstractBuilder<?> builder) {
        this.request = builder.buildRequestAndTransformIfNecessary();
        this.resultAssessor = builder.resultAssessor;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ElasticsearchRequest request() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final CompletableFuture<R> execute(ElasticsearchWorkExecutionContext executionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected CompletableFuture<?> beforeExecute(ElasticsearchWorkExecutionContext executionContext, ElasticsearchRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract R generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response);

    private R handleResult(ElasticsearchWorkExecutionContext executionContext, ElasticsearchResponse response) {
        R result;
        try {
            resultAssessor.checkSuccess(response);
            result = generateResult(executionContext, response);
        } catch (RuntimeException e) {
            throw ElasticsearchClientLog.INSTANCE.elasticsearchRequestFailed(request, response, e.getMessage(), e);
        }
        return result;
    }

    // By contract, subclasses must implement B
    @SuppressWarnings("unchecked")
    protected abstract static class AbstractBuilder<B> {

        protected ElasticsearchRequestSuccessAssessor resultAssessor;

        private Function<ElasticsearchRequest, ElasticsearchRequest> requestTransformer;

        public AbstractBuilder(ElasticsearchRequestSuccessAssessor resultAssessor) {
            this.resultAssessor = resultAssessor;
        }

        public B requestTransformer(Function<ElasticsearchRequest, ElasticsearchRequest> requestTransformer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private ElasticsearchRequest buildRequestAndTransformIfNecessary() {
            ElasticsearchRequest request = buildRequest();
            if (requestTransformer != null) {
                request = requestTransformer.apply(request);
            }
            return request;
        }

        protected abstract ElasticsearchRequest buildRequest();

        public abstract AbstractNonBulkableWork<?> build();
    }
}
