package com.aegisql.multifunction.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgUtilsTest {

    @Test
    void types() {
        assertEquals("A1,A2,A3,A4", ArgUtils.types(4));
    }

    @Test
    void typedArgs() {
        assertEquals("A1 a1,A2 a2,A3 a3,A4 a4", ArgUtils.typedArgs(4));
    }

    @Test
    void args() {
        assertEquals("a1,a2,a3,a4", ArgUtils.args(4));
    }

    @Test
    void argsTemplate() {
        assertEquals("{1},{2},{3},{4}", ArgUtils.argsTemplate(4));
    }

    @Test
    void superTypes() {
        assertEquals("? super A1,? super A2,? super A3,? super A4", ArgUtils.superTypes(4));
    }

    @Test
    void lazyArgs() {
        assertEquals("applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4)", ArgUtils.lazyArgs(4));
    }

    @Test
    void applyArg() {
        assertEquals("a2,a3,a4", ArgUtils.applyedArgs(1,4));
        assertEquals("a1,a3,a4", ArgUtils.applyedArgs(2,4));
        assertEquals("a1,a2,a4", ArgUtils.applyedArgs(3,4));
        assertEquals("a1,a2,a3", ArgUtils.applyedArgs(4,4));
    }

    @Test
    void applySupplierArg() {
        assertEquals("a1Supplier.get(),a2,a3,a4", ArgUtils.applySupplierArg(1,4));
        assertEquals("a1,a2Supplier.get(),a3,a4", ArgUtils.applySupplierArg(2,4));
        assertEquals("a1,a2,a3Supplier.get(),a4", ArgUtils.applySupplierArg(3,4));
        assertEquals("a1,a2,a3,a4Supplier.get()", ArgUtils.applySupplierArg(4,4));

        assertEquals("a1Supplier.get(),a2,a3,a4,a5,a6,a7,a8,a9,a10", ArgUtils.applySupplierArg(1,10));

    }
}