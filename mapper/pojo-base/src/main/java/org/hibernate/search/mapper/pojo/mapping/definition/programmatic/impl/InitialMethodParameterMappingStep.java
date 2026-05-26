/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoSearchMappingMethodParameterNode;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.MethodParameterMappingStep;
import org.hibernate.search.mapper.pojo.model.spi.PojoMethodParameterModel;
import org.hibernate.search.mapper.pojo.search.definition.binding.ProjectionBinder;

class InitialMethodParameterMappingStep implements MethodParameterMappingStep, PojoSearchMappingMethodParameterNode {

    private final InitialConstructorMappingStep parent;

    private final PojoMethodParameterModel<?> parameterModel;

    private List<ProjectionBindingData> projectionDefinitions;

    InitialMethodParameterMappingStep(InitialConstructorMappingStep parent, PojoMethodParameterModel<?> parameterModel) {
        this.parent = parent;
        this.parameterModel = parameterModel;
    }

    @Override
    public MethodParameterMappingStep projection(BeanReference<? extends ProjectionBinder> binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<ProjectionBindingData> projectionBindings() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
