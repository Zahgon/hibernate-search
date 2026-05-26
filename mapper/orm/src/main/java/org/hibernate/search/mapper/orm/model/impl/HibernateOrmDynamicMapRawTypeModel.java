/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.model.impl;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.hibernate.search.engine.mapper.model.spi.MappableTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.AbstractPojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

@SuppressWarnings("rawtypes")
public class HibernateOrmDynamicMapRawTypeModel extends AbstractPojoRawTypeModel<Map, HibernateOrmBootstrapIntrospector> {

    private final HibernateOrmBasicDynamicMapTypeMetadata ormTypeMetadata;

    HibernateOrmDynamicMapRawTypeModel(HibernateOrmBootstrapIntrospector introspector, PojoRawTypeIdentifier<Map> typeIdentifier, HibernateOrmBasicDynamicMapTypeMetadata ormTypeMetadata) {
        super(introspector, typeIdentifier);
        this.ormTypeMetadata = ormTypeMetadata;
    }

    @Override
    public final boolean isAbstract() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isSubTypeOf(MappableTypeModel superTypeCandidate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Stream<PojoRawTypeModel<? super Map>> ascendingSuperTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Stream<PojoRawTypeModel<? super Map>> descendingSuperTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<? extends PojoTypeModel<?>> typeArgument(Class<?> rawSuperType, int typeParameterIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<? extends PojoTypeModel<?>> arrayElementType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Stream<? extends Annotation> annotations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected List<PojoConstructorModel<Map>> createDeclaredConstructors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected PojoTypeModel<? extends Map> doCast(PojoTypeModel<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Stream<String> declaredPropertyNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The supertype of this type.
     * Dynamic-map types cannot implement interfaces, so they only have one direct supertype.
     */
    private PojoRawTypeModel<? super Map> getSuperType() {
        HibernateOrmDynamicMapRawTypeModel entitySupertypeOrNull = getSuperEntityOrNull();
        if (entitySupertypeOrNull != null) {
            return entitySupertypeOrNull;
        } else {
            return introspector.typeModel(typeIdentifier.javaClass());
        }
    }

    private HibernateOrmDynamicMapRawTypeModel getSuperEntityOrNull() {
        String superEntityName = ormTypeMetadata.getSuperEntityNameOrNull();
        if (superEntityName != null) {
            // This cast is safe, because if a dynamic-map entity type has an entity supertype,
            // that entity supertype is also a dynamic-map entity type.
            return (HibernateOrmDynamicMapRawTypeModel) introspector.typeModel(superEntityName);
        }
        return null;
    }

    @Override
    protected HibernateOrmDynamicMapPropertyModel<?> createPropertyModel(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private HibernateOrmBasicDynamicMapPropertyMetadata getPropertyMetadata(String propertyName) {
        HibernateOrmBasicDynamicMapPropertyMetadata ormPropertyMetadata = ormTypeMetadata.getDynamicMapPropertyMetadataOrNull(propertyName);
        if (ormPropertyMetadata == null) {
            /*
			 * We don't have a metadata for this property in the current type.
			 * The property may be inherited: try to find the metadata in the parent types.
			 */
            HibernateOrmDynamicMapRawTypeModel entitySupertypeOrNull = getSuperEntityOrNull();
            if (entitySupertypeOrNull != null) {
                ormPropertyMetadata = entitySupertypeOrNull.getPropertyMetadata(propertyName);
            }
        }
        return ormPropertyMetadata;
    }
}
