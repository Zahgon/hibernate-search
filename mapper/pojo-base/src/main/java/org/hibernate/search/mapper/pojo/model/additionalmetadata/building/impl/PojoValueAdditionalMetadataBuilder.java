/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorValueNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoValueAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;

class PojoValueAdditionalMetadataBuilder implements PojoAdditionalMetadataCollectorValueNode {

    private PojoModelPathValueNode inverseSidePath;

    private boolean associationEmbedded = false;

    private Optional<ReindexOnUpdate> reindexOnUpdate = Optional.empty();

    private Set<PojoModelPathValueNode> derivedFrom = Collections.emptySet();

    private Integer decimalScale;

    @Override
    public void associationInverseSide(PojoModelPathValueNode inverseSidePath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void associationEmbedded() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reindexOnUpdate(ReindexOnUpdate reindexOnUpdate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void derivedFrom(Set<PojoModelPathValueNode> derivedFrom) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void decimalScale(int decimalScale) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PojoValueAdditionalMetadata build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
