/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

/**
 * The interface To int 6 function.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 * @param <A6> the type parameter
 */
@FunctionalInterface
public interface ToInt6Function<A1,A2,A3,A4,A5,A6> {
    /**
     * Apply as int int.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     * @return the int
     */
    int applyAsInt(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6);
}
