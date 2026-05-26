/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.cluster.impl;

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
import org.hibernate.search.mapper.orm.outboxpolling.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.ConfigurationLog;
import org.hibernate.search.mapper.orm.outboxpolling.mapping.impl.AdditionalMappingBuilder;
import org.hibernate.search.mapper.orm.outboxpolling.mapping.impl.JaxbMappingHelper;

public class OutboxPollingAgentAdditionalMappingProducer implements HibernateSearchOrmMappingProducer {

    public static final String CLASS_NAME = Agent.class.getName();

    // Setting both the JPA entity name and the native entity name to the FQCN so that:
    // 1. We don't pollute the namespace of JPA entity names with something like
    // "Agent" that could potentially conflict with user-defined entities.
    // 2. We can still use session methods (persist, ...) without passing the entity name,
    // because our override actually matches the default for the native entity name.
    public static final String ENTITY_NAME = CLASS_NAME;

    public static final String ENTITY_DEFINITION = "<entity-mappings xmlns=\"http://www.hibernate.org/xsd/orm/mapping\">\n" + "    <entity name=\"org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.Agent\" class=\"org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.Agent\" access=\"FIELD\">\n" + "        <table name=\"HSEARCH_AGENT\" catalog=\"\" schema=\"\"/>\n" + "        <attributes>\n" + "            <id name=\"id\">\n" + "                <uuid-generator style=\"random\"/>\n" + "            </id>\n" + "            <basic name=\"type\">\n" + "                <column name=\"type\" nullable=\"false\"/>\n" + "                <enumerated>STRING</enumerated>\n" + "            </basic>\n" + "            <basic name=\"name\">\n" + "                <column name=\"name\" nullable=\"false\"/>\n" + "            </basic>\n" + "            <basic name=\"expiration\">\n" + "                <column name=\"expiration\" nullable=\"false\"/>\n" + "            </basic>\n" + "            <basic name=\"state\">\n" + "                <column name=\"state\" nullable=\"false\"/>\n" + "                <enumerated>STRING</enumerated>\n" + "            </basic>\n" + "            <basic name=\"totalShardCount\">\n" + "                <column name=\"totalShardCount\" nullable=\"true\"/>\n" + "            </basic>\n" + "            <basic name=\"assignedShardIndex\">\n" + "                <column name=\"assignedShardIndex\" nullable=\"true\"/>\n" + "            </basic>\n" + "            <basic name=\"payload\">\n" + "                <column name=\"payload\" nullable=\"true\" length=\"2147483647\"/>\n" + "            </basic>\n" + "        </attributes>\n" + "    </entity>\n" + "</entity-mappings>";

    private static final OptionalConfigurationProperty<String> AGENT_ENTITY_MAPPING = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSpiSettings.CoordinationRadicals.AGENT_ENTITY_MAPPING).asString().build();

    private static final OptionalConfigurationProperty<String> ENTITY_MAPPING_AGENT_SCHEMA = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.ENTITY_MAPPING_AGENT_SCHEMA).asString().build();

    private static final OptionalConfigurationProperty<String> ENTITY_MAPPING_AGENT_CATALOG = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.ENTITY_MAPPING_AGENT_CATALOG).asString().build();

    private static final OptionalConfigurationProperty<String> ENTITY_MAPPING_AGENT_TABLE = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.ENTITY_MAPPING_AGENT_TABLE).asString().build();

    private static final OptionalConfigurationProperty<UuidGenerationStrategy> ENTITY_MAPPING_AGENT_UUID_GEN_STRATEGY = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.ENTITY_MAPPING_AGENT_UUID_GEN_STRATEGY).as(UuidGenerationStrategy.class, UuidGenerationStrategy::of).build();

    private static final OptionalConfigurationProperty<String> ENTITY_MAPPING_AGENT_UUID_TYPE = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.ENTITY_MAPPING_OUTBOXEVENT_UUID_TYPE).asString().build();

    @Override
    public Consumer<AdditionalMappingContributions> produceMappingContributor(ConfigurationPropertySource propertySource, MetadataBuildingContext buildingContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static ClassDetails createMappings(MetadataBuildingContext buildingContext, String schema, String catalog, String table, Integer resolvedUuidType, String resolvedUuidStrategy, boolean tenantIdRequired) {
        AdditionalMappingBuilder builder = new AdditionalMappingBuilder(buildingContext, Agent.class, ENTITY_NAME).id(resolvedUuidType, resolvedUuidStrategy).table(schema, catalog, table).enumAttribute("type", null, false).attribute("name", null, false).attribute("expiration", null, false).enumAttribute("state", null, false).attribute("totalShardCount", null, true).attribute("assignedShardIndex", null, true).attribute("payload", Length.LONG32, true);
        if (tenantIdRequired) {
            builder.tenantId("tenantId");
        }
        return builder.build();
    }
}
