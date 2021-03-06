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
package org.subquark.mtdt;;

import org.junit.Test;

public class MtdtTest {
    @Test( expected = PropertyViolatedException.class )
    public void testPropertyViolation() {
        Mtdt.checkProperty(r -> r.nextInt(), i -> false);
    }
    

    
    @Test( expected=PropertyViolatedException.class )
    public void testExceptionsAreAnnotatedWithInput() {
        Mtdt.checkProperty(r -> r.nextInt(), i -> { throw new NullPointerException(); });
    }
}
