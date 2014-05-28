package org.proptest;

public class PropertyViolatedException extends RuntimeException {
    public PropertyViolatedException( Object faultyInput ) {
        super( "Property violated by input " + faultyInput );
    }
}
