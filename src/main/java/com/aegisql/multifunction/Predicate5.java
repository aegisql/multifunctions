/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;

@FunctionalInterface
public interface Predicate5<A1,A2,A3,A4,A5> {
    boolean test(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5);

    default Predicate5<A1,A2,A3,A4,A5> and(Predicate5<? super A1,? super A2,? super A3,? super A4,? super A5> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5) -> test(a1,a2,a3,a4,a5) && other.test(a1,a2,a3,a4,a5);
    }

    default Predicate5<A1,A2,A3,A4,A5> negate() {
        return (a1,a2,a3,a4,a5) -> !test(a1,a2,a3,a4,a5);
    }

    default Predicate5<A1,A2,A3,A4,A5> or(Predicate5<? super A1,? super A2,? super A3,? super A4,? super A5> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5) -> test(a1,a2,a3,a4,a5) || other.test(a1,a2,a3,a4,a5);
    }
}
