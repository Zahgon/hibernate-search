/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.impl;

import java.io.IOException;
import org.apache.http.nio.IOControl;

public final class StubIOControl implements IOControl {

    public static final StubIOControl INSTANCE = new StubIOControl();

    private StubIOControl() {
    }

    @Override
    public void requestInput() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void suspendInput() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void requestOutput() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void suspendOutput() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void shutdown() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private UnsupportedOperationException unsupported() {
        return new UnsupportedOperationException("This IOControl instance is a stub");
    }
}
