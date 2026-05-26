/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.spi;

import java.util.Objects;
import java.util.function.Predicate;
import org.hibernate.search.util.common.annotation.Incubating;

/**
 * Holds a configuration scope.
 * <p>
 * It is <strong>not expected</strong> for service implementors to create the scopes.
 * Hibernate Search will create the scope itself, and it will pass a corresponding scope to the {@link ConfigurationProvider}
 * whenever it is required.
 * <p>
 * Scope always starts as the global scope.
 * This global scope should always be reachable through recursively accessing the {@link #parent() parent scope},
 * unless the current scope is already a global scope.
 * <p>
 * An example of a scope sequence:
 * <ul>
 *     <li>{@code [namespace:global]} -- scope always starts with the global scope</li>
 *     <li>
 *         {@code [namespace:backend name:backend-name]} -- next a backend scope with an <strong>optional</strong> backend named.
 *     		If the name is not present, it means that scope represents a default backend.
 *     	</li>
 *     <li>{@code [namespace:index name:index-name]} -- next is a scope specific to an index</li>
 * </ul>
 * @see ConfigurationScopeNamespaces
 * @see ConfigurationProvider
 */
@Incubating
public final class ConfigurationScope {

    public static final ConfigurationScope GLOBAL = new ConfigurationScope(null, ConfigurationScopeNamespaces.GLOBAL, null);

    private final ConfigurationScope parent;

    private final String namespace;

    private final String name;

    private ConfigurationScope(ConfigurationScope parent, String namespace, String name) {
        this.parent = parent;
        this.namespace = namespace;
        this.name = name;
    }

    public ConfigurationScope reduce(String namespace, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean matchAny(String namespace) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean matchExact(String namespace) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean matchExact(String namespace, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean match(Predicate<ConfigurationScope> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationScope parent() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String namespace() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
