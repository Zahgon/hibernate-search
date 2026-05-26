/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.search.definition.binding.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.search.projection.definition.ProjectionDefinition;
import org.hibernate.search.engine.search.projection.definition.spi.ConstantProjectionDefinition;
import org.hibernate.search.mapper.pojo.logging.impl.ProjectionLog;
import org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMappingHelper;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoSearchMappingConstructorNode;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoSearchMappingMethodParameterNode;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoTypeMetadataContributor;
import org.hibernate.search.mapper.pojo.model.impl.PojoModelConstructorParameterRootElement;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoMethodParameterModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.reporting.spi.PojoEventContexts;
import org.hibernate.search.mapper.pojo.search.definition.binding.ProjectionBinder;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.hibernate.search.util.common.reporting.EventContext;
import org.hibernate.search.util.common.reporting.spi.EventContextProvider;

class ProjectionConstructorParameterBinder<P> implements EventContextProvider {

    final PojoMappingHelper mappingHelper;

    final ProjectionConstructorBinder<?> parent;

    final PojoMethodParameterModel<P> parameter;

    final PojoModelConstructorParameterRootElement<P> parameterRootElement;

    ProjectionConstructorParameterBinder(PojoMappingHelper mappingHelper, ProjectionConstructorBinder<?> parent, PojoMethodParameterModel<P> parameter) {
        this.mappingHelper = mappingHelper;
        this.parent = parent;
        this.parameter = parameter;
        this.parameterRootElement = new PojoModelConstructorParameterRootElement<>(mappingHelper.introspector(), parameter);
    }

    @Override
    public EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    BeanHolder<? extends ProjectionDefinition<?>> bind() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private BeanHolder<? extends ProjectionDefinition<?>> applyBinder(ProjectionBindingContextImpl<?> context, BeanReference<? extends ProjectionBinder> binderReference) {
        BeanHolder<? extends ProjectionDefinition<?>> definitionHolder = null;
        try (BeanHolder<? extends ProjectionBinder> binderHolder = mappingHelper.beanResolver().resolve(binderReference)) {
            definitionHolder = context.applyBinder(binderHolder.get());
            return definitionHolder;
        } catch (RuntimeException e) {
            new SuppressingCloser(e).push(definitionHolder);
            throw e;
        }
    }

    <T> PojoConstructorModel<T> findProjectionConstructorOrNull(PojoRawTypeModel<T> projectedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
