/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction.generator;

import static com.aegisql.multifunction.generator.ArgUtils.*;

public class PredicateGenerator {

    private static void generate(int fN) {

        String className = "Predicate"+fN;

        String code = STR."""
/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction.tmp;

import java.util.Objects;

@FunctionalInterface
public interface \{className}<\{types(fN)}> {
    boolean test(\{typedArgs(fN)});

    default \{className}<\{types(fN)}> and(\{className}<\{superTypes(fN)}> other) {
        Objects.requireNonNull(other);
        return (\{args(fN)}) -> test(\{args(fN)}) && other.test(\{args(fN)});
    }

    default \{className}<\{types(fN)}> negate() {
        return (\{args(fN)}) -> !test(\{args(fN)});
    }

    default \{className}<\{types(fN)}> or(\{className}<\{superTypes(fN)}> other) {
        Objects.requireNonNull(other);
        return (\{args(fN)}) -> test(\{args(fN)}) || other.test(\{args(fN)});
    }

    default int arity() { return \{fN}; }
}
                """;

        saveClass(className,code);
    }

    public static void main(String[] args) {
            for(int i = 3; i <=10; i++) {
                generate(i);
            }
    }

}
