/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.jakarta.batch.core.massindexing.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.search.jakarta.batch.core.massindexing.util.impl.EntityTypeDescriptor;
import org.hibernate.search.mapper.orm.tenancy.spi.TenancyConfiguration;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingDefaultCleanOperation;

/**
 * Container for data shared across the entire batch job.
 *
 * @author Gunnar Morling
 * @author Mincong Huang
 */
public class JobContextData {

    private EntityManagerFactory entityManagerFactory;

    /*
	 * In Jakarta Batch standard, only string values can be propagated using job properties, but class types are frequently
	 * used too. So this map has string keys to facilitate lookup for values extracted from job properties.
	 */
    private Map<String, EntityTypeDescriptor<?, ?>> entityTypeDescriptorMap;

    private TenancyConfiguration tenancyConfiguration;

    private MassIndexingDefaultCleanOperation massIndexingDefaultCleanOperation;

    public JobContextData() {
        entityTypeDescriptorMap = new HashMap<>();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEntityTypeDescriptors(Collection<EntityTypeDescriptor<?, ?>> descriptors) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTenancyConfiguration(TenancyConfiguration tenancyConfiguration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TenancyConfiguration getTenancyConfiguration() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MassIndexingDefaultCleanOperation getMassIndexingDefaultCleanOperation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMassIndexingDefaultCleanOperation(MassIndexingDefaultCleanOperation massIndexingDefaultCleanOperation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public EntityTypeDescriptor<?, ?> getEntityTypeDescriptor(String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<EntityTypeDescriptor<?, ?>> getEntityTypeDescriptors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Class<?>> getEntityTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
