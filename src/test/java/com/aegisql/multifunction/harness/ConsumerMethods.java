package com.aegisql.multifunction.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConsumerMethods {
    private String valConcat;

    public String getValConcat() {
        return valConcat;
    }

    public void assertValConcat(String expected) {
        assertNotNull(valConcat);
        assertEquals(expected,valConcat);
    }

    public void c(AA a1) {
        valConcat = ""+a1;
    }
    public void cE(AA a1) throws IsNull {
        if(a1==null) throw new IsNull("a1 is null");
        c(a1);
    }
    public void c(AA a1, A2 a2) {
        valConcat = ""+a1+a2;
    }
    public void cE(AA a1, A2 a2)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c(a1,a2);
    }

    public void c(AA a1, A2 a2, A3 a3) {
        valConcat = ""+a1+a2+a3;
    }

    public void cE(AA a1, A2 a2, A3 a3)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c(a1,a2,a3);
    }

    public void c(AA a1, A2 a2, A3 a3, A4 a4) {
        valConcat = ""+a1+a2+a3+a4;
    }

    public void cE(AA a1, A2 a2, A3 a3, A4 a4)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c(a1,a2,a3,a4);
    }

    public void c(AA a1, A2 a2, A3 a3, A4 a4, A5 a5) {
        valConcat = ""+a1+a2+a3+a4+a5;
    }

    public void cE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c(a1,a2,a3,a4,a5);
    }

    public void c(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6) {
        valConcat = ""+a1+a2+a3+a4+a5+a6;
    }

    public void cE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c(a1,a2,a3,a4,a5,a6);
    }

    public void c(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7) {
        valConcat = ""+a1+a2+a3+a4+a5+a6+a7;
    }

    public void cE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c(a1,a2,a3,a4,a5,a6,a7);
    }

    public void c(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8) {
        valConcat = ""+a1+a2+a3+a4+a5+a6+a7+a8;
    }

    public void cE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c(a1,a2,a3,a4,a5,a6,a7,a8);
    }

    public void c(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9) {
        valConcat = ""+a1+a2+a3+a4+a5+a6+a7+a8+a9;
    }

    public void cE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c(a1,a2,a3,a4,a5,a6,a7,a8,a9);
    }

    public void c(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10) {
        valConcat = ""+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10;
    }

    public void cE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10)throws IsNull,IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is missing");
        c(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

}
