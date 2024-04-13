package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

class Consumer3Test {

    public void sum(int x, int y, int z) {
        System.out.println("Summa "+x+"+"+y+"+"+z+"="+(x+y+z));
    }

    public void mul(int x, int y, int z) {
        System.out.println( "Prod "+x+"*"+y+"*"+z+"="+(x*y*z));
    }

    public void pow(int x, int y, int z) {
        System.out.println( "Pow "+z+"*("+x+"^"+y+")="+z*Math.pow(x,y));
    }


    @Test
    void testDispatch1() {

        var dispatch = Consumer3.dispatch(
                (x, y, z) -> (x + y + z) % 3,
                this::sum,
                this::mul,
                this::pow
        );
        dispatch.andThen((a,b,c)->System.out.println(".")).accept(1,2,3);
        dispatch.andThen((a,b,c)->System.out.println(".")).accept(1,2,4);
        dispatch.andThen((a,b,c)->System.out.println(".")).accept(1,2,5);
    }

    @Test
    void testDispatch2() {
        var dispatch = Consumer3.dispatch(
                (x, y, z) -> (x + y + z) % 3==0,
                this::sum,
                this::mul
        );
        dispatch.andThen((a,b,c)->System.out.println("...")).accept(1,2,3);
        dispatch.andThen((a,b,c)->System.out.println("...")).accept(1,2,4);
    }
}