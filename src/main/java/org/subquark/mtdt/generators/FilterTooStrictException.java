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

/**
 * Thrown if the system can't find an input after a number of tries.
 *
 * MTDT can create new filters by filtering existing generators 
 * down to a desired subset. However, MTDT doesn't know anthing
 * about the generators, so MTDT has to generate an element,
 * check if the predicate likes it and start over if it doesn't.
 * <p>
 * This works fine for permissive predicates, which accept
 * every other element on average, but if your predicate allows
 * 1 element per thousand, finding this element will take a
 * long time. Thus, after some amount of retries, this
 * exception is raised.
 */
public class FilterTooStrictException extends RuntimeException {
    public FilterTooStrictException( int numTries ) {
        super( "Couldn't find a suitable input after " + numTries + " tries. Your filters are probably too strict - write your own generator." );
    }
}
