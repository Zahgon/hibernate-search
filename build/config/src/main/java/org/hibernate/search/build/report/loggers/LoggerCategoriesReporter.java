/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.build.report.loggers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.yaml.snakeyaml.Yaml;

public class LoggerCategoriesReporter {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class Category {

        String name;

        String description;

        Set<String> modules = new TreeSet<>();

        Set<String> levels = new TreeSet<>();

        public Category(String name) {
            this.name = name;
        }
    }
}
