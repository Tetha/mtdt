package org.proptest.generators;

public class FilterTooStrictException extends RuntimeException {
    public FilterTooStrictException( int numTries ) {
        super( "Couldn't find a suitable input after " + numTries + " tries. Your filters are probably too strict - write your own generator." );
    }
}
