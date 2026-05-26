/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * A superclass to both {@link AnalyzerDefinition} and {@link NormalizerDefinition}.
 */
public abstract class AbstractCompositeAnalysisDefinition extends AnalysisDefinition {

    @SerializedName("filter")
    private List<String> tokenFilters;

    @SerializedName("char_filter")
    private List<String> charFilters;

    public List<String> getTokenFilters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTokenFilters(List<String> tokenFilters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void addTokenFilter(String tokenFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<String> getInitializedTokenFilters() {
        if (tokenFilters == null) {
            tokenFilters = new ArrayList<>();
        }
        return tokenFilters;
    }

    public List<String> getCharFilters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCharFilters(List<String> charFilters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void addCharFilter(String charFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<String> getInitializedCharFilters() {
        if (charFilters == null) {
            charFilters = new ArrayList<>();
        }
        return charFilters;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
