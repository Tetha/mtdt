package org.proptest.generators;

import java.util.Random;
import java.util.function.Predicate;

@FunctionalInterface
public interface InputGenerator<T> {
    T generateRandomInput( Random r );
    
    default InputGenerator<T> butOnly( Predicate<T> predicate ) {
        return butOnly( predicate, 100 );
    }
    
    default InputGenerator<T> butOnly( Predicate<T> predicate, int maxTries ) {
        return r -> {
            for ( int i = 0; i < maxTries; i++ ) {
                T potentialOutput = generateRandomInput( r );
                if ( predicate.test( potentialOutput ) ) return potentialOutput;
            }
            throw new FilterTooStrictException( maxTries );
        };
    }
}
