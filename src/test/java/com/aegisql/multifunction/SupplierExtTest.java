package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.util.Optional;

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
    public void exceptionTest() {
        SupplierExt<String> throwing = SupplierExt.throwing(this::getEx);
        assertThrows(RuntimeException.class,()->throwing.get());

        SupplierExt<String> error = throwing.orElse("ERROR");
        assertEquals("ERROR",error.get());
    }

}