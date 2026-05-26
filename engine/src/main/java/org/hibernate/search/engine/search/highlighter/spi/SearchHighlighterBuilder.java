/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.highlighter.spi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.hibernate.search.engine.search.highlighter.SearchHighlighter;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterEncoder;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterFragmenter;
import org.hibernate.search.engine.search.highlighter.dsl.HighlighterTagSchema;

public abstract class SearchHighlighterBuilder {

    protected SearchHighlighterType type;

    protected char[] boundaryChars;

    protected Integer boundaryMaxScan;

    protected Integer fragmentSize;

    protected Integer noMatchSize;

    protected Integer numberOfFragments;

    protected Boolean orderByScore;

    protected List<String> preTags;

    protected List<String> postTags;

    protected BoundaryScannerType boundaryScannerType = BoundaryScannerType.DEFAULT;

    protected Locale boundaryScannerLocale;

    protected HighlighterFragmenter fragmenterType;

    protected Integer phraseLimit;

    protected HighlighterEncoder encoder;

    protected HighlighterTagSchema tagSchema;

    public SearchHighlighterBuilder type(SearchHighlighterType type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder boundaryChars(String boundaryChars) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder boundaryChars(char[] boundaryChars) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder boundaryMaxScan(Integer boundaryMaxScan) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder fragmentSize(Integer fragmentSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder noMatchSize(Integer noMatchSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder numberOfFragments(Integer numberOfFragments) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder orderByScore(Boolean orderByScore) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder boundaryScannerType(BoundaryScannerType boundaryScannerType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder boundaryScannerLocale(Locale boundaryScannerLocale) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder fragmenter(HighlighterFragmenter type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder phraseLimit(Integer phraseLimit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder tag(String preTag, String postTag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder tags(Collection<String> preTags, String postTag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder tags(Collection<String> preTags, Collection<String> postTags) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void clearTags() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void clearIfNotNull(List<String> tags) {
        if (tags != null) {
            tags.clear();
        }
    }

    public SearchHighlighterBuilder tagSchema(HighlighterTagSchema tagSchema) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterBuilder encoder(HighlighterEncoder encoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchHighlighterType type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public char[] boundaryChars() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String boundaryCharsAsString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer boundaryMaxScan() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer fragmentSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer noMatchSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer numberOfFragments() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean orderByScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> preTags() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> postTags() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BoundaryScannerType boundaryScannerType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Locale boundaryScannerLocale() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public HighlighterFragmenter fragmenterType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer phraseLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public HighlighterTagSchema tagSchema() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public HighlighterEncoder encoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract SearchHighlighter build();
}
