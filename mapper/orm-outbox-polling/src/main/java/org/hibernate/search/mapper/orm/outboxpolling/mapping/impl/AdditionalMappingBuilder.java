/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.mapping.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;
import jakarta.persistence.AccessType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Index;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.boot.models.HibernateAnnotations;
import org.hibernate.boot.models.JpaAnnotations;
import org.hibernate.boot.models.annotations.internal.AccessJpaAnnotation;
import org.hibernate.boot.models.annotations.internal.ColumnJpaAnnotation;
import org.hibernate.boot.models.annotations.internal.EntityJpaAnnotation;
import org.hibernate.boot.models.annotations.internal.EnumeratedJpaAnnotation;
import org.hibernate.boot.models.annotations.internal.IndexJpaAnnotation;
import org.hibernate.boot.models.annotations.internal.JdbcTypeCodeAnnotation;
import org.hibernate.boot.models.annotations.internal.TableJpaAnnotation;
import org.hibernate.boot.models.annotations.internal.UuidGeneratorAnnotation;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.models.internal.MutableClassDetailsRegistry;
import org.hibernate.models.internal.jdk.JdkBuilders;
import org.hibernate.models.spi.ClassDetails;
import org.hibernate.models.spi.ModelsContext;
import org.hibernate.models.spi.MutableClassDetails;
import org.hibernate.models.spi.MutableMemberDetails;

public class AdditionalMappingBuilder {

    private final MetadataBuildingContext buildingContext;

    private final Class<?> type;

    private final String name;

    private final List<BiConsumer<ModelsContext, MutableClassDetails>> contributors = new ArrayList<>();

    public AdditionalMappingBuilder(MetadataBuildingContext buildingContext, Class<?> type, String name) {
        this.buildingContext = buildingContext;
        this.type = type;
        this.name = name;
    }

    public AdditionalMappingBuilder table(String schema, String catalog, String table) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AdditionalMappingBuilder index(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AdditionalMappingBuilder index(String name, String columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AdditionalMappingBuilder attribute(String name, Integer length, Boolean nullable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AdditionalMappingBuilder attribute(String name, Integer length, Boolean nullable, Integer type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AdditionalMappingBuilder tenantId(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AdditionalMappingBuilder enumAttribute(String name, Integer length, Boolean nullable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AdditionalMappingBuilder id(Integer type, String strategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ClassDetails build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void createAttribute(String name, Integer size, boolean nullable) {
        createAttribute(name, size, nullable, null);
    }

    private void createAttribute(String name, Integer length, boolean nullable, Integer type) {
        contributors.add((context, classDetails) -> {
            final MutableMemberDetails field = (MutableMemberDetails) classDetails.findFieldByName(name);
            ColumnJpaAnnotation columnUsage = (ColumnJpaAnnotation) field.applyAnnotationUsage(JpaAnnotations.COLUMN, context);
            columnUsage.name(name);
            columnUsage.nullable(nullable);
            if (length != null) {
                columnUsage.length(length);
            }
            if (type != null) {
                JdbcTypeCodeAnnotation jdbcTypeCodeUsage = (JdbcTypeCodeAnnotation) field.applyAnnotationUsage(HibernateAnnotations.JDBC_TYPE_CODE, context);
                jdbcTypeCodeUsage.value(type);
            }
        });
    }
}
