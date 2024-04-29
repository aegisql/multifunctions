package com.aegisql.multifunction.generator;

import static com.aegisql.multifunction.generator.ArgUtils.*;

public class ToIntFunctionGenerator {

    private static void generate(int functionNumber) {

        String className = "ToInt"+functionNumber+"Function";

        String code = STR."""
package com.aegisql.multifunction.tmp;
@FunctionalInterface
public interface \{className}<\{types(functionNumber)}> {
    int applyAsInt(\{typedArgs(functionNumber).toString()});
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
