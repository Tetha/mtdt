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
package org.proptest;

import java.util.Random;
import java.util.function.Predicate;

import org.proptest.generators.InputGenerator;

public class PropTest {
    private static Random r = new Random();
    private static int MAX_TRIES = 100;
    
    public static <T> void checkProperty( InputGenerator<T> exampleGenerator, Predicate<T> property ) {
        for ( int i = 0; i < MAX_TRIES; i++ ) {
            T randomInput = exampleGenerator.generateRandomInput( r );
            
            boolean propertyHolds;
            try {
                propertyHolds = property.test( randomInput );
            } catch ( Exception e ) {
                throw new PropertyViolatedException( randomInput, e );
            }
            if ( !propertyHolds ) throw new PropertyViolatedException( randomInput );
        }
    }
    
    public static final InputGenerator<Integer> INTEGERS = Random::nextInt;
    public static final InputGenerator<Long> LONGS = Random::nextLong;
    public static final InputGenerator<Double> DOUBLES = Random::nextDouble;
}
