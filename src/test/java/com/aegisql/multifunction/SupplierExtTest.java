package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class SupplierExtTest {

    public String getVal() {
        return "VALUE";
    }

    public String getEx() throws Exception{
        throw new Exception("VALUE");
    }


    @Test
    public void supplierExtTest() {
        SupplierExt<String> value = SupplierExt.ofConst("VALUE");
        assertNotNull(value);
        assertEquals("VALUE",value.get());
        SupplierExt<Optional<String>> optional = value.optional();
        assertNotNull(optional);
        assertEquals("VALUE",optional.get().get());

        SupplierExt<String> getVal = SupplierExt.of(this::getVal);
        assertNotNull(getVal);
        assertEquals("VALUE",getVal.get());

        SupplierExt<String> transform = value.transform(v -> v + "!");
        assertEquals("VALUE!",transform.get());

    }

    @Test
    public void optionalTest2() {
        SupplierExt<Optional<String>> os = SupplierExt.throwing(this::getEx).optional();
        Optional<String> o = os.get();
        assertTrue(o.isEmpty());
    }

    @Test
    public void exceptionTest() {
        SupplierExt<String> throwing = SupplierExt.throwing(this::getEx);
        assertThrows(RuntimeException.class,()->throwing.get());

        SupplierExt<String> error = throwing.orElse("ERROR");
        assertEquals("ERROR",error.get());
    }

    @Test
    public void exceptionTest2() {
        SupplierExt<String> throwing = SupplierExt.throwing(this::getEx,e->{
            return "SOMETHING WRONG";
        });
        assertEquals("SOMETHING WRONG",throwing.get());
    }

    @Test
    public void beforeAfterTest() {
        SupplierExt<String> s = SupplierExt.of(this::getVal).before(() -> {
            System.out.println("ready to execute getVal()");
        }).after(res -> System.out.println("getVal() returned " + res));
        String res = s.get();
        assertEquals("VALUE",res);
    }

    @Test
    public void unCurryTest() {
        SupplierExt<String> supplierExt = SupplierExt.of(() -> "TEST_SUP_1");
        assertEquals("TEST_SUP_1",supplierExt.get());
        assertThrows(RuntimeException.class,supplierExt::uncurry);

        SupplierExt<Object> supplierExt2 = Function1.of(Function.identity()).applyArg1("TEST_SUP_2");
        assertEquals("TEST_SUP_2",supplierExt2.get());
        Function1<Object, Object> uncurry = supplierExt2.uncurry();
        assertEquals("TEST_SUP_3",uncurry.apply("TEST_SUP_3"));

    }

}