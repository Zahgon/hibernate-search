/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.building.spi;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorPropertyNode;

public final class ErrorCollectingPojoPropertyMetadataContributor implements PojoPropertyMetadataContributor {

    private List<PojoPropertyMetadataContributor> children;

    @Override
    public void contributeAdditionalMetadata(PojoAdditionalMetadataCollectorPropertyNode collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contributeIndexMapping(PojoIndexMappingCollectorPropertyNode collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ErrorCollectingPojoPropertyMetadataContributor add(PojoPropertyMetadataContributor child) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasContent() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void initChildren() {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
    }
}
