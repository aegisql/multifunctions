package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

class Consumer4Test {

    public void sum(int x, int y, int z, int t) {
        System.out.println( "Summa "+x+"+"+y+"+"+z+"+"+t+"="+(x+y+z+t));
    }

    public void mul(int x, int y, int z, int t) {
        System.out.println( "Prod "+x+"*"+y+"*"+z+"*"+t+"="+(x*y*z*t));
    }

    public void pow(int x, int y, int z, int t) {
        System.out.println( "Pow ("+z+"^"+t+")*("+x+"^"+y+")="+Math.pow(z,t)*Math.pow(x,y));
    }

    @Test
    void testDispatch1() {

        var dispatch = Consumer4.dispatch(
                (a, b, c, d) -> d % 3,
                this::sum,
                this::mul,
                this::pow
        );

        dispatch.accept(1,2,3,4);
        dispatch.accept(1,2,3,5);
        dispatch.accept(1,2,3,6);

    }

    @Test
    void testDispatch2() {
        var dispatch = Consumer4.dispatch(
                (a, b, c, d) -> d % 3 == 0,
                this::sum,
                this::mul
        );

        dispatch.accept(1,2,3,4);
        dispatch.accept(1,2,3,6);
    }
}