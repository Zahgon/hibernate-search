/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.impl;

import java.util.Optional;
import org.hibernate.search.backend.elasticsearch.ElasticsearchVersion;
import org.hibernate.search.backend.elasticsearch.cfg.ElasticsearchBackendSettings;
import org.hibernate.search.backend.elasticsearch.client.common.gson.spi.GsonProvider;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchClient;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchClientFactory;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchClientImplementor;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.ElasticsearchClientUtils;
import org.hibernate.search.backend.elasticsearch.dialect.impl.ElasticsearchDialectFactory;
import org.hibernate.search.backend.elasticsearch.dialect.protocol.impl.ElasticsearchProtocolDialect;
import org.hibernate.search.backend.elasticsearch.gson.spi.GsonProviderHelper;
import org.hibernate.search.backend.elasticsearch.index.layout.IndexLayoutStrategy;
import org.hibernate.search.backend.elasticsearch.index.layout.impl.IndexNames;
import org.hibernate.search.backend.elasticsearch.link.impl.ElasticsearchLink;
import org.hibernate.search.backend.elasticsearch.logging.impl.MappingLog;
import org.hibernate.search.backend.elasticsearch.logging.impl.VersionLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.syntax.metadata.impl.ElasticsearchIndexMetadataSyntax;
import org.hibernate.search.backend.elasticsearch.lowlevel.syntax.search.impl.ElasticsearchSearchSyntax;
import org.hibernate.search.backend.elasticsearch.mapping.impl.TypeNameMapping;
import org.hibernate.search.backend.elasticsearch.multitenancy.impl.MultiTenancyStrategy;
import org.hibernate.search.backend.elasticsearch.resources.impl.BackendThreads;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionExtractionHelper;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.SearchProjectionBackendContext;
import org.hibernate.search.backend.elasticsearch.search.query.impl.ElasticsearchSearchResultExtractorFactory;
import org.hibernate.search.backend.elasticsearch.work.factory.impl.ElasticsearchWorkFactory;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Closer;
import com.google.gson.GsonBuilder;

class ElasticsearchLinkImpl implements ElasticsearchLink {

    static final OptionalConfigurationProperty<ElasticsearchVersion> VERSION = ConfigurationProperty.forKey(ElasticsearchBackendSettings.VERSION).as(ElasticsearchVersion.class, ElasticsearchVersion::of).build();

    private static final OptionalConfigurationProperty<Boolean> VERSION_CHECK_ENABLED = ConfigurationProperty.forKey(ElasticsearchBackendSettings.VERSION_CHECK_ENABLED).asBoolean().build();

    private static final ConfigurationProperty<Integer> SCROLL_TIMEOUT = ConfigurationProperty.forKey(ElasticsearchBackendSettings.SCROLL_TIMEOUT).asIntegerStrictlyPositive().withDefault(ElasticsearchBackendSettings.Defaults.SCROLL_TIMEOUT).build();

    private static final ConfigurationProperty<Boolean> QUERY_SHARD_FAILURE_IGNORE = ConfigurationProperty.forKey(ElasticsearchBackendSettings.QUERY_SHARD_FAILURE_IGNORE).asBoolean().withDefault(ElasticsearchBackendSettings.Defaults.QUERY_SHARD_FAILURE_IGNORE).build();

    private static final ConfigurationProperty<BeanReference<? extends IndexLayoutStrategy>> LAYOUT_STRATEGY = ConfigurationProperty.forKey(ElasticsearchBackendSettings.LAYOUT_STRATEGY).asBeanReference(IndexLayoutStrategy.class).withDefault(ElasticsearchBackendSettings.Defaults.LAYOUT_STRATEGY).build();

    private final BeanHolder<? extends ElasticsearchClientFactory> clientFactoryHolder;

    private final BackendThreads threads;

    private final GsonProvider defaultGsonProvider;

    private final boolean logPrettyPrinting;

    private final ElasticsearchDialectFactory dialectFactory;

    private final Optional<ElasticsearchVersion> configuredVersionOnBackendCreationOptional;

    private final TypeNameMapping typeNameMapping;

    private final IndexNamesRegistry indexNamesRegistry;

    private ElasticsearchClientImplementor clientImplementor;

    private ElasticsearchVersion elasticsearchVersion;

    private GsonProvider gsonProvider;

    private ElasticsearchIndexMetadataSyntax indexMetadataSyntax;

    private ElasticsearchSearchSyntax searchSyntax;

    private ElasticsearchWorkFactory workFactory;

    private ElasticsearchSearchResultExtractorFactory searchResultExtractorFactory;

    private Integer scrollTimeout;

    private BeanHolder<? extends IndexLayoutStrategy> indexLayoutStrategyHolder;

    private SearchProjectionBackendContext searchProjectionBackendContext;

    ElasticsearchLinkImpl(BeanHolder<? extends ElasticsearchClientFactory> clientFactoryHolder, BackendThreads threads, GsonProvider defaultGsonProvider, boolean logPrettyPrinting, ElasticsearchDialectFactory dialectFactory, Optional<ElasticsearchVersion> configuredVersionOnBackendCreationOptional, TypeNameMapping typeNameMapping) {
        this.clientFactoryHolder = clientFactoryHolder;
        this.threads = threads;
        this.defaultGsonProvider = defaultGsonProvider;
        this.logPrettyPrinting = logPrettyPrinting;
        this.dialectFactory = dialectFactory;
        this.configuredVersionOnBackendCreationOptional = configuredVersionOnBackendCreationOptional;
        this.typeNameMapping = typeNameMapping;
        this.indexNamesRegistry = new IndexNamesRegistry();
    }

    @Override
    public ElasticsearchClient getClient() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GsonProvider getGsonProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchIndexMetadataSyntax getIndexMetadataSyntax() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchSyntax getSearchSyntax() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchWorkFactory getWorkFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchResultExtractorFactory getSearchResultExtractorFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer getScrollTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexLayoutStrategy getIndexLayoutStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypeNameMapping getTypeNameMapping() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexNames createIndexNames(String hibernateSearchIndexName, String mappedTypeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchProjectionBackendContext getSearchProjectionBackendContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ElasticsearchVersion getElasticsearchVersion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void onStart(BeanResolver beanResolver, MultiTenancyStrategy multiTenancyStrategy, ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void onStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void checkStarted() {
        if (clientImplementor == null) {
            throw new AssertionFailure("Attempt to retrieve Elasticsearch client or related information before the Elasticsearch client was started.");
        }
    }

    private ElasticsearchVersion initVersion(ConfigurationPropertySource propertySource) {
        Optional<Boolean> versionCheckEnabled = VERSION_CHECK_ENABLED.get(propertySource);
        Optional<ElasticsearchVersion> configuredVersionOptional = VERSION.getAndTransform(propertySource, configuredVersionOnStartOptional -> {
            Optional<ElasticsearchVersion> resultOptional;
            if (configuredVersionOnStartOptional.isPresent()) {
                // Allow overriding the version on start,
                // but expect it to match the version configured on backend creation (if any)
                if (configuredVersionOnBackendCreationOptional.isPresent() && !configuredVersionOnBackendCreationOptional.get().matches(configuredVersionOnStartOptional.get())) {
                    throw VersionLog.INSTANCE.incompatibleElasticsearchVersionOnStart(configuredVersionOnBackendCreationOptional.get(), configuredVersionOnStartOptional.get());
                }
                resultOptional = configuredVersionOnStartOptional;
            } else {
                // Default to the version configured when the backend was created
                resultOptional = configuredVersionOnBackendCreationOptional;
            }
            // If the version is unset or imprecise,
            // we will need to retrieve it from the cluster through a version check.
            // So in that situation, if version checks are disabled explicitly (they're enabled by default),
            // we'll raise an exception now, in the context of the "version" configuration property.
            if ((resultOptional.isEmpty() || !ElasticsearchDialectFactory.isPreciseEnoughForProtocolDialect(resultOptional.get())) && versionCheckEnabled.isPresent() && !versionCheckEnabled.get()) {
                throw VersionLog.INSTANCE.impreciseElasticsearchVersionWhenVersionCheckDisabled(VERSION_CHECK_ENABLED.resolveOrRaw(propertySource));
            }
            return resultOptional;
        });
        // If someone tries to force the version check on a distribution that doesn't support them
        // (Amazon OpenSearch Serverless), we'll raise an exception.
        boolean versionCheckImpossible = configuredVersionOptional.isPresent() && ElasticsearchDialectFactory.isVersionCheckImpossible(configuredVersionOptional.get());
        if (versionCheckImpossible && versionCheckEnabled.isPresent() && versionCheckEnabled.get()) {
            // Get the configuration property again in order to produce
            // an error message in the context of the problematic configuration property.
            VERSION_CHECK_ENABLED.getAndMap(propertySource, enabled -> {
                if (enabled) {
                    throw VersionLog.INSTANCE.cannotCheckElasticsearchVersion(configuredVersionOptional.get().distribution());
                }
                return enabled;
            });
        }
        // Version checks are disabled by default if we know they're impossible.
        if (versionCheckEnabled.orElse(!versionCheckImpossible)) {
            ElasticsearchVersion versionFromCluster = fetchElasticsearchVersion(propertySource);
            if (configuredVersionOptional.isPresent()) {
                ElasticsearchVersion configuredVersion = configuredVersionOptional.get();
                if (!configuredVersion.matches(versionFromCluster)) {
                    throw VersionLog.INSTANCE.unexpectedElasticsearchVersion(configuredVersion, versionFromCluster);
                }
            }
            return versionFromCluster;
        } else {
            // In this case we know the optional is non-empty:
            // see the checks when retrieving the configured version.
            return configuredVersionOptional.get();
        }
    }

    private ElasticsearchVersion fetchElasticsearchVersion(ConfigurationPropertySource propertySource) {
        try {
            ElasticsearchVersion version = ElasticsearchClientUtils.tryGetElasticsearchVersion(clientImplementor);
            if (version == null) {
                // This can happen when targeting Amazon OpenSearch Service
                // and we didn't notice the problem early
                // because the version was unset
                // or the distribution was incorrectly set to elasticsearch/opensearch.
                throw VersionLog.INSTANCE.unableToFetchElasticsearchVersion(VERSION.resolveOrRaw(propertySource), ElasticsearchDialectFactory.AMAZON_OPENSEARCH_SERVERLESS);
            }
            return version;
        } catch (RuntimeException e) {
            throw VersionLog.INSTANCE.failedToDetectElasticsearchVersion(e.getMessage(), e);
        }
    }

    private BeanHolder<? extends IndexLayoutStrategy> createIndexLayoutStrategy(BeanResolver beanResolver, ConfigurationPropertySource propertySource) {
        return LAYOUT_STRATEGY.getAndTransform(propertySource, beanResolver::resolve);
    }
}
