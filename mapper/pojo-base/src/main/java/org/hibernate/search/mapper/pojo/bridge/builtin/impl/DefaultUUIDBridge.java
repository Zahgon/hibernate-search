/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.util.UUID;
import org.hibernate.search.engine.cfg.spi.ParseUtils;

public final class DefaultUUIDBridge extends AbstractStringBasedDefaultBridge<UUID> {

    public static final DefaultUUIDBridge INSTANCE = new DefaultUUIDBridge();

    private DefaultUUIDBridge() {
    }

    @Override
    protected String toString(UUID value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected UUID fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
