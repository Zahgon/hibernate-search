/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.cluster.impl;

import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.Transient;

public class Agent {

    private UUID id;

    private AgentType type;

    private String name;

    private Instant expiration;

    private AgentState state;

    private Integer totalShardCount;

    private Integer assignedShardIndex;

    private byte[] payload;

    private String tenantId;

    protected Agent() {
    }

    public Agent(AgentType type, String name, Instant expiration, AgentState state, ShardAssignmentDescriptor shardAssignment) {
        this.type = type;
        this.name = name;
        this.expiration = expiration;
        this.state = state;
        this.totalShardCount = shardAssignment == null ? null : shardAssignment.totalShardCount;
        this.assignedShardIndex = shardAssignment == null ? null : shardAssignment.assignedShardIndex;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UUID getId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // For tests only
    public void setId(UUID id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AgentType getType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setType(AgentType type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void setName(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Instant getExpiration() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExpiration(Instant expiration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AgentState getState() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setState(AgentState state) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getTotalShardCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTotalShardCount(Integer totalShardCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getAssignedShardIndex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAssignedShardIndex(Integer assignedShardIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public byte[] getPayload() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPayload(byte[] payload) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getTenantId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTenantId(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Transient
    public AgentReference getReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Transient
    public ShardAssignmentDescriptor getShardAssignment() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
