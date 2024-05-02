package com.aegisql.multifunction;

import com.aegisql.multifunction.harness.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Function3Test {

    FunctionMethods1 fm1;
    FunctionMethods2 fm2;
    FunctionMethods3 fm3;

    @BeforeEach
    void setUp() {
        fm1= new FunctionMethods1();
        fm2= new FunctionMethods2();
        fm3= new FunctionMethods3();
    }

    @Test
    void lazyApply() {
        Function3<AA, A2, A3,String> f = Function3.of(fm1::f3);
        SupplierExt<String> s = f.lazyApply(new A1(), new A2(), new A3());
        assertEquals("FM1:A1A2A3",s.get());
    }

    @Test
    void applyArg1() {
        var f = Function3.of(fm1::f3);
        var f1 = f.applyArg1(new A1());
        assertEquals("FM1:A1A2A3",f1.apply(new A2(),new A3()));
        assertNotNull(f1.uncurry());
    }

    @Test
    void testApplyArg1() {
        var f = Function3.of(fm1::f3);
        var f1 = f.applyArg1(B1::new);
        assertEquals("FM1:B1A2A3",f1.apply(new A2(),new A3()));
        assertNotNull(f1.uncurry());
    }

    @Test
    void applyArg2() {
        var f = Function3.of(fm2::f3);
        var f1 = f.applyArg2(new A2());
        assertEquals("FM2:A1A2A3",f1.apply(new A1(),new A3()));
        assertNotNull(f1.uncurry());
    }

    @Test
    void testApplyArg2() {
        var f = Function3.of(fm2::f3);
        var f1 = f.applyArg2(A2::new);
        assertEquals("FM2:A1A2A3",f1.apply(new A1(),new A3()));
        assertNotNull(f1.uncurry());
    }

    @Test
    void applyArg3() {
        var f = Function3.of(fm2::f3);
        var f1 = f.applyArg3(new A3());
        assertEquals("FM2:A1A2A3",f1.apply(new A1(),new A2()));
        assertNotNull(f1.uncurry());
    }

    @Test
    void testApplyArg3() {
        var f = Function3.of(fm2::f3);
        var f1 = f.applyArg3(A3::new);
        assertEquals("FM2:A1A2A3",f1.apply(new A1(),new A2()));
        assertNotNull(f1.uncurry());
    }

    @Test
    void uncurry() {
        var f = Function3.of(fm1::f3);
        assertThrows(RuntimeException.class,f::uncurry);
    }

    @Test
    void optional() {
        var o = Function3.throwing(fm3::f3E).optional();
        assertEquals("FM3:A1A2A3",o.apply(new A1(),new A2(), new A3()).get());
        assertTrue(o.apply(null,new A2(),new A3()).isEmpty());
    }

    @Test
    void orElse() {
        var f = Function3.throwing(fm3::f3E).orElse("ERROR");
        assertEquals("FM3:A1A2A3",f.apply(new A1(),new A2(), new A3()));
        assertEquals("ERROR",f.apply(new A1(),null,null));
    }

    @Test
    void testOrElse() {
        var f = Function3.throwing(fm3::f3E).orElse(()->"ERROR");
        assertEquals("FM3:A1A2A3",f.apply(new A1(),new A2(),new A3()));
        assertEquals("ERROR",f.apply(new A1(),null,null));
    }

    @Test
    void beforeAndAfter() {
        var f = Function3.of(fm1::f3)
                .before((a1,a2,a3)->{System.out.println("Ready to process "+a1+" and "+a2+" and "+a3);})
                .after((a1,a2,a3,r)->{System.out.println("F2("+a1+","+a2+","+a3+")="+r);})
                ;
        assertEquals("FM1:A1A2A3",f.apply(new A1(),new A2(), new A3()));
    }

    @Test
    void dispatch() {
        var dispatch = Function3.dispatch((aa,_,_) -> switch (aa) {
            case A1 a1 -> 0;
            case B1 b1 -> 1;
            case C1 c1 -> 2;
            default -> -1;
        }, fm1::f3, fm2::f3, fm3::f3);

        assertEquals("FM1:A1A2A3",dispatch.apply(new A1(),new A2(),new A3()));
        assertEquals("FM2:B1A2A3",dispatch.apply(new B1(),new A2(),new A3()));
        assertEquals("FM3:C1A2A3",dispatch.apply(new C1(),new A2(),new A3()));
        assertThrows(RuntimeException.class,()->{dispatch.apply(new D1(),new A2(),new A3());});
    }

    @Test
    void testDispatch() {
        var dispatch = Function3.dispatch((aa,_,_) -> aa instanceof A1, fm1::f3, fm2::f3);

        assertEquals("FM1:A1A2A3",dispatch.apply(new A1(),new A2(),new A3()));
        assertEquals("FM2:B1A2A3",dispatch.apply(new B1(),new A2(),new A3()));
        assertEquals("FM2:C1A2A3",dispatch.apply(new C1(),new A2(),new A3()));
    }

    @Test
    void throwing() {
        var f = Function3.throwing(fm3::f3E,(e,a1,a2,a3)->{
            return a1+","+a2+","+a3+" - WRONG VALUES";
        });
        String s = f.apply(null, null,null);
        assertEquals("null,null,null - WRONG VALUES",s);
    }

}