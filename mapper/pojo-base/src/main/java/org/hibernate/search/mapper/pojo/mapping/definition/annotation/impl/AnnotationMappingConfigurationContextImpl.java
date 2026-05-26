/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.classpath.spi.ClassResolver;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingBuildContext;
import org.hibernate.search.engine.mapper.mapping.building.spi.MappingConfigurationCollector;
import org.hibernate.search.engine.mapper.model.spi.MappableTypeModel;
import org.hibernate.search.engine.mapper.model.spi.TypeMetadataDiscoverer;
import org.hibernate.search.engine.reporting.spi.FailureCollector;
import org.hibernate.search.mapper.pojo.logging.impl.PojoMapperMiscLog;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoTypeMetadataContributor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.AnnotationMappingConfigurationContext;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.spi.BuiltinAnnotations;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoMappingConfigurationContext;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoMappingConfigurationContributor;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.reporting.spi.MapperHints;
import org.hibernate.search.util.common.jar.impl.JandexUtils;
import org.hibernate.search.util.common.jar.impl.JarUtils;
import org.hibernate.search.util.common.jar.spi.JandexBehavior;
import org.hibernate.search.util.common.reflect.spi.AnnotationHelper;
import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexView;

public class AnnotationMappingConfigurationContextImpl implements AnnotationMappingConfigurationContext, PojoMappingConfigurationContributor {

    private final PojoBootstrapIntrospector introspector;

    private final MapperHints mapperHints;

    private boolean discoverAnnotatedTypesFromRootMappingAnnotations = false;

    private boolean discoverJandexIndexesFromAddedTypes = false;

    private boolean buildMissingJandexIndexes = false;

    private boolean discoverAnnotationsFromReferencedTypes = false;

    // Use a LinkedHashSet for deterministic iteration
    private final Set<Class<?>> explicitAnnotatedTypes = new LinkedHashSet<>();

    private final List<IndexView> explicitJandexIndexes = new ArrayList<>();

    public AnnotationMappingConfigurationContextImpl(PojoBootstrapIntrospector introspector, MapperHints mapperHints) {
        this.introspector = introspector;
        this.mapperHints = mapperHints;
    }

    @Override
    public AnnotationMappingConfigurationContext discoverAnnotatedTypesFromRootMappingAnnotations(boolean enabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AnnotationMappingConfigurationContext discoverJandexIndexesFromAddedTypes(boolean enabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AnnotationMappingConfigurationContext buildMissingDiscoveredJandexIndexes(boolean enabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AnnotationMappingConfigurationContext discoverAnnotationsFromReferencedTypes(boolean enabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AnnotationMappingConfigurationContext add(Class<?> annotatedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AnnotationMappingConfigurationContext add(Set<Class<?>> annotatedTypes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AnnotationMappingConfigurationContext addJandexIndex(IndexView jandexIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void configure(MappingBuildContext buildContext, PojoMappingConfigurationContext configurationContext, MappingConfigurationCollector<PojoTypeMetadataContributor> collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void discoverAnnotatedTypesFromRootMappingAnnotation(Set<PojoRawTypeModel<?>> annotatedTypes, IndexView jandexIndex, ClassResolver classResolver) {
        Set<DotName> rootMappingAnnotations = new HashSet<>(BuiltinAnnotations.ROOT_MAPPING_ANNOTATIONS);
        rootMappingAnnotations.addAll(JandexUtils.findAnnotatedAnnotationsAndContaining(jandexIndex, BuiltinAnnotations.ROOT_MAPPING));
        Set<DotName> rootMappingAnnotatedTypes = new HashSet<>();
        for (DotName annotationName : rootMappingAnnotations) {
            for (AnnotationInstance annotation : jandexIndex.getAnnotations(annotationName)) {
                ClassInfo annotatedClassInfo = JandexUtils.extractDeclaringClass(annotation.target());
                rootMappingAnnotatedTypes.add(annotatedClassInfo.name());
            }
        }
        for (DotName rootMappingAnnotatedType : rootMappingAnnotatedTypes) {
            Class<?> annotatedClass = classResolver.classForName(rootMappingAnnotatedType.toString());
            introspector.typeModel(annotatedClass).ascendingSuperTypes().forEach(annotatedTypes::add);
        }
    }

    private IndexView buildJandexIndex() {
        List<IndexView> jandexIndexes = new ArrayList<>(explicitJandexIndexes);
        if (discoverJandexIndexesFromAddedTypes) {
            IndexView compositeOfExplicitJandexIndexes = JandexUtils.compositeIndex(jandexIndexes);
            Set<URL> discoveredBuildingAllowedCodeSourceLocations = new LinkedHashSet<>();
            Set<URL> discoveredBuildingForbiddenCodeSourceLocations = new LinkedHashSet<>();
            for (Class<?> annotatedType : explicitAnnotatedTypes) {
                DotName dotName = DotName.createSimple(annotatedType.getName());
                // Optimization: if a class is already in the Jandex index,
                // there's no need to discover the Jandex index of its JAR.
                if (compositeOfExplicitJandexIndexes.getClassByName(dotName) == null) {
                    Set<URL> targetSet = isJandexBuildingAllowed(annotatedType) ? discoveredBuildingAllowedCodeSourceLocations : discoveredBuildingForbiddenCodeSourceLocations;
                    JarUtils.codeSourceLocation(annotatedType).ifPresent(targetSet::add);
                }
            }
            for (URL codeSourceLocation : discoveredBuildingAllowedCodeSourceLocations) {
                jandexIndexForCodeSourceLocation(codeSourceLocation, true).ifPresent(jandexIndexes::add);
            }
            for (URL codeSourceLocation : discoveredBuildingForbiddenCodeSourceLocations) {
                jandexIndexForCodeSourceLocation(codeSourceLocation, false).ifPresent(jandexIndexes::add);
            }
        }
        return jandexIndexes.isEmpty() ? null : JandexUtils.compositeIndex(jandexIndexes);
    }

    private boolean isJandexBuildingAllowed(Class<?> annotatedType) {
        if (buildMissingJandexIndexes) {
            Package pakkage = annotatedType.getPackage();
            // We expect Hibernate projects to always provide a Jandex index if one is needed.
            return pakkage != null && !pakkage.getName().equals("org.hibernate") && !pakkage.getName().startsWith("org.hibernate.");
        } else {
            return false;
        }
    }

    private Optional<Index> jandexIndexForCodeSourceLocation(URL codeSourceLocation, boolean buildIfMissing) {
        try {
            if (buildIfMissing) {
                return Optional.of(JandexUtils.readOrBuildIndex(codeSourceLocation));
            } else {
                return JandexUtils.readIndex(codeSourceLocation);
            }
        } catch (RuntimeException e) {
            throw PojoMapperMiscLog.INSTANCE.errorDiscoveringJandexIndex(codeSourceLocation, e.getMessage(), mapperHints.cannotReadJandexRootMapping(), e);
        }
    }

    /**
     * A type metadata discoverer that will provide annotation-based metadata
     * for types that were not explicitly requested .
     */
    private static class PojoAnnotationTypeMetadataDiscoverer implements TypeMetadataDiscoverer<PojoTypeMetadataContributor> {

        private final AnnotationPojoTypeMetadataContributorFactory contributorFactory;

        private final Set<PojoRawTypeModel<?>> alreadyContributedTypes;

        PojoAnnotationTypeMetadataDiscoverer(AnnotationPojoTypeMetadataContributorFactory contributorFactory, Set<PojoRawTypeModel<?>> alreadyContributedTypes) {
            this.contributorFactory = contributorFactory;
            this.alreadyContributedTypes = alreadyContributedTypes;
        }

        @Override
        public Optional<PojoTypeMetadataContributor> discover(MappableTypeModel typeModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
