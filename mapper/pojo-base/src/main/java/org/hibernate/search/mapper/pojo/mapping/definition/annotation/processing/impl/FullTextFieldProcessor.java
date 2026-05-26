/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import java.util.Arrays;
import java.util.Collections;
import org.hibernate.search.engine.backend.types.Highlightable;
import org.hibernate.search.engine.backend.types.Norms;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.TermVector;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.ValueBinderRef;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.ValueBridgeRef;
import org.hibernate.search.mapper.pojo.extractor.mapping.annotation.ContainerExtraction;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingFullTextFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStandardFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

public class FullTextFieldProcessor extends AbstractStandardFieldAnnotationProcessor<FullTextField> {

    @Override
    PropertyMappingStandardFieldOptionsStep<?> initStandardFieldMappingContext(PropertyMappingStep mappingContext, FullTextField annotation, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getName(FullTextField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Projectable getProjectable(FullTextField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Searchable getSearchable(FullTextField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Highlightable[] getHighlightable(FullTextField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ValueBridgeRef getValueBridge(FullTextField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ValueBinderRef getValueBinder(FullTextField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ContainerExtraction getExtraction(FullTextField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
