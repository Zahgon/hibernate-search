/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor;

import java.util.List;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import org.hibernate.search.processor.impl.ExceptionUtils;
import org.hibernate.search.processor.impl.HibernateSearchMetamodelProcessorContext;
import org.hibernate.search.processor.impl.IndexedEntityMetamodelAnnotationProcessor;
import org.hibernate.search.processor.impl.MetamodelAnnotationProcessor;

// We inspect all annotations and then decide if we can process them,
// this way we can also work with user-defined ones (at some point):
@SupportedAnnotationTypes("*")
// Currently this is more of a placeholder for future config options:
@SupportedOptions({ HibernateSearchProcessorSettings.GENERATED_ANNOTATION_ADD, HibernateSearchProcessorSettings.GENERATED_ANNOTATION_TIMESTAMP, HibernateSearchProcessorSettings.BACKEND_VERSION })
@org.hibernate.search.util.common.annotation.impl.SuppressJQAssistant(reason = "JQAssistant has issue with detecting that getSupportedSourceVersion is an overridden method.")
public class HibernateSearchProcessor extends AbstractProcessor {

    private HibernateSearchMetamodelProcessorContext context;

    private List<MetamodelAnnotationProcessor> processors;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
