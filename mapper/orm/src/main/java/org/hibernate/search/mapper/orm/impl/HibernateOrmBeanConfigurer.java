/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.impl;

import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.spi.BeanConfigurationContext;
import org.hibernate.search.engine.environment.bean.spi.BeanConfigurer;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationStrategy;
import org.hibernate.search.mapper.orm.coordination.impl.NoCoordinationStrategy;

public class HibernateOrmBeanConfigurer implements BeanConfigurer {

    @Override
    @SuppressWarnings("deprecation")
    public void configure(BeanConfigurationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
