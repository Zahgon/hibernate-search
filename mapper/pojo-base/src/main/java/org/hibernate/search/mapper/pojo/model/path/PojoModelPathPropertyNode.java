/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.path;

import java.util.Objects;
import java.util.Optional;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.util.common.impl.Contracts;

/**
 * A node in a {@link PojoModelPath} representing a property.
 * <p>
 * Property nodes represent the property with no indication as to how its value(s) are extracted:
 * it just represent how to access the property itself.
 * To access the value(s) of that property, additional information is required,
 * and that information is provided by a {@link PojoModelPathValueNode}.
 */
public final class PojoModelPathPropertyNode extends PojoModelPath {

    private final PojoModelPathValueNode parent;

    private final String propertyName;

    PojoModelPathPropertyNode(PojoModelPathValueNode parent, String propertyName) {
        Contracts.assertNotNullNorEmpty(propertyName, "propertyName");
        if (DOT_PATTERN.matcher(propertyName).find()) {
            throw MappingLog.INSTANCE.propertyNameCannotContainDots(propertyName);
        }
        this.parent = parent;
        this.propertyName = propertyName;
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The model path to the value from which the property represented by this node is extracted.
     * May be {@code null}.
     */
    @Override
    public PojoModelPathValueNode parent() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param extractorPath The extractor path allowing extraction of a value from this property.
     * The extractor path may be invalid: no check will be performed.
     * @return A new path representing the current path, with an additional access to the given property at the end.
     */
    public PojoModelPathValueNode value(ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The name of this property.
     */
    public String propertyName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A simple string representation of this path taking into account property nodes only,
     * in the form {@code propertyA.propertyB.propertyC}.
     * <p>
     * Completely ignores container extractors.
     */
    public String toPropertyString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<PojoModelPathPropertyNode> relativize(PojoModelPathValueNode other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void appendSelfPath(StringBuilder builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void addPropertyPathsRecursively(StringBuilder builder, PojoModelPathPropertyNode propertyNode) {
        PojoModelPathValueNode parentValueNode = propertyNode.parent();
        if (parentValueNode != null) {
            addPropertyPathsRecursively(builder, parentValueNode.parent());
            builder.append('.');
        }
        builder.append(propertyNode.propertyName());
    }
}
