/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.build.enforcer;

import static org.hibernate.search.build.enforcer.MavenProjectUtils.isAnyParentPublicParent;
import static org.hibernate.search.build.enforcer.MavenProjectUtils.isAnyParentRelocationParent;
import static org.hibernate.search.build.enforcer.MavenProjectUtils.isProjectDeploySkipped;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.maven.enforcer.rule.api.AbstractEnforcerRule;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;

// rule name - must start with lowercase character
@Named("javadocSourcePathIncludesAllPublicArtifactsRule")
public class JavadocSourcePathIncludesAllPublicArtifactsRule extends AbstractEnforcerRule {

    private static final String JAVADOC_PLUGIN = "org.apache.maven.plugins:maven-javadoc-plugin";

    private static final String EXECUTION_GENERATE_JAVADOC = "generate-javadoc";

    // Inject needed Maven components
    @Inject
    private MavenSession session;

    /**
     * Rule parameter as list of items.
     */
    private Set<String> pathsToSkip;

    public void execute() throws EnforcerRuleException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Path getRootProjectPath(MavenProject project) {
        return project.getParent() == null ? project.getBasedir().toPath() : getRootProjectPath(project.getParent());
    }

    private Set<Path> expectedJavaDocPaths(Path rootProjectPath) {
        Set<Path> expectations = new HashSet<>();
        Set<Path> checkPaths = pathsToSkip.stream().map(Path::of).collect(Collectors.toSet());
        for (MavenProject project : session.getAllProjects()) {
            boolean publicParent = isAnyParentPublicParent(project);
            boolean relocationParent = isAnyParentRelocationParent(project);
            boolean canContainSourcesWithPublishableJavadoc = publicParent && !relocationParent;
            boolean deploySkipped = isProjectDeploySkipped(project);
            if (canContainSourcesWithPublishableJavadoc && !deploySkipped) {
                Path path = project.getBasedir().toPath();
                for (String sourceRoot : project.getCompileSourceRoots()) {
                    Path source = path.resolve(sourceRoot).normalize();
                    if (!checkPaths.contains(rootProjectPath.relativize(path.resolve(sourceRoot)))) {
                        expectations.add(source);
                    }
                }
            }
        }
        return expectations;
    }
}
