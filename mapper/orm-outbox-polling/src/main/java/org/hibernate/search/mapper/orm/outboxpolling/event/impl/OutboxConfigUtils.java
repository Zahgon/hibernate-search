/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.time.Duration;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.ConfigurationLog;

final class OutboxConfigUtils {

    private OutboxConfigUtils() {
    }

    static Duration checkPulseInterval(Duration pulseInterval, Duration pollingInterval) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static Duration checkPulseExpiration(Duration pulseExpiration, Duration pulseInterval) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
