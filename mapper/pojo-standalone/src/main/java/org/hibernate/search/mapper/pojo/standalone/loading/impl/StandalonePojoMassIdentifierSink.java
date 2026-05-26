/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.loading.impl;

import java.util.List;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierSink;
import org.hibernate.search.mapper.pojo.standalone.loading.MassIdentifierSink;

public class StandalonePojoMassIdentifierSink<I> implements MassIdentifierSink<I> {

    private final PojoMassIdentifierSink<I> delegate;

    public StandalonePojoMassIdentifierSink(PojoMassIdentifierSink<I> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void accept(List<? extends I> batch) throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void complete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
