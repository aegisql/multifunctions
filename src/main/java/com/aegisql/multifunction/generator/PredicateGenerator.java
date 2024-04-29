package com.aegisql.multifunction.generator;

import static com.aegisql.multifunction.generator.ArgUtils.*;

public class PredicateGenerator {

    private static void generate(int functionNumber) {

        String className = "Predicate"+functionNumber;

        String code = STR."""
package com.aegisql.multifunction.tmp;

import java.util.Objects;

@FunctionalInterface
public interface \{className}<\{types(functionNumber)}> {
    boolean test(\{typedArgs(functionNumber)});

    default \{className}<\{types(functionNumber)}> and(\{className}<\{superTypes(functionNumber)}> other) {
        Objects.requireNonNull(other);
        return (\{args(functionNumber)}) -> test(\{args(functionNumber)}) && other.test(\{args(functionNumber)});
    }

    default \{className}<\{types(functionNumber)}> negate() {
        return (\{args(functionNumber)}) -> !test(\{args(functionNumber)});
    }

    default \{className}<\{types(functionNumber)}> or(\{className}<\{superTypes(functionNumber)}> other) {
        Objects.requireNonNull(other);
        return (\{args(functionNumber)}) -> test(\{args(functionNumber)}) || other.test(\{args(functionNumber)});
    }
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
