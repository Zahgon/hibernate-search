/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.factory.impl;

import org.hibernate.search.backend.elasticsearch.client.common.gson.spi.GsonProvider;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.index.IndexStatus;
import org.hibernate.search.backend.elasticsearch.logging.impl.ElasticsearchMiscLog;
import org.hibernate.search.backend.elasticsearch.work.impl.CloseIndexWork;
import org.hibernate.search.backend.elasticsearch.work.impl.DeleteByQueryWork;
import org.hibernate.search.backend.elasticsearch.work.impl.FlushWork;
import org.hibernate.search.backend.elasticsearch.work.impl.ForceMergeWork;
import org.hibernate.search.backend.elasticsearch.work.impl.OpenIndexWork;
import org.hibernate.search.backend.elasticsearch.work.impl.RefreshWork;
import org.hibernate.search.backend.elasticsearch.work.impl.WaitForIndexStatusWork;
import com.google.gson.JsonObject;

/**
 * A work builder factory for Amazon OpenSearch Serverless.
 * <p>
 * Not all operations are supported,
 * see <a href="https://docs.aws.amazon.com/opensearch-service/latest/developerguide/serverless-genref.html#serverless-operations">the documentation</a>.
 *
 * @see org.hibernate.search.backend.elasticsearch.ElasticsearchDistributionName#AMAZON_OPENSEARCH_SERVERLESS
 */
public class AmazonOpenSearchServerlessWorkFactory extends Elasticsearch7WorkFactory {

    public AmazonOpenSearchServerlessWorkFactory(GsonProvider gsonProvider, Boolean ignoreShardFailures) {
        super(gsonProvider, ignoreShardFailures);
    }

    @Override
    public boolean isDeleteByQuerySupported() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DeleteByQueryWork.Builder deleteByQuery(URLEncodedString indexName, JsonObject payload) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isFlushSupported() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FlushWork.Builder flush() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isRefreshSupported() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RefreshWork.Builder refresh() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isMergeSegmentsSupported() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ForceMergeWork.Builder mergeSegments() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OpenIndexWork.Builder openIndex(URLEncodedString indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CloseIndexWork.Builder closeIndex(URLEncodedString indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public WaitForIndexStatusWork.Builder waitForIndexStatus(URLEncodedString indexName, IndexStatus requiredStatus, int requiredStatusTimeoutInMs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isWaitForIndexStatusSupported() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
