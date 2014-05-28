package org.proptest.generators;

import java.util.Random;

@FunctionalInterface
public interface InputGenerator<T> {
    T generateRandomInput( Random r );
}
