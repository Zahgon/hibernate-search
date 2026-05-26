/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.models.spi;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;
import org.hibernate.models.spi.MemberDetails;
import org.hibernate.search.mapper.pojo.model.spi.GenericContextAwarePojoGenericTypeModel.RawTypeDeclaringContext;
import org.hibernate.search.mapper.pojo.model.spi.PojoPropertyModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;

public final class PojoSimpleModelsRawTypeModel<T> extends AbstractPojoModelsRawTypeModel<T, AbstractPojoModelsBootstrapIntrospector> {

    public PojoSimpleModelsRawTypeModel(AbstractPojoModelsBootstrapIntrospector introspector, PojoRawTypeIdentifier<T> typeIdentifier, RawTypeDeclaringContext<T> rawTypeDeclaringContext) {
        super(introspector, typeIdentifier, rawTypeDeclaringContext);
    }

    @Override
    // xClass represents T, so its supertypes represent ? super T
    @SuppressWarnings("unchecked")
    public Stream<PojoSimpleModelsRawTypeModel<? super T>> ascendingSuperTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // xClass represents T, so its supertypes represent ? super T
    @SuppressWarnings("unchecked")
    public Stream<PojoSimpleModelsRawTypeModel<? super T>> descendingSuperTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected PojoPropertyModel<?> createPropertyModel(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<Member> findPropertyMember(String propertyName) {
        // Try using the getter first (if declared)...
        List<Member> getters = findInSelfOrParents(t -> t.declaredPropertyGetters(propertyName));
        if (getters != null) {
            return getters;
        }
        // ... and fall back to the field (or null if not found)
        Member field = findInSelfOrParents(t -> t.declaredPropertyField(propertyName));
        return field == null ? null : Collections.singletonList(field);
    }

    private <T2> T2 findInSelfOrParents(Function<PojoSimpleModelsRawTypeModel<?>, T2> getter) {
        return ascendingSuperTypes().map(getter).filter(Objects::nonNull).findFirst().orElse(null);
    }
}
