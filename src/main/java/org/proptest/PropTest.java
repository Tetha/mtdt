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
    
    public static final InputGenerator<Integer> INTEGERS = r -> r.nextInt();
    public static final InputGenerator<Long> LONGS = r -> r.nextLong();
    public static final InputGenerator<Double> DOUBLES = r -> r.nextDouble();
}
