/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.building.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.mapper.mapping.building.spi.IndexBindingContext;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorTypeNode;
import org.hibernate.search.mapper.pojo.bridge.PropertyBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.BoundPropertyBridge;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.IdentifierBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.PropertyBinder;
import org.hibernate.search.mapper.pojo.extractor.impl.BoundContainerExtractorPath;
import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorHolder;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.identity.impl.PojoIdentityMappingCollector;
import org.hibernate.search.mapper.pojo.mapping.building.impl.PojoMappingHelper;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoIndexMappingCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoIndexMappingCollectorValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.processing.impl.PojoIndexingProcessor;
import org.hibernate.search.mapper.pojo.processing.impl.PojoIndexingProcessorPropertyBridgeNode;
import org.hibernate.search.mapper.pojo.processing.impl.PojoIndexingProcessorPropertyNode;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.SuppressingCloser;

/**
 * A builder of {@link PojoIndexingProcessorPropertyNode}.
 *
 * @param <T> The property holder type
 * @param <P> The property type
 */
class PojoIndexingProcessorPropertyNodeBuilder<T, P> extends AbstractPojoProcessorNodeBuilder implements PojoIndexMappingCollectorPropertyNode {

    private final BoundPojoModelPathPropertyNode<T, P> modelPath;

    private final PojoIdentityMappingCollector identityMappingCollector;

    private final Collection<BoundPropertyBridge<P>> boundPropertyBridges = new ArrayList<>();

    private final PojoIndexingProcessorValueNodeBuilderDelegate<P, P> valueWithoutExtractorBuilderDelegate;

    // Use a LinkedHashMap for deterministic iteration
    private final Map<ContainerExtractorPath, PojoIndexingProcessorContainerElementNodeBuilder<P, ? super P, ?>> containerElementNodeBuilders = new LinkedHashMap<>();

    PojoIndexingProcessorPropertyNodeBuilder(BoundPojoModelPathPropertyNode<T, P> modelPath, PojoMappingHelper mappingHelper, IndexBindingContext bindingContext, PojoIdentityMappingCollector identityMappingCollector) {
        super(mappingHelper, bindingContext);
        this.modelPath = modelPath;
        this.identityMappingCollector = identityMappingCollector;
        this.valueWithoutExtractorBuilderDelegate = new PojoIndexingProcessorValueNodeBuilderDelegate<>(modelPath.valueWithoutExtractors(), mappingHelper, bindingContext, false);
    }

    @Override
    public void propertyBinder(PropertyBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void identifierBinder(IdentifierBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexMappingCollectorValueNode value(ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * This generic method is necessary to make it clear to the compiler
	 * that the extracted type and extractor have compatible generic arguments.
	 */
    private <V> PojoIndexingProcessorContainerElementNodeBuilder<P, ? super P, V> createContainerElementNodeBuilder(BoundContainerExtractorPath<P, V> boundExtractorPath) {
        BoundPojoModelPathValueNode<T, P, V> containerElementPath = modelPath.value(boundExtractorPath);
        ContainerExtractorHolder<P, V> extractorHolder = mappingHelper.indexModelBinder().createExtractors(boundExtractorPath);
        return new PojoIndexingProcessorContainerElementNodeBuilder<>(containerElementPath, extractorHolder, mappingHelper, bindingContext);
    }

    @Override
    BoundPojoModelPath getModelPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Optional<PojoIndexingProcessorPropertyNode<T, P>> build(PojoIndexingDependencyCollectorTypeNode<T> parentDependencyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Optional<PojoIndexingProcessorPropertyNode<T, P>> doBuild(PojoIndexingDependencyCollectorTypeNode<T> parentDependencyCollector) {
        // We know from the property model that this property has type P
        @SuppressWarnings("unchecked")
        PojoIndexingDependencyCollectorPropertyNode<T, P> propertyDependencyCollector = (PojoIndexingDependencyCollectorPropertyNode<T, P>) parentDependencyCollector.property(modelPath.getPropertyModel().name());
        Collection<PojoIndexingProcessor<? super P>> nestedNodes = new ArrayList<>();
        try {
            for (BoundPropertyBridge<P> boundBridge : boundPropertyBridges) {
                nestedNodes.add(new PojoIndexingProcessorPropertyBridgeNode<>(boundBridge.getBridgeHolder()));
                boundBridge.contributeDependencies(propertyDependencyCollector);
            }
            Collection<PojoIndexingProcessor<? super P>> valueWithoutExtractorNodes = valueWithoutExtractorBuilderDelegate.build(propertyDependencyCollector);
            if (!valueWithoutExtractorNodes.isEmpty()) {
                nestedNodes.addAll(valueWithoutExtractorNodes);
            }
            containerElementNodeBuilders.values().stream().// Necessary because the default extractor path has two possible keys with the same value
            distinct().filter(Objects::nonNull).map(builder -> builder.build(propertyDependencyCollector)).filter(Optional::isPresent).map(Optional::get).forEach(nestedNodes::add);
            if (nestedNodes.isEmpty()) {
                /*
				 * If this node doesn't have any bridge, nor any nested node,
				 * it is useless and we don't need to build it.
				 */
                return Optional.empty();
            } else {
                return Optional.of(new PojoIndexingProcessorPropertyNode<>(modelPath.getPropertyModel().handle(), createNested(nestedNodes), modelPath.toUnboundPath()));
            }
        } catch (RuntimeException e) {
            // Close the nested processors created so far before aborting
            new SuppressingCloser(e).pushAll(PojoIndexingProcessor::close, nestedNodes);
            throw e;
        }
    }
}
