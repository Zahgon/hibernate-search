/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.impl;

import org.hibernate.search.engine.common.spi.SearchIntegration;
import org.hibernate.search.engine.logging.impl.EngineMiscLog;

final class SearchIntegrationHandle implements SearchIntegration.Handle {

    private SearchIntegration integration;

    void initialize(SearchIntegration integration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIntegration getOrFail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIntegration getOrNull() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
