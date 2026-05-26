/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.hibernate.search.mapper.pojo.logging.impl.FormattingLog;

public final class DefaultJavaNetURLBridge extends AbstractStringBasedDefaultBridge<URL> {

    public static final DefaultJavaNetURLBridge INSTANCE = new DefaultJavaNetURLBridge();

    private DefaultJavaNetURLBridge() {
    }

    @Override
    protected String toString(URL value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected URL fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
