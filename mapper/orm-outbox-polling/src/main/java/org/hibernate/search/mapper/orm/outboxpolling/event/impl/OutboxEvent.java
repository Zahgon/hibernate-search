/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.Transient;

public class OutboxEvent {

    public enum Status {

        PENDING, ABORTED
    }

    private UUID id;

    private String entityName;

    private String entityId;

    private int entityIdHash;

    private byte[] payload;

    private int retries = 0;

    private Instant processAfter;

    private Status status = Status.PENDING;

    private String tenantId;

    @Transient
    private Object originalEntityId;

    protected OutboxEvent() {
    }

    public OutboxEvent(String entityName, String entityId, int entityIdHash, byte[] payload, Object originalEntityId) {
        this.entityName = entityName;
        this.entityId = entityId;
        this.entityIdHash = entityIdHash;
        this.payload = payload;
        this.processAfter = Instant.now();
        this.originalEntityId = originalEntityId;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UUID getId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setId(UUID id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEntityName(String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getEntityId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEntityId(String entityId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getEntityIdHash() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEntityIdHash(int entityIdHash) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public byte[] getPayload() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPayload(byte[] payload) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getRetries() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRetries(int retries) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Instant getProcessAfter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setProcessAfter(Instant processAfter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Status getStatus() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setStatus(Status status) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object getOriginalEntityId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setOriginalEntityId(Object originalEntityId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getTenantId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTenantId(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    OutboxEventReference getReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
