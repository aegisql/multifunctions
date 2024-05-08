package com.aegisql.multifunction;

import com.aegisql.multifunction.harness.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Consumer3Test {

    ConsumerMethods1 cm1 = new ConsumerMethods1();
    ConsumerMethods2 cm2 = new ConsumerMethods2();
    ConsumerMethods3 cm3 = new ConsumerMethods3();


    @BeforeEach
    void setUp() {
        cm1 = new ConsumerMethods1();
        cm2 = new ConsumerMethods2();
        cm3 = new ConsumerMethods3();
    }

    @Test
    void accept() {
        var c = Consumer3.of(cm1::c3);
        assertEquals(3,c.arity());

        c.accept(new A1(),new A2(),new A3());
        cm1.assertValConcat("CM1:A1A2A3");
    }

    @Test
    void lazyAccept() {
        var c = Consumer3.of(cm1::c3);
        var r = c.lazyAccept(new A1(),new A2(),new A3());
        r.run();
        cm1.assertValConcat("CM1:A1A2A3");
    }

    @Test
    void acceptArg1() {
        var c = Consumer3.of(cm1::c3).acceptArg1(new A1());
        var uc = c.uncurry();
        uc.accept(new B1(),new A2(),new A3());
        cm1.assertValConcat("CM1:B1A2A3");
        c.accept(new A2(),new A3());
        cm1.assertValConcat("CM1:A1A2A3");
    }

    @Test
    void testAcceptArg1() {
        var c = Consumer3.of(cm1::c3).acceptArg1(A1::new);
        c.accept(new A2(),new A3());
        cm1.assertValConcat("CM1:A1A2A3");
        assertNotNull(c.uncurry());
    }

    @Test
    void acceptArg2() {
        var c = Consumer3.of(cm1::c3).acceptArg2(new A2());
        c.accept(new B1(),new A3());
        cm1.assertValConcat("CM1:B1A2A3");
        assertNotNull(c.uncurry());
    }

    @Test
    void testAcceptArg2() {
        var c = Consumer3.of(cm1::c3).acceptArg2(A2::new);
        c.accept(new B1(),new A3());
        cm1.assertValConcat("CM1:B1A2A3");
        assertNotNull(c.uncurry());
    }

    @Test
    void acceptArg3() {
        var c = Consumer3.of(cm1::c3).acceptArg3(new A3());
        c.accept(new C1(),new A2());
        cm1.assertValConcat("CM1:C1A2A3");
        assertNotNull(c.uncurry());
    }

    @Test
    void testAcceptArg3() {
        var c = Consumer3.of(cm1::c3).acceptArg3(A3::new);
        c.accept(new C1(),new A2());
        cm1.assertValConcat("CM1:C1A2A3");
        assertNotNull(c.uncurry());
    }

    @Test
    void uncurry() {
        var c = Consumer3.of(cm1::c3);
        assertThrows(UnsupportedOperationException.class,c::uncurry);
    }

    @Test
    void beforeAndAfter() {
        var c = Consumer3.of(cm1::c3);
        var c2 = c.before((aa,a2,a3) -> {
            System.out.println("Ready to consume " + aa+" and "+a2+" and "+a3);
        }).after((aa,a2,a3) -> {
            System.out.println("Successfully consumed " + aa+ " and "+a2+" and "+a3);
        });
        c2.accept(new A1(),new A2(),new A3());
    }


    @Test
    void dispatch() {
        var dispatch = Consumer3.dispatch((aa,_,_)->switch(aa) {
                    case A1 a1 -> 0;
                    case B1 b1 -> 1;
                    case C1 c1 -> 2;
                    default -> -1;
        },
                cm1::c3,
                cm2::c3,
                cm3::c3
        );
        Consumer1<AA> c = dispatch.acceptArg2(new A2()).acceptArg2(new A3());
        c.accept(new A1());
        c.accept(new B1());
        c.accept(new C1());
        cm1.assertValConcat("CM1:A1A2A3");
        cm2.assertValConcat("CM2:B1A2A3");
        cm3.assertValConcat("CM3:C1A2A3");
        assertThrows(IndexOutOfBoundsException.class,()->c.accept(new D1()));
    }

    @Test
    void testDispatch() {
        var dispatch = Consumer3.dispatch((aa,_,_)->aa instanceof A1,
                cm1::c3,
                cm2::c3
        );
        Consumer1<AA> c = dispatch.acceptArg2(new A2()).acceptArg2(new A3());
        c.accept(new A1());
        c.accept(new B1());
        cm1.assertValConcat("CM1:A1A2A3");
        cm2.assertValConcat("CM2:B1A2A3");
        c.accept(new C1());
        cm2.assertValConcat("CM2:C1A2A3");
        c.accept(new D1());
        cm2.assertValConcat("CM2:D1A2A3");
    }


    @Test
    void throwing() {
        var c = Consumer3.throwing(cm1::c3E);
        c.accept(new A1(),new A2(),new A3());
        cm1.assertValConcat("CM1:A1A2A3");
        assertThrows(RuntimeException.class,()->c.accept(null,new A2(),new A3()));
    }

    @Test
    void testThrowing() {
        var c = Consumer3.throwing(cm1::c3E,(a1,a2,a3,e)->{
            if(a3!=null) {
                cm1.c3(a1,a2,a3);
            } else {
                throw new NullPointerException("a3 is null");
            }
        });
        c.accept(new A1(),null,new A3());
        cm1.assertValConcat("CM1:A1nullA3");
        assertThrows(RuntimeException.class,()->c.accept(null,new A2(),null));
    }
}