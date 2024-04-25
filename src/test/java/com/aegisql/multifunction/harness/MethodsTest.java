package com.aegisql.multifunction.harness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodsTest {

    @Test
    public void consumerTests() {
        ConsumerMethods cm = new ConsumerMethods();
        cm.c(new A1());
        cm.assertValConcat("A1");
        cm.c(new A1(),new A2());
        cm.assertValConcat("A1A2");
        cm.c(new A1(),new A2(),new A3());
        cm.assertValConcat("A1A2A3");
        cm.c(new A1(),new A2(),new A3(),new A4());
        cm.assertValConcat("A1A2A3A4");
        cm.c(new A1(),new A2(),new A3(),new A4(),new A5());
        cm.assertValConcat("A1A2A3A4A5");
        cm.c(new A1(),new A2(),new A3(),new A4(),new A5(),new A6());
        cm.assertValConcat("A1A2A3A4A5A6");
        cm.c(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7());
        cm.assertValConcat("A1A2A3A4A5A6A7");
        cm.c(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8());
        cm.assertValConcat("A1A2A3A4A5A6A7A8");
        cm.c(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9());
        cm.assertValConcat("A1A2A3A4A5A6A7A8A9");
        cm.c(new B1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10());
        cm.assertValConcat("B1A2A3A4A5A6A7A8A9A10");
    }

    @Test
    public void consumerETests() throws IsNull, IsMandatory {
        ConsumerMethods cm = new ConsumerMethods();
        cm.cE(new A1());
        cm.assertValConcat("A1");
        cm.cE(new A1(),new A2());
        cm.assertValConcat("A1A2");
        cm.cE(new A1(),new A2(),new A3());
        cm.assertValConcat("A1A2A3");
        cm.cE(new A1(),new A2(),new A3(),new A4());
        cm.assertValConcat("A1A2A3A4");
        cm.cE(new A1(),new A2(),new A3(),new A4(),new A5());
        cm.assertValConcat("A1A2A3A4A5");
        cm.cE(new A1(),new A2(),new A3(),new A4(),new A5(),new A6());
        cm.assertValConcat("A1A2A3A4A5A6");
        cm.cE(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7());
        cm.assertValConcat("A1A2A3A4A5A6A7");
        cm.cE(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8());
        cm.assertValConcat("A1A2A3A4A5A6A7A8");
        cm.cE(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9());
        cm.assertValConcat("A1A2A3A4A5A6A7A8A9");
        cm.cE(new B1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10());
        cm.assertValConcat("B1A2A3A4A5A6A7A8A9A10");
        assertThrows(IsNull.class,()->cm.cE(null));
        assertThrows(IsNull.class,()->cm.cE(null,new A2()));
        assertThrows(IsNull.class,()->cm.cE(null,new A2(),new A3()));
        assertThrows(IsNull.class,()->cm.cE(null,new A2(),new A3(),new A4()));
        assertThrows(IsNull.class,()->cm.cE(null,new A2(),new A3(),new A4(),new A5()));
        assertThrows(IsNull.class,()->cm.cE(null,new A2(),new A3(),new A4(),new A5(),new A6()));
        assertThrows(IsNull.class,()->cm.cE(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7()));
        assertThrows(IsNull.class,()->cm.cE(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertThrows(IsNull.class,()->cm.cE(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertThrows(IsNull.class,()->cm.cE(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));

        assertThrows(IsMandatory.class,()->cm.cE(new A1(),null));
        assertThrows(IsMandatory.class,()->cm.cE(new A1(),null,new A3()));
        assertThrows(IsMandatory.class,()->cm.cE(new A1(),null,new A3(),new A4()));
        assertThrows(IsMandatory.class,()->cm.cE(new A1(),null,new A3(),new A4(),new A5()));
        assertThrows(IsMandatory.class,()->cm.cE(new A1(),null,new A3(),new A4(),new A5(),new A6()));
        assertThrows(IsMandatory.class,()->cm.cE(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7()));
        assertThrows(IsMandatory.class,()->cm.cE(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertThrows(IsMandatory.class,()->cm.cE(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertThrows(IsMandatory.class,()->cm.cE(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));
    }

    @Test
    public void functionsTest() {
        FunctionMethods fm = new FunctionMethods();
        assertEquals("A1",fm.f(new A1()));
        assertEquals("A1A2",fm.f(new A1(),new A2()));
        assertEquals("A1A2A3",fm.f(new A1(),new A2(),new A3()));
        assertEquals("A1A2A3A4",fm.f(new A1(),new A2(),new A3(),new A4()));
        assertEquals("A1A2A3A4A5",fm.f(new A1(),new A2(),new A3(),new A4(),new A5()));
        assertEquals("A1A2A3A4A5A6",fm.f(new A1(),new A2(),new A3(),new A4(),new A5(),new A6()));
        assertEquals("A1A2A3A4A5A6A7",fm.f(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7()));
        assertEquals("A1A2A3A4A5A6A7A8",fm.f(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertEquals("C1A2A3A4A5A6A7A8A9",fm.f(new C1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertEquals("D1A2A3A4A5A6A7A8A9A10",fm.f(new D1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));
    }

    @Test
    public void functionsETest() throws IsNull, IsMandatory {
        FunctionMethods fm = new FunctionMethods();
        assertEquals("A1",fm.fE(new A1()));
        assertEquals("A1A2",fm.fE(new A1(),new A2()));
        assertEquals("A1A2A3",fm.fE(new A1(),new A2(),new A3()));
        assertEquals("A1A2A3A4",fm.fE(new A1(),new A2(),new A3(),new A4()));
        assertEquals("A1A2A3A4A5",fm.fE(new A1(),new A2(),new A3(),new A4(),new A5()));
        assertEquals("A1A2A3A4A5A6",fm.fE(new A1(),new A2(),new A3(),new A4(),new A5(),new A6()));
        assertEquals("A1A2A3A4A5A6A7",fm.fE(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7()));
        assertEquals("A1A2A3A4A5A6A7A8",fm.fE(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertEquals("C1A2A3A4A5A6A7A8A9",fm.fE(new C1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertEquals("D1A2A3A4A5A6A7A8A9A10",fm.fE(new D1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));

        assertThrows(IsNull.class,()->fm.fE(null));
        assertThrows(IsNull.class,()->fm.fE(null,new A2()));
        assertThrows(IsNull.class,()->fm.fE(null,new A2(),new A3()));
        assertThrows(IsNull.class,()->fm.fE(null,new A2(),new A3(),new A4()));
        assertThrows(IsNull.class,()->fm.fE(null,new A2(),new A3(),new A4(),new A5()));
        assertThrows(IsNull.class,()->fm.fE(null,new A2(),new A3(),new A4(),new A5(),new A6()));
        assertThrows(IsNull.class,()->fm.fE(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7()));
        assertThrows(IsNull.class,()->fm.fE(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertThrows(IsNull.class,()->fm.fE(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertThrows(IsNull.class,()->fm.fE(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));

        assertThrows(IsMandatory.class,()->fm.fE(new A1(),null));
        assertThrows(IsMandatory.class,()->fm.fE(new A1(),null,new A3()));
        assertThrows(IsMandatory.class,()->fm.fE(new A1(),null,new A3(),new A4()));
        assertThrows(IsMandatory.class,()->fm.fE(new A1(),null,new A3(),new A4(),new A5()));
        assertThrows(IsMandatory.class,()->fm.fE(new A1(),null,new A3(),new A4(),new A5(),new A6()));
        assertThrows(IsMandatory.class,()->fm.fE(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7()));
        assertThrows(IsMandatory.class,()->fm.fE(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertThrows(IsMandatory.class,()->fm.fE(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertThrows(IsMandatory.class,()->fm.fE(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));

    }

}