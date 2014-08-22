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

import java.util.Random;

public final class ObjectGenerator {

    @FunctionalInterface
    public interface TrinaryConstructor<A,B,C,T> {
        T create(A a, B b, C c);
    }

    public static <A,B,C,T> InputGenerator<T> randomInstances( final TrinaryConstructor<A,B,C,T> factory,
                                                        final InputGenerator<A> aGen,
                                                        final InputGenerator<B> bGen,
                                                        final InputGenerator<C> cGen ) {
        return (Random r) -> {
            return factory.create( 
                            aGen.generateRandomInput( r ),
                            bGen.generateRandomInput( r ),
                            cGen.generateRandomInput( r ) );
        };
    }

    @FunctionalInterface
    public interface BinaryConstructor<A,B,T> {
        T create(A a, B b);
    }

    public static <A,B,T> InputGenerator<T> randomInstances( final BinaryConstructor<A,B,T> factory,
                                                        final InputGenerator<A> aGen,
                                                        final InputGenerator<B> bGen ) {
        return (Random r) -> {
            return factory.create(
                            aGen.generateRandomInput( r ),
                            bGen.generateRandomInput( r ) );
        };
    }
}
