/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.docvalues.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.ChildDocIds;
import org.apache.lucene.index.SortedNumericDocValues;
import org.apache.lucene.index.SortedSetDocValues;
import org.apache.lucene.search.DocIdSetIterator;

/**
 * Defines what values to pick in the case a document contains multiple values
 * for a particular field.
 */
public enum MultiValueMode {

    SUM {

        @Override
        long pick(SortedNumericDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        long pick(SortedNumericDocValues values, ChildDocIds childDocsWithValues) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        double pick(SortedNumericDoubleDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        double pick(SortedNumericDoubleDocValues values, ChildDocIds childDocsWithValues) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , AVG {

        @Override
        long pick(SortedNumericDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        long pick(SortedNumericDocValues values, ChildDocIds childDocsWithValues) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        double pick(SortedNumericDoubleDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        double pick(SortedNumericDoubleDocValues values, ChildDocIds childDocsWithValues) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , MIN {

        @Override
        long pick(SortedNumericDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        long pick(SortedNumericDocValues values, ChildDocIds childDocsWithValues) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        double pick(SortedNumericDoubleDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        double pick(SortedNumericDoubleDocValues values, ChildDocIds childDocsWithValues) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        long pick(SortedSetDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        long pick(SortedSetDocValues values, ChildDocIds childDocsWithValues) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , MAX {

        @Override
        long pick(SortedNumericDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        long pick(SortedNumericDocValues values, ChildDocIds childDocsWithValues) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        double pick(SortedNumericDoubleDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        double pick(SortedNumericDoubleDocValues values, ChildDocIds childDocsWithValues) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        long pick(SortedSetDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        long pick(SortedSetDocValues values, ChildDocIds childDocsWithValues) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , MEDIAN {

        @Override
        long pick(SortedNumericDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        double pick(SortedNumericDoubleDocValues values) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ;

    abstract long pick(SortedNumericDocValues values) throws IOException;

    long pick(SortedNumericDocValues values, ChildDocIds childDocsWithValues) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract double pick(SortedNumericDoubleDocValues values) throws IOException;

    double pick(SortedNumericDoubleDocValues values, ChildDocIds childDocsWithValues) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    long pick(SortedSetDocValues values) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    long pick(SortedSetDocValues values, ChildDocIds childDocsWithValues) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    IllegalArgumentException unsupportedSortMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
