/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.extractor.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.mapper.pojo.extractor.ContainerExtractor;
import org.hibernate.search.mapper.pojo.extractor.builtin.impl.CollectionElementExtractor;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.extractor.spi.ContainerExtractorDefinition;
import org.hibernate.search.mapper.pojo.extractor.spi.ContainerExtractorRegistry;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.mapper.pojo.model.typepattern.impl.ExtractingTypePatternMatcher;
import org.hibernate.search.mapper.pojo.model.typepattern.impl.TypePatternMatcherFactory;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.hibernate.search.util.common.reflect.impl.GenericTypeContext;

/**
 * Binds {@link ContainerExtractorPath}s to a given input type,
 * and allows to create extractors for a given {@link BoundContainerExtractorPath}.
 * <p>
 * The {@link ContainerExtractorPath} is independent from the input type.
 * This means in particular that the path needs to "bound" to an input type before it can be useful:
 * <ul>
 *     <li>First to check that the path applies correctly: {@link CollectionElementExtractor}
 *     won't work on a {@link Map}.
 *     <li>Second to determine the resulting value type:
 *     {@code [MapValueExtractor.class, CollectionElementExtractor.class]} applied
 *     to a {@code Map<String, Collection<Integer>>} will result in {@code Integer} values.
 *     <li>Third, in the case of the default path, to determine the exact list of extractor classes.
 *     For instance, for a {@code Collection<String>} the default path will be resolved
 *     to {@link CollectionElementExtractor}.
 *     For a {@code Map<String, Collection<Integer>>} the default path will be resolved
 *     to {@code [MapValueExtractor.class, CollectionElementExtractor.class]}.
 * </ul>
 * This "binding" results in a {@link BoundContainerExtractorPath},
 * which carries both a {@link ContainerExtractorPath}
 * (which is an explicit list of classes, and never {@link ContainerExtractorPath#defaultExtractors()},
 * since the default path was resolved) and the resulting value type.
 * <p>
 * From this "bound path", the {@link ContainerExtractorBinder} is able to later create
 * a {@link ContainerExtractor}, which can be used at runtime to extract values from a container.
 */
public class ContainerExtractorBinder {

    private final BeanResolver beanResolver;

    private final ContainerExtractorRegistry containerExtractorRegistry;

    private final TypePatternMatcherFactory typePatternMatcherFactory;

    private final FirstMatchingExtractorContributor defaultExtractorContributor = new FirstMatchingExtractorContributor();

    private final Map<String, SingleExtractorContributor> extractorContributorCache = new HashMap<>();

    public ContainerExtractorBinder(BeanResolver beanResolver, ContainerExtractorRegistry containerExtractorRegistry, TypePatternMatcherFactory typePatternMatcherFactory) {
        this.beanResolver = beanResolver;
        this.containerExtractorRegistry = containerExtractorRegistry;
        this.typePatternMatcherFactory = typePatternMatcherFactory;
        for (String extractorName : containerExtractorRegistry.defaults()) {
            addDefaultExtractor(extractorName);
        }
    }

    /**
     * Try to bind a container extractor path to a given source type,
     * i.e. to resolve the possibly implicit extractor path ({@link ContainerExtractorPath#defaultExtractors()})
     * and to validate that all extractors in the path can be applied.
     *
     * @param sourceType A model of the source type to apply extractors to.
     * @param extractorPath The list of extractors to apply.
     * @param <C> The source type.
     * @return The resolved extractor path, or an empty optional if
     * one of the extractors in the path cannot be applied.
     */
    public <C> Optional<BoundContainerExtractorPath<C, ?>> tryBindPath(PojoTypeModel<C> sourceType, ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bind a container extractor path to a given source type,
     * i.e. resolve the possibly implicit extractor path ({@link ContainerExtractorPath#defaultExtractors()})
     * and validate that all extractors in the path can be applied,
     * or fail.
     *
     * @param sourceType A model of the source type to apply extractors to.
     * @param extractorPath The list of extractors to apply.
     * @param <C> The source type.
     * @return The bound extractor path.
     * @throws SearchException if
     * one of the extractors in the path cannot be applied.
     */
    public <C> BoundContainerExtractorPath<C, ?> bindPath(PojoTypeModel<C> sourceType, ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a container value extractor from a bound path, or fail.
     *
     * @param boundPath The bound path to create the extractor from.
     * @param <C> The source type.
     * @param <V> The extracted value type.
     * @return The extractor.
     * @throws AssertionFailure if the bound path was empty
     */
    // Checks are performed using reflection when building the resolved path
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public <C, V> ContainerExtractorHolder<C, V> create(BoundContainerExtractorPath<C, V> boundPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <C> boolean isDefaultExtractorPath(PojoTypeModel<C> sourceType, ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void addDefaultExtractor(String extractorName) {
        ExtractorContributor extractorContributor = getExtractorContributorForName(extractorName);
        defaultExtractorContributor.addCandidate(extractorContributor);
    }

    private SingleExtractorContributor getExtractorContributorForName(String extractorName) {
        return extractorContributorCache.computeIfAbsent(extractorName, this::createExtractorContributorForName);
    }

    // Checks are implemented using reflection
    @SuppressWarnings("rawtypes")
    private SingleExtractorContributor createExtractorContributorForName(String extractorName) {
        Class<? extends ContainerExtractor> extractorClass = containerExtractorRegistry.forName(extractorName).type();
        GenericTypeContext typeContext = new GenericTypeContext(extractorClass);
        Type typePattern = typeContext.resolveTypeArgument(ContainerExtractor.class, 0).orElseThrow(() -> MappingLog.INSTANCE.cannotInferContainerExtractorClassTypePattern(extractorClass, null));
        Type typeToExtract = typeContext.resolveTypeArgument(ContainerExtractor.class, 1).orElseThrow(() -> MappingLog.INSTANCE.cannotInferContainerExtractorClassTypePattern(extractorClass, null));
        ExtractingTypePatternMatcher typePatternMatcher;
        try {
            typePatternMatcher = typePatternMatcherFactory.createExtractingMatcher(typePattern, typeToExtract);
        } catch (UnsupportedOperationException e) {
            throw MappingLog.INSTANCE.cannotInferContainerExtractorClassTypePattern(extractorClass, e);
        }
        return new SingleExtractorContributor(typePatternMatcher, extractorName, extractorClass);
    }

    private interface ExtractorContributor {

        /**
         * @param state The state to append an extractor to
         * @return {@code true} if the current type was accepted by this contributor and an extractor was added,
         * {@code false} if the type was rejected and no extractor was added.
         */
        boolean tryAppend(ExtractorResolutionState<?> state);
    }

    // Checks are implemented using reflection
    @SuppressWarnings("rawtypes")
    private static class SingleExtractorContributor implements ExtractorContributor {

        private final ExtractingTypePatternMatcher typePatternMatcher;

        private final String extractorName;

        private final Class<? extends ContainerExtractor> extractorClass;

        SingleExtractorContributor(ExtractingTypePatternMatcher typePatternMatcher, String extractorName, Class<? extends ContainerExtractor> extractorClass) {
            this.typePatternMatcher = typePatternMatcher;
            this.extractorName = extractorName;
            this.extractorClass = extractorClass;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean tryAppend(ExtractorResolutionState<?> state) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void append(ExtractorResolutionState<?> state) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class FirstMatchingExtractorContributor implements ExtractorContributor {

        private final List<ExtractorContributor> candidates = new ArrayList<>();

        void addCandidate(ExtractorContributor contributor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean tryAppend(ExtractorResolutionState<?> state) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private boolean tryAppend(ExtractorResolutionState<?> state, PojoTypeModel<?> initialType, Set<PojoTypeModel<?>> encounteredTypes) {
            for (ExtractorContributor extractorContributor : candidates) {
                if (extractorContributor.tryAppend(state)) {
                    if (!encounteredTypes.add(state.extractedType)) {
                        throw MappingLog.INSTANCE.defaultContainerExtractorCyclicRecursion(initialType, state.extractorNames);
                    }
                    // Recurse as much as possible
                    tryAppend(state);
                    return true;
                }
            }
            return false;
        }

        public boolean tryMatch(ExtractorResolutionState<?> state, List<String> toMatch) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private boolean tryMatch(ExtractorResolutionState<?> state, List<String> toMatch, int toMatchIndex) {
            for (ExtractorContributor extractorContributor : candidates) {
                if (extractorContributor.tryAppend(state)) {
                    // There is a resolved path from this point.
                    if (toMatchIndex >= toMatch.size()) {
                        // The path to match is empty,
                        // so the resolved path is longer than the one to match:
                        // it doesn't match.
                        return false;
                    } else if (!toMatch.get(toMatchIndex).equals(state.extractorNames.get(state.extractorNames.size() - 1))) {
                        // The resolved path has a different extractor
                        // than the path to match at this point:
                        // it doesn't match.
                        return false;
                    } else {
                        // The resolved path matches at this point.
                        // Try to match the rest of the path to match.
                        return tryMatch(state, toMatch, toMatchIndex + 1);
                    }
                }
            }
            // No resolved path from this point: we'll only match if the path to match is empty.
            return toMatchIndex >= toMatch.size();
        }
    }

    private static class ExtractorResolutionState<C> {

        private final List<String> extractorNames = new ArrayList<>();

        private PojoTypeModel<?> extractedType;

        ExtractorResolutionState(PojoTypeModel<C> sourceType) {
            this.extractedType = sourceType;
        }

        void append(String extractorName, PojoTypeModel<?> extractedType) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        BoundContainerExtractorPath<C, ?> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
