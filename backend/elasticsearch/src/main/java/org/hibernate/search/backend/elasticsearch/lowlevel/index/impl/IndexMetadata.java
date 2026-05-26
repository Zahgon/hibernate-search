/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.impl;

import java.util.Map;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.aliases.impl.IndexAliasDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.settings.impl.IndexSettings;
import com.google.gson.GsonBuilder;

/**
 * An object representing metadata of an Elasticsearch index: aliases, mapping, settings, ...
 */
public class IndexMetadata {

    private Map<String, IndexAliasDefinition> aliases;

    private RootTypeMapping mapping;

    private IndexSettings settings;

    public Map<String, IndexAliasDefinition> getAliases() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAliases(Map<String, IndexAliasDefinition> aliases) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RootTypeMapping getMapping() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMapping(RootTypeMapping mapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexSettings getSettings() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSettings(IndexSettings settings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
