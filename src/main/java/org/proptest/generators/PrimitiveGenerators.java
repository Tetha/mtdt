package org.proptest.generators;

import java.util.Random;

/**
 * The input generators in this class provide uniformly distributed values of their respective type.
 * 
 * @author hkraemer
 *
 */
public class PrimitiveGenerators {
    public static final InputGenerator<Byte> BYTES = r -> {
        return (byte) (r.nextInt( Byte.MAX_VALUE + (-Byte.MIN_VALUE) + 1) + Byte.MIN_VALUE);
    };

    public static final InputGenerator<Short> SHORTS = r -> {
        return (short) (r.nextInt( Short.MAX_VALUE + (-Short.MIN_VALUE) + 1) + Short.MIN_VALUE);
    };

    public static final InputGenerator<Integer> INTEGERS = Random::nextInt;
    public static final InputGenerator<Long> LONGS = Random::nextLong;
    
    public static final InputGenerator<Float> FLOATS = Random::nextFloat;
    public static final InputGenerator<Double> DOUBLES = Random::nextDouble;
    
    public static final InputGenerator<Boolean> BOOLEANS = Random::nextBoolean;
}
