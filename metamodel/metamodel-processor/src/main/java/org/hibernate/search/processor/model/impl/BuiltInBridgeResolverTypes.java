/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.model.impl;

import java.util.Optional;
import java.util.Set;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;
import org.hibernate.search.util.common.annotation.Incubating;

@Incubating
public final class BuiltInBridgeResolverTypes {

    private BuiltInBridgeResolverTypes() {
    }

    // TODO: need test that types are not missing
    private static Set<String> TYPES = Set.of("java.lang.String", "java.lang.Character", "java.lang.Boolean", "java.lang.Byte", "java.lang.Short", "java.lang.Integer", "java.lang.Long", "java.lang.Float", "java.lang.Double", "java.math.BigInteger", "java.math.BigDecimal", "java.time.LocalDate", "java.time.Instant", "java.time.LocalDateTime", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.Year", "java.time.YearMonth", "java.time.MonthDay", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneId", "java.time.Period", "java.time.Duration", "java.util.UUID", "java.util.Date", "java.util.Calendar", "java.sql.Date", "java.sql.Timestamp", "java.sql.Time", "java.net.URI", "java.net.URL", "org.hibernate.search.engine.spatial.GeoPoint");

    public static boolean isBuiltInType(String typeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Optional<Class<?>> loadableType(TypeMirror propertyType, Types types) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
