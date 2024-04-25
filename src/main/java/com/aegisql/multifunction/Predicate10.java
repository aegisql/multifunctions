package com.aegisql.multifunction;

import java.util.Objects;

@FunctionalInterface
public interface Predicate10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> {
    boolean test(A1 a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10);

    default Predicate10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> and(Predicate10<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7, ? super A8, ? super A9, ? super A10> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) -> test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) && other.test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

    default Predicate10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> negate() {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) -> !test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

    default Predicate10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> or(Predicate10<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7, ? super A8, ? super A9, ? super A10> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) -> test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) || other.test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }
}