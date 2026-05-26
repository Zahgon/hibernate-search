/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.extractor.mapping.programmatic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import org.hibernate.search.mapper.pojo.extractor.ContainerExtractor;
import org.hibernate.search.mapper.pojo.extractor.ContainerExtractorConfigurationContext;
import org.hibernate.search.mapper.pojo.extractor.builtin.BuiltinContainerExtractors;

/**
 * A chain of {@link ContainerExtractor container extractors} to be applied one after the other to a property value,
 * in order to extract other values.
 * <p>
 * The extractors are either represented:
 * <ul>
 * <li>explicitly by their name, e.g. {@code ["map-values", "collection"]},
 * meaning "apply the 'map-values' extractor to the property value, then apply the 'collection' extractor to the map values".
 * Names are either {@link BuiltinContainerExtractors built-in}
 * or {@link ContainerExtractorConfigurationContext registered at bootstrap}.
 * <li>or simply by the "default" path ({@link #defaultExtractors()}),
 * which means "whatever default Hibernate Search manages to apply using its internal extractor resolution algorithm".
 * This second form may result in different "resolved" paths depending on the type of the property it is applied to.
 * </ul>
 *
 * @see ContainerExtractor
 * @see BuiltinContainerExtractors
 */
public class ContainerExtractorPath {

    private static final ContainerExtractorPath DEFAULT = new ContainerExtractorPath(true, Collections.emptyList());

    private static final ContainerExtractorPath NONE = new ContainerExtractorPath(false, Collections.emptyList());

    /**
     * @return A path that will apply the default extractor(s) based on the property type.
     */
    public static ContainerExtractorPath defaultExtractors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A path that will not apply any container extractor.
     */
    public static ContainerExtractorPath noExtractors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param extractorName A container extractor referenced by its name.
     * @return A path that will apply the referenced container extractor.
     * @see BuiltinContainerExtractors
     */
    public static ContainerExtractorPath explicitExtractor(String extractorName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param extractorNames A list of container extractors referenced by their name.
     * @return A path that will apply the referenced container extractors in order.
     */
    public static ContainerExtractorPath explicitExtractors(List<String> extractorNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final boolean applyDefaultExtractors;

    private final List<String> explicitExtractorNames;

    private ContainerExtractorPath(boolean applyDefaultExtractors, List<String> explicitExtractorNames) {
        this.applyDefaultExtractors = applyDefaultExtractors;
        this.explicitExtractorNames = explicitExtractorNames;
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return {@code true} if this path represents the default extractor(s),
     * which will be determined automatically based on the property type.
     * {@code false} otherwise.
     */
    public boolean isDefault() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return {@code true} if this path is empty,
     * i.e. it represents direct access to the property value.
     * {@code false} otherwise.
     */
    public boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The list of extractor names explicitly referenced by this path.
     * Empty if this path represents the default extractor(s).
     */
    public List<String> explicitExtractorNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
