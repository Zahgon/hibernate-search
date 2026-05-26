/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.impl;

import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.spi.BeanConfigurationContext;
import org.hibernate.search.engine.environment.bean.spi.BeanConfigurer;
import org.hibernate.search.mapper.pojo.tenancy.TenantIdentifierConverter;
import org.hibernate.search.mapper.pojo.tenancy.spi.StringTenantIdentifierConverter;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategyNames;

public class PojoBaseBeanConfigurer implements BeanConfigurer {

    @Override
    public void configure(BeanConfigurationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
