/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.event.impl;

import org.hibernate.event.service.spi.DuplicationStrategy;

class KeepIfSameClassDuplicationStrategy implements DuplicationStrategy {

    private final Class<?> checkClass;

    public KeepIfSameClassDuplicationStrategy(Class<?> checkClass) {
        this.checkClass = checkClass;
    }

    @Override
    public boolean areMatch(Object listener, Object original) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Action getAction() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
