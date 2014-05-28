package org.proptest;

import org.junit.Test;

public class PropTestTest {
    @Test( expected = PropertyViolatedException.class )
    public void testPropertyViolation() {
        PropTest.checkProperty(r -> r.nextInt(), i -> false);
    }
    

    
    @Test( expected=PropertyViolatedException.class )
    public void testExceptionsAreAnnotatedWithInput() {
        PropTest.checkProperty(r -> r.nextInt(), i -> { throw new NullPointerException(); });
    }
}
