package com.aegisql.multifunction;

import com.aegisql.multifunction.harness.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Consumer1Test {

    @Test
    public void dispatchPredicate2Test() {
        var cm1 = new ConsumerMethods1();
        var cm2 = new ConsumerMethods2();
        var dispatch = Consumer1.dispatch((a1) -> a1 instanceof A1, cm1::c1, cm2::c1);
        assertNotNull(dispatch);

        dispatch.accept(new A1());
        assertNotNull(cm1.getValConcat());
        assertEquals("CM1:A1",cm1.getValConcat());
        assertNull(cm2.getValConcat());

        dispatch.accept(new B1());
        assertNotNull(cm2.getValConcat());
        assertEquals("CM2:B1",cm2.getValConcat());

    }

    @Test
    public void dispatch3Test() {
        var cm1 = new ConsumerMethods1();
        var cm2 = new ConsumerMethods2();
        var cm3 = new ConsumerMethods3();

        var dispatch = Consumer1.dispatch((a1) -> switch (a1){
            case A1 _ -> 0;
            case B1 _-> 1;
            case C1 _-> 2;
            default -> 3;
        }, cm1::c1, cm2::c1,cm3::c1);
        assertNotNull(dispatch);

        dispatch.accept(new A1());
        assertNotNull(cm1.getValConcat());
        assertEquals("CM1:A1",cm1.getValConcat());
        assertNull(cm2.getValConcat());

        dispatch.accept(new B1());
        assertNotNull(cm2.getValConcat());
        assertEquals("CM2:B1",cm2.getValConcat());

        dispatch.accept(new C1());
        assertNotNull(cm3.getValConcat());
        assertEquals("CM3:C1",cm3.getValConcat());

        assertThrows(IndexOutOfBoundsException.class,()->dispatch.accept(new D1()));
    }

    @Test
    public void acceptTest() {
        var cm1 = new ConsumerMethods1();
        var c1 = Consumer1.of(cm1::c1);

        var a1A1 = c1.acceptArg1(new A1());
        var a1B1 = c1.acceptArg1(B1::new);
        var a0C1 = c1.lazyAccept(new C1());

        assertNull(cm1.getValConcat());

        a1A1.run();
        assertNotNull(cm1.getValConcat());
        assertEquals("CM1:A1",cm1.getValConcat());

        a1B1.run();
        assertEquals("CM1:B1",cm1.getValConcat());

        a0C1.run();
        assertEquals("CM1:C1",cm1.getValConcat());

        Consumer1<Object> uncurry = a1A1.uncurry();
        uncurry.accept(new B1());
        Consumer1<Object> uncurry1 = a1B1.uncurry();
        uncurry1.accept(new C1());

        assertThrows(RuntimeException.class,()->c1.uncurry());

    }

    @Test
    public void throwingTest() {
        var cm1 = new ConsumerMethods1();
        var c1 = Consumer1.throwing(cm1::c1E);
        c1.accept(new A1());
        assertEquals("CM1:A1",cm1.getValConcat());
        assertThrows(RuntimeException.class,()->c1.accept(null));
    }

    @Test
    public void throwingTest2() {
        var cm1 = new ConsumerMethods1();
        var c1 = Consumer1.throwing(cm1::c1E,(v,e)->{
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        });
        c1.accept(new A1());
        assertEquals("CM1:A1",cm1.getValConcat());
        assertThrows(RuntimeException.class,()->c1.accept(null));
    }

    @Test
    public void beforeAfterTest() {
        var cm1 = new ConsumerMethods1();
        Consumer1<AA> c = Consumer1.of(cm1::c1);
        Consumer1<AA> c2 = c.before(aa -> {
            System.out.println("Ready to consume " + aa);
        }).after(aa -> {
            System.out.println("Successfully consumed " + aa);
        });
        c2.accept(new A1());
    }

}