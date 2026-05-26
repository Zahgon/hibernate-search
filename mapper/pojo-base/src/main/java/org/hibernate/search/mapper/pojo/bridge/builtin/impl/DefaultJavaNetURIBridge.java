/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.net.URI;
import java.net.URISyntaxException;
import org.hibernate.search.mapper.pojo.logging.impl.FormattingLog;

public final class DefaultJavaNetURIBridge extends AbstractStringBasedDefaultBridge<URI> {

    public static final DefaultJavaNetURIBridge INSTANCE = new DefaultJavaNetURIBridge();

    private DefaultJavaNetURIBridge() {
    }

    @Override
    protected String toString(URI value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected URI fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
