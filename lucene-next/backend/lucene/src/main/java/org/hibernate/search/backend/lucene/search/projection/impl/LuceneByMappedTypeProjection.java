/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.projection.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorExecutionContext;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.Values;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.IndexReaderMetadataResolver;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.apache.lucene.index.LeafReaderContext;

public class LuceneByMappedTypeProjection<P> extends AbstractLuceneProjection<P> {

    private final Map<String, LuceneSearchProjection<? extends P>> inners;

    public LuceneByMappedTypeProjection(LuceneSearchIndexScope<?> scope, Map<String, LuceneSearchProjection<? extends P>> inners) {
        super(scope);
        this.inners = inners;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Extractor<?, P> request(ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final class ByMappedTypeExtractor implements Extractor<DelegateAndExtractedValue<?, P>, P> {

        private final Map<String, Extractor<?, ? extends P>> inners;

        private ByMappedTypeExtractor(Map<String, Extractor<?, ? extends P>> inners) {
            this.inners = inners;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Values<DelegateAndExtractedValue<?, P>> values(ProjectionExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public P transform(LoadingResult<?> loadingResult, DelegateAndExtractedValue<?, P> extracted, ProjectionTransformContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class ValuesWrapper<E, P> implements Values<DelegateAndExtractedValue<E, P>> {

        private final Extractor<E, ? extends P> extractor;

        private final Values<E> values;

        private ValuesWrapper(Extractor<E, ? extends P> extractor, ProjectionExtractContext context) {
            this.extractor = extractor;
            this.values = extractor.values(context);
        }

        @Override
        public void context(LeafReaderContext context) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public DelegateAndExtractedValue<E, P> get(int doc) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class ByMappedTypeValues<P> implements Values<DelegateAndExtractedValue<?, P>> {

        private final IndexReaderMetadataResolver metadataResolver;

        private final Map<String, Values<? extends DelegateAndExtractedValue<?, P>>> inners;

        private Values<? extends DelegateAndExtractedValue<?, P>> currentLeafInner;

        public ByMappedTypeValues(CollectorExecutionContext executionContext, Map<String, Values<? extends DelegateAndExtractedValue<?, P>>> inners) {
            this.metadataResolver = executionContext.getMetadataResolver();
            this.inners = inners;
        }

        @Override
        public void context(LeafReaderContext context) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public DelegateAndExtractedValue<?, P> get(int doc) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class DelegateAndExtractedValue<E, P> {

        private final Extractor<E, ? extends P> delegate;

        private final E extractedValue;

        private DelegateAndExtractedValue(Extractor<E, ? extends P> delegate, E extractedValue) {
            this.delegate = delegate;
            this.extractedValue = extractedValue;
        }

        P transform(LoadingResult<?> loadingResult, ProjectionTransformContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
