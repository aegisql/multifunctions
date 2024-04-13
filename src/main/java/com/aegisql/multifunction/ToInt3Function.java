package com.aegisql.multifunction;

@FunctionalInterface
public interface ToInt3Function<A1,A2,A3> {
    int applyAsInt(A1 arg1, A2 arg2, A3 arg3);
}
