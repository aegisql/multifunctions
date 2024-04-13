package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

class Function4Test {

    public String sum(int x, int y, int z, int t) {
        return "Summa "+x+"+"+y+"+"+z+"+"+t+"="+(x+y+z+t);
    }

    public String mul(int x, int y, int z, int t) {
        return "Prod "+x+"*"+y+"*"+z+"*"+t+"="+(x*y*z*t);
    }

    public String pow(int x, int y, int z, int t) {
        return "Pow ("+z+"^"+t+")*("+x+"^"+y+")="+Math.pow(z,t)*Math.pow(x,y);
    }

    @Test
    void testDispatch1() {

        var dispatch = Function4.dispatch(
                (a, b, c, d) -> d % 3,
                this::sum,
                this::mul,
                this::pow
        );

        System.out.println(dispatch.andThen(s->s+";").apply(1,2,3,4));
        System.out.println(dispatch.andThen(s->s+";").apply(1,2,3,5));
        System.out.println(dispatch.andThen(s->s+";").apply(1,2,3,6));

    }

    @Test
    void testDispatch2() {
        var dispatch = Function4.dispatch(
                (a, b, c, d) -> d % 3 == 0,
                this::sum,
                this::mul
        );

        System.out.println(dispatch.andThen(s->s+";").apply(1,2,3,4));
        System.out.println(dispatch.andThen(s->s+";").apply(1,2,3,6));
    }
}