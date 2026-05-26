/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.tenancy.spi;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.tenancy.spi.TenancyMode;
import org.hibernate.search.mapper.orm.cfg.HibernateOrmMapperSettings;
import org.hibernate.search.mapper.orm.logging.impl.ConfigurationLog;
import org.hibernate.search.mapper.pojo.tenancy.TenantIdentifierConverter;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.impl.Contracts;

public class TenancyConfiguration implements AutoCloseable {

    private static final OptionalConfigurationProperty<List<String>> MULTI_TENANCY_TENANT_IDS = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.MULTI_TENANCY_TENANT_IDS).asString().multivalued().validate(value -> Contracts.assertNotNullNorEmpty(value, "value")).build();

    private static final ConfigurationProperty<BeanReference<? extends TenantIdentifierConverter>> MULTI_TENANCY_TENANT_IDENTIFIER_CONVERTER = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.MULTI_TENANCY_TENANT_IDENTIFIER_CONVERTER).asBeanReference(TenantIdentifierConverter.class).withDefault(HibernateOrmMapperSettings.Defaults.MULTI_TENANCY_TENANT_IDENTIFIER_CONVERTER).build();

    public static TenancyConfiguration create(BeanResolver beanResolver, TenancyMode tenancyMode, ConfigurationPropertySource configurationPropertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // for tests:
    public static TenancyConfiguration create(TenancyMode tenancyMode, BeanHolder<? extends TenantIdentifierConverter> tenantIdentifierConverter, Optional<Set<String>> tenantIds, String tenantIdsConfigurationPropertyKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final TenancyMode tenancyMode;

    private final Optional<Set<String>> tenantIds;

    private final String tenantIdsConfigurationPropertyKey;

    private final BeanHolder<? extends TenantIdentifierConverter> tenantIdentifierConverter;

    private TenancyConfiguration(TenancyMode tenancyMode, BeanHolder<? extends TenantIdentifierConverter> tenantIdentifierConverter, Optional<Set<String>> tenantIds, String tenantIdsConfigurationPropertyKey) {
        this.tenancyMode = tenancyMode;
        this.tenantIdentifierConverter = tenantIdentifierConverter;
        this.tenantIds = tenantIds;
        this.tenantIdsConfigurationPropertyKey = tenantIdsConfigurationPropertyKey;
    }

    /**
     * @return A set of all possible tenant IDs, or an empty set if the application is single-tenant.
     * @throws org.hibernate.search.util.common.SearchException if the application is multi-tenant
     * and the full list of tenant IDs was not configured.
     */
    public Set<String> tenantIdsOrFail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchException invalidTenantId(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object convert(String tenantIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String convert(Object tenantIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TenancyMode tenancyMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
