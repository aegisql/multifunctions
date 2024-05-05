package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CalcDispatcherTest {

    @Test
    public void test() {

        Function3<String,Double,Double,Double> dispatch = Function3.dispatch(
                (op,_,_)->switch (op.toUpperCase()) {
                    case "MIN" -> 0;
                    case "MAX" -> 1;
                    case "POW" -> 2;
                    case "ROOT_N" -> 3;
                    case "MUL" -> 4;
                    case "DIV" -> 5;
                    default -> throw new UnsupportedOperationException(STR."Unsupported operation: \{op}");
                },
                (_,x,y)->Math.min(x,y),
                (_,x,y)->Math.max(x,y),
                (_,x,y)->Math.pow(x,y),
                (_,x,y)->Math.pow(x,1/y),
                (_,x,y)->x*y,
                (_,x,y)->x/y
        );

        Double min = dispatch.apply("MIN", 10d, 15d);
        assertEquals(10,min);

        Double max = dispatch.apply("MAX", 10d, 15d);
        assertEquals(15,max);

        Double pow = dispatch.apply("POW", 2d, 3d);
        assertEquals(8,pow);

        Double root = dispatch.apply("ROOT_N", 8d, 3d);
        assertEquals(2,root);

        Double mul = dispatch.apply("MUL", 2d, 3d);
        assertEquals(6,mul);

        Double div = dispatch.apply("DIV", 2d, 3d);
        assertEquals(0.666,div,0.001);

        assertThrows(UnsupportedOperationException.class,()->{dispatch.apply("LOG_N",2d,1024d);});

    }

    @Test
    public void divTest() {
        Function2<Integer,Integer,Integer> div = (x,y)->x/y;

        //Integer res = div.apply(10, 0);

        Function2<Integer, Integer, Optional<Integer>> divOptional = div.optional();
        Optional<Integer> resOptional = divOptional.apply(10, 0);

        Function2<Integer, Integer, Integer> divDef = div.orElse(() -> null);

        Integer resDef = divDef.apply(10, 0);
        assertNull(resDef);
    }


}
