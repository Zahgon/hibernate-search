/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;

public final class ExceptionUtils {

    private ExceptionUtils() {
    }

    public static void logError(Messager messager, Exception exception, String message) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void logError(Messager messager, Exception exception, String message, Element element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
