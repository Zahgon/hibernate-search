/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.configuration.properties.collector.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Lists the config parameters that can be passed to this annotation processor via {@code -A.....}.
 */
public final class ConfigurationRules {

    private static final Set<String> IGNORED_CLASSES = Collections.emptySet();

    private static final Set<String> IGNORED_CONSTANTS = new HashSet<>(Arrays.asList("org.hibernate.search.engine.cfg.BackendSettings#INDEXES", "org.hibernate.search.backend.elasticsearch.cfg.ElasticsearchBackendSettings#TYPE_NAME", "org.hibernate.search.backend.lucene.cfg.LuceneBackendSettings#TYPE_NAME", "org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings#SHARDS", "org.hibernate.search.mapper.orm.cfg.HibernateOrmMapperSettings#COORDINATION", "org.hibernate.search.mapper.orm.outboxpolling.cfg.HibernateOrmMapperOutboxPollingSettings#COORDINATION_STRATEGY_NAME", "org.hibernate.search.engine.cfg.EngineSettings#BACKEND", "org.hibernate.search.engine.cfg.EngineSettings#BACKENDS", "org.hibernate.search.engine.cfg.BackendSettings#INDEXES"));

    private ConfigurationRules() {
    }

    public static boolean isClassIgnored(String className) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isConstantIgnored(String className, String constantName, String constantValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static List<String> prefixes(String className, String propertyKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
