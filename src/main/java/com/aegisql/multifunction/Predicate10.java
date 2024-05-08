/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;

/**
 * The interface Predicate 10.
 *
 * @param <A1>  the type parameter
 * @param <A2>  the type parameter
 * @param <A3>  the type parameter
 * @param <A4>  the type parameter
 * @param <A5>  the type parameter
 * @param <A6>  the type parameter
 * @param <A7>  the type parameter
 * @param <A8>  the type parameter
 * @param <A9>  the type parameter
 * @param <A10> the type parameter
 */
@FunctionalInterface
public interface Predicate10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> {
    /**
     * Test boolean.
     *
     * @param a1  the a 1
     * @param a2  the a 2
     * @param a3  the a 3
     * @param a4  the a 4
     * @param a5  the a 5
     * @param a6  the a 6
     * @param a7  the a 7
     * @param a8  the a 8
     * @param a9  the a 9
     * @param a10 the a 10
     * @return the boolean
     */
    boolean test(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10);

    /**
     * And predicate 10.
     *
     * @param other the other
     * @return the predicate 10
     */
    default Predicate10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> and(Predicate10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) -> test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) && other.test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

    /**
     * Negate predicate 10.
     *
     * @return the predicate 10
     */
    default Predicate10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> negate() {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) -> !test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

    /**
     * Or predicate 10.
     *
     * @param other the other
     * @return the predicate 10
     */
    default Predicate10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> or(Predicate10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) -> test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) || other.test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 10; }
}
