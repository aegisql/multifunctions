/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;

/**
 * The interface Predicate 4.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 */
@FunctionalInterface
public interface Predicate4<A1,A2,A3,A4> {
    /**
     * Test boolean.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @return the boolean
     */
    boolean test(A1 a1,A2 a2,A3 a3,A4 a4);

    /**
     * And predicate 4.
     *
     * @param other the other
     * @return the predicate 4
     */
    default Predicate4<A1,A2,A3,A4> and(Predicate4<? super A1,? super A2,? super A3,? super A4> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4) -> test(a1,a2,a3,a4) && other.test(a1,a2,a3,a4);
    }

    /**
     * Negate predicate 4.
     *
     * @return the predicate 4
     */
    default Predicate4<A1,A2,A3,A4> negate() {
        return (a1,a2,a3,a4) -> !test(a1,a2,a3,a4);
    }

    /**
     * Or predicate 4.
     *
     * @param other the other
     * @return the predicate 4
     */
    default Predicate4<A1,A2,A3,A4> or(Predicate4<? super A1,? super A2,? super A3,? super A4> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4) -> test(a1,a2,a3,a4) || other.test(a1,a2,a3,a4);
    }
}
