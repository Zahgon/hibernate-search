/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.MarkerBindingContextImpl;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.MarkerBinder;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorValueNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoPropertyAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoValueAdditionalMetadata;

class PojoPropertyAdditionalMetadataBuilder implements PojoAdditionalMetadataCollectorPropertyNode {

    private final BeanResolver beanResolver;

    // Use a LinkedHashMap for deterministic iteration
    private final Map<ContainerExtractorPath, PojoValueAdditionalMetadataBuilder> valueBuilders = new LinkedHashMap<>();

    private final Map<Class<?>, List<?>> markers = new LinkedHashMap<>();

    PojoPropertyAdditionalMetadataBuilder(BeanResolver beanResolver) {
        this.beanResolver = beanResolver;
    }

    @Override
    public PojoAdditionalMetadataCollectorValueNode value(ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void markerBinder(MarkerBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private <M> void doAddMarker(M marker) {
        Class<M> markerType = (Class<M>) (marker instanceof Annotation ? ((Annotation) marker).annotationType() : marker.getClass());
        List<M> list = (List<M>) markers.computeIfAbsent(markerType, ignored -> new ArrayList<M>());
        list.add(marker);
    }

    PojoPropertyAdditionalMetadata build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
