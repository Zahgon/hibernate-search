/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.resources.impl;

import org.hibernate.search.backend.lucene.cfg.LuceneBackendSettings;
import org.hibernate.search.backend.lucene.work.spi.LuceneWorkExecutorProvider;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.common.execution.spi.DelegatingSimpleScheduledExecutor;
import org.hibernate.search.engine.common.execution.spi.SimpleScheduledExecutor;

public class DefaultLuceneWorkExecutorProvider implements LuceneWorkExecutorProvider {

    public static final String DEFAULT_BEAN_NAME = "lucene-built-in";

    private static final OptionalConfigurationProperty<Integer> THREAD_POOL_SIZE = ConfigurationProperty.forKey(LuceneBackendSettings.THREAD_POOL_SIZE).asIntegerStrictlyPositive().build();

    @Override
    public SimpleScheduledExecutor writeExecutor(Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
