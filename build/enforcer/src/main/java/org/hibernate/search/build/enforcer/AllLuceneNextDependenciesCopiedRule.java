/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.build.enforcer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.maven.enforcer.rule.api.AbstractEnforcerRule;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.DefaultDependencyResolutionRequest;
import org.apache.maven.project.DependencyResolutionException;
import org.apache.maven.project.DependencyResolutionResult;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectDependenciesResolver;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.aether.util.filter.AndDependencyFilter;
import org.eclipse.aether.util.filter.ExclusionsDependencyFilter;
import org.eclipse.aether.util.filter.ScopeDependencyFilter;

// rule name - must start with lowercase character
@Named("allLuceneNextDependenciesCopiedRule")
public class AllLuceneNextDependenciesCopiedRule extends AbstractEnforcerRule {

    private static final String DEPENDENCY_PLUGIN = "org.apache.maven.plugins:maven-dependency-plugin";

    private static final String EXECUTION_COPY = "copy-dependencies-lucene-next";

    private static final String LUCENE_NEXT_ARTIFACT_ID = "hibernate-search-backend-lucene-next";

    // Inject needed Maven components
    @Inject
    private MavenSession session;

    @Inject
    private ProjectDependenciesResolver dependenciesResolver;

    /**
     * Rule parameter as list of items.
     */
    private Set<Dependency> dependenciesToSkip;

    public void execute() throws EnforcerRuleException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<org.eclipse.aether.graph.Dependency> resolveDependencies(MavenProject luceneNextProject) {
        try {
            DependencyResolutionResult result = dependenciesResolver.resolve(new DefaultDependencyResolutionRequest(luceneNextProject, session.getRepositorySession()).setResolutionFilter(new AndDependencyFilter(// we skip test dependencies
            new ScopeDependencyFilter("test"), // and the ones we explicitly asked to skip:
            new ExclusionsDependencyFilter(dependenciesToSkip.stream().map(d -> d.getGroupId() + ":" + d.getArtifactId()).toList()))));
            return result.getDependencies();
        } catch (DependencyResolutionException e) {
            throw new RuntimeException(e);
        }
    }
}
