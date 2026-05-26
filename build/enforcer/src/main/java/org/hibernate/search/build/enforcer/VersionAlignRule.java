/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.build.enforcer;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.maven.enforcer.rule.api.AbstractEnforcerRule;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;

// rule name - must start with lowercase character
@Named("versionAlignRule")
public class VersionAlignRule extends AbstractEnforcerRule {

    /**
     * Rule parameter as list of items.
     */
    private List<VersionAlignData> propertiesToCheck;

    // Inject needed Maven components
    @Inject
    private MavenSession session;

    public void execute() throws EnforcerRuleException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
