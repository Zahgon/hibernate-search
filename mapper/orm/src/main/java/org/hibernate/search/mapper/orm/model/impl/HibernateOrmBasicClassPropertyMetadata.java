/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.model.impl;

import java.lang.reflect.Member;

class HibernateOrmBasicClassPropertyMetadata {

    private final Member member;

    private final boolean id;

    HibernateOrmBasicClassPropertyMetadata(Member member, boolean id) {
        this.member = member;
        this.id = id;
    }

    Member getMember() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    boolean isId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
