/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;

/**
 * The interface Predicate 7.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 * @param <A6> the type parameter
 * @param <A7> the type parameter
 */
@FunctionalInterface
public interface Predicate7<A1,A2,A3,A4,A5,A6,A7> {
    /**
     * Test boolean.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     * @param a7 the a 7
     * @return the boolean
     */
    boolean test(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7);

    /**
     * And predicate 7.
     *
     * @param other the other
     * @return the predicate 7
     */
    default Predicate7<A1,A2,A3,A4,A5,A6,A7> and(Predicate7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6,a7) -> test(a1,a2,a3,a4,a5,a6,a7) && other.test(a1,a2,a3,a4,a5,a6,a7);
    }

    /**
     * Negate predicate 7.
     *
     * @return the predicate 7
     */
    default Predicate7<A1,A2,A3,A4,A5,A6,A7> negate() {
        return (a1,a2,a3,a4,a5,a6,a7) -> !test(a1,a2,a3,a4,a5,a6,a7);
    }

    /**
     * Or predicate 7.
     *
     * @param other the other
     * @return the predicate 7
     */
    default Predicate7<A1,A2,A3,A4,A5,A6,A7> or(Predicate7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6,a7) -> test(a1,a2,a3,a4,a5,a6,a7) || other.test(a1,a2,a3,a4,a5,a6,a7);
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 7; }
}
