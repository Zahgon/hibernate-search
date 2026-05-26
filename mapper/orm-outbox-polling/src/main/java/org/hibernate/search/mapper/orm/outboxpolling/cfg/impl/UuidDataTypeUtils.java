/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.cfg.impl;

import java.util.Locale;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.ConfigurationLog;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.DeprecationLog;
import org.hibernate.type.SqlTypes;
import org.hibernate.type.descriptor.JdbcTypeNameMapper;

public final class UuidDataTypeUtils {

    private UuidDataTypeUtils() {
    }

    private static final String DEFAULT = "default";

    @Deprecated(since = "7.0")
    private static final String UUID_BINARY = "uuid-binary";

    @Deprecated(since = "7.0")
    private static final String UUID_CHAR = "uuid-char";

    /**
     * @return In case of {@code value == "default" } a database specific result will be returned.
     * Some databases might not work correctly with a particular representation of UUID hence the
     * default provides a sensible value depending on which particular database is used. By default, a character representation
     * is used as characters should be overall supported by databases.
     * <p>
     * But for some databases, a different value is used. For instance, in the case of Microsoft SQL Server,
     * using a character representation might lead to undesired behavior in the form of deadlocks
     * so a binary representation is used by default.
     * <p>
     * Otherwise, when {@code value != "default" } a user passed value will be used.
     */
    @SuppressWarnings("deprecation")
    public static Integer uuidType(String value, ConfigurationPropertySource source, OptionalConfigurationProperty<String> property) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Copied and adapted from ORM's ConfigurationHelper$TypeCodeConverter
    private static class TypeCodeConverter {

        public static int convert(String value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
