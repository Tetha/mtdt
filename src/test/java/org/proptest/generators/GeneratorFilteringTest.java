package org.proptest.generators;

import org.junit.Test;
import org.proptest.PropTest;

public class GeneratorFilteringTest {
    @Test
    public void testFiltering() {
        PropTest.checkProperty(PropTest.INTEGERS.butOnly( i -> i % 2 == 0), 
                               i -> i % 2 == 0);
    }
}
