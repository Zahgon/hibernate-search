/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.document.model.spi;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import org.hibernate.search.engine.backend.analysis.AnalyzerDescriptor;
import org.hibernate.search.engine.backend.analysis.NormalizerDescriptor;
import org.hibernate.search.engine.backend.analysis.spi.AnalysisDescriptorRegistry;
import org.hibernate.search.engine.backend.metamodel.IndexDescriptor;
import org.hibernate.search.engine.backend.metamodel.IndexFieldDescriptor;
import org.hibernate.search.engine.common.tree.spi.TreeNodeInclusion;
import org.hibernate.search.engine.logging.impl.MappingLog;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.impl.CollectionHelper;
import org.hibernate.search.util.common.reporting.EventContext;
import org.hibernate.search.util.common.reporting.spi.EventContextProvider;

public abstract class AbstractIndexModel<S extends AbstractIndexModel<?, R, F>, R extends IndexCompositeNode<?, ?, ?>, F extends IndexField<?, ?>> implements EventContextProvider, IndexDescriptor {

    private final AnalysisDescriptorRegistry analysisDescriptorRegistry;

    private final String hibernateSearchIndexName;

    private final EventContext eventContext;

    private final String mappedTypeName;

    private final IndexIdentifier identifier;

    private final R root;

    private final Map<String, F> staticFields;

    private final List<IndexFieldDescriptor> includedStaticFields;

    private final List<? extends AbstractIndexFieldTemplate<? super S, ? extends F, ? super R, ?>> fieldTemplates;

    private final ConcurrentMap<String, F> dynamicFieldsCache = new ConcurrentHashMap<>();

    public AbstractIndexModel(AnalysisDescriptorRegistry analysisDescriptorRegistry, String hibernateSearchIndexName, String mappedTypeName, IndexIdentifier identifier, R root, Map<String, F> staticFields, List<? extends AbstractIndexFieldTemplate<? super S, ? extends F, ? super R, ?>> fieldTemplates) {
        this.analysisDescriptorRegistry = analysisDescriptorRegistry;
        this.hibernateSearchIndexName = hibernateSearchIndexName;
        this.eventContext = EventContexts.fromIndexName(hibernateSearchIndexName);
        this.mappedTypeName = mappedTypeName;
        this.identifier = identifier;
        this.root = root;
        this.staticFields = CollectionHelper.toImmutableMap(staticFields);
        this.includedStaticFields = CollectionHelper.toImmutableList(staticFields.values().stream().filter(field -> TreeNodeInclusion.INCLUDED.equals(field.inclusion())).collect(Collectors.toList()));
        this.fieldTemplates = fieldTemplates;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract S self();

    @Override
    public final EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String hibernateSearchName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexIdentifier identifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final R root() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Optional<IndexFieldDescriptor> field(String absolutePath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final F fieldOrNull(String absolutePath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final F fieldOrNull(String absolutePath, IndexFieldFilter filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Collection<IndexFieldDescriptor> staticFields() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<? extends AnalyzerDescriptor> analyzer(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Collection<? extends AnalyzerDescriptor> analyzers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<? extends NormalizerDescriptor> normalizer(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Collection<? extends NormalizerDescriptor> normalizers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final String mappedTypeName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private F fieldOrNullIgnoringInclusion(String absolutePath) {
        F field = staticFields.get(absolutePath);
        if (field != null) {
            return field;
        }
        field = dynamicFieldsCache.get(absolutePath);
        if (field != null) {
            return field;
        }
        for (AbstractIndexFieldTemplate<? super S, ? extends F, ? super R, ?> template : fieldTemplates) {
            field = template.createNodeIfMatching(self(), root, absolutePath);
            if (field != null) {
                F previous = dynamicFieldsCache.putIfAbsent(absolutePath, field);
                if (previous != null) {
                    // Some other thread created the node before us.
                    // Keep the first created node, discard ours: they are identical.
                    field = previous;
                }
                break;
            }
        }
        return field;
    }
}
