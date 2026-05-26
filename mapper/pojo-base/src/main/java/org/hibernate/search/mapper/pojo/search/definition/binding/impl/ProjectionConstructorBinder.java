/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.search.definition.binding.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.engine.common.tree.spi.TreeNestingContext;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.search.projection.definition.ProjectionDefinition;
import org.hibernate.search.engine.search.projection.definition.spi.ConstantProjectionDefinition;
import org.hibernate.search.mapper.pojo.logging.impl.ProjectionLog;
import org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMappingHelper;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoMethodParameterModel;
import org.hibernate.search.mapper.pojo.reporting.spi.PojoEventContexts;
import org.hibernate.search.mapper.pojo.search.definition.impl.PojoConstructorProjectionDefinition;
import org.hibernate.search.util.common.reporting.EventContext;
import org.hibernate.search.util.common.reporting.spi.EventContextProvider;

public class ProjectionConstructorBinder<T> implements EventContextProvider {

    private final PojoMappingHelper mappingHelper;

    private final ProjectionBindingContextImpl<?> parentBindingContext;

    final TreeNestingContext nestingContext;

    final PojoConstructorModel<T> constructor;

    final PojoConstructorIdentifier constructorIdentifier;

    public ProjectionConstructorBinder(PojoMappingHelper mappingHelper, PojoConstructorModel<T> constructor) {
        this(mappingHelper, constructor, null, TreeNestingContext.root());
    }

    public ProjectionConstructorBinder(PojoMappingHelper mappingHelper, PojoConstructorModel<T> constructor, ProjectionBindingContextImpl<?> parentBindingContext, TreeNestingContext nestingContext) {
        this.mappingHelper = mappingHelper;
        this.parentBindingContext = parentBindingContext;
        this.nestingContext = nestingContext;
        this.constructor = constructor;
        this.constructorIdentifier = new PojoConstructorIdentifier(constructor);
    }

    @Override
    public EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoConstructorProjectionDefinition<T> bind() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
