/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.build.enforcer;

import org.apache.maven.project.MavenProject;

public class MavenProjectUtils {

    public static final String HIBERNATE_SEARCH_PARENT_PUBLIC = "hibernate-search-parent-public";

    public static final String HIBERNATE_SEARCH_PARENT_PUBLIC_LUCENE_NEXT = "hibernate-search-parent-public-lucene-next";

    public static final String HIBERNATE_SEARCH_PARENT_INTEGRATION_TEST = "hibernate-search-parent-integrationtest";

    public static final String HIBERNATE_SEARCH_PARENT_INTEGRATION_TEST_LUCENE_NEXT = "hibernate-search-parent-integrationtest-lucene-next";

    public static final String HIBERNATE_SEARCH_PARENT_RELOCATION = "hibernate-search-parent-relocation";

    public static final String DEPLOY_SKIP = "deploy.skip";

    private MavenProjectUtils() {
    }

    public static boolean isAnyParentPublicParent(MavenProject project) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isAnyParentRelocationParent(MavenProject project) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isAnyParentIntegrationTestParent(MavenProject project) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isProjectDeploySkipped(MavenProject project) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isProjectJacocoSkipped(MavenProject project) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
