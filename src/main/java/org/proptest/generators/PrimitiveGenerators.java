package org.proptest.generators;

import java.util.Random;

public class PrimitiveGenerators {
 
    public static final InputGenerator<Integer> INTEGERS = Random::nextInt;
    public static final InputGenerator<Long> LONGS = Random::nextLong;
    
}
