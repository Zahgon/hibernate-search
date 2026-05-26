/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.impl;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class CustomConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {

    private final long maxKeepAlive;

    CustomConnectionKeepAliveStrategy(long maxKeepAlive) {
        this.maxKeepAlive = maxKeepAlive;
    }

    @Override
    public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
