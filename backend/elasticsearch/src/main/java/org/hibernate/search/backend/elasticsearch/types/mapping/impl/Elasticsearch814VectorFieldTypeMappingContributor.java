/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.mapping.impl;

public class Elasticsearch814VectorFieldTypeMappingContributor extends Elasticsearch812VectorFieldTypeMappingContributor {

    @Override
    protected boolean indexOptionAddCondition(Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
