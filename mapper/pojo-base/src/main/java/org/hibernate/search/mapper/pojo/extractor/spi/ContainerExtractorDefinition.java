/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.extractor.spi;

import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.mapper.pojo.extractor.ContainerExtractor;

// We need to allow raw container types, e.g. MapValueExtractor.class
@SuppressWarnings("rawtypes")
public final class ContainerExtractorDefinition<C extends ContainerExtractor> {

    private final Class<C> type;

    private final BeanReference<? extends C> reference;

    ContainerExtractorDefinition(Class<C> type, BeanReference<? extends C> reference) {
        this.type = type;
        this.reference = reference;
    }

    public Class<C> type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BeanReference<? extends C> reference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
