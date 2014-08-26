/*
 * Copyright 2014 Harald Kraemer
 *
 * This file is part of "Multiple Threads Testing Disorder" or "MTDT".
 *
 * MTDT is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MTDT is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public License
 * along with MTDT.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.subquark.mtdt.generators;

import java.util.Random;

/**
 * The input generators in this class provide uniformly distributed values of their respective type.
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
