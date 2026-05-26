/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.util.Optional;
import java.util.function.Consumer;
import org.hibernate.Length;
import org.hibernate.boot.jaxb.mapping.spi.JaxbEntityMappingsImpl;
import org.hibernate.boot.spi.AdditionalMappingContributions;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.models.spi.ClassDetails;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.mapper.orm.bootstrap.spi.HibernateSearchOrmMappingProducer;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.HibernateOrmMapperOutboxPollingSettings;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.UuidGenerationStrategy;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.impl.UuidDataTypeUtils;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.spi.HibernateOrmMapperOutboxPollingSpiSettings;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.Agent;
import org.hibernate.search.mapper.orm.outboxpolling.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.ConfigurationLog;
import org.hibernate.search.mapper.orm.outboxpolling.mapping.impl.AdditionalMappingBuilder;
import org.hibernate.search.mapper.orm.outboxpolling.mapping.impl.JaxbMappingHelper;

public final class OutboxPollingOutboxEventAdditionalMappingProducer implements HibernateSearchOrmMappingProducer {

    private static final String CLASS_NAME = OutboxEvent.class.getName();

    // Setting both the JPA entity name and the native entity name to the FQCN so that:
    // 1. We don't pollute the namespace of JPA entity names with something like
    // "OutboxEvent" that could potentially conflict with user-defined entities.
    // 2. We can still use session methods (persist, ...) without passing the entity name,
    // because our override actually matches the default for the native entity name.
    public static final String ENTITY_NAME = CLASS_NAME;

    public static final String ENTITY_DEFINITION = "<entity-mappings xmlns=\"http://www.hibernate.org/xsd/orm/mapping\">\n" + "    <entity name=\"org.hibernate.search.mapper.orm.outboxpolling.event.impl.OutboxEvent\" class=\"org.hibernate.search.mapper.orm.outboxpolling.event.impl.OutboxEvent\" access=\"FIELD\">\n" + "        <table name=\"HSEARCH_OUTBOX_EVENT\" catalog=\"\" schema=\"\">\n" + "            <index name=\"entityIdHash\" column-list=\"entityIdHash\"/>\n" + "            <index name=\"status\" column-list=\"status\"/>\n" + "            <index name=\"processAfter\" column-list=\"processAfter\"/>\n" + "        </table>\n" + "        <attributes>\n" + "            <id name=\"id\">\n" + "                <uuid-generator style=\"random\"/>\n" + "            </id>\n" + "            <basic name=\"entityName\">\n" + "                <column name=\"entityName\" nullable=\"false\" length=\"256\"/>\n" + "            </basic>\n" + "            <basic name=\"entityId\">\n" + "                <column name=\"entityId\" nullable=\"false\" length=\"256\"/>\n" + "            </basic>\n" + "            <basic name=\"entityIdHash\">\n" + "                <column name=\"entityIdHash\" nullable=\"false\"/>\n" + "            </basic>\n" + "            <basic name=\"payload\">\n" + "                <column name=\"payload\" nullable=\"false\" length=\"2147483647\"/>\n" + "            </basic>\n" + "            <basic name=\"retries\">\n" + "                <column name=\"retries\" nullable=\"false\"/>\n" + "            </basic>\n" + "            <basic name=\"processAfter\">\n" + "                <column name=\"processAfter\" nullable=\"false\"/>\n" + "            </basic>\n" + "            <basic name=\"status\">\n" + "                <column name=\"status\" nullable=\"false\"/>\n" + "                <enumerated>STRING</enumerated>\n" + "            </basic>\n" + "        </attributes>\n" + "    </entity>\n" + "</entity-mappings>";

    private static final OptionalConfigurationProperty<String> OUTBOXEVENT_ENTITY_MAPPING = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSpiSettings.CoordinationRadicals.OUTBOXEVENT_ENTITY_MAPPING).asString().build();

    private static final OptionalConfigurationProperty<String> ENTITY_MAPPING_OUTBOXEVENT_SCHEMA = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.ENTITY_MAPPING_OUTBOXEVENT_SCHEMA).asString().build();

    private static final OptionalConfigurationProperty<String> ENTITY_MAPPING_OUTBOXEVENT_CATALOG = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.ENTITY_MAPPING_OUTBOXEVENT_CATALOG).asString().build();

    private static final OptionalConfigurationProperty<String> ENTITY_MAPPING_OUTBOXEVENT_TABLE = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.ENTITY_MAPPING_OUTBOXEVENT_TABLE).asString().build();

    public static final OptionalConfigurationProperty<UuidGenerationStrategy> ENTITY_MAPPING_OUTBOXEVENT_UUID_GEN_STRATEGY = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.ENTITY_MAPPING_OUTBOXEVENT_UUID_GEN_STRATEGY).as(UuidGenerationStrategy.class, UuidGenerationStrategy::of).build();

    private static final OptionalConfigurationProperty<String> ENTITY_MAPPING_OUTBOXEVENT_UUID_TYPE = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.ENTITY_MAPPING_OUTBOXEVENT_UUID_TYPE).asString().build();

    @Override
    public Consumer<AdditionalMappingContributions> produceMappingContributor(ConfigurationPropertySource propertySource, MetadataBuildingContext buildingContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static ClassDetails createMappings(MetadataBuildingContext buildingContext, String schema, String catalog, String table, Integer resolvedUuidType, String resolvedUuidStrategy, boolean tenantIdRequired) {
        AdditionalMappingBuilder builder = new AdditionalMappingBuilder(buildingContext, OutboxEvent.class, ENTITY_NAME).id(resolvedUuidType, resolvedUuidStrategy).index("entityIdHash").index("status").index("processAfter").table(schema, catalog, table).attribute("entityName", 256, false).attribute("entityId", 256, false).attribute("entityIdHash", null, false).attribute("payload", Length.LONG32, false).attribute("retries", null, false).attribute("processAfter", null, false).enumAttribute("status", null, false);
        if (tenantIdRequired) {
            builder.tenantId("tenantId");
        }
        return builder.build();
    }
}
