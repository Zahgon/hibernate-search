/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.search.query.spi;

import java.util.function.Function;
import jakarta.persistence.QueryTimeoutException;
import org.hibernate.ScrollableResults;
import org.hibernate.query.spi.ScrollableResultsImplementor;
import org.hibernate.search.engine.search.query.SearchScroll;
import org.hibernate.search.engine.search.query.SearchScrollResult;
import org.hibernate.search.mapper.orm.logging.impl.OrmMiscLog;
import org.hibernate.search.util.common.SearchTimeoutException;

public class HibernateOrmSearchScrollableResultsAdapter<R, H> implements ScrollableResults<R>, ScrollableResultsImplementor<R> {

    private final SearchScroll<H> scroll;

    private final int maxResults;

    private final Function<? super H, ? extends R> hitExtractor;

    private SearchScrollResult<H> currentChunk;

    private H currentHit;

    private int currentIndexInScroll;

    private int currentIndexInCurrentChunk;

    private boolean afterLast;

    private boolean closed;

    public HibernateOrmSearchScrollableResultsAdapter(SearchScroll<H> scroll, int maxResults, Function<? super H, ? extends R> hitExtractor) {
        this.scroll = scroll;
        this.maxResults = maxResults;
        this.hitExtractor = hitExtractor;
        this.currentChunk = null;
        this.currentHit = null;
        this.currentIndexInScroll = -1;
        this.currentIndexInCurrentChunk = -1;
        this.afterLast = false;
        this.closed = false;
    }

    @Override
    public boolean next() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean previous() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean scroll(int positions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean last() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean first() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void beforeFirst() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void afterLast() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isFirst() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isLast() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("removal")
    @Deprecated(since = "8.0", forRemoval = true)
    @Override
    public int getRowNumber() {
        if (afterLast) {
            return -1;
        }
        return currentIndexInScroll;
    }

    // For EJC
    @SuppressWarnings({ "removal", "deprecation" })
    @Override
    public boolean position(int position) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getPosition() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("removal")
    @Deprecated(since = "8.0", forRemoval = true)
    @Override
    public boolean setRowNumber(int rowNumber) {
        checkNotClosed();
        if (rowNumber < 0) {
            // Can't set the position relative to the last element if we're forward only,
            // since we don't know it's the last element until we reach it.
            throw OrmMiscLog.INSTANCE.cannotSetScrollPositionRelativeToEnd();
        }
        return scroll(rowNumber - currentIndexInScroll);
    }

    // We cannot use @Override here because this method only exists in ORM 6.1.2+
    public void setFetchSize(int i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isClosed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public R get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private SearchScrollResult<H> nextChunk() {
        try {
            return scroll.next();
        } catch (SearchTimeoutException e) {
            throw new QueryTimeoutException(e);
        }
    }

    private void checkNotClosed() {
        if (closed) {
            throw OrmMiscLog.INSTANCE.cannotUseClosedScrollableResults();
        }
    }
}
