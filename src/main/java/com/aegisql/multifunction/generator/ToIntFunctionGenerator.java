/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction.generator;

import static com.aegisql.multifunction.generator.ArgUtils.*;

public class ToIntFunctionGenerator {

    private static void generate(int fN) {

        String className = "ToInt"+fN+"Function";

        String code = STR."""
/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction.tmp;
@FunctionalInterface
public interface \{className}<\{types(fN)}> {
    int applyAsInt(\{typedArgs(fN).toString()});
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
