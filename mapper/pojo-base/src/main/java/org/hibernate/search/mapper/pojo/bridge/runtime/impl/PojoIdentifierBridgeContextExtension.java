/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.runtime.impl;

import java.util.Optional;
import org.hibernate.search.engine.backend.mapping.spi.BackendMappingContext;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContext;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContextExtension;
import org.hibernate.search.engine.backend.types.converter.runtime.ToDocumentValueConvertContext;
import org.hibernate.search.engine.backend.types.converter.runtime.ToDocumentValueConvertContextExtension;
import org.hibernate.search.mapper.pojo.bridge.runtime.IdentifierBridgeFromDocumentIdentifierContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.IdentifierBridgeToDocumentIdentifierContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeMappingContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeSessionContext;

final class PojoIdentifierBridgeContextExtension implements ToDocumentValueConvertContextExtension<IdentifierBridgeToDocumentIdentifierContext>, FromDocumentValueConvertContextExtension<IdentifierBridgeFromDocumentIdentifierContext> {

    static final PojoIdentifierBridgeContextExtension INSTANCE = new PojoIdentifierBridgeContextExtension();

    @Override
    public Optional<IdentifierBridgeToDocumentIdentifierContext> extendOptional(ToDocumentValueConvertContext original, BackendMappingContext mappingContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<IdentifierBridgeFromDocumentIdentifierContext> extendOptional(FromDocumentValueConvertContext original, BackendSessionContext sessionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
