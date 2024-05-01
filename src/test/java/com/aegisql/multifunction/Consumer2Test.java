package com.aegisql.multifunction;

import com.aegisql.multifunction.harness.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Consumer2Test {

    @Test
    public void dispatchPredicate2Test() {
        var cm1 = new ConsumerMethods1();
        var cm2 = new ConsumerMethods2();
        var dispatch = Consumer2.dispatch((a1,_) -> a1 instanceof A1, cm1::c2, cm2::c2);
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
    public void dispatch3Test() {
        var cm1 = new ConsumerMethods1();
        var cm2 = new ConsumerMethods2();
        var cm3 = new ConsumerMethods3();

        var dispatch = Consumer2.dispatch((a1,_) -> switch (a1){
            case A1 _-> 0;
            case B1 _-> 1;
            case C1 _-> 2;
            default -> 3;
        }, cm1::c2, cm2::c2,cm3::c2);
        assertNotNull(dispatch);

        dispatch.accept(new A1(),new A2());
        assertNotNull(cm1.getValConcat());
        assertEquals("CM1:A1A2",cm1.getValConcat());
        assertNull(cm2.getValConcat());

        dispatch.accept(new B1(),new A2());
        assertNotNull(cm2.getValConcat());
        assertEquals("CM2:B1A2",cm2.getValConcat());

        dispatch.accept(new C1(),new A2());
        assertNotNull(cm3.getValConcat());
        assertEquals("CM3:C1A2",cm3.getValConcat());

        assertThrows(IndexOutOfBoundsException.class,()->dispatch.accept(new D1(), new A2()));
    }

    @Test
    public void acceptTest() {
        var cm1 = new ConsumerMethods1();
        var c2 = Consumer2.of(cm1::c2);

        assertThrows(RuntimeException.class, c2::uncurry);

        var a1A1 = c2.acceptArg1(new A1());
        var a1B1 = c2.acceptArg1(B1::new);
        var a0A1 = a1A1.acceptArg1(new A2());
        var a0B1 = a1B1.acceptArg1(new A2());
        var a1A2 = c2.acceptArg2(new A2());
        var a1A2s = c2.acceptArg2(A2::new);

        assertNull(cm1.getValConcat());

        a0A1.run();
        assertNotNull(cm1.getValConcat());
        assertEquals("CM1:A1A2",cm1.getValConcat());

        a1A1.uncurry().accept(new B1(),new A2());
        assertEquals("CM1:B1A2",cm1.getValConcat());

        a0B1.run();
        assertEquals("CM1:B1A2",cm1.getValConcat());

        a1B1.uncurry().accept(new C1(),new A2());
        assertEquals("CM1:C1A2",cm1.getValConcat());

        var a0C1 = c2.lazyAccept(new C1(),new A2());
        a0C1.run();
        assertEquals("CM1:C1A2",cm1.getValConcat());

        var a0D1 = a1A2.acceptArg1(new D1());
        a0D1.run();
        assertEquals("CM1:D1A2",cm1.getValConcat());
        a1A2s.acceptArg1(A1::new).run();
        assertEquals("CM1:A1A2",cm1.getValConcat());

        a1A2.uncurry().accept(new C1(),new A2());
        assertEquals("CM1:C1A2",cm1.getValConcat());

        a1A2s.uncurry().accept(new D1(),new A2());
        assertEquals("CM1:D1A2",cm1.getValConcat());

    }

    @Test
    public void throwingTest() {
        var cm1 = new ConsumerMethods1();
        var c2 = Consumer2.throwing(cm1::c2E);
        c2.accept(new A1(), new A2());
        assertEquals("CM1:A1A2",cm1.getValConcat());
        assertThrows(RuntimeException.class,()->c2.accept(null,new A2()));
    }

    @Test
    public void throwingTest2() {
        var cm1 = new ConsumerMethods1();
        var c2 = Consumer2.throwing(cm1::c2E,(v1,v2,e)->{
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        });
        c2.accept(new A1(),new A2());
        assertEquals("CM1:A1A2",cm1.getValConcat());
        assertThrows(RuntimeException.class,()->c2.accept(new A1(),null));
    }

    @Test
    public void beforeAfterTest() {
        var cm1 = new ConsumerMethods1();
        var c = Consumer2.of(cm1::c2);
        var c2 = c.before((aa,a2) -> {
            System.out.println("Ready to consume " + aa+" and "+a2);
        }).after((aa,a2) -> {
            System.out.println("Successfully consumed " + aa+ " and "+a2);
        });
        c2.accept(new A1(),new A2());
    }

}