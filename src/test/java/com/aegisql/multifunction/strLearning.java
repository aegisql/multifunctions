package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import static java.lang.StringTemplate.RAW;
import static java.lang.StringTemplate.STR;

public class strLearning {

    private String val = "!";
    StringTemplate st = RAW."template \{val}";

    @Test
    public void strTest() {

        String name = "World";
        int x = 10;

        String s = STR."""
        Hello , \{name} \{x}
        """;

        System.out.println(s);

        val = "TEST";
        String processed = STR.process(st);
        System.out.println(processed);

    }

}
