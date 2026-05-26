/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.common.util.spi;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Contracts;

/**
 * To avoid re-encoding strings into URLs we have several opportunities
 * to reuse them and compose them more efficiently.
 */
public final class URLEncodedString {

    public final String encoded;

    public final String original;

    /**
     * Do not invoke directly.
     * @see #fromString(String)
     * @param string the original string to be encoded.
     */
    private URLEncodedString(String string) {
        this.original = string;
        try {
            encoded = URLEncoder.encode(string, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionFailure("Unexpected error retrieving the UTF-8 charset", e);
        }
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static URLEncodedString fromString(String string) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
