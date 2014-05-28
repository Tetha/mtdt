package org.proptest;

public class PropertyViolatedException extends RuntimeException {
    public PropertyViolatedException( Object faultyInput ) {
        super( "Property violated by input " + faultyInput );
    }
    
    public PropertyViolatedException( Object faultyInput, Throwable cause ) {
        super( "Input caused error: " + faultyInput, cause );
    }
}
