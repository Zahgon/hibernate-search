/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.util.impl;

/**
 * Copied from {@code org.apache.lucene.util.SloppyMath} class of <a href="https://github.com/apache/lucene-solr">Apache Lucene project</a>.
 */
public class SloppyMath {

    private SloppyMath() {
    }

    /**
     * Returns the Haversine distance in meters between two points
     * specified in decimal degrees (latitude/longitude).  This works correctly
     * even if the dateline is between the two points.
     * <p>
     * Error is at most 4E-1 (40cm) from the actual haversine distance, but is typically
     * much smaller for reasonable distances: around 1E-5 (0.01mm) for distances less than
     * 1000km.
     *
     * @param lat1 Latitude of the first point.
     * @param lon1 Longitude of the first point.
     * @param lat2 Latitude of the second point.
     * @param lon2 Longitude of the second point.
     *
     * @return distance in meters.
     */
    public static double haversinMeters(double lat1, double lon1, double lat2, double lon2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the Haversine distance in meters between two points
     * given the previous result from {@link #haversinSortKey(double, double, double, double)}
     *
     * @return distance in meters.
     */
    public static double haversinMeters(double sortKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a sort key for distance. This is less expensive to compute than
     * {@link #haversinMeters(double, double, double, double)}, but it always compares the same.
     * This can be converted into an actual distance with {@link #haversinMeters(double)}, which
     * effectively does the second half of the computation.
     */
    public static double haversinSortKey(double lat1, double lon1, double lat2, double lon2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the trigonometric cosine of an angle.
     * <p>
     * Error is around 1E-15.
     * <p>
     * Special cases:
     * <ul>
     *  <li>If the argument is {@code NaN} or an infinity, then the result is {@code NaN}.
     * </ul>
     *
     * @param a an angle, in radians.
     *
     * @return the cosine of the argument.
     *
     * @see Math#cos(double)
     */
    public static double cos(double a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the arc sine of a value.
     * <p>
     * The returned angle is in the range <i>-pi</i>/2 through <i>pi</i>/2.
     * Error is around 1E-7.
     * <p>
     * Special cases:
     * <ul>
     *  <li>If the argument is {@code NaN} or its absolute value is greater than 1, then the result is {@code NaN}.
     * </ul>
     *
     * @param a the value whose arc sine is to be returned.
     *
     * @return arc sine of the argument
     *
     * @see Math#asin(double)
     */
    // because asin(-x) = -asin(x), asin(x) only needs to be computed on [0,1].
    // ---> we only have to compute asin(x) on [0,1].
    // For values not close to +-1, we use look-up tables;
    // for values near +-1, we use code derived from fdlibm.
    public static double asin(double a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Earth's mean radius, in meters and kilometers; see http://earth-info.nga.mil/GandG/publications/tr8350.2/wgs84fin.pdf
    // equatorial radius
    private static final double TO_METERS = 6_371_008.7714D;

    // cos/asin
    private static final double ONE_DIV_F2 = 1 / 2.0;

    private static final double ONE_DIV_F3 = 1 / 6.0;

    private static final double ONE_DIV_F4 = 1 / 24.0;

    private static final double PIO2_HI = Double.longBitsToDouble(// 1.57079632673412561417e+00 first 33 bits of pi/2
    0x3FF921FB54400000L);

    private static final double PIO2_LO = Double.longBitsToDouble(// 6.07710050650619224932e-11 pi/2 - PIO2_HI
    0x3DD0B4611A626331L);

    private static final double TWOPI_HI = 4 * PIO2_HI;

    private static final double TWOPI_LO = 4 * PIO2_LO;

    private static final int SIN_COS_TABS_SIZE = (1 << 11) + 1;

    private static final double SIN_COS_DELTA_HI = TWOPI_HI / (SIN_COS_TABS_SIZE - 1);

    private static final double SIN_COS_DELTA_LO = TWOPI_LO / (SIN_COS_TABS_SIZE - 1);

    private static final double SIN_COS_INDEXER = 1 / (SIN_COS_DELTA_HI + SIN_COS_DELTA_LO);

    private static final double[] sinTab = new double[SIN_COS_TABS_SIZE];

    private static final double[] cosTab = new double[SIN_COS_TABS_SIZE];

    // Max abs value for fast modulo, above which we use regular angle normalization.
    // This value must be < (Integer.MAX_VALUE / SIN_COS_INDEXER), to stay in range of int type.
    // The higher it is, the higher the error, but also the faster it is for lower values.
    // If you set it to ((Integer.MAX_VALUE / SIN_COS_INDEXER) * 0.99), worse accuracy on double range is about 1e-10.
    static final double SIN_COS_MAX_VALUE_FOR_INT_MODULO = ((Integer.MAX_VALUE >> 9) / SIN_COS_INDEXER) * 0.99;

    // Supposed to be >= sin(77.2deg), as fdlibm code is supposed to work with values > 0.975,
    // but seems to work well enough as long as value >= sin(25deg).
    private static final double ASIN_MAX_VALUE_FOR_TABS = StrictMath.sin(Math.toRadians(73.0));

    private static final int ASIN_TABS_SIZE = (1 << 13) + 1;

    private static final double ASIN_DELTA = ASIN_MAX_VALUE_FOR_TABS / (ASIN_TABS_SIZE - 1);

    private static final double ASIN_INDEXER = 1 / ASIN_DELTA;

    private static final double[] asinTab = new double[ASIN_TABS_SIZE];

    private static final double[] asinDer1DivF1Tab = new double[ASIN_TABS_SIZE];

    private static final double[] asinDer2DivF2Tab = new double[ASIN_TABS_SIZE];

    private static final double[] asinDer3DivF3Tab = new double[ASIN_TABS_SIZE];

    private static final double[] asinDer4DivF4Tab = new double[ASIN_TABS_SIZE];

    private static final double ASIN_PIO2_HI = Double.longBitsToDouble(// 1.57079632679489655800e+00
    0x3FF921FB54442D18L);

    private static final double ASIN_PIO2_LO = Double.longBitsToDouble(// 6.12323399573676603587e-17
    0x3C91A62633145C07L);

    private static final double ASIN_PS0 = Double.longBitsToDouble(//  1.66666666666666657415e-01
    0x3fc5555555555555L);

    private static final double ASIN_PS1 = Double.longBitsToDouble(// -3.25565818622400915405e-01
    0xbfd4d61203eb6f7dL);

    private static final double ASIN_PS2 = Double.longBitsToDouble(//  2.01212532134862925881e-01
    0x3fc9c1550e884455L);

    private static final double ASIN_PS3 = Double.longBitsToDouble(// -4.00555345006794114027e-02
    0xbfa48228b5688f3bL);

    private static final double ASIN_PS4 = Double.longBitsToDouble(//  7.91534994289814532176e-04
    0x3f49efe07501b288L);

    private static final double ASIN_PS5 = Double.longBitsToDouble(//  3.47933107596021167570e-05
    0x3f023de10dfdf709L);

    private static final double ASIN_QS1 = Double.longBitsToDouble(// -2.40339491173441421878e+00
    0xc0033a271c8a2d4bL);

    private static final double ASIN_QS2 = Double.longBitsToDouble(//  2.02094576023350569471e+00
    0x40002ae59c598ac8L);

    private static final double ASIN_QS3 = Double.longBitsToDouble(// -6.88283971605453293030e-01
    0xbfe6066c1b8d0159L);

    private static final double ASIN_QS4 = Double.longBitsToDouble(//  7.70381505559019352791e-02
    0x3fb3b8c5b12e9282L);

    /* Initializes look-up tables. */
    static {
        // sin and cos
        final int SIN_COS_PI_INDEX = (SIN_COS_TABS_SIZE - 1) / 2;
        final int SIN_COS_PI_MUL_2_INDEX = 2 * SIN_COS_PI_INDEX;
        final int SIN_COS_PI_MUL_0_5_INDEX = SIN_COS_PI_INDEX / 2;
        final int SIN_COS_PI_MUL_1_5_INDEX = 3 * SIN_COS_PI_INDEX / 2;
        for (int i = 0; i < SIN_COS_TABS_SIZE; i++) {
            // angle: in [0,2*PI].
            double angle = i * SIN_COS_DELTA_HI + i * SIN_COS_DELTA_LO;
            double sinAngle = StrictMath.sin(angle);
            double cosAngle = StrictMath.cos(angle);
            // For indexes corresponding to null cosine or sine, we make sure the value is zero
            // and not an epsilon. This allows for a much better accuracy for results close to zero.
            if (i == SIN_COS_PI_INDEX) {
                sinAngle = 0.0;
            } else if (i == SIN_COS_PI_MUL_2_INDEX) {
                sinAngle = 0.0;
            } else if (i == SIN_COS_PI_MUL_0_5_INDEX) {
                cosAngle = 0.0;
            } else if (i == SIN_COS_PI_MUL_1_5_INDEX) {
                cosAngle = 0.0;
            }
            sinTab[i] = sinAngle;
            cosTab[i] = cosAngle;
        }
        // asin
        for (int i = 0; i < ASIN_TABS_SIZE; i++) {
            // x: in [0,ASIN_MAX_VALUE_FOR_TABS].
            double x = i * ASIN_DELTA;
            asinTab[i] = StrictMath.asin(x);
            double oneMinusXSqInv = 1.0 / (1 - x * x);
            double oneMinusXSqInv0_5 = StrictMath.sqrt(oneMinusXSqInv);
            double oneMinusXSqInv1_5 = oneMinusXSqInv0_5 * oneMinusXSqInv;
            double oneMinusXSqInv2_5 = oneMinusXSqInv1_5 * oneMinusXSqInv;
            double oneMinusXSqInv3_5 = oneMinusXSqInv2_5 * oneMinusXSqInv;
            asinDer1DivF1Tab[i] = oneMinusXSqInv0_5;
            asinDer2DivF2Tab[i] = (x * oneMinusXSqInv1_5) * ONE_DIV_F2;
            asinDer3DivF3Tab[i] = ((1 + 2 * x * x) * oneMinusXSqInv2_5) * ONE_DIV_F3;
            asinDer4DivF4Tab[i] = ((5 + 2 * x * (2 + x * (5 - 2 * x))) * oneMinusXSqInv3_5) * ONE_DIV_F4;
        }
    }
}
