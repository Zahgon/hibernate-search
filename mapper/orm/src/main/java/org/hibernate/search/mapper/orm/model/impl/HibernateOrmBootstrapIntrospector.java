/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.model.impl;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.hibernate.AssertionFailure;
import org.hibernate.bytecode.enhance.spi.EnhancerConstants;
import org.hibernate.engine.spi.PersistentAttributeInterceptable;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.models.spi.ClassDetailsRegistry;
import org.hibernate.search.mapper.orm.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.models.spi.AbstractPojoModelsBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.models.spi.PojoModelsGenericContextHelper;
import org.hibernate.search.mapper.pojo.model.spi.AbstractPojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.GenericContextAwarePojoGenericTypeModel.RawTypeDeclaringContext;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.util.common.impl.ReflectionHelper;
import org.hibernate.search.util.common.reflect.spi.ValueCreateHandle;
import org.hibernate.search.util.common.reflect.spi.ValueHandleFactory;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;

public class HibernateOrmBootstrapIntrospector extends AbstractPojoModelsBootstrapIntrospector implements PojoBootstrapIntrospector {

    public static HibernateOrmBootstrapIntrospector create(HibernateOrmBasicTypeMetadataProvider basicTypeMetadataProvider, ClassDetailsRegistry classDetailsRegistry, ValueHandleFactory valueHandleFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final HibernateOrmBasicTypeMetadataProvider basicTypeMetadataProvider;

    private final PojoModelsGenericContextHelper genericContextHelper;

    /*
	 * Note: the main purpose of these caches is not to improve performance,
	 * but to ensure the unicity of the returned PojoTypeModels.
	 * so as to ensure the unicity of PojoPropertyModels,
	 * which lowers the risk of generating duplicate ValueReadHandles.
	 *
	 * Also, this cache allows to not care at all about implementing equals and hashcode,
	 * since type models are presumably instantiated only once per type.
	 */
    private final Map<Class<?>, HibernateOrmClassRawTypeModel<?>> classTypeModelCache = new HashMap<>();

    private final Map<String, HibernateOrmDynamicMapRawTypeModel> dynamicMapTypeModelCache = new HashMap<>();

    private HibernateOrmBootstrapIntrospector(HibernateOrmBasicTypeMetadataProvider basicTypeMetadataProvider, ClassDetailsRegistry classDetailsRegistry, ValueHandleFactory valueHandleFactory) {
        super(classDetailsRegistry, valueHandleFactory);
        this.basicTypeMetadataProvider = basicTypeMetadataProvider;
        this.genericContextHelper = new PojoModelsGenericContextHelper(this);
    }

    @Override
    public AbstractPojoRawTypeModel<?, ?> typeModel(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> HibernateOrmClassRawTypeModel<T> typeModel(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected <T> ValueCreateHandle<T> createValueCreateHandle(Constructor<T> constructor) throws IllegalAccessException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ValueReadHandle<?> createValueReadHandle(Member member) throws IllegalAccessException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ValueReadHandle<?> createValueReadHandle(Class<?> holderClass, Member member, HibernateOrmBasicClassPropertyMetadata ormPropertyMetadata) throws IllegalAccessException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("rawtypes")
    private HibernateOrmDynamicMapRawTypeModel createDynamicMapTypeModel(String name) {
        HibernateOrmBasicDynamicMapTypeMetadata ormMetadata = basicTypeMetadataProvider.getBasicDynamicMapTypeMetadata(name);
        PojoRawTypeIdentifier<Map> typeIdentifier = PojoRawTypeIdentifier.of(Map.class, name);
        return new HibernateOrmDynamicMapRawTypeModel(this, typeIdentifier, ormMetadata);
    }

    private <T> HibernateOrmClassRawTypeModel<T> createClassTypeModel(Class<T> type) {
        HibernateOrmBasicClassTypeMetadata ormMetadataOrNull = basicTypeMetadataProvider.getBasicClassTypeMetadata(type);
        PojoRawTypeIdentifier<T> typeIdentifier = PojoRawTypeIdentifier.of(type);
        return new HibernateOrmClassRawTypeModel<>(this, typeIdentifier, ormMetadataOrNull, new RawTypeDeclaringContext<>(genericContextHelper, type));
    }

    private static void setAccessible(Member member) {
        // always try to set accessible to true regardless of visibility
        // as it's faster even for public fields:
        // it bypasses the security model checks at execution time.
        ((AccessibleObject) member).setAccessible(true);
    }

    /**
     * @param holderClass A class exposing the given field.
     * @param field A member field from the Hibernate metamodel or from a XProperty.
     * @return A method generated through bytecode enhancement that triggers lazy-loading before returning the member's value,
     * or {@code null} if there is no such method.
     */
    private static Method getBytecodeEnhancerReaderMethod(Class<?> holderClass, Field field) {
        if (!PersistentAttributeInterceptable.class.isAssignableFrom(holderClass)) {
            // The declaring class is not enhanced, the only way to access the field is to read it directly.
            return null;
        }
        /*
		 * The class is enhanced.
		 * Use the "magic" methods that trigger lazy loading instead of accessing the field directly.
		 */
        try {
            return holderClass.getMethod(EnhancerConstants.PERSISTENT_FIELD_READER_PREFIX + field.getName());
        } catch (NoSuchMethodException e) {
            throw new AssertionFailure("Read method for enhanced field " + field + " is unexpectedly missing.", e);
        }
    }
}
