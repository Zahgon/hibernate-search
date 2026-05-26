/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoSearchMappingConstructorNode;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoSearchMappingMethodParameterNode;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.ConstructorMappingStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.MethodParameterMappingStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.TypeMappingStep;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoMethodParameterModel;

class InitialConstructorMappingStep implements ConstructorMappingStep, PojoSearchMappingConstructorNode {

    private final TypeMappingStepImpl parent;

    private final PojoConstructorModel<?> constructorModel;

    private boolean projectionConstructor = false;

    private Map<Integer, InitialMethodParameterMappingStep> parameters;

    InitialConstructorMappingStep(TypeMappingStepImpl parent, PojoConstructorModel<?> constructorModel) {
        this.parent = parent;
        this.constructorModel = constructorModel;
    }

    @Override
    public TypeMappingStep hostingType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<?>[] parametersJavaTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConstructorMappingStep projectionConstructor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isProjectionConstructor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MethodParameterMappingStep parameter(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<PojoSearchMappingMethodParameterNode> parameterNode(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
