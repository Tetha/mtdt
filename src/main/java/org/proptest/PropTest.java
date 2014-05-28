package org.proptest;

import java.util.Random;
import java.util.function.Predicate;

import org.proptest.generators.InputGenerator;

public class PropTest {
    private static Random r = new Random();
    private static int MAX_TRIES = 100;
    
    public static <T> void checkProperty( InputGenerator<T> exampleGenerator, Predicate<T> property ) {
        for ( int i = 0; i < 100; i++ ) {
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
}
