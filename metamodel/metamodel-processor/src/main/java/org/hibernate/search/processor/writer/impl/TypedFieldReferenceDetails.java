/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.writer.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.search.engine.search.common.ValueModel;

record TypedFieldReferenceDetails(String name, String identifier, Collection<String> typeVariables, List<ClassProperty> properties, Collection<String> implementedInterfaces) {

    public static TypedFieldReferenceDetails of(Collection<TraitReferenceDetails> traits) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String constructorCall(String valueModel, String input, String output) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String constructorSuperCall(String valueModel, String input, String output) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String asType(String input, String output) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void constructorCall(StringBuilder result, String valueModel, String input, String output) {
        result.append("(absolutePath, scopeRootType");
        if (properties().size() > 2) {
            result.append(", ").append(valueModel);
        }
        for (int i = 3; i < properties().size(); i++) {
            ClassProperty prop = properties().get(i);
            if (prop.type().contains("<I>")) {
                result.append(", ").append(input);
            }
            if (prop.type().contains("<O>")) {
                result.append(", ").append(output);
            }
        }
        result.append(")");
    }

    public String formatted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
