package com.aegisql.multifunction.generator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ToIntFunctionGenerator {

    private static void generate(int functionNumber) throws IOException {

        String className = "ToInt"+functionNumber+"Function";

        StringBuilder typeListBuilder = new StringBuilder("A1");
        for (int i = 2; i <= functionNumber; i++) {
            typeListBuilder.append(",").append("A").append(i);
        }

        StringBuilder argListBuilder = new StringBuilder("A1 a1");
        for (int i = 2; i <= functionNumber; i++) {
            argListBuilder.append(", ").append("A").append(i).append(" a").append(i);
        }

        String code = STR."""
package com.aegisql.multifunction.tmp;
@FunctionalInterface
public interface \{className}<\{typeListBuilder.toString()}> {
    int applyAsInt(\{argListBuilder.toString()});
}                
                """;
        System.out.println(code);

        Path path = Path.of("src/main/java/com/aegisql/multifunction/tmp/"+className+".java");
        Files.writeString(path,code, StandardCharsets.UTF_8);

    }

    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("""
                Usage: ToIntFunctionGenerator n
                where n is a number >=2
                """);
            System.exit(1);
        }
        try {
            generate(Integer.parseInt(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        }

    }

}
