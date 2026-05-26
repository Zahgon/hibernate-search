/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.configuration.properties.collector.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConfigurationProperty implements Comparable<ConfigurationProperty> {

    public enum Type {

        /**
         * Configuration property type API/SPI will be determined by inspecting the package in which a class is located.
         * In case package contains {@code spi} package at any upper levels the type will be {@code SPI}, otherwise - {@code API}
         */
        API,
        SPI
    }

    private static final Comparator<ConfigurationProperty> CONFIGURATION_PROPERTY_COMPARATOR = Comparator.comparing(c -> c.key().key);

    private Key key;

    private String javadoc;

    private String sourceClass;

    private Type type;

    private Object defaultValue;

    private String anchorPrefix;

    private String moduleName;

    public Key key() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationProperty key(Key key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String javadoc() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationProperty javadoc(String javadoc) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String sourceClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationProperty sourceClass(String sourceClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Type type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationProperty type(Type type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object defaultValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationProperty defaultValue(Object defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String anchorPrefix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationProperty anchorPrefix(String anchorPrefix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String moduleName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationProperty moduleName(String moduleName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int compareTo(ConfigurationProperty o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Key {

        private final List<String> prefixes;

        private final String key;

        public Key(List<String> prefixes, String key) {
            this.key = key;
            this.prefixes = prefixes;
        }

        public List<String> resolvedKeys() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
