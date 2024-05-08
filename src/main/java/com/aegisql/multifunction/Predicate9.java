/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;

/**
 * The interface Predicate 9.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 * @param <A6> the type parameter
 * @param <A7> the type parameter
 * @param <A8> the type parameter
 * @param <A9> the type parameter
 */
@FunctionalInterface
public interface Predicate9<A1,A2,A3,A4,A5,A6,A7,A8,A9> {
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
     * @param a8 the a 8
     * @param a9 the a 9
     * @return the boolean
     */
    boolean test(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9);

    /**
     * And predicate 9.
     *
     * @param other the other
     * @return the predicate 9
     */
    default Predicate9<A1,A2,A3,A4,A5,A6,A7,A8,A9> and(Predicate9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9) -> test(a1,a2,a3,a4,a5,a6,a7,a8,a9) && other.test(a1,a2,a3,a4,a5,a6,a7,a8,a9);
    }

    /**
     * Negate predicate 9.
     *
     * @return the predicate 9
     */
    default Predicate9<A1,A2,A3,A4,A5,A6,A7,A8,A9> negate() {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9) -> !test(a1,a2,a3,a4,a5,a6,a7,a8,a9);
    }

    /**
     * Or predicate 9.
     *
     * @param other the other
     * @return the predicate 9
     */
    default Predicate9<A1,A2,A3,A4,A5,A6,A7,A8,A9> or(Predicate9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9) -> test(a1,a2,a3,a4,a5,a6,a7,a8,a9) || other.test(a1,a2,a3,a4,a5,a6,a7,a8,a9);
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 9; }
}
