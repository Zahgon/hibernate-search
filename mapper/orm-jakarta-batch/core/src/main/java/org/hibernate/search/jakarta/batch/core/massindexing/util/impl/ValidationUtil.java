/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.jakarta.batch.core.massindexing.util.impl;

import java.util.LinkedHashSet;
import java.util.Set;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.search.jakarta.batch.core.context.jpa.spi.EntityManagerFactoryRegistry;
import org.hibernate.search.jakarta.batch.core.logging.impl.JakartaBatchLog;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.mapping.SearchMapping;
import org.hibernate.search.util.common.SearchException;

/**
 * Utility class for job parameter validation.
 *
 * @author Mincong Huang
 */
public final class ValidationUtil {

    private ValidationUtil() {
        // Private constructor, do not use it.
    }

    public static void validateCheckpointInterval(int checkpointInterval, int rowsPerPartition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void validateEntityFetchSize(int entityFetchSize, int checkpointInterval) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void validatePositive(String parameterName, int parameterValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void validateEntityTypes(EntityManagerFactoryRegistry emfRegistry, String entityManagerFactoryScope, String entityManagerFactoryReference, String serializedEntityTypes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
