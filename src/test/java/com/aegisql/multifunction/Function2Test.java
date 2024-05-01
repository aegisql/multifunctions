package com.aegisql.multifunction;

import com.aegisql.multifunction.harness.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Function2Test {

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
        Function2<AA, A2, String> f = Function2.of(fm1::f2);
        SupplierExt<String> s = f.lazyApply(new A1(), new A2());
        assertEquals("FM1:A1A2",s.get());
    }

    @Test
    void applyArg1() {
        Function2<AA, A2, String> f = Function2.of(fm1::f2);
        Function1<A2, String> f1 = f.applyArg1(new A1());
        assertEquals("FM1:A1A2",f1.apply(new A2()));
    }

    @Test
    void testApplyArg1() {
        Function2<AA, A2, String> f = Function2.of(fm1::f2);
        Function1<A2, String> f1 = f.applyArg1(B1::new);
        assertEquals("FM1:B1A2",f1.apply(new A2()));
    }

    @Test
    void applyArg2() {
        Function2<AA, A2, String> f = Function2.of(fm2::f2);
        Function1<AA, String> f1 = f.applyArg2(new A2());
        assertEquals("FM2:A2A2",f1.apply(new A2()));
    }

    @Test
    void testApplyArg2() {
        Function2<AA, A2, String> f = Function2.of(fm2::f2);
        Function1<AA, String> f1 = f.applyArg2(A2::new);
        assertEquals("FM2:A3A2",f1.apply(new A3()));
    }

    @Test
    void uncurry() {
        Function2<AA, A2, String> f = Function2.of(fm1::f2);
        assertThrows(RuntimeException.class,f::uncurry);
    }

    @Test
    void optional() {
        Function2<AA, A2, Optional<String>> o = Function2.throwing(fm3::f2E).optional();
        assertEquals("FM3:A1A2",o.apply(new A1(),new A2()).get());
        assertTrue(o.apply(null,new A2()).isEmpty());
    }

    @Test
    void orElse() {
        Function2<AA, A2, String> f = Function2.throwing(fm3::f2E).orElse("ERROR");
        assertEquals("FM3:A1A2",f.apply(new A1(),new A2()));
        assertEquals("ERROR",f.apply(new A1(),null));
    }

    @Test
    void testOrElse() {
        Function2<AA, A2, String> f = Function2.throwing(fm3::f2E).orElse(()->"ERROR");
        assertEquals("FM3:A1A2",f.apply(new A1(),new A2()));
        assertEquals("ERROR",f.apply(new A1(),null));
    }

    @Test
    void beforeAndAfter() {
        Function2<AA, A2, String> f = Function2.of(fm1::f2)
                .before((a1,a2)->{System.out.println("Ready to process "+a1+" and "+a2);})
                .after((a1,a2,r)->{System.out.println("F2("+a1+","+a2+")="+r);})
                ;
        assertEquals("FM1:A1A2",f.apply(new A1(),new A2()));
    }

    @Test
    void dispatch() {
        Function2<AA, A2, String> dispatch = Function2.dispatch((aa, a2) -> switch (aa) {
            case A1 a1 -> 0;
            case B1 b1 -> 1;
            case C1 c1 -> 2;
            default -> -1;
        }, fm1::f2, fm2::f2, fm3::f2);

        assertEquals("FM1:A1A2",dispatch.apply(new A1(),new A2()));
        assertEquals("FM2:B1A2",dispatch.apply(new B1(),new A2()));
        assertEquals("FM3:C1A2",dispatch.apply(new C1(),new A2()));
        assertThrows(RuntimeException.class,()->{dispatch.apply(new D1(),new A2());});
    }

    @Test
    void testDispatch() {
        Function2<AA, A2, String> dispatch = Function2.dispatch((aa, a2) -> aa instanceof A1, fm1::f2, fm2::f2);

        assertEquals("FM1:A1A2",dispatch.apply(new A1(),new A2()));
        assertEquals("FM2:B1A2",dispatch.apply(new B1(),new A2()));
        assertEquals("FM2:C1A2",dispatch.apply(new C1(),new A2()));
    }

    @Test
    void throwing() {
        Function2<AA, A2, String> f = Function2.throwing(fm3::f2E,(e,a1,a2)->{
            return a1+","+a2+" - WRONG VALUES";
        });
        String s = f.apply(null, null);
        assertEquals("null,null - WRONG VALUES",s);
    }

}