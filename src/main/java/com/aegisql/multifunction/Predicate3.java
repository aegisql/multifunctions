/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;

@FunctionalInterface
public interface Predicate3<A1,A2,A3> {
    boolean test(A1 a1,A2 a2,A3 a3);

    default Predicate3<A1,A2,A3> and(Predicate3<? super A1,? super A2,? super A3> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3) -> test(a1,a2,a3) && other.test(a1,a2,a3);
    }

    default Predicate3<A1,A2,A3> negate() {
        return (a1,a2,a3) -> !test(a1,a2,a3);
    }

    default Predicate3<A1,A2,A3> or(Predicate3<? super A1,? super A2,? super A3> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3) -> test(a1,a2,a3) || other.test(a1,a2,a3);
    }
}
