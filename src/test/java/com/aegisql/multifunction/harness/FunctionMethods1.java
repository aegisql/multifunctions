package com.aegisql.multifunction.harness;

public class FunctionMethods1 {
    
    public String f1(AA a1) {
        return "FM1:"+a1;
    }

    public String f1E(AA a1) throws IsNull {
        if(a1==null) throw new IsNull("a1 is null");
        return f1(a1);
    }

    public String f2(AA a1, A2 a2) {
        return "FM1:"+a1+a2;
    }

    public String f2E(AA a1, A2 a2) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f2(a1,a2);
    }

    public String f3(AA a1, A2 a2, A3 a3) {
        return "FM1:"+a1+a2+a3;
    }

    public String f3E(AA a1, A2 a2, A3 a3) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f3(a1,a2,a3);
    }

    public String f4(AA a1, A2 a2, A3 a3, A4 a4) {
        return "FM1:"+a1+a2+a3+a4;
    }

    public String f4E(AA a1, A2 a2, A3 a3, A4 a4) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f4(a1,a2,a3,a4);
    }

    public String f5(AA a1, A2 a2, A3 a3, A4 a4, A5 a5) {
        return "FM1:"+a1+a2+a3+a4+a5;
    }

    public String f5E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f5(a1,a2,a3,a4,a5);
    }

    public String f6(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6) {
        return "FM1:"+a1+a2+a3+a4+a5+a6;
    }

    public String f6E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f6(a1,a2,a3,a4,a5,a6);
    }

    public String f7(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7) {
        return "FM1:"+a1+a2+a3+a4+a5+a6+a7;
    }

    public String f7E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f7(a1,a2,a3,a4,a5,a6,a7);
    }

    public String f8(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8) {
        return "FM1:"+a1+a2+a3+a4+a5+a6+a7+a8;
    }

    public String f8E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f8(a1,a2,a3,a4,a5,a6,a7,a8);
    }

    public String f9(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9) {
        return "FM1:"+a1+a2+a3+a4+a5+a6+a7+a8+a9;
    }

    public String f9E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f9(a1,a2,a3,a4,a5,a6,a7,a8,a9);
    }

    public String f10(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10) {
        return "FM1:"+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10;
    }

    public String f10E(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f10(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

}
