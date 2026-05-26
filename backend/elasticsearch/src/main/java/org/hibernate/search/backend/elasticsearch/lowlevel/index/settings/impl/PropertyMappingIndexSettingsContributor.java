/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.settings.impl;

public class PropertyMappingIndexSettingsContributor {

    private Boolean knn;

    public void contribute(IndexSettings settings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void addKnn(boolean knn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
