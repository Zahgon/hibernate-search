/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.mapper.mapping.building.impl;

import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexRootBuilder;
import org.hibernate.search.engine.backend.types.converter.FromDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.ToDocumentValueConverter;
import org.hibernate.search.engine.common.tree.spi.TreeNestingContext;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexedEntityBindingContext;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexedEntityBindingMapperContext;

public class IndexedEntityBindingContextImpl extends AbstractIndexBindingContext<IndexRootBuilder> implements IndexedEntityBindingContext {

    public IndexedEntityBindingContextImpl(IndexedEntityBindingMapperContext mapperContext, IndexRootBuilder indexRootBuilder) {
        super(mapperContext, indexRootBuilder, indexRootBuilder, TreeNestingContext.root());
    }

    @Override
    public void explicitRouting() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <I> void idDslConverter(Class<I> valueType, ToDocumentValueConverter<I, String> converter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <I> void idProjectionConverter(Class<I> valueType, FromDocumentValueConverter<String, I> converter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void idParser(ToDocumentValueConverter<String, String> parser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    boolean isParentMultivaluedAndWithoutObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
