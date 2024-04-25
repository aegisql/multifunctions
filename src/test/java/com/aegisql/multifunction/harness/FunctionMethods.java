package com.aegisql.multifunction.harness;

public class FunctionMethods {
    
    public String f(AA a1) {
        return ""+a1;
    }

    public String fE(AA a1) throws IsNull {
        if(a1==null) throw new IsNull("a1 is null");
        return f(a1);
    }

    public String f(AA a1, A2 a2) {
        return ""+a1+a2;
    }

    public String fE(AA a1, A2 a2) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f(a1,a2);
    }

    public String f(AA a1, A2 a2, A3 a3) {
        return ""+a1+a2+a3;
    }

    public String fE(AA a1, A2 a2, A3 a3) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f(a1,a2,a3);
    }

    public String f(AA a1, A2 a2, A3 a3, A4 a4) {
        return ""+a1+a2+a3+a4;
    }

    public String fE(AA a1, A2 a2, A3 a3, A4 a4) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f(a1,a2,a3,a4);
    }

    public String f(AA a1, A2 a2, A3 a3, A4 a4, A5 a5) {
        return ""+a1+a2+a3+a4+a5;
    }

    public String fE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f(a1,a2,a3,a4,a5);
    }

    public String f(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6) {
        return ""+a1+a2+a3+a4+a5+a6;
    }

    public String fE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f(a1,a2,a3,a4,a5,a6);
    }

    public String f(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7) {
        return ""+a1+a2+a3+a4+a5+a6+a7;
    }

    public String fE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f(a1,a2,a3,a4,a5,a6,a7);
    }

    public String f(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8) {
        return ""+a1+a2+a3+a4+a5+a6+a7+a8;
    }

    public String fE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f(a1,a2,a3,a4,a5,a6,a7,a8);
    }

    public String f(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9) {
        return ""+a1+a2+a3+a4+a5+a6+a7+a8+a9;
    }

    public String fE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f(a1,a2,a3,a4,a5,a6,a7,a8,a9);
    }

    public String f(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10) {
        return ""+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10;
    }

    public String fE(AA a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10) throws IsNull, IsMandatory {
        if(a1==null) throw new IsNull("a1 is null");
        if(a2==null) throw new IsMandatory("a2 is null");
        return f(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

}
