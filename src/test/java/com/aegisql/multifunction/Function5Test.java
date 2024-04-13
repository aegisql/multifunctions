package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

class Function5Test {

    public String sum(int x, int y, int z, int t, String head) {
        return head+" "+x+"+"+y+"+"+z+"+"+t+"="+(x+y+z+t);
    }

    public String mul(int x, int y, int z, int t, String head) {
        return head+" "+x+"*"+y+"*"+z+"*"+t+"="+(x*y*z*t);
    }

    public String pow(int x, int y, int z, int t, String head) {
        return head+" ("+z+"^"+t+")*("+x+"^"+y+")="+Math.pow(z,t)*Math.pow(x,y);
    }

    @Test
    void testDispatch1() {

        var dispatch = Function5.dispatch(
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

        System.out.println(dispatch.andThen(s->s+";").apply(1,2,3,4,"sum"));
        System.out.println(dispatch.andThen(s->s+";").apply(1,2,3,5,"mul"));
        System.out.println(dispatch.andThen(s->s+";").apply(1,2,3,6,"pow"));

    }

    @Test
    void testDispatch2() {
        var dispatch = Function5.dispatch(
                (a, b, c, d, h) -> "sum".equalsIgnoreCase(h),
                this::sum,
                this::mul
        );

        System.out.println(dispatch.andThen(s->s+";").apply(1,2,3,4,"sum"));
        System.out.println(dispatch.andThen(s->s+";").apply(1,2,3,6,"mul"));
    }
}