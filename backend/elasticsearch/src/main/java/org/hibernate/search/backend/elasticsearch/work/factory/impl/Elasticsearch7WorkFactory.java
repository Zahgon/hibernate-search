/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.factory.impl;

import java.util.List;
import java.util.Map;
import org.hibernate.search.backend.elasticsearch.client.common.gson.spi.GsonProvider;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.index.IndexStatus;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.aliases.impl.IndexAliasDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.settings.impl.IndexSettings;
import org.hibernate.search.backend.elasticsearch.work.impl.AnalyzeWork;
import org.hibernate.search.backend.elasticsearch.work.impl.BulkWork;
import org.hibernate.search.backend.elasticsearch.work.impl.BulkableWork;
import org.hibernate.search.backend.elasticsearch.work.impl.ClearScrollWork;
import org.hibernate.search.backend.elasticsearch.work.impl.CloseIndexWork;
import org.hibernate.search.backend.elasticsearch.work.impl.CountWork;
import org.hibernate.search.backend.elasticsearch.work.impl.CreateIndexWork;
import org.hibernate.search.backend.elasticsearch.work.impl.DeleteByQueryWork;
import org.hibernate.search.backend.elasticsearch.work.impl.DeleteWork;
import org.hibernate.search.backend.elasticsearch.work.impl.DropIndexWork;
import org.hibernate.search.backend.elasticsearch.work.impl.ElasticsearchSearchResultExtractor;
import org.hibernate.search.backend.elasticsearch.work.impl.ExplainWork;
import org.hibernate.search.backend.elasticsearch.work.impl.FlushWork;
import org.hibernate.search.backend.elasticsearch.work.impl.ForceMergeWork;
import org.hibernate.search.backend.elasticsearch.work.impl.GetIndexMetadataWork;
import org.hibernate.search.backend.elasticsearch.work.impl.IndexWork;
import org.hibernate.search.backend.elasticsearch.work.impl.OpenIndexWork;
import org.hibernate.search.backend.elasticsearch.work.impl.PutIndexAliasesWork;
import org.hibernate.search.backend.elasticsearch.work.impl.PutIndexMappingWork;
import org.hibernate.search.backend.elasticsearch.work.impl.PutIndexSettingsWork;
import org.hibernate.search.backend.elasticsearch.work.impl.RefreshWork;
import org.hibernate.search.backend.elasticsearch.work.impl.ScrollWork;
import org.hibernate.search.backend.elasticsearch.work.impl.SearchWork;
import org.hibernate.search.backend.elasticsearch.work.impl.WaitForIndexStatusWork;
import com.google.gson.JsonObject;

/**
 * A work builder factory for ES7.0+.
 */
public class Elasticsearch7WorkFactory implements ElasticsearchWorkFactory {

    protected final GsonProvider gsonProvider;

    private final Boolean ignoreShardFailures;

    public Elasticsearch7WorkFactory(GsonProvider gsonProvider, Boolean ignoreShardFailures) {
        this.gsonProvider = gsonProvider;
        this.ignoreShardFailures = ignoreShardFailures;
    }

    @Override
    public IndexWork.Builder index(String entityTypeName, Object entityIdentifier, URLEncodedString elasticsearchIndexName, String documentIdentifier, String routingKey, JsonObject document) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DeleteWork.Builder delete(String entityTypeName, Object entityIdentifier, URLEncodedString elasticsearchIndexName, String documentIdentifier, String routingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
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
    public BulkWork.Builder bulk(List<? extends BulkableWork<?>> bulkableWorks) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchWork.Builder<T> search(JsonObject payload, ElasticsearchSearchResultExtractor<T> searchResultExtractor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CountWork.Builder count() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ExplainWork.Builder explain(URLEncodedString indexName, URLEncodedString id, JsonObject payload) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> ScrollWork.Builder<T> scroll(String scrollId, String scrollTimeout, ElasticsearchSearchResultExtractor<T> searchResultExtractor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ClearScrollWork.Builder clearScroll(String scrollId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CreateIndexWork.Builder createIndex(URLEncodedString indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DropIndexWork.Builder dropIndex(URLEncodedString indexName) {
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
    public GetIndexMetadataWork.Builder getIndexMetadata() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PutIndexSettingsWork.Builder putIndexSettings(URLEncodedString indexName, IndexSettings settings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PutIndexMappingWork.Builder putIndexTypeMapping(URLEncodedString indexName, RootTypeMapping mapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isWaitForIndexStatusSupported() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public WaitForIndexStatusWork.Builder waitForIndexStatus(URLEncodedString indexName, IndexStatus requiredStatus, int requiredStatusTimeoutInMs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PutIndexAliasesWork.Builder putIndexAliases(URLEncodedString indexName, Map<String, IndexAliasDefinition> aliases) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AnalyzeWork.Builder analyze(URLEncodedString indexName, String text, String analyzer, String normalizer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
