/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.dialect.protocol.impl;

import org.hibernate.search.backend.elasticsearch.client.common.gson.spi.GsonProvider;
import org.hibernate.search.backend.elasticsearch.lowlevel.syntax.metadata.impl.Elasticsearch7IndexMetadataSyntax;
import org.hibernate.search.backend.elasticsearch.lowlevel.syntax.metadata.impl.ElasticsearchIndexMetadataSyntax;
import org.hibernate.search.backend.elasticsearch.lowlevel.syntax.search.impl.Elasticsearch81SearchSyntax;
import org.hibernate.search.backend.elasticsearch.lowlevel.syntax.search.impl.ElasticsearchSearchSyntax;
import org.hibernate.search.backend.elasticsearch.search.query.impl.Elasticsearch7SearchResultExtractorFactory;
import org.hibernate.search.backend.elasticsearch.search.query.impl.ElasticsearchSearchResultExtractorFactory;
import org.hibernate.search.backend.elasticsearch.work.factory.impl.Elasticsearch7WorkFactory;
import org.hibernate.search.backend.elasticsearch.work.factory.impl.ElasticsearchWorkFactory;

/**
 * The protocol dialect for Elasticsearch 8.1 and later 8.x.
 */
public class Elasticsearch81ProtocolDialect implements ElasticsearchProtocolDialect {

    @Override
    public ElasticsearchIndexMetadataSyntax createIndexMetadataSyntax() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchSyntax createSearchSyntax() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchWorkFactory createWorkFactory(GsonProvider gsonProvider, Boolean ignoreShardFailures) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchResultExtractorFactory createSearchResultExtractorFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
