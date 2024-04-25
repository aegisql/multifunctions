package com.aegisql.multifunction.harness;

public abstract class AA implements TestType{
    @Override
    public String val() {
        return getClass().getSimpleName();
    }
    @Override
    public String toString() {
        return val();
    }
}
