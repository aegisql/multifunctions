/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;
@FunctionalInterface
public interface ToInt4Function<A1,A2,A3,A4> {
    int applyAsInt(A1 a1,A2 a2,A3 a3,A4 a4);
}
