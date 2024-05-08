/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;

/**
 * The interface Predicate 6.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 * @param <A6> the type parameter
 */
@FunctionalInterface
public interface Predicate6<A1,A2,A3,A4,A5,A6> {
    /**
     * Test boolean.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     * @return the boolean
     */
    boolean test(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6);

    /**
     * And predicate 6.
     *
     * @param other the other
     * @return the predicate 6
     */
    default Predicate6<A1,A2,A3,A4,A5,A6> and(Predicate6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6) -> test(a1,a2,a3,a4,a5,a6) && other.test(a1,a2,a3,a4,a5,a6);
    }

    /**
     * Negate predicate 6.
     *
     * @return the predicate 6
     */
    default Predicate6<A1,A2,A3,A4,A5,A6> negate() {
        return (a1,a2,a3,a4,a5,a6) -> !test(a1,a2,a3,a4,a5,a6);
    }

    /**
     * Or predicate 6.
     *
     * @param other the other
     * @return the predicate 6
     */
    default Predicate6<A1,A2,A3,A4,A5,A6> or(Predicate6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6) -> test(a1,a2,a3,a4,a5,a6) || other.test(a1,a2,a3,a4,a5,a6);
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 6; }
}
