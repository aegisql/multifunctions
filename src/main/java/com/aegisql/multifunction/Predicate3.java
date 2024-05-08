/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;

/**
 * The interface Predicate 3.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 */
@FunctionalInterface
public interface Predicate3<A1,A2,A3> {
    /**
     * Test boolean.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @return the boolean
     */
    boolean test(A1 a1,A2 a2,A3 a3);

    /**
     * And predicate 3.
     *
     * @param other the other
     * @return the predicate 3
     */
    default Predicate3<A1,A2,A3> and(Predicate3<? super A1,? super A2,? super A3> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3) -> test(a1,a2,a3) && other.test(a1,a2,a3);
    }

    /**
     * Negate predicate 3.
     *
     * @return the predicate 3
     */
    default Predicate3<A1,A2,A3> negate() {
        return (a1,a2,a3) -> !test(a1,a2,a3);
    }

    /**
     * Or predicate 3.
     *
     * @param other the other
     * @return the predicate 3
     */
    default Predicate3<A1,A2,A3> or(Predicate3<? super A1,? super A2,? super A3> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3) -> test(a1,a2,a3) || other.test(a1,a2,a3);
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 3; }
}
