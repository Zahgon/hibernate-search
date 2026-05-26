/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.spatial.impl;

import static java.util.function.Predicate.isEqual;
import java.util.function.Function;
import java.util.stream.Collector;
import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.engine.backend.document.IndexFieldReference;
import org.hibernate.search.engine.backend.document.model.dsl.IndexSchemaElement;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFactory;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.mapper.pojo.bridge.PropertyBridge;
import org.hibernate.search.mapper.pojo.bridge.TypeBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.TypeBindingContext;
import org.hibernate.search.mapper.pojo.bridge.builtin.programmatic.GeoPointBinder;
import org.hibernate.search.mapper.pojo.bridge.runtime.PropertyBridgeWriteContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.TypeBridgeWriteContext;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.PojoElementAccessor;
import org.hibernate.search.mapper.pojo.model.PojoModelCompositeElement;
import org.hibernate.search.util.common.impl.StreamHelper;

public class GeoPointBridge implements TypeBridge<Object>, PropertyBridge<Object> {

    private final Function<Object, GeoPoint> coordinatesExtractor;

    private final IndexFieldReference<GeoPoint> indexFieldReference;

    /**
     * Private constructor, use {@link GeoPointBinder#create()} instead.
     */
    private GeoPointBridge(Function<Object, GeoPoint> coordinatesExtractor, IndexFieldReference<GeoPoint> indexFieldReference) {
        this.coordinatesExtractor = coordinatesExtractor;
        this.indexFieldReference = indexFieldReference;
    }

    @Override
    public void write(DocumentElement target, Object bridgedElement, TypeBridgeWriteContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(DocumentElement target, Object bridgedElement, PropertyBridgeWriteContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void doWrite(DocumentElement target, Object bridgedElement) {
        GeoPoint coordinates = coordinatesExtractor.apply(bridgedElement);
        target.addValue(indexFieldReference, coordinates);
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Binder implements GeoPointBinder {

        private String fieldName;

        private Projectable projectable = Projectable.DEFAULT;

        private Sortable sortable = Sortable.DEFAULT;

        private String markerSet;

        @Override
        public Binder fieldName(String fieldName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Binder projectable(Projectable projectable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Binder sortable(Sortable sortable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Binder markerSet(String markerSet) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void bind(TypeBindingContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void bind(PropertyBindingContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private GeoPointBridge doBind(String defaultedFieldName, IndexFieldTypeFactory typeFactory, IndexSchemaElement indexSchemaElement, PojoModelCompositeElement bridgedPojoModelElement) {
            IndexFieldReference<GeoPoint> indexFieldReference = indexSchemaElement.field(defaultedFieldName, typeFactory.asGeoPoint().projectable(projectable).sortable(sortable).toIndexFieldType()).toReference();
            Function<Object, GeoPoint> coordinatesExtractor;
            PojoElementAccessor<Double> latitudeAccessor = bridgedPojoModelElement.properties().stream().filter(model -> model.markers(LatitudeMarker.class).stream().map(LatitudeMarker::getMarkerSet).anyMatch(isEqual(markerSet))).collect(singleMarkedProperty("@Latitude", defaultedFieldName, markerSet)).createAccessor(Double.class);
            PojoElementAccessor<Double> longitudeAccessor = bridgedPojoModelElement.properties().stream().filter(model -> model.markers(LongitudeMarker.class).stream().map(LongitudeMarker::getMarkerSet).anyMatch(isEqual(markerSet))).collect(singleMarkedProperty("@Longitude", defaultedFieldName, markerSet)).createAccessor(Double.class);
            coordinatesExtractor = bridgedElement -> {
                Double latitude = latitudeAccessor.read(bridgedElement);
                Double longitude = longitudeAccessor.read(bridgedElement);
                if (latitude == null || longitude == null) {
                    return null;
                }
                return GeoPoint.of(latitude, longitude);
            };
            return new GeoPointBridge(coordinatesExtractor, indexFieldReference);
        }

        private static Collector<PojoModelCompositeElement, ?, PojoModelCompositeElement> singleMarkedProperty(String markerName, String fieldName, String markerSet) {
            return StreamHelper.singleElement(() -> MappingLog.INSTANCE.unableToFindLongitudeOrLatitudeProperty(markerName, fieldName, markerSet), () -> MappingLog.INSTANCE.multipleLatitudeOrLongitudeProperties(markerName, fieldName, markerSet));
        }
    }
}
