package com.aegisql.multifunction;

import java.util.Objects;

@FunctionalInterface
public interface Predicate4<A1,A2,A3,A4>{
    boolean test(A1 arg1, A2 arg2, A3 arg3, A4 arg4);

    default Predicate4<A1,A2,A3,A4> and(Predicate4<? super A1, ? super A2, ? super A3, ? super A4> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4) -> test(a1, a2, a3, a4) && other.test(a1, a2, a3, a4);
    }

    default Predicate4<A1, A2, A3, A4> negate() {
        return (a1,a2,a3,a4) -> !test(a1,a2,a3,a4);
    }

    default Predicate4<A1, A2, A3, A4> or(Predicate4<? super A1, ? super A2, ? super A3, ? super A4> other) {
        Objects.requireNonNull(other);
        return (a1,a2,a3,a4) -> test(a1, a2, a3, a4) || other.test(a1, a2, a3, a4);
    }

}
