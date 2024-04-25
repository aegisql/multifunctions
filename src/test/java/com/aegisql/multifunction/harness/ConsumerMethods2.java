package com.aegisql.multifunction.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConsumerMethods2 {
    private String valConcat;

    public String getValConcat() {
        return valConcat;
    }

    public void assertValConcat(String expected) {
        assertNotNull(valConcat);
        assertEquals(expected,valConcat);
    }

    public void c1(AA a1) {
        valConcat = "CM2:"+a1;
    }
    public void c1E(AA a1) throws IsNull {
        if(a1==null) throw new IsNull("a1 is null");
        c1(a1);
    }
    public void c2(AA a1, A2 a2) {
        valConcat = "CM2:"+a1+a2;
    }
    public void c2E(AA a1, A2 a2)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c2(a1,a2);
    }

    public void c3(AA a1, A2 a2, A3 a3) {
        valConcat = "CM2:"+a1+a2+a3;
    }

    public void c3E(AA a1, A2 a2, A3 a3)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c3(a1,a2,a3);
    }

    public void c4(AA a1, A2 a2, A3 a3, A4 a4) {
        valConcat = "CM2:"+a1+a2+a3+a4;
    }

    public void c4E(AA a1, A2 a2, A3 a3, A4 a4)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c4(a1,a2,a3,a4);
    }

    public void c5(AA a1, A2 a2, A3 a3, A4 a4, A5 a5) {
        valConcat = "CM2:"+a1+a2+a3+a4+a5;
    }

    public void c5E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c5(a1,a2,a3,a4,a5);
    }

    public void c6(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6) {
        valConcat = "CM2:"+a1+a2+a3+a4+a5+a6;
    }

    public void c6E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c6(a1,a2,a3,a4,a5,a6);
    }

    public void c7(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7) {
        valConcat = "CM2:"+a1+a2+a3+a4+a5+a6+a7;
    }

    public void c7E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c7(a1,a2,a3,a4,a5,a6,a7);
    }

    public void c8(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8) {
        valConcat = "CM2:"+a1+a2+a3+a4+a5+a6+a7+a8;
    }

    public void c8E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c8(a1,a2,a3,a4,a5,a6,a7,a8);
    }

    public void c9(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9) {
        valConcat = "CM2:"+a1+a2+a3+a4+a5+a6+a7+a8+a9;
    }

    public void c9E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c9(a1,a2,a3,a4,a5,a6,a7,a8,a9);
    }

    public void c10(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10) {
        valConcat = "CM2:"+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10;
    }

    public void c10E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c10(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

}
