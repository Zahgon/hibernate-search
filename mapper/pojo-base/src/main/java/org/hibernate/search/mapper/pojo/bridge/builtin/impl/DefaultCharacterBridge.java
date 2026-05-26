/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import org.hibernate.search.engine.cfg.spi.ParseUtils;

public final class DefaultCharacterBridge extends AbstractStringBasedDefaultBridge<Character> {

    public static final DefaultCharacterBridge INSTANCE = new DefaultCharacterBridge();

    private DefaultCharacterBridge() {
    }

    @Override
    protected String toString(Character value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Character fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
