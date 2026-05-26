/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.tenancy.impl;

import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.tenancy.spi.TenancyMode;
import org.hibernate.search.mapper.pojo.standalone.cfg.StandalonePojoMapperSettings;
import org.hibernate.search.mapper.pojo.tenancy.TenantIdentifierConverter;

public class TenancyConfiguration implements AutoCloseable {

    private static final ConfigurationProperty<BeanReference<? extends TenantIdentifierConverter>> MULTI_TENANCY_TENANT_IDENTIFIER_CONVERTER = ConfigurationProperty.forKey(StandalonePojoMapperSettings.Radicals.MULTI_TENANCY_TENANT_IDENTIFIER_CONVERTER).asBeanReference(TenantIdentifierConverter.class).withDefault(StandalonePojoMapperSettings.Defaults.MULTI_TENANCY_TENANT_IDENTIFIER_CONVERTER).build();

    public static TenancyConfiguration create(BeanResolver beanResolver, TenancyMode tenancyMode, ConfigurationPropertySource configurationPropertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final TenancyMode tenancyMode;

    private final BeanHolder<? extends TenantIdentifierConverter> tenantIdentifierConverter;

    private TenancyConfiguration(TenancyMode tenancyMode, BeanHolder<? extends TenantIdentifierConverter> tenantIdentifierConverter) {
        this.tenancyMode = tenancyMode;
        this.tenantIdentifierConverter = tenantIdentifierConverter;
    }

    public Object convert(String tenantIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String convert(Object tenantIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TenancyMode tenancyMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
