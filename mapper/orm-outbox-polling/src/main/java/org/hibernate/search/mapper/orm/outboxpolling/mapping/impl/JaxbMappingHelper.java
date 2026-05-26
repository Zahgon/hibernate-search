/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.mapping.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.hibernate.boot.jaxb.mapping.spi.JaxbEntityMappingsImpl;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.ConfigurationLog;

public class JaxbMappingHelper {

    private JaxbMappingHelper() {
    }

    public static String marshall(JaxbEntityMappingsImpl mappings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static JaxbEntityMappingsImpl unmarshall(String mappings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
