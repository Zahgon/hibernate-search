/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.hibernate.search.backend.elasticsearch.logging.impl.AnalysisLog;
import org.hibernate.search.backend.elasticsearch.logging.impl.MappingLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchCountValuesAggregation;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.ElasticsearchTermsAggregation;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchExistsPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchPredicateTypeKeys;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchRangePredicate;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchFieldHighlightProjection;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchFieldProjection;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchStringFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchCommonQueryStringPredicateBuilderFieldState;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchTermsPredicate;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchTextMatchPredicate;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchTextPhrasePredicate;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchTextPrefixPredicate;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchTextRegexpPredicate;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchTextWildcardPredicate;
import org.hibernate.search.backend.elasticsearch.types.sort.impl.ElasticsearchStandardFieldSort;
import org.hibernate.search.engine.backend.types.Aggregable;
import org.hibernate.search.engine.backend.types.Highlightable;
import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.engine.backend.types.Norms;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.engine.backend.types.TermVector;
import org.hibernate.search.engine.backend.types.dsl.StringIndexFieldTypeOptionsStep;
import org.hibernate.search.engine.search.aggregation.spi.AggregationTypeKeys;
import org.hibernate.search.engine.search.highlighter.spi.SearchHighlighterType;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.engine.search.sort.spi.SortTypeKeys;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Contracts;
import com.google.gson.JsonPrimitive;

class ElasticsearchStringIndexFieldTypeOptionsStep extends AbstractElasticsearchStandardIndexFieldTypeOptionsStep<ElasticsearchStringIndexFieldTypeOptionsStep, String> implements StringIndexFieldTypeOptionsStep<ElasticsearchStringIndexFieldTypeOptionsStep> {

    private String analyzerName;

    private String searchAnalyzerName;

    private String normalizerName;

    private Projectable projectable = Projectable.DEFAULT;

    private Searchable searchable = Searchable.DEFAULT;

    private Norms norms = Norms.DEFAULT;

    private Sortable sortable = Sortable.DEFAULT;

    private Aggregable aggregable = Aggregable.DEFAULT;

    private String indexNullAs;

    private TermVector termVector = TermVector.DEFAULT;

    private Set<Highlightable> highlightable;

    ElasticsearchStringIndexFieldTypeOptionsStep(ElasticsearchIndexFieldTypeBuildContext buildContext) {
        super(buildContext, String.class);
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep analyzer(String analyzerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep searchAnalyzer(String searchAnalyzerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep normalizer(String normalizerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep projectable(Projectable projectable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep norms(Norms norms) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep termVector(TermVector termVector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep highlightable(Collection<Highlightable> highlightable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep sortable(Sortable sortable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep indexNullAs(String indexNullAs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep searchable(Searchable searchable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchStringIndexFieldTypeOptionsStep aggregable(Aggregable aggregable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexFieldType<String> toIndexFieldType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchStringIndexFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean resolveNorms() {
        switch(norms) {
            case YES:
                return true;
            case NO:
                return false;
            case DEFAULT:
                return (analyzerName != null);
            default:
                throw new AssertionFailure("Unexpected value for Norms: " + norms);
        }
    }

    private String resolveTermVector() {
        if (highlightable != null && (highlightable.contains(Highlightable.FAST_VECTOR) || highlightable.contains(Highlightable.ANY))) {
            if (TermVector.DEFAULT.equals(termVector)) {
                return TermVector.WITH_POSITIONS_OFFSETS.name().toLowerCase(Locale.ROOT);
            } else if (TermVector.WITH_POSITIONS_OFFSETS.equals(termVector) || TermVector.WITH_POSITIONS_OFFSETS_PAYLOADS.equals(termVector)) {
                return termVector.name().toLowerCase(Locale.ROOT);
            } else {
                throw MappingLog.INSTANCE.termVectorDontAllowFastVectorHighlighter(termVector);
            }
        } else {
            switch(termVector) {
                case NO:
                case DEFAULT:
                    return "no";
                default:
                    return termVector.name().toLowerCase(Locale.ROOT);
            }
        }
    }

    private Set<SearchHighlighterType> resolveAllowedHighlighterTypes() {
        if (highlightable == null) {
            highlightable = EnumSet.of(Highlightable.DEFAULT);
        }
        if (highlightable.isEmpty()) {
            throw MappingLog.INSTANCE.noHighlightableProvided();
        }
        if (highlightable.contains(Highlightable.DEFAULT)) {
            if (TermVector.WITH_POSITIONS_OFFSETS.equals(termVector) || TermVector.WITH_POSITIONS_OFFSETS_PAYLOADS.equals(termVector)) {
                highlightable = EnumSet.of(Highlightable.ANY);
            } else {
                highlightable = EnumSet.of(Highlightable.UNIFIED, Highlightable.PLAIN);
            }
        }
        if (highlightable.contains(Highlightable.NO)) {
            if (highlightable.size() == 1) {
                return Collections.emptySet();
            } else {
                throw MappingLog.INSTANCE.unsupportedMixOfHighlightableValues(highlightable);
            }
        }
        if (highlightable.contains(Highlightable.ANY)) {
            return EnumSet.of(SearchHighlighterType.PLAIN, SearchHighlighterType.UNIFIED, SearchHighlighterType.FAST_VECTOR);
        }
        Set<SearchHighlighterType> highlighters = new HashSet<>();
        if (highlightable.contains(Highlightable.PLAIN)) {
            highlighters.add(SearchHighlighterType.PLAIN);
        }
        if (highlightable.contains(Highlightable.UNIFIED)) {
            highlighters.add(SearchHighlighterType.UNIFIED);
        }
        if (highlightable.contains(Highlightable.FAST_VECTOR)) {
            highlighters.add(SearchHighlighterType.FAST_VECTOR);
        }
        return EnumSet.copyOf(highlighters);
    }
}
