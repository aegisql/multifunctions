package com.aegisql.multifunction;

import java.util.Objects;

@FunctionalInterface
public interface Predicate6<A1,A2,A3,A4,A5,A6> {
    boolean test(A1 a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6);

    default Predicate6<A1,A2,A3,A4,A5,A6> and(Predicate6<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6) -> test(a1,a2,a3,a4,a5,a6) && other.test(a1,a2,a3,a4,a5,a6);
    }

    default Predicate6<A1,A2,A3,A4,A5,A6> negate() {
        return (a1,a2,a3,a4,a5,a6) -> !test(a1,a2,a3,a4,a5,a6);
    }

    default Predicate6<A1,A2,A3,A4,A5,A6> or(Predicate6<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6) -> test(a1,a2,a3,a4,a5,a6) || other.test(a1,a2,a3,a4,a5,a6);
    }
}
