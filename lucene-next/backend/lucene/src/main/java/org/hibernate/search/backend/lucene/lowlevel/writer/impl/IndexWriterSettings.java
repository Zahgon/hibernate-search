/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.writer.impl;

import static org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings.IO_MERGE_CALIBRATE_BY_DELETES;
import static org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings.IO_MERGE_FACTOR;
import static org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings.IO_MERGE_MAX_DOCS;
import static org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings.IO_MERGE_MAX_FORCED_SIZE;
import static org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings.IO_MERGE_MAX_SIZE;
import static org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings.IO_MERGE_MIN_SIZE;
import static org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings.IO_WRITER_INFOSTREAM;
import static org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings.IO_WRITER_MAX_BUFFERED_DOCS;
import static org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings.IO_WRITER_RAM_BUFFER_SIZE;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.hibernate.search.backend.lucene.logging.impl.LuceneMiscLog;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.util.common.reporting.EventContext;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.LogByteSizeMergePolicy;

/**
 * Represents possible options to be applied to an
 * {@code org.apache.lucene.index.IndexWriter}.
 *
 * @author Sanne Grinovero
 */
public final class IndexWriterSettings implements Serializable {

    private IndexWriterSettings() {
    }

    public static List<IndexWriterSettingValue<?>> extractAll(ConfigurationPropertySource propertySource, EventContext eventContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final List<Extractor<?, ?>> EXTRACTORS = new ArrayList<>();

    static {
        registerIntegerWriterSetting(IO_WRITER_MAX_BUFFERED_DOCS, IndexWriterConfig::setMaxBufferedDocs);
        registerIntegerWriterSetting(IO_WRITER_RAM_BUFFER_SIZE, IndexWriterConfig::setRAMBufferSizeMB);
        registerSetting(Extractor.fromBoolean(IO_WRITER_INFOSTREAM, enabled -> Boolean.TRUE.equals(enabled) ? new LoggerInfoStream() : null, IndexWriterConfig::setInfoStream, (logByteSizeMergePolicy, integer) -> {
        }));
        registerIntegerMergePolicySetting(IO_MERGE_MAX_DOCS, LogByteSizeMergePolicy::setMaxMergeDocs);
        registerIntegerMergePolicySetting(IO_MERGE_FACTOR, LogByteSizeMergePolicy::setMergeFactor);
        registerIntegerMergePolicySetting(IO_MERGE_MIN_SIZE, LogByteSizeMergePolicy::setMinMergeMB);
        registerIntegerMergePolicySetting(IO_MERGE_MAX_SIZE, LogByteSizeMergePolicy::setMaxMergeMB);
        registerIntegerMergePolicySetting(IO_MERGE_MAX_FORCED_SIZE, LogByteSizeMergePolicy::setMaxMergeMBForForcedMerge);
        registerBooleanMergePolicySetting(IO_MERGE_CALIBRATE_BY_DELETES, LogByteSizeMergePolicy::setCalibrateSizeByDeletes);
    }

    private static void registerIntegerWriterSetting(String propertyKey, BiConsumer<IndexWriterConfig, Integer> writerSettingApplier) {
        EXTRACTORS.add(Extractor.fromInteger(propertyKey, Function.identity(), writerSettingApplier, (logByteSizeMergePolicy, integer) -> {
        }));
    }

    private static void registerIntegerMergePolicySetting(String propertyKey, BiConsumer<LogByteSizeMergePolicy, Integer> mergePolicySettingApplier) {
        EXTRACTORS.add(Extractor.fromInteger(propertyKey, Function.identity(), (writer, integer) -> {
        }, mergePolicySettingApplier));
    }

    private static void registerBooleanMergePolicySetting(String propertyKey, BiConsumer<LogByteSizeMergePolicy, Boolean> mergePolicySettingApplier) {
        EXTRACTORS.add(Extractor.fromBoolean(propertyKey, Function.identity(), (writer, integer) -> {
        }, mergePolicySettingApplier));
    }

    private static void registerSetting(Extractor<?, ?> extractor) {
        EXTRACTORS.add(extractor);
    }

    private static final class Extractor<T, R> {

        static <R> Extractor<Integer, R> fromInteger(String propertyKey, Function<Integer, R> processor, BiConsumer<IndexWriterConfig, R> writerSettingApplier, BiConsumer<LogByteSizeMergePolicy, R> mergePolicySettingApplier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        static <R> Extractor<Boolean, R> fromBoolean(String propertyKey, Function<Boolean, R> processor, BiConsumer<IndexWriterConfig, R> writerSettingApplier, BiConsumer<LogByteSizeMergePolicy, R> mergePolicySettingApplier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private final String settingName;

        private final OptionalConfigurationProperty<T> property;

        private final Function<T, R> processor;

        private final BiConsumer<IndexWriterConfig, R> writerSettingApplier;

        private final BiConsumer<LogByteSizeMergePolicy, R> mergePolicySettingApplier;

        private Extractor(String settingName, OptionalConfigurationProperty<T> property, Function<T, R> processor, BiConsumer<IndexWriterConfig, R> writerSettingApplier, BiConsumer<LogByteSizeMergePolicy, R> mergePolicySettingApplier) {
            this.settingName = settingName;
            this.property = property;
            this.processor = processor;
            this.writerSettingApplier = writerSettingApplier;
            this.mergePolicySettingApplier = mergePolicySettingApplier;
        }

        IndexWriterSettingValue<R> extractOrNull(ConfigurationPropertySource source, EventContext eventContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private IndexWriterSettingValue<R> createValueOrNull(T value, EventContext eventContext) {
            if (value == null) {
                return null;
            }
            if (LuceneMiscLog.INSTANCE.isDebugEnabled()) {
                LuceneMiscLog.INSTANCE.indexWriterSetParameter(settingName, value, eventContext.renderWithPrefix());
            }
            R processedValue = processor.apply(value);
            return new IndexWriterSettingValue<>(settingName, processedValue, writerSettingApplier, mergePolicySettingApplier);
        }
    }
}
