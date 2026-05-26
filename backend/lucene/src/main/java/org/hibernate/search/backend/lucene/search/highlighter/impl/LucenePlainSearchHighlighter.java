/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.highlighter.impl;

import static org.hibernate.search.backend.lucene.search.projection.impl.LuceneFieldHighlightProjection.HighlighterValues;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.StoredFieldsValuesDelegate;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.Values;
import org.hibernate.search.backend.lucene.search.projection.impl.ProjectionExtractContext;
import org.hibernate.search.backend.lucene.search.projection.impl.ProjectionRequestContext;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterFragmenter;
import org.hibernate.search.engine.search.highlighter.spi.BoundaryScannerType;
import org.hibernate.search.engine.search.highlighter.spi.SearchHighlighterType;
import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.highlight.Encoder;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.NullFragmenter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.search.highlight.TextFragment;

class LucenePlainSearchHighlighter extends LuceneAbstractSearchHighlighter {

    private static final Comparator<TextFragment> SCORE_COMPARATOR = Comparator.comparingDouble(TextFragment::getScore).reversed();

    private static final NullFragmenter NULL_FRAGMENTER = new NullFragmenter();

    private static final LucenePlainSearchHighlighter DEFAULTS = new LucenePlainSearchHighlighter(BoundaryScannerType.SENTENCE);

    private LucenePlainSearchHighlighter(BoundaryScannerType scannerType) {
        super(scannerType);
    }

    protected LucenePlainSearchHighlighter(Builder builder) {
        super(builder);
    }

    private LucenePlainSearchHighlighter(Set<String> indexNames, char[] boundaryChars, Integer boundaryMaxScan, Integer fragmentSize, Integer noMatchSize, Integer numberOfFragments, Boolean orderByScore, List<String> preTags, List<String> postTags, BoundaryScannerType boundaryScannerType, Locale boundaryScannerLocale, HighlighterFragmenter fragmenterType, Integer phraseLimit, Encoder encoder) {
        super(indexNames, boundaryChars, boundaryMaxScan, fragmentSize, noMatchSize, numberOfFragments, orderByScore, preTags, postTags, boundaryScannerType, boundaryScannerLocale, fragmenterType, phraseLimit, encoder);
    }

    @Override
    protected LuceneAbstractSearchHighlighter createHighlighterSameType(Set<String> indexNames, char[] boundaryChars, Integer boundaryMaxScan, Integer fragmentSize, Integer noMatchSize, Integer numberOfFragments, Boolean orderByScore, List<String> preTags, List<String> postTags, BoundaryScannerType boundaryScannerType, Locale boundaryScannerLocale, HighlighterFragmenter fragmenterType, Integer phraseLimit, Encoder encoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneAbstractSearchHighlighter withFallbackDefaults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <A, T> Values<A> createValues(String parentDocumentPath, String nestedDocumentPath, String absoluteFieldPath, Analyzer analyzer, ProjectionExtractContext context, ProjectionCollector<String, ?, A, T> collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchHighlighterType type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void request(ProjectionRequestContext context, String absoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final class PlainHighlighterValues<A, T> extends HighlighterValues<A, T> {

        private final StoredFieldsValuesDelegate storedFieldsValuesDelegate;

        private final Highlighter highlighter;

        private final Analyzer analyzer;

        private final String field;

        PlainHighlighterValues(String parentDocumentPath, String nestedDocumentPath, String field, Analyzer analyzer, ProjectionExtractContext context, ProjectionCollector<String, ?, A, T> collector) {
            super(parentDocumentPath, nestedDocumentPath, context.collectorExecutionContext(), collector);
            this.storedFieldsValuesDelegate = context.collectorExecutionContext().storedFieldsValuesDelegate();
            this.field = field;
            this.analyzer = analyzer;
            QueryScorer queryScorer = new QueryScorer(context.collectorExecutionContext().originalQuery(), field);
            queryScorer.setExpandMultiTermQuery(true);
            Fragmenter fragmenter;
            if (LucenePlainSearchHighlighter.this.numberOfFragments == 0) {
                fragmenter = NULL_FRAGMENTER;
            } else if (HighlighterFragmenter.SPAN.equals(LucenePlainSearchHighlighter.this.fragmenterType)) {
                fragmenter = new SimpleSpanFragmenter(queryScorer, LucenePlainSearchHighlighter.this.fragmentSize);
            } else {
                fragmenter = new SimpleFragmenter(LucenePlainSearchHighlighter.this.fragmentSize);
            }
            this.highlighter = new Highlighter(new SimpleHTMLFormatter(LucenePlainSearchHighlighter.this.preTags.get(0), LucenePlainSearchHighlighter.this.postTags.get(0)), LucenePlainSearchHighlighter.this.encoder, queryScorer);
            this.highlighter.setTextFragmenter(fragmenter);
            this.highlighter.setMaxDocCharsToAnalyze(Integer.MAX_VALUE);
        }

        @Override
        public List<String> highlight(int doc) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
