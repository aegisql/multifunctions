package com.aegisql.multifunction;

@FunctionalInterface
public interface ToInt4Function<A1,A2,A3,A4> {
    int applyAsInt(A1 arg1, A2 arg2, A3 arg3, A4 arg4);
}
