package com.aegisql.multifunction.harness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Methods2Test {

    @Test
    public void consumerTests() {
        ConsumerMethods2 cm = new ConsumerMethods2();
        cm.c1(new A1());
        cm.assertValConcat("CM2:A1");
        cm.c2(new A1(),new A2());
        cm.assertValConcat("CM2:A1A2");
        cm.c3(new A1(),new A2(),new A3());
        cm.assertValConcat("CM2:A1A2A3");
        cm.c4(new A1(),new A2(),new A3(),new A4());
        cm.assertValConcat("CM2:A1A2A3A4");
        cm.c5(new A1(),new A2(),new A3(),new A4(),new A5());
        cm.assertValConcat("CM2:A1A2A3A4A5");
        cm.c6(new A1(),new A2(),new A3(),new A4(),new A5(),new A6());
        cm.assertValConcat("CM2:A1A2A3A4A5A6");
        cm.c7(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7());
        cm.assertValConcat("CM2:A1A2A3A4A5A6A7");
        cm.c8(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8());
        cm.assertValConcat("CM2:A1A2A3A4A5A6A7A8");
        cm.c9(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9());
        cm.assertValConcat("CM2:A1A2A3A4A5A6A7A8A9");
        cm.c10(new B1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10());
        cm.assertValConcat("CM2:B1A2A3A4A5A6A7A8A9A10");
    }

    @Test
    public void consumerETests() throws IsNull, IsMandatory {
        ConsumerMethods2 cm = new ConsumerMethods2();
        cm.c1E(new A1());
        cm.assertValConcat("CM2:A1");
        cm.c2E(new A1(),new A2());
        cm.assertValConcat("CM2:A1A2");
        cm.c3E(new A1(),new A2(),new A3());
        cm.assertValConcat("CM2:A1A2A3");
        cm.c4E(new A1(),new A2(),new A3(),new A4());
        cm.assertValConcat("CM2:A1A2A3A4");
        cm.c5E(new A1(),new A2(),new A3(),new A4(),new A5());
        cm.assertValConcat("CM2:A1A2A3A4A5");
        cm.c6E(new A1(),new A2(),new A3(),new A4(),new A5(),new A6());
        cm.assertValConcat("CM2:A1A2A3A4A5A6");
        cm.c7E(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7());
        cm.assertValConcat("CM2:A1A2A3A4A5A6A7");
        cm.c8E(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8());
        cm.assertValConcat("CM2:A1A2A3A4A5A6A7A8");
        cm.c9E(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9());
        cm.assertValConcat("CM2:A1A2A3A4A5A6A7A8A9");
        cm.c10E(new B1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10());
        cm.assertValConcat("CM2:B1A2A3A4A5A6A7A8A9A10");
        assertThrows(IsNull.class,()->cm.c1E(null));
        assertThrows(IsNull.class,()->cm.c2E(null,new A2()));
        assertThrows(IsNull.class,()->cm.c3E(null,new A2(),new A3()));
        assertThrows(IsNull.class,()->cm.c4E(null,new A2(),new A3(),new A4()));
        assertThrows(IsNull.class,()->cm.c5E(null,new A2(),new A3(),new A4(),new A5()));
        assertThrows(IsNull.class,()->cm.c6E(null,new A2(),new A3(),new A4(),new A5(),new A6()));
        assertThrows(IsNull.class,()->cm.c7E(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7()));
        assertThrows(IsNull.class,()->cm.c8E(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertThrows(IsNull.class,()->cm.c9E(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertThrows(IsNull.class,()->cm.c10E(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));

        assertThrows(IsMandatory.class,()->cm.c2E(new A1(),null));
        assertThrows(IsMandatory.class,()->cm.c3E(new A1(),null,new A3()));
        assertThrows(IsMandatory.class,()->cm.c4E(new A1(),null,new A3(),new A4()));
        assertThrows(IsMandatory.class,()->cm.c5E(new A1(),null,new A3(),new A4(),new A5()));
        assertThrows(IsMandatory.class,()->cm.c6E(new A1(),null,new A3(),new A4(),new A5(),new A6()));
        assertThrows(IsMandatory.class,()->cm.c7E(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7()));
        assertThrows(IsMandatory.class,()->cm.c8E(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertThrows(IsMandatory.class,()->cm.c9E(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertThrows(IsMandatory.class,()->cm.c10E(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));
    }

    @Test
    public void functionsTest() {
        FunctionMethods2 fm = new FunctionMethods2();
        assertEquals("FM2:A1",fm.f1(new A1()));
        assertEquals("FM2:A1A2",fm.f2(new A1(),new A2()));
        assertEquals("FM2:A1A2A3",fm.f3(new A1(),new A2(),new A3()));
        assertEquals("FM2:A1A2A3A4",fm.f4(new A1(),new A2(),new A3(),new A4()));
        assertEquals("FM2:A1A2A3A4A5",fm.f5(new A1(),new A2(),new A3(),new A4(),new A5()));
        assertEquals("FM2:A1A2A3A4A5A6",fm.f6(new A1(),new A2(),new A3(),new A4(),new A5(),new A6()));
        assertEquals("FM2:A1A2A3A4A5A6A7",fm.f7(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7()));
        assertEquals("FM2:A1A2A3A4A5A6A7A8",fm.f8(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertEquals("FM2:C1A2A3A4A5A6A7A8A9",fm.f9(new C1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertEquals("FM2:D1A2A3A4A5A6A7A8A9A10",fm.f10(new D1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));
    }

    @Test
    public void functionsETest() throws IsNull, IsMandatory {
        FunctionMethods2 fm = new FunctionMethods2();
        assertEquals("FM2:A1",fm.f1E(new A1()));
        assertEquals("FM2:A1A2",fm.f2E(new A1(),new A2()));
        assertEquals("FM2:A1A2A3",fm.f3E(new A1(),new A2(),new A3()));
        assertEquals("FM2:A1A2A3A4",fm.f4E(new A1(),new A2(),new A3(),new A4()));
        assertEquals("FM2:A1A2A3A4A5",fm.f5E(new A1(),new A2(),new A3(),new A4(),new A5()));
        assertEquals("FM2:A1A2A3A4A5A6",fm.f6E(new A1(),new A2(),new A3(),new A4(),new A5(),new A6()));
        assertEquals("FM2:A1A2A3A4A5A6A7",fm.f7E(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7()));
        assertEquals("FM2:A1A2A3A4A5A6A7A8",fm.f8E(new A1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertEquals("FM2:C1A2A3A4A5A6A7A8A9",fm.f9E(new C1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertEquals("FM2:D1A2A3A4A5A6A7A8A9A10",fm.f10E(new D1(),new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));

        assertThrows(IsNull.class,()->fm.f1E(null));
        assertThrows(IsNull.class,()->fm.f2E(null,new A2()));
        assertThrows(IsNull.class,()->fm.f3E(null,new A2(),new A3()));
        assertThrows(IsNull.class,()->fm.f4E(null,new A2(),new A3(),new A4()));
        assertThrows(IsNull.class,()->fm.f5E(null,new A2(),new A3(),new A4(),new A5()));
        assertThrows(IsNull.class,()->fm.f6E(null,new A2(),new A3(),new A4(),new A5(),new A6()));
        assertThrows(IsNull.class,()->fm.f7E(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7()));
        assertThrows(IsNull.class,()->fm.f8E(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertThrows(IsNull.class,()->fm.f9E(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertThrows(IsNull.class,()->fm.f10E(null,new A2(),new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));

        assertThrows(IsMandatory.class,()->fm.f2E(new A1(),null));
        assertThrows(IsMandatory.class,()->fm.f3E(new A1(),null,new A3()));
        assertThrows(IsMandatory.class,()->fm.f4E(new A1(),null,new A3(),new A4()));
        assertThrows(IsMandatory.class,()->fm.f5E(new A1(),null,new A3(),new A4(),new A5()));
        assertThrows(IsMandatory.class,()->fm.f6E(new A1(),null,new A3(),new A4(),new A5(),new A6()));
        assertThrows(IsMandatory.class,()->fm.f7E(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7()));
        assertThrows(IsMandatory.class,()->fm.f8E(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8()));
        assertThrows(IsMandatory.class,()->fm.f9E(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9()));
        assertThrows(IsMandatory.class,()->fm.f10E(new A1(),null,new A3(),new A4(),new A5(),new A6(),new A7(),new A8(),new A9(),new A10()));

    }

}