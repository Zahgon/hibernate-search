/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.impl;

import org.hibernate.search.mapper.pojo.extractor.ContainerExtractionContext;

final class PojoIndexingProcessorContainerExtractionContext implements ContainerExtractionContext {

    static final PojoIndexingProcessorContainerExtractionContext INSTANCE = new PojoIndexingProcessorContainerExtractionContext();

    private PojoIndexingProcessorContainerExtractionContext() {
    }

    @Override
    public void propagateOrIgnoreContainerExtractionException(RuntimeException exception) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
