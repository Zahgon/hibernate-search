/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.mapping.impl;

import org.hibernate.mapping.PersistentClass;
import org.hibernate.search.mapper.orm.loading.impl.HibernateOrmEntityIdEntityLoadingStrategy;
import org.hibernate.search.mapper.orm.loading.impl.HibernateOrmNonEntityIdPropertyEntityLoadingStrategy;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmEntityLoadingStrategy;
import org.hibernate.search.mapper.orm.model.impl.DocumentIdSourceProperty;

public class HibernateOrmEntityLoadingBinder {

    public HibernateOrmEntityLoadingBinder() {
    }

    public <I> HibernateOrmEntityLoadingStrategy<?, ?> createLoadingStrategy(PersistentClass persistentClass, DocumentIdSourceProperty<I> documentIdSourceProperty) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
