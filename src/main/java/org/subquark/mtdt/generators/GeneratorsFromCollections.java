/*
 * Copyright 2014 Harald Kraemer
 *
 * This file is part of "Multiple Threads Testing Disorder" or "MTDT".
 *
 * MTDT is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MTDT is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public License
 * along with MTDT.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.subquark.mtdt.generators;

import java.util.List;

/**
 * This class contains generators based on the Java Collections Framework.
 */
public class GeneratorsFromCollections {
    private GeneratorsFromCollections() {
        /* static class. */
    }

    /**
     * Randomly chooses one of the elements in the list according to a uniform distribution.
     */
    public static <T> InputGenerator<T> oneOf( List<T> values ) {
        if ( values == null ) throw new NullPointerException();

        return r -> {
            int idx = r.nextInt( values.size() );
            return values.get( idx );
        };
    }
}
