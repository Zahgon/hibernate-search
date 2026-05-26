/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

/**
 * @author Emmanuel Bernard
 */
public class PhraseQueryContext {

    private int slop = 0;

    private String sentence;

    public int getSlop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSlop(int slop) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getSentence() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSentence(String sentence) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
