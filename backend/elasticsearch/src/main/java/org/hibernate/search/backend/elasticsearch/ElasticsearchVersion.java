/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.search.backend.elasticsearch.logging.impl.VersionLog;

public class ElasticsearchVersion {

    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\d+)(?:\\.(\\d+)(?:\\.(\\d+)(?:-(\\w+))?)?)?");

    // This matches either no separator with an empty string before or after, or a separator with something left and right.
    private static final String SEPARATOR_PATTERN_STRING = "(?<=^)|(?=$)|(?<=.):(?=.)";

    private static final Pattern DISTRIBUTION_AND_VERSION_PATTERN = Pattern.compile("([^\\d]+)?(?:" + SEPARATOR_PATTERN_STRING + ")(" + VERSION_PATTERN.pattern() + ")?");

    /**
     * @param distributionAndVersionString A version string following the format {@code x.y.z-qualifier} or {@code <distribution>:x.y.z-qualifier},
     * where {@code <distribution>} is a string accepted by {@link ElasticsearchDistributionName#of(String)},
     * {@code x}, {@code y} and {@code z} are integers and {@code qualifier} is a string of word characters (alphanumeric or '_').
     * Incomplete versions are allowed, for example 'elastic:7.0', {@code 7.0} or just {@code 7}.
     * @return An {@link ElasticsearchVersion} object representing the given version.
     * @throws org.hibernate.search.util.common.SearchException If the input string doesn't follow the required format.
     */
    // This method conforms to the MicroProfile Config specification. Do not change its signature.
    public static ElasticsearchVersion of(String distributionAndVersionString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param distribution A distribution name.
     * @param versionString A version string following the format {@code x.y.z-qualifier},
     * where {@code x}, {@code y} and {@code z} are integers and {@code qualifier} is a string of word characters (alphanumeric or '_').
     * Incomplete versions are allowed, for example {@code 7.0} or just {@code 7}.
     * Null is allowed.
     * @return An {@link ElasticsearchVersion} object representing the given version.
     * @throws org.hibernate.search.util.common.SearchException If the input string doesn't follow the required format.
     */
    public static ElasticsearchVersion of(ElasticsearchDistributionName distribution, String versionString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Integer parseVersionComponent(String string) {
        return string == null ? null : Integer.parseInt(string);
    }

    private final ElasticsearchDistributionName distribution;

    private final Integer major;

    private final Integer minor;

    private final Integer micro;

    private final String qualifier;

    private ElasticsearchVersion(ElasticsearchDistributionName distribution, Integer major, Integer minor, Integer micro, String qualifier) {
        this.distribution = distribution;
        this.major = major;
        this.minor = minor;
        this.micro = micro;
        this.qualifier = qualifier;
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The version string, i.e. the version without the distribution prefix.
     */
    public String versionString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The distribution to which this version applies, e.g. {@link ElasticsearchDistributionName#ELASTIC}
     * or {@link ElasticsearchDistributionName#OPENSEARCH}.
     */
    public ElasticsearchDistributionName distribution() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The "major" number of this version, i.e. the {@code x} in {@code x.y.z-qualifier}.
     * @deprecated Use {@link #majorOptional()} instead.
     */
    @Deprecated(since = "7.0")
    public int major() {
        if (major == null) {
            return 0;
        }
        return major;
    }

    /**
     * @return The "major" number of this version, i.e. the {@code x} in {@code x.y.z-qualifier}. May be empty.
     */
    public OptionalInt majorOptional() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The "minor" number of this version, i.e. the {@code y} in {@code x.y.z-qualifier}. May be empty.
     */
    public OptionalInt minor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The "minor" number of this version, i.e. the {@code z} in {@code x.y.z-qualifier}. May be empty.
     */
    public OptionalInt micro() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The qualifier in this version, i.e. the {@code qualifier} in {@code x.y.z-qualifier}. May be empty.
     */
    public Optional<String> qualifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param other A version to be matched against this version.
     * @return {@code true} if the other version matches this version,
     * i.e. if all the components defined in this version are also defined in the other version with the same value.
     * {@code false} otherwise.
     * Components that are not defined in this version do not matter.
     */
    public boolean matches(ElasticsearchVersion other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
