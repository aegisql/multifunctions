package com.aegisql.multifunction.generator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConsumerGenerator {

    private static void generate(int functionNumber) throws IOException {

        String className = STR."Consumer\{functionNumber}";

        StringBuilder typeListBuilder = new StringBuilder("A1");
        for (int i = 2; i <= functionNumber; i++) {
            typeListBuilder.append(",").append("A").append(i);
        }

        StringBuilder argListBuilder = new StringBuilder("A1 a1");
        for (int i = 2; i <= functionNumber; i++) {
            argListBuilder.append(", ").append("A").append(i).append(" a").append(i);
        }

        StringBuilder argShortListBuilder = new StringBuilder("a1");
        for (int i = 2; i <= functionNumber; i++) {
            argShortListBuilder.append(",").append("a").append(i);
        }

        StringBuilder argSuperListBuilder = new StringBuilder("? super A1");
        for (int i = 2; i <= functionNumber; i++) {
            argSuperListBuilder.append(", ").append("? super A").append(i);
        }

        String code = STR."""
package com.aegisql.multifunction.tmp;

import java.util.Objects;

@FunctionalInterface
public interface \{className}<\{typeListBuilder.toString()}> {
    boolean test(\{argListBuilder.toString()});

    default \{className}<\{typeListBuilder.toString()}> and(\{className}<\{argSuperListBuilder.toString()}> other) {
        Objects.requireNonNull(other);
        return (\{argShortListBuilder.toString()}) -> test(\{argShortListBuilder.toString()}) && other.test(\{argShortListBuilder.toString()});
    }

    default \{className}<\{typeListBuilder.toString()}> negate() {
        return (\{argShortListBuilder.toString()}) -> !test(\{argShortListBuilder.toString()});
    }

    default \{className}<\{typeListBuilder.toString()}> or(\{className}<\{argSuperListBuilder.toString()}> other) {
        Objects.requireNonNull(other);
        return (\{argShortListBuilder.toString()}) -> test(\{argShortListBuilder.toString()}) || other.test(\{argShortListBuilder.toString()});
    }
}
                """;
        System.out.println(code);

        Path path = Path.of("src/main/java/com/aegisql/multifunction/tmp/"+className+".java");
        Files.writeString(path,code, StandardCharsets.UTF_8);

    }

    public static void main(String[] args) {
        try {
            for(int i = 3; i <=10; i++) {
                generate(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        }

    }

}
