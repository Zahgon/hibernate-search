/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.dsl.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import org.hibernate.search.backend.lucene.analysis.model.impl.LuceneAnalysisDefinitionRegistry;
import org.hibernate.search.backend.lucene.logging.impl.MappingLog;
import org.hibernate.search.backend.lucene.types.converter.LuceneFieldContributor;
import org.hibernate.search.backend.lucene.types.converter.LuceneFieldValueExtractor;
import org.hibernate.search.backend.lucene.types.dsl.LuceneIndexFieldTypeFactory;
import org.hibernate.search.engine.backend.mapping.spi.BackendMapperContext;
import org.hibernate.search.engine.backend.reporting.spi.BackendMappingHints;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeOptionsStep;
import org.hibernate.search.engine.backend.types.dsl.ScaledNumberIndexFieldTypeOptionsStep;
import org.hibernate.search.engine.backend.types.dsl.StandardIndexFieldTypeOptionsStep;
import org.hibernate.search.engine.backend.types.dsl.StringIndexFieldTypeOptionsStep;
import org.hibernate.search.engine.backend.types.dsl.VectorFieldTypeOptionsStep;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexFieldTypeDefaultsProvider;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.util.common.reporting.EventContext;

public class LuceneIndexFieldTypeFactoryImpl implements LuceneIndexFieldTypeFactory, LuceneIndexFieldTypeBuildContext {

    private final EventContext eventContext;

    private final BackendMapperContext backendMapperContext;

    private final LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry;

    private final IndexFieldTypeDefaultsProvider typeDefaultsProvider;

    public LuceneIndexFieldTypeFactoryImpl(EventContext eventContext, BackendMapperContext backendMapperContext, LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry, IndexFieldTypeDefaultsProvider typeDefaultsProvider) {
        this.eventContext = eventContext;
        this.backendMapperContext = backendMapperContext;
        this.analysisDefinitionRegistry = analysisDefinitionRegistry;
        this.typeDefaultsProvider = typeDefaultsProvider;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <F> StandardIndexFieldTypeOptionsStep<?, F> as(Class<F> valueType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public <F> VectorFieldTypeOptionsStep<?, F> asVector(Class<F> valueType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StringIndexFieldTypeOptionsStep<?> asString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, Integer> asInteger() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, Long> asLong() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, Boolean> asBoolean() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, Byte> asByte() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, Short> asShort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, Float> asFloat() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, Double> asDouble() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, LocalDate> asLocalDate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, LocalDateTime> asLocalDateTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, LocalTime> asLocalTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, Instant> asInstant() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, ZonedDateTime> asZonedDateTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, Year> asYear() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, YearMonth> asYearMonth() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, MonthDay> asMonthDay() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, OffsetDateTime> asOffsetDateTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, OffsetTime> asOffsetTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandardIndexFieldTypeOptionsStep<?, GeoPoint> asGeoPoint() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ScaledNumberIndexFieldTypeOptionsStep<?, BigDecimal> asBigDecimal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ScaledNumberIndexFieldTypeOptionsStep<?, BigInteger> asBigInteger() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public VectorFieldTypeOptionsStep<?, byte[]> asByteVector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public VectorFieldTypeOptionsStep<?, float[]> asFloatVector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <F> IndexFieldTypeOptionsStep<?, F> asNative(Class<F> indexFieldType, LuceneFieldContributor<F> fieldContributor, LuceneFieldValueExtractor<F> fieldValueExtractor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EventContext getEventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneAnalysisDefinitionRegistry getAnalysisDefinitionRegistry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BackendMappingHints hints() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
