/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.spi;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.query.Query;

public final class ConditionalExpression {

    private final String hql;

    private final Map<String, Object> params = new HashMap<>();

    public ConditionalExpression(String hql) {
        this.hql = hql;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String hql() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void param(String name, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void applyParams(Query<?> query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
