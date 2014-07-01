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
