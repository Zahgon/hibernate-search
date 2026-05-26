/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.spi;

import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.backend.common.spi.EntityReferenceFactory;
import org.hibernate.search.engine.backend.reporting.spi.BackendMappingHints;
import org.hibernate.search.engine.backend.types.converter.runtime.ToDocumentValueConvertContext;
import org.hibernate.search.engine.backend.types.converter.runtime.spi.ToDocumentValueConvertContextImpl;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.engine.mapper.mapping.spi.MappingImplementor;
import org.hibernate.search.engine.mapper.mapping.spi.MappingPreStopContext;
import org.hibernate.search.engine.mapper.mapping.spi.MappingStartContext;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.engine.search.projection.definition.spi.ProjectionRegistry;
import org.hibernate.search.engine.search.projection.spi.ProjectionMappedTypeContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.IdentifierBridgeToDocumentIdentifierContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeToIndexedValueContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.impl.IdentifierBridgeToDocumentIdentifierContextImpl;
import org.hibernate.search.mapper.pojo.bridge.runtime.impl.ValueBridgeToIndexedValueContextImpl;
import org.hibernate.search.mapper.pojo.common.spi.PojoEntityReference;
import org.hibernate.search.mapper.pojo.common.spi.PojoEntityReferenceFactoryDelegate;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeMappingContext;
import org.hibernate.search.mapper.pojo.session.spi.PojoSearchSessionMappingContext;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexer;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventProcessingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventSendingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;
import org.hibernate.search.util.common.impl.Closer;

public abstract class AbstractPojoMappingImplementor<M> implements MappingImplementor<M>, PojoScopeMappingContext, PojoSearchSessionMappingContext {

    private final PojoMappingDelegate delegate;

    private boolean stopped = false;

    private final PojoEntityReferenceFactoryDelegate entityReferenceFactoryDelegate;

    private final EntityReferenceFactory entityReferenceFactory;

    private final ToDocumentValueConvertContext toDocumentValueConvertContext;

    private final IdentifierBridgeToDocumentIdentifierContext toDocumentIdentifierContext;

    private final ValueBridgeToIndexedValueContext toIndexedValueContext;

    // For EJC
    @SuppressWarnings("deprecation")
    public AbstractPojoMappingImplementor(PojoMappingDelegate delegate) {
        this(delegate, PojoEntityReference::new);
    }

    /**
     * @param delegate The {@link PojoMappingDelegate}
     * @param entityReferenceFactoryDelegate The {@link PojoEntityReferenceFactoryDelegate},
     * used to implement the {@link EntityReferenceFactory}.
     * @deprecated Use {@link AbstractPojoMappingImplementor}.
     * This constructor is only present for backwards compatibility, for mappers that expose a custom entity reference type.
     */
    @Deprecated(since = "6.2")
    public AbstractPojoMappingImplementor(PojoMappingDelegate delegate, PojoEntityReferenceFactoryDelegate entityReferenceFactoryDelegate) {
        this.delegate = delegate;
        this.entityReferenceFactoryDelegate = entityReferenceFactoryDelegate;
        this.entityReferenceFactory = delegate.createEntityReferenceFactory(entityReferenceFactoryDelegate);
        this.toDocumentValueConvertContext = new ToDocumentValueConvertContextImpl(this);
        this.toDocumentIdentifierContext = new IdentifierBridgeToDocumentIdentifierContextImpl(this);
        this.toIndexedValueContext = new ValueBridgeToIndexedValueContextImpl(this);
    }

    @Override
    public CompletableFuture<?> start(MappingStartContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> preStop(MappingPreStopContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BackendMappingHints hints() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ThreadPoolProvider threadPoolProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FailureHandler failureHandler() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PojoRawTypeIdentifierResolver typeIdentifierResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PojoEntityReferenceFactoryDelegate entityReferenceFactoryDelegate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final EntityReferenceFactory entityReferenceFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final ToDocumentValueConvertContext toDocumentValueConvertContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final ProjectionRegistry projectionRegistry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final ProjectionMappedTypeContext mappedTypeContext(String mappedTypeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final IdentifierBridgeToDocumentIdentifierContext identifierBridgeToDocumentIdentifierContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueBridgeToIndexedValueContext valueBridgeToIndexedValueContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexingPlan createIndexingPlan(PojoWorkSessionContext context, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexingPlan createIndexingPlan(PojoWorkSessionContext context, PojoIndexingQueueEventSendingPlan sendingPlan) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexer createIndexer(PojoWorkSessionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexingQueueEventProcessingPlan createIndexingQueueEventProcessingPlan(PojoWorkSessionContext context, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy, PojoIndexingQueueEventSendingPlan sendingPlan) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final PojoMappingDelegate delegate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void doStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
