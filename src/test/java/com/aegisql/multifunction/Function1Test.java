package com.aegisql.multifunction;

import com.aegisql.multifunction.harness.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class Function1Test {

    @Test
    public void dispatchPredicate2Test() {
        var fm1 = new FunctionMethods1();
        var fm2 = new FunctionMethods2();
        var dispatch = Function1.dispatch((a1) -> a1 instanceof A1, fm1::f1, fm2::f1);
        assertNotNull(dispatch);

        assertEquals("FM1:A1",dispatch.apply(new A1()));
        assertEquals("FM2:B1",dispatch.apply(new B1()));

    }

    @Test
    public void dispatch3Test() {
        var fm1 = new FunctionMethods1();
        var fm2 = new FunctionMethods2();
        var fm3 = new FunctionMethods3();

        var dispatch = Function1.dispatch((a1) -> switch (a1){
            case A1 _ -> 0;
            case B1 _-> 1;
            case C1 _-> 2;
            default -> 3;
        }, fm1::f1, fm2::f1,fm3::f1);
        assertNotNull(dispatch);

        assertEquals("FM1:A1",dispatch.apply(new A1()));
        assertEquals("FM2:B1",dispatch.apply(new B1()));
        assertEquals("FM3:C1",dispatch.apply(new C1()));

        assertThrows(IndexOutOfBoundsException.class,()->dispatch.apply(new D1()));
    }

    @Test
    public void acceptTest() {
        var fm1 = new FunctionMethods1();
        var f1 = Function1.of(fm1::f1);

        var a1A1 = f1.applyArg1(new A1());
        var a1B1 = f1.applyArg1(B1::new);
        var a0C1 = f1.lazyApply(new C1());

        assertEquals("FM1:A1",a1A1.get());
        assertEquals("FM1:B1",a1B1.get());
        assertEquals("FM1:C1",a0C1.get());

        Function1<Object, String> restoredFunction = a1A1.uncurry(); //this works
        assertEquals("FM1:A1", restoredFunction.apply(new A1()));
        assertThrows(ClassCastException.class,()->restoredFunction.apply(""));

        SupplierExt<String> wrap = SupplierExt.of(a1A1);
        assertThrows(UnsupportedOperationException.class,wrap::uncurry); //this should not!
        assertThrows(UnsupportedOperationException.class,f1::uncurry); //this should not!

        Function1<Object, String> uncurry = a1B1.uncurry(); //this works
        uncurry.apply(new B1());
    }

    @Test
    public void throwingTest() {
        var fm1 = new FunctionMethods1();
        var f1 = Function1.throwing(fm1::f1E);
        assertEquals("FM1:A1",f1.apply(new A1()));
        assertThrows(RuntimeException.class,()->f1.apply(null));
    }

    @Test
    public void optionalTest() {
        var fm1 = new FunctionMethods1();
        var f1 = Function1.throwing(fm1::f1E).optional();
        assertEquals("FM1:A1",f1.apply(new A1()).get());
        var optional = f1.apply(null);
        assertTrue(optional.isEmpty());
    }

    @Test
    public void defaultValTest() {
        var fm1 = new FunctionMethods1();
        var f1 = Function1.throwing(fm1::f1E).orElse("SOMETHING WRONG");
        assertEquals("FM1:A1",f1.apply(new A1()));
        var defaultVal = f1.apply(null);
        assertEquals("SOMETHING WRONG",defaultVal);
    }

    @Test
    public void throwingTest2() {
        var fm1 = new FunctionMethods1();
        var f1 = Function1.throwing(fm1::f1E,(e,a)->{
            System.err.println(e.getMessage());
            return "SOMETHING WRONG";
        });
        assertEquals("FM1:A1",f1.apply(new A1()));
        var defaultVal = f1.apply(null);
        assertEquals("SOMETHING WRONG",defaultVal);
    }

    @Test
    public void beforeAfterTest() {
        var fm1 = new FunctionMethods1();
        Function1<AA, String> f1 = Function1.of(fm1::f1);
        Function1<AA, String> f2 = f1.before(aa -> {
            System.out.println("Ready to apply " + aa);
        }).after((aa, res) -> {
            System.out.println("Applyed " + aa + " res:" + res);
        });
        assertEquals("FM1:A1",f1.apply(new A1()));
        assertEquals("FM1:B1",f2.apply(new B1()));
    }
}