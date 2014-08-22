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

package org.proptest.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface InputGenerator<T> {
    T generateRandomInput( Random r );

    /**
     * Tries to get an input from the generator which fulfills the predicate, but at most 100 tries.
     * 
     * This merely invokes {@link InputGenerator.butOnly} with a default value for maxTries.
     * 
     * @param predicate only inputs fulfilling this predicate are returned
     * @return an input generator which only returns outputs which fulfill the predicate
     */
    default InputGenerator<T> butOnly( Predicate<T> predicate ) {
        return butOnly( predicate, 100 );
    }

    /**
     * Tries to get an input from the generator which fulfills the predicate, but at most maxTries.
     * 
     * This method is used to slightly reduce the output set of a generator, for example to
     * reduce the generator for all integers to a generator of positive numbers or a generator
     * of even or odd numbers. 
     * 
     * In order to avoid hanging tests, at most maxTries many inputs are fetched and if the 
     * predicate never accepted an input, the test is aborted. This can have two causes, 
     * either your predicate is wrong and never accepts the inputs you want - or your
     * predicate is too strict. If your predicate is too strict, you need to make a 
     * constructive generator which simply creates the output you need. 
     * 
     * @param predicate only inputs fulfilling this predicate are returned
     * @param maxTries only this many attempts are tried
     * @return an input generator which only returns outputs which fulfill the predicate
     */
    default InputGenerator<T> butOnly( Predicate<T> predicate, int maxTries ) {
        return r -> {
            for ( int i = 0; i < maxTries; i++ ) {
                T potentialOutput = generateRandomInput( r );
                if ( predicate.test( potentialOutput ) ) return potentialOutput;
            }
            throw new FilterTooStrictException( maxTries );
        };
    }

    default <R> InputGenerator<R> forEach( Function<T, R> f ) {
        return r -> {
            T output = generateRandomInput( r );
            return f.apply( output );
        };
    }

    default InputGenerator<List<T>> repeat( int min, int max ) {
        return r -> {
            int length = r.nextInt( max - min ) + min;
            List<T> result = new ArrayList<>(length);
            for ( int i = 0; i < length; i++ ) {
                result.add( generateRandomInput(r) );
            }
            return result;
        };
    }
}
