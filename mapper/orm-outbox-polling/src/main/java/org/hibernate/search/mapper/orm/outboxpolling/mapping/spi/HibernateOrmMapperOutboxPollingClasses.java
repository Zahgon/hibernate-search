/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.mapping.spi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class HibernateOrmMapperOutboxPollingClasses {

    private HibernateOrmMapperOutboxPollingClasses() {
    }

    /**
     * @return A set of names of all classes that will be involved in Avro serialization
     * and thus will require reflection support.
     * Useful to enable reflection for these classes in GraalVM-based native images.
     */
    public static Set<String> avroTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A set of names of all classes that will be involved in Hibernate ORM mapping
     * and thus will require reflection support.
     * Useful to enable reflection for these classes in GraalVM-based native images.
     */
    public static Set<String> hibernateOrmTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
