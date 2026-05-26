/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.spi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanRetrieval;
import org.hibernate.search.mapper.pojo.common.annotation.Param;
import org.hibernate.search.mapper.pojo.extractor.mapping.annotation.ContainerExtract;
import org.hibernate.search.mapper.pojo.extractor.mapping.annotation.ContainerExtraction;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.ObjectPath;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.PropertyValue;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.annotation.Incubating;
import org.hibernate.search.util.common.impl.Contracts;

@Incubating
public final class MappingAnnotationProcessorUtils {

    private MappingAnnotationProcessorUtils() {
    }

    public static Optional<PojoModelPathValueNode> toPojoModelPathValueNode(ObjectPath objectPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ContainerExtractorPath toContainerExtractorPath(ContainerExtraction extraction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Optional<BeanReference<? extends T>> toBeanReference(Class<T> expectedType, Class<?> undefinedTypeMarker, Class<? extends T> type, String name, BeanRetrieval retrieval) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Map<String, Object> toMap(Param[] params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Set<String> cleanUpPaths(String[] pathsArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
