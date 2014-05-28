package org.proptest.generators;

import java.util.Random;
import java.util.function.Predicate;

@FunctionalInterface
public interface InputGenerator<T> {
    T generateRandomInput( Random r );
    
    default InputGenerator<T> butOnly( Predicate<T> predicate ) {
        return r -> {
            while ( true ) {
                T potentialOutput = generateRandomInput( r );
                if ( predicate.test( potentialOutput ) ) return potentialOutput;
            }
        };
    }
}
