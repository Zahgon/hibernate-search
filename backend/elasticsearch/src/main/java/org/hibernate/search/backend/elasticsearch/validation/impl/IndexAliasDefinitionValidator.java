/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.aliases.impl.IndexAliasDefinition;
import com.google.gson.JsonElement;

public class IndexAliasDefinitionValidator implements Validator<IndexAliasDefinition> {

    private final Validator<JsonElement> extraAttributeValidator = new JsonElementValidator(new JsonElementEquivalence());

    @Override
    public void validate(ValidationErrorCollector errorCollector, IndexAliasDefinition expectedDefinition, IndexAliasDefinition actualDefinition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
