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
 * This utililty class is the main way to generate custom objects.
 *
 * The idea behind this class is to pick a constructor of a class
 * to generate instances from. In this class, you pick
 * a constructor and supply an input generator for each of the
 * parameters. Generators from here will tie the generators
 * and the constructor together to make a generator for the objects.
 *
 * There is no function for unary constructors, because unary 
 * constructors can be handled through InputGenerator.forEach.
 */
public final class ObjectGenerator {

    @FunctionalInterface
    public interface PentaryConstructor<A,B,C,D,E,T> {
        T create(A a, B b, C c, D d, E e);
    }
    
    public static <A,B,C,D,E,T> InputGenerator<T> randomInstances( final PentaryConstructor<A,B,C,D,E,T> factory,
                                                        final InputGenerator<A> aGen,
                                                        final InputGenerator<B> bGen,
                                                        final InputGenerator<C> cGen,
                                                        final InputGenerator<D> dGen,
                                                        final InputGenerator<E> eGen ) {
        return (Random r) -> {
            return factory.create( 
                            aGen.generateRandomInput( r ),
                            bGen.generateRandomInput( r ),
                            cGen.generateRandomInput( r ),
                            dGen.generateRandomInput( r ),
                            eGen.generateRandomInput( r ) );
        };
    }

    @FunctionalInterface
    public interface QuartaryConstructor<A,B,C,D,T> {
        T create(A a, B b, C c, D d);
    }

    public static <A,B,C,D,T> InputGenerator<T> randomInstances( final QuartaryConstructor<A,B,C,D,T> factory,
                                                        final InputGenerator<A> aGen,
                                                        final InputGenerator<B> bGen,
                                                        final InputGenerator<C> cGen,
                                                        final InputGenerator<D> dGen ) {
        return (Random r) -> {
            return factory.create( 
                            aGen.generateRandomInput( r ),
                            bGen.generateRandomInput( r ),
                            cGen.generateRandomInput( r ),
                            dGen.generateRandomInput( r ) );
        };
    }

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
