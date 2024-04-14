package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

class Function3Test {

    public String sum(int x, int y, int z) {
        return "Summa "+x+"+"+y+"+"+z+"="+(x+y+z);
    }

    public String mul(int x, int y, int z) {
        return "Prod "+x+"*"+y+"*"+z+"="+(x*y*z);
    }

    public String pow(int x, int y, int z) {
        return "Pow "+z+"*("+x+"^"+y+")="+z*Math.pow(x,y);
    }


    @Test
    void testDispatch1() {
        var dispatch = Function3.dispatch((x, y, z) -> (x + y + z) % 3,
                this::sum,
                this::mul,
                this::pow
        );

        System.out.println(dispatch.apply(1,2,3));
        System.out.println(dispatch.apply(1,2,4));
        System.out.println(dispatch.apply(1,2,5));
    }

    @Test
    void testDispatch2() {
        var d = Function3.dispatch((x, y, z) -> (x + y + z) % 3==0,
                this::sum,
                this::mul
        );

        System.out.println(d.apply(1,2,3));
        System.out.println(d.apply(1,2,4));
    }

    @Test
    public void curryTest() {
        String s1 = Function3.of(this::mul).curry1(10).curry1(20).apply(5);
        System.out.println(s1);
        String s2 = Function3.of(this::mul).curry2(10).curry1(20).apply(5);
        System.out.println(s2);
        String s3 = Function3.of(this::mul).curry3(10).curry2(20).apply(5);
        System.out.println(s3);
    }

}