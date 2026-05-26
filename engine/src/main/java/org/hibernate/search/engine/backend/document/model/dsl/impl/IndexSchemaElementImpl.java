/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.document.model.dsl.impl;

import java.util.function.Function;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.backend.document.IndexFieldReference;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaElement;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaFieldOptionsStep;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaFieldTemplateOptionsStep;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaNamedPredicateOptionsStep;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaObjectField;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexCompositeNodeBuilder;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexObjectFieldBuilder;
import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFactory;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFinalStep;
import org.hibernate.search.engine.common.tree.spi.TreeNestingContext;
import org.hibernate.search.engine.logging.impl.MappingLog;
import org.hibernate.search.engine.search.predicate.definition.PredicateDefinition;
import org.hibernate.search.engine.search.predicate.definition.TypedPredicateDefinition;
import org.hibernate.search.util.common.impl.StringHelper;

public class IndexSchemaElementImpl<B extends IndexCompositeNodeBuilder> implements IndexSchemaElement {

    private final IndexFieldTypeFactory typeFactory;

    final B objectNodeBuilder;

    private final TreeNestingContext nestingContext;

    private final boolean directChildrenAreMultiValuedByDefault;

    public IndexSchemaElementImpl(IndexFieldTypeFactory typeFactory, B objectNodeBuilder, TreeNestingContext nestingContext, boolean directChildrenAreMultiValuedByDefault) {
        this.typeFactory = typeFactory;
        this.objectNodeBuilder = objectNodeBuilder;
        this.nestingContext = nestingContext;
        this.directChildrenAreMultiValuedByDefault = directChildrenAreMultiValuedByDefault;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <F> IndexSchemaFieldOptionsStep<?, IndexFieldReference<F>> field(String relativeFieldName, IndexFieldType<F> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaNamedPredicateOptionsStep namedPredicate(String relativeNamedPredicateName, PredicateDefinition definition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaNamedPredicateOptionsStep namedPredicate(String relativeNamedPredicateName, TypedPredicateDefinition<?> definition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <F> IndexSchemaFieldOptionsStep<?, IndexFieldReference<F>> field(String relativeFieldName, Function<? super IndexFieldTypeFactory, ? extends IndexFieldTypeFinalStep<F>> typeContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaObjectField objectField(String relativeFieldName, ObjectStructure structure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaFieldTemplateOptionsStep<?> fieldTemplate(String templateName, IndexFieldType<?> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaFieldTemplateOptionsStep<?> fieldTemplate(String templateName, Function<? super IndexFieldTypeFactory, ? extends IndexFieldTypeFinalStep<?>> typeContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaFieldTemplateOptionsStep<?> objectFieldTemplate(String templateName, ObjectStructure structure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void checkRelativeFieldName(String relativeFieldName) {
        if (StringHelper.isEmpty(relativeFieldName)) {
            throw MappingLog.INSTANCE.relativeFieldNameCannotBeNullOrEmpty(relativeFieldName, objectNodeBuilder.eventContext());
        }
        if (relativeFieldName.contains(FieldPaths.PATH_SEPARATOR_STRING)) {
            throw MappingLog.INSTANCE.relativeFieldNameCannotContainDot(relativeFieldName, objectNodeBuilder.eventContext());
        }
    }

    private void checkFieldTemplateName(String templateName) {
        if (StringHelper.isEmpty(templateName)) {
            throw MappingLog.INSTANCE.fieldTemplateNameCannotBeNullOrEmpty(templateName, objectNodeBuilder.eventContext());
        }
        // This is mostly to allow making template names absolute and unique by prepending them
        // with the path of the schema elements they were declared on.
        if (templateName.contains(FieldPaths.PATH_SEPARATOR_STRING)) {
            throw MappingLog.INSTANCE.fieldTemplateNameCannotContainDot(templateName, objectNodeBuilder.eventContext());
        }
    }

    private void checkRelativeNamedPredicateName(String relativeFilterName) {
        if (StringHelper.isEmpty(relativeFilterName)) {
            throw MappingLog.INSTANCE.relativeNamedPredicateNameCannotBeNullOrEmpty(relativeFilterName, objectNodeBuilder.eventContext());
        }
        if (relativeFilterName.contains(".")) {
            throw MappingLog.INSTANCE.relativeNamedPredicateNameCannotContainDot(relativeFilterName, objectNodeBuilder.eventContext());
        }
    }
}
