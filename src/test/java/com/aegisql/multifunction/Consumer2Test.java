package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

class Consumer2Test {

    public void sum(int x, int y) {
        System.out.println( "Summa "+x+"+"+y+"="+(x+y) );
    }

    public void mul(int x, int y) {
        System.out.println( "Prod "+x+"*"+y+"="+(x*y) );
    }

    public void pow(int x, int y) {
        System.out.println( "Pow "+x+"^"+y+"="+Math.pow(x,y) );
    }


    @Test
    public void consumer2Test() {
        BiConsumer<Integer,Integer> dispatch = Consumer2.dispatch((x,y) -> x%2==0,
                this::mul,
                this::pow);

        dispatch.accept(1,2);
        dispatch.accept(2,3);

    }

    @Test
    public void consumer2MulTest() {
        BiConsumer<Integer,Integer> dispatch = Consumer2.dispatch((x,y) -> x % 3,
                this::sum,
                this::mul,
                this::pow
        );

        dispatch.accept(3,4);
        dispatch.accept(4,5);
        dispatch.accept(5,6);

    }

}