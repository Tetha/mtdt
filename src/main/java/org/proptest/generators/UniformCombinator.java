package org.proptest.generators;

public class UniformCombinator {
    @SafeVarargs
    public static <T> InputGenerator<T> uniform( InputGenerator<T>... children ) {
        return r -> {
            int idx = r.nextInt(children.length);
            return children[idx].generateRandomInput(r);
        };
    }
}
