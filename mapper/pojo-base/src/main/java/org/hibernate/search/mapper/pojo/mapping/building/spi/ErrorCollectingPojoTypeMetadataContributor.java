/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.building.spi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorTypeNode;

public final class ErrorCollectingPojoTypeMetadataContributor implements PojoTypeMetadataContributor {

    private List<PojoTypeMetadataContributor> children;

    @Override
    public void contributeAdditionalMetadata(PojoAdditionalMetadataCollectorTypeNode collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contributeIndexMapping(PojoIndexMappingCollectorTypeNode collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ErrorCollectingPojoTypeMetadataContributor addAll(Collection<? extends PojoTypeMetadataContributor> children) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ErrorCollectingPojoTypeMetadataContributor add(PojoTypeMetadataContributor child) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void initChildren() {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
    }
}
