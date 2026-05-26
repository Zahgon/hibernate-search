/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.writer.impl;

import java.util.List;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.util.common.reporting.EventContext;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.codecs.Codec;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.LogByteSizeMergePolicy;
import org.apache.lucene.search.similarities.Similarity;

/**
 * A source of index writer configuration that can be re-used on multiple writers.
 * <p>
 * This is mostly necessary because we don't have access to the user configuration after startup,
 * and we don't want to re-use the same IndexWriterConfig instance multiple times in order to be safe
 * and make sure a previous, failing index writer will never affect the configuration of
 * the new index writer created to replace it.
 *
 * @author Hardy Ferentschik
 * @author Sanne Grinovero
 */
public class IndexWriterConfigSource {

    public static IndexWriterConfigSource create(Similarity similarity, Analyzer analyzer, Codec codec, ConfigurationPropertySource propertySource, EventContext eventContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Similarity similarity;

    private final Analyzer analyzer;

    private final Codec codec;

    private final List<IndexWriterSettingValue<?>> values;

    private IndexWriterConfigSource(Similarity similarity, Analyzer analyzer, Codec codec, List<IndexWriterSettingValue<?>> values) {
        this.similarity = similarity;
        this.analyzer = analyzer;
        this.codec = codec;
        this.values = values;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new {@link IndexWriterConfig}.
     * Undefined parameters are not set, leaving the lucene default.
     */
    public IndexWriterConfig createIndexWriterConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private LogByteSizeMergePolicy createMergePolicy() {
        LogByteSizeMergePolicy logByteSizeMergePolicy = new LogByteSizeMergePolicy();
        for (IndexWriterSettingValue<?> value : values) {
            value.applySetting(logByteSizeMergePolicy);
        }
        return logByteSizeMergePolicy;
    }
}
