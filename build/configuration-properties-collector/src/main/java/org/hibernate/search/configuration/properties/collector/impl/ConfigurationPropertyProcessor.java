/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.configuration.properties.collector.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class ConfigurationPropertyProcessor implements AutoCloseable {

    private static final Predicate<Map.Entry<String, ConfigurationProperty>> API_FILTER = entry -> ConfigurationProperty.Type.API.equals(entry.getValue().type());

    private static final Predicate<Map.Entry<String, ConfigurationProperty>> SPI_FILTER = entry -> ConfigurationProperty.Type.SPI.equals(entry.getValue().type());

    private final ConfigurationPropertyCollector propertyCollector;

    private final String fileName;

    private final String javadocFolderName;

    private final Path target;

    private final Path output;

    private final Path javadocsBaseDir;

    public ConfigurationPropertyProcessor(String javadocFolderName, String javadocsBaseLink, Path target, Path output, Path javadocsBaseDir, String artifact, String moduleName) {
        this.javadocFolderName = javadocFolderName;
        this.target = target;
        this.output = output;
        this.fileName = artifact.startsWith("_") ? artifact : "_" + artifact;
        this.javadocsBaseDir = javadocsBaseDir;
        this.propertyCollector = new ConfigurationPropertyCollector(javadocsBaseLink, locateJavaDocDirectory(), artifact, moduleName);
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean process() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void writeProperties(String fileName, BiConsumer<Map<String, ConfigurationProperty>, Writer> transformer) {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(Files.createDirectories(output).resolve(fileName).toFile()), StandardCharsets.UTF_8)) {
            propertyCollector.write(transformer, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Path locateJavaDocDirectory() {
        Path javadocsLocation = javadocsBaseDir.resolve(javadocFolderName);
        if (!Files.exists(javadocsLocation)) {
            throw new IllegalStateException("Was unable to locate javadocs. No processing is possible. Make sure that " + "the Javadocs are generated prior to running this processor. " + "Was expecting to find javadocs in " + javadocsLocation);
        }
        return javadocsLocation;
    }
}
