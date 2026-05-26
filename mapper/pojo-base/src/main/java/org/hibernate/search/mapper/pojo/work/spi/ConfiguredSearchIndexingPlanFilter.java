/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.spi;

import java.util.Set;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;

public interface ConfiguredSearchIndexingPlanFilter {

    boolean isIncluded(PojoRawTypeIdentifier<?> typeIdentifier);

    default boolean supportsAsyncProcessing() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static ConfiguredSearchIndexingPlanFilter create(Set<PojoRawTypeIdentifier<?>> includes, Set<PojoRawTypeIdentifier<?>> excludes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class IncludeAll implements ConfiguredSearchIndexingPlanFilter {

        public static final IncludeAll INSTANCE = new IncludeAll();

        private IncludeAll() {
        }

        @Override
        public boolean isIncluded(PojoRawTypeIdentifier<?> typeIdentifier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportsAsyncProcessing() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    class ExcludeAll implements ConfiguredSearchIndexingPlanFilter {

        static final ExcludeAll INSTANCE = new ExcludeAll();

        private ExcludeAll() {
        }

        @Override
        public boolean isIncluded(PojoRawTypeIdentifier<?> typeIdentifier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    class Filter implements ConfiguredSearchIndexingPlanFilter {

        protected final Set<PojoRawTypeIdentifier<?>> includes;

        private Filter(Set<PojoRawTypeIdentifier<?>> includes) {
            this.includes = includes;
        }

        @Override
        public boolean isIncluded(PojoRawTypeIdentifier<?> typeIdentifier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportsAsyncProcessing() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
