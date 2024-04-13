package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class Consumer5Test {

    public void sum(int x, int y, int z, int t, String head) {
        System.out.println( head+" "+x+"+"+y+"+"+z+"+"+t+"="+(x+y+z+t));
    }

    public void mul(int x, int y, int z, int t, String head) {
        System.out.println( head+" "+x+"*"+y+"*"+z+"*"+t+"="+(x*y*z*t));
    }

    public void pow(int x, int y, int z, int t, String head) {
        System.out.println( head+" ("+z+"^"+t+")*("+x+"^"+y+")="+Math.pow(z,t)*Math.pow(x,y));
    }

    @Test
    void testDispatch1() {

        var dispatch = Consumer5.dispatch(
                (a, b, c, d, h) -> switch (h.toLowerCase()) {
                    case "sum" -> 0;
                    case "mul" -> 1;
                    case "pow" -> 2;
                    default -> -1;
                },
                this::sum,
                this::mul,
                this::pow
        );

        dispatch.accept(1,2,3,4,"Sum");
        dispatch.accept(1,2,3,5,"Mul");
        dispatch.accept(1,2,3,6,"Pow");
        assertThrows(RuntimeException.class, ()-> dispatch.accept(1,2,3,6,"XXX"));

    }

    @Test
    void testDispatch2() {
        var dispatch = Consumer5.dispatch(
                (a, b, c, d, h) -> d % 3 == 0,
                this::sum,
                this::mul
        );

        dispatch.accept(1,2,3,4,"Sum");
        dispatch.accept(1,2,3,6,"Mul");
    }
}