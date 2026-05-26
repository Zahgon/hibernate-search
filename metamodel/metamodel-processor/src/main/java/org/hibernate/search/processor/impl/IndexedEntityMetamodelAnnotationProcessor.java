/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.impl;

import static org.hibernate.search.processor.impl.ProcessorElementUtils.flattenedAnnotations;
import static org.hibernate.search.processor.impl.ProcessorElementUtils.propertyElements;
import static org.hibernate.search.processor.impl.ProcessorElementUtils.propertyName;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import org.hibernate.search.engine.backend.metamodel.IndexObjectFieldDescriptor;
import org.hibernate.search.engine.backend.metamodel.IndexValueFieldDescriptor;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.IdentifierBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.DefaultIdentifierBindingContext;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.IdentifierBinder;
import org.hibernate.search.mapper.pojo.bridge.runtime.IdentifierBridgeFromDocumentIdentifierContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.IdentifierBridgeToDocumentIdentifierContext;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.ProgrammaticMappingConfigurationContext;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.TypeMappingStep;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.standalone.bootstrap.spi.StandalonePojoIntegrationBooter;
import org.hibernate.search.mapper.pojo.standalone.cfg.StandalonePojoMapperSettings;
import org.hibernate.search.mapper.pojo.standalone.entity.SearchIndexedEntity;
import org.hibernate.search.mapper.pojo.standalone.mapping.CloseableSearchMapping;
import org.hibernate.search.mapper.pojo.standalone.mapping.StandalonePojoMappingConfigurer;
import org.hibernate.search.processor.annotation.processing.impl.ProcessorAnnotationProcessorContext;
import org.hibernate.search.processor.annotation.processing.impl.ProcessorPropertyMappingAnnotationProcessor;
import org.hibernate.search.processor.annotation.processing.impl.ProcessorTypeMappingAnnotationProcessor;
import org.hibernate.search.processor.mapping.impl.ProcessorIntrospectorContext;
import org.hibernate.search.processor.mapping.impl.ProcessorPojoModelsBootstrapIntrospector;
import org.hibernate.search.processor.model.impl.HibernateSearchProcessorEnum;
import org.hibernate.search.processor.writer.impl.MetamodelClassWriter;
import org.hibernate.search.processor.writer.impl.MetamodelNamesFormatter;
import org.hibernate.search.util.common.annotation.impl.SuppressJQAssistant;

public class IndexedEntityMetamodelAnnotationProcessor implements MetamodelAnnotationProcessor {

    private static final String ANNOTATION_INDEXED = "org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed";

    private final HibernateSearchMetamodelProcessorContext context;

    private final ProcessorIntrospectorContext introspectorContext;

    public IndexedEntityMetamodelAnnotationProcessor(HibernateSearchMetamodelProcessorContext context) {
        this.context = context;
        this.introspectorContext = new ProcessorIntrospectorContext(context);
    }

    @Override
    public void process(RoundEnvironment roundEnv) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void processTypeAndProperties(TypeElement typeElement, TypeMappingStep typeMappingContext, ProcessorAnnotationProcessorContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ProcessorPojoModelsBootstrapIntrospector wrapIntrospector(PojoBootstrapIntrospector introspector) {
        return new ProcessorPojoModelsBootstrapIntrospector(introspectorContext, introspector);
    }

    @SuppressJQAssistant(reason = "Need to cast to an impl type to get access to not-yet exposed method")
    private static class ProcessorIdentifierBinder implements IdentifierBinder {

        static ProcessorIdentifierBinder INSTANCE = new ProcessorIdentifierBinder();

        @SuppressWarnings({ "rawtypes", "unchecked" })
        @Override
        public void bind(IdentifierBindingContext<?> context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static class ProcessorIdentifierBridge implements IdentifierBridge<Object> {

            static ProcessorIdentifierBridge INSTANCE = new ProcessorIdentifierBridge();

            @Override
            public String toDocumentIdentifier(Object propertyValue, IdentifierBridgeToDocumentIdentifierContext context) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Object fromDocumentIdentifier(String documentIdentifier, IdentifierBridgeFromDocumentIdentifierContext context) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }
}
