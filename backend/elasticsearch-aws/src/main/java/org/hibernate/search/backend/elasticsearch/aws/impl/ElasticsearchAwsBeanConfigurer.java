/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.aws.impl;

import org.hibernate.search.backend.elasticsearch.aws.cfg.ElasticsearchAwsCredentialsTypeNames;
import org.hibernate.search.backend.elasticsearch.aws.spi.ElasticsearchAwsCredentialsProvider;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequestInterceptorProvider;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.spi.BeanConfigurationContext;
import org.hibernate.search.engine.environment.bean.spi.BeanConfigurer;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;

public class ElasticsearchAwsBeanConfigurer implements BeanConfigurer {

    @Override
    public void configure(BeanConfigurationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
