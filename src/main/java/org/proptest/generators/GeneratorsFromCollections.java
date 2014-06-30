package org.proptest.generators;

import java.util.List;

public class GeneratorsFromCollections {
    public static <T> InputGenerator<T> oneOf( List<T> values ) {
        return r -> {
            int idx = r.nextInt( values.size() );
            return values.get( idx );
        };
    }
}
