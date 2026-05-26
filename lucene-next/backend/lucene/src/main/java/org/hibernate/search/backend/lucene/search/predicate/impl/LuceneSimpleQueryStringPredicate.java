/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import java.util.Map;
import java.util.Set;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneCommonQueryStringPredicateBuilderFieldState;
import org.hibernate.search.engine.search.common.BooleanOperator;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementTypeKey;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.SimpleQueryFlag;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.predicate.spi.SimpleQueryStringPredicateBuilder;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.simple.SimpleQueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.Query;

public class LuceneSimpleQueryStringPredicate extends LuceneCommonQueryStringPredicate {

    private LuceneSimpleQueryStringPredicate(Builder builder) {
        super(builder);
    }

    public static class Builder extends LuceneCommonQueryStringPredicate.Builder implements SimpleQueryStringPredicateBuilder {

        private int flags = -1;

        Builder(LuceneSearchIndexScope<?> scope) {
            super(scope);
        }

        @Override
        public void flags(Set<SimpleQueryFlag> flags) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query buildQuery(PredicateRequestContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected SearchQueryElementTypeKey<LuceneCommonQueryStringPredicateBuilderFieldState> typeKey() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static BooleanClause.Occur toOccur(BooleanOperator operator) {
            switch(operator) {
                case AND:
                    return BooleanClause.Occur.MUST;
                case OR:
                    return BooleanClause.Occur.SHOULD;
                default:
                    throw new AssertionFailure("Unknown boolean operator: " + operator);
            }
        }

        private static int toFlagsMask(Set<SimpleQueryFlag> flags) {
            int flag = -1;
            if (flags != null) {
                flag = 0;
                for (SimpleQueryFlag operation : flags) {
                    switch(operation) {
                        case AND:
                            flag |= SimpleQueryParser.AND_OPERATOR;
                            break;
                        case NOT:
                            flag |= SimpleQueryParser.NOT_OPERATOR;
                            break;
                        case OR:
                            flag |= SimpleQueryParser.OR_OPERATOR;
                            break;
                        case PREFIX:
                            flag |= SimpleQueryParser.PREFIX_OPERATOR;
                            break;
                        case PHRASE:
                            flag |= SimpleQueryParser.PHRASE_OPERATOR;
                            break;
                        case PRECEDENCE:
                            flag |= SimpleQueryParser.PRECEDENCE_OPERATORS;
                            break;
                        case ESCAPE:
                            flag |= SimpleQueryParser.ESCAPE_OPERATOR;
                            break;
                        case WHITESPACE:
                            flag |= SimpleQueryParser.WHITESPACE_OPERATOR;
                            break;
                        case FUZZY:
                            flag |= SimpleQueryParser.FUZZY_OPERATOR;
                            break;
                        case NEAR:
                            flag |= SimpleQueryParser.NEAR_OPERATOR;
                            break;
                    }
                }
            }
            return flag;
        }
    }

    private static class HibernateSearchSimpleQueryParser extends SimpleQueryParser {

        private final Map<String, LuceneCommonQueryStringPredicateBuilderFieldState> fieldStates;

        private final LuceneSearchIndexScope<?> scope;

        public HibernateSearchSimpleQueryParser(Analyzer analyzer, Map<String, Float> weights, Map<String, LuceneCommonQueryStringPredicateBuilderFieldState> fieldStates, int flags, LuceneSearchIndexScope<?> scope) {
            super(analyzer, weights, flags);
            this.fieldStates = fieldStates;
            this.scope = scope;
        }

        @Override
        protected Query createFieldQuery(Analyzer analyzer, BooleanClause.Occur operator, String field, String queryText, boolean quoted, int phraseSlop) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query newPrefixQuery(String text) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query newFuzzyQuery(String text, int fuzziness) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
