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

import org.junit.Test;
import org.subquark.mtdt.Mtdt;

public class GeneratorFilteringTest {
    @Test
    public void testFiltering() {
        Mtdt.checkProperty(PrimitiveGenerators.INTEGERS.butOnly( i -> i % 2 == 0), 
                           i -> i % 2 == 0);
    }
    
    @Test( timeout = 200, expected = FilterTooStrictException.class )
    public void testTooStrictFiltering() {
        Mtdt.checkProperty(PrimitiveGenerators.INTEGERS.butOnly( i -> i == Integer.MAX_VALUE-1),
                           i -> true);
    }
}
