package com.aegisql.multifunction;

import com.aegisql.multifunction.harness.*;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

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
    public void dispatchPredicate2Test() {
        ConsumerMethods1 cm1 = new ConsumerMethods1();
        ConsumerMethods2 cm2 = new ConsumerMethods2();
        Consumer2<AA, A2> dispatch = Consumer2.dispatch((a1, a2) -> a1 instanceof A1, cm1::c2, cm2::c2);
        assertNotNull(dispatch);

        dispatch.accept(new A1(),new A2());
        assertNotNull(cm1.getValConcat());
        assertEquals("CM1:A1A2",cm1.getValConcat());
        assertNull(cm2.getValConcat());

        dispatch.accept(new B1(),new A2());
        assertNotNull(cm2.getValConcat());
        assertEquals("CM2:B1A2",cm2.getValConcat());

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