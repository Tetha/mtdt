package org.proptest.generators;

import org.junit.Test;
import org.proptest.PropTest;

public class GeneratorFilteringTest {
    @Test
    public void testFiltering() {
        PropTest.checkProperty(PrimitiveGenerators.INTEGERS.butOnly( i -> i % 2 == 0), 
                               i -> i % 2 == 0);
    }
    
    @Test( timeout = 200, expected = FilterTooStrictException.class )
    public void testTooStrictFiltering() {
        PropTest.checkProperty(PrimitiveGenerators.INTEGERS.butOnly( i -> i == Integer.MAX_VALUE-1),
                               i -> true);
    }
}
