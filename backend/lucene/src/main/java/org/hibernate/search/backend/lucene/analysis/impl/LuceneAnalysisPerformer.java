/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.backend.lucene.LuceneBackend;
import org.hibernate.search.backend.lucene.logging.impl.AnalysisLog;
import org.hibernate.search.engine.backend.analysis.AnalysisToken;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

public class LuceneAnalysisPerformer {

    private final LuceneBackend backend;

    public LuceneAnalysisPerformer(LuceneBackend backend) {
        this.backend = backend;
    }

    public List<? extends AnalysisToken> analyze(String analyzerName, String terms) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AnalysisToken normalize(String normalizerName, String terms) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static List<LuceneAnalysisToken> analyze(String analyzerName, Analyzer analyzer, String string) {
        List<LuceneAnalysisToken> tokens = new ArrayList<>();
        try (TokenStream tokenStream = analyzer.tokenStream("", string)) {
            CharTermAttribute termAttribute = tokenStream.addAttribute(CharTermAttribute.class);
            OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
            TypeAttribute typeAttribute = tokenStream.addAttribute(TypeAttribute.class);
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                tokens.add(new LuceneAnalysisToken(termAttribute.toString(), offsetAttribute.startOffset(), offsetAttribute.endOffset(), typeAttribute.type()));
            }
        } catch (IOException e) {
            throw AnalysisLog.INSTANCE.unableToPerformAnalysisOperation(analyzerName, string, e.getMessage(), e);
        }
        return tokens;
    }

    private static class LuceneAnalysisToken implements AnalysisToken {

        private final String term;

        private final int startOffset;

        private final int endOffset;

        private final String type;

        private LuceneAnalysisToken(String term, int startOffset, int endOffset, String type) {
            this.term = term;
            this.startOffset = startOffset;
            this.endOffset = endOffset;
            this.type = type;
        }

        @Override
        public String term() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int startOffset() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int endOffset() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String type() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
