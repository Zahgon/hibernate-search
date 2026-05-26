/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.impl;

import java.util.Optional;
import org.hibernate.search.engine.cfg.BackendSettings;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.EngineSettings;

public final class EngineConfigurationUtils {

    private EngineConfigurationUtils() {
    }

    public static ConfigurationPropertySourceExtractor extractorForBackend(Optional<String> backendNameOptional) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ConfigurationPropertySourceExtractor extractorForIndex(ConfigurationPropertySourceExtractor extractorForBackend, String backendName, String indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
