/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.spi;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.metamodel.mapping.EntityMappingType;
import org.hibernate.metamodel.model.domain.EntityDomainType;
import org.hibernate.search.util.common.impl.Contracts;

public final class MutableEntityLoadingOptions {

    private int fetchSize;

    private List<EntityGraphHint<?>> entityGraphHints;

    public MutableEntityLoadingOptions(HibernateOrmLoadingMappingContext mappingContext) {
        this.fetchSize = mappingContext.fetchSize();
    }

    public int fetchSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void fetchSize(int fetchSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public EntityGraphHint<?> entityGraphHintOrNullForType(EntityMappingType entityMappingType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void entityGraphHint(EntityGraphHint<?> entityGraphHint, boolean replaceExisting) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
