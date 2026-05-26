/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import java.math.BigDecimal;
import org.hibernate.search.engine.cfg.spi.ParseUtils;

public final class DefaultBigDecimalBridge extends AbstractPassThroughDefaultBridge<BigDecimal> {

    public static final DefaultBigDecimalBridge INSTANCE = new DefaultBigDecimalBridge();

    private DefaultBigDecimalBridge() {
    }

    @Override
    protected String toString(BigDecimal value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected BigDecimal fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
