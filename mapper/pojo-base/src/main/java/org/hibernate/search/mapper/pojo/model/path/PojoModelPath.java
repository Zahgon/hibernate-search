/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.path;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.util.common.impl.Contracts;

/**
 * Represents an arbitrarily long access path when walking the POJO model.
 * <p>
 * For instance the path could be:
 * <code>
 * property "propertyOfA" =&gt; extractor "MapValueExtractor" =&gt; property "propertyOfB"
 * </code>
 * Meaning: extract property "propertyOfA", then extract values using "MapValueExtractor",
 * then for each value extract property "propertyOfB".
 */
public abstract class PojoModelPath {

    protected static final Pattern DOT_PATTERN = Pattern.compile("\\.");

    /**
     * @return A builder allowing to create a {@link PojoModelPath}
     * by specifying its components (property, container extractors) one by one.
     */
    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param propertyName The name of a POJO property.
     * @return A path from a POJO to the property with the given name.
     */
    public static PojoModelPathPropertyNode ofProperty(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param propertyName The name of a POJO property.
     * @return A {@link PojoModelPath} from a POJO to the value(s) of the property with the given name.
     * Default container extractors are applied to the property,
     * so that for example a path to a List property will in fact point to the <em>elements</em> of that list.
     */
    public static PojoModelPathValueNode ofValue(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param propertyName The name of a POJO property.
     * @param extractorPath A container extractor path.
     * @return A {@link PojoModelPath} from a POJO to the value(s) of the property with the given name.
     * The extractors represented by the given extractor path are applied to the property,
     * so that for example a path to a List property may in fact point to the <em>elements</em> of that list.
     */
    public static PojoModelPathValueNode ofValue(String propertyName, ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param dotSeparatedPath A dot-separated path, such as {@code "myProperty.someNestedProperty"}.
     * @return A {@link PojoModelPath} representing the same path,
     * which the default container extractors applied to each property,
     * so that for example a path to a List property will in fact point to the <em>elements</em> of that list.
     */
    public static PojoModelPathValueNode parse(String dotSeparatedPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PojoModelPath() {
        // Package-protected constructor
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A representation of this path in the form
     * {@code propertyA<containerExtractorPathA>.propertyB<containerExtractorPathB>.propertyC<containerExtractorPathB>}.
     */
    public final String toPathString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The model path to the element from which the value represented by this node is extracted.
     * May be {@code null}.
     */
    public abstract PojoModelPath parent();

    abstract void appendSelfPath(StringBuilder builder);

    private void appendPath(StringBuilder builder) {
        PojoModelPath parent = parent();
        if (parent == null) {
            appendSelfPath(builder);
        } else {
            parent.appendPath(builder);
            appendSelfPath(builder);
        }
    }

    public static class Builder {

        private PojoModelPathPropertyNode currentPropertyNode;

        private final List<String> currentExplicitExtractors = new ArrayList<>();

        private boolean noExtractors;

        private boolean defaultExtractors;

        private Builder() {
        }

        /**
         * Append to the path an access the property with the given name.
         *
         * @param propertyName The name of the property to access.
         * @return {@code this}, for method chaining.
         * @throws org.hibernate.search.util.common.SearchException If no property name was previously given.
         */
        public Builder property(String propertyName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Append to the path a value extraction using the given container extractor path.
         *
         * @param extractorPath The container extractors to apply, as a {@link ContainerExtractorPath}.
         * @return {@code this}, for method chaining.
         * @throws org.hibernate.search.util.common.SearchException If no property name was previously given.
         */
        public Builder value(ContainerExtractorPath extractorPath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Append to the path a value extraction using the given container extractor.
         * <p>
         * Multiple {@link #value(String)} calls can be chained to apply multiple extractors.
         *
         * @param extractorName The name of the container extractor to apply.
         * @return {@code this}, for method chaining.
         * @throws org.hibernate.search.util.common.SearchException If no property name was previously given.
         * @see org.hibernate.search.mapper.pojo.extractor.builtin.BuiltinContainerExtractors
         */
        public Builder value(String extractorName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Append to the path a direct value extraction, not using any container extractors.
         * @return {@code this}, for method chaining.
         * @throws org.hibernate.search.util.common.SearchException If no property name was previously given.
         */
        public Builder valueWithoutExtractors() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Append to the path a value extraction using the default container extractors.
         * @return {@code this}, for method chaining.
         * @throws org.hibernate.search.util.common.SearchException If no property name was previously given.
         */
        public Builder valueWithDefaultExtractors() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * @return A {@link PojoModelPathPropertyNode} built from the given components.
         * @throws org.hibernate.search.util.common.SearchException If no initial property name was given.
         */
        public PojoModelPathPropertyNode toPropertyPath() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * @return A {@link PojoModelPathPropertyNode} built from the given components,
         * or {@code null} if no information was added to this builder.
         */
        public PojoModelPathPropertyNode toPropertyPathOrNull() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * @return A {@link PojoModelPathValueNode} built from the given components.
         * @throws org.hibernate.search.util.common.SearchException If no initial property name was given.
         */
        public PojoModelPathValueNode toValuePath() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * @return A {@link PojoModelPathValueNode} built from the given components,
         * or {@code null} if no information was added to this builder.
         */
        public PojoModelPathValueNode toValuePathOrNull() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private boolean isEmpty() {
            // Empty if nothing was called
            return currentPropertyNode == null && !noExtractors && !defaultExtractors && currentExplicitExtractors.isEmpty();
        }

        private ContainerExtractorPath flushContainerExtractorPath() {
            ContainerExtractorPath result;
            if (!currentExplicitExtractors.isEmpty()) {
                result = ContainerExtractorPath.explicitExtractors(currentExplicitExtractors);
            } else if (noExtractors) {
                result = ContainerExtractorPath.noExtractors();
            } else {
                // Default
                result = ContainerExtractorPath.defaultExtractors();
            }
            currentExplicitExtractors.clear();
            noExtractors = false;
            defaultExtractors = false;
            return result;
        }

        private void checkHasPropertyName() {
            if (currentPropertyNode == null) {
                throw MappingLog.INSTANCE.cannotDefinePojoModelPathWithoutProperty();
            }
        }
    }
}
