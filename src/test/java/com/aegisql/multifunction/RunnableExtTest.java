package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class RunnableExtTest {

    void doSomething() {
        System.out.println("Doing Something...");
    }

    void runMe() throws Exception {
        throw new Exception("NOT");
    }

    @Test
    void of() {
        var r = RunnableExt.of(() -> {
            System.out.println("RUN!");
        });
        r.run();
    }

    @Test
    void throwing() {
        var r = RunnableExt.throwing(this::runMe);
        assertThrows(Exception.class,r::run);
    }

    @Test
    void testThrowing() {
        var r = RunnableExt.throwing(this::runMe,"TEST EXCEPTION {0}");
        assertThrows(Exception.class,r::run);
    }

    @Test
    void testThrowing1() {
        var r = RunnableExt.throwing(this::runMe,"TEST EXCEPTION {0}", InvalidParameterException::new);
        assertThrows(Exception.class,r::run);
    }

    @Test
    void testThrowing2() {
        var r = RunnableExt.throwing(this::runMe,e->{
            throw new RuntimeException(e);
        });
        assertThrows(Exception.class,r::run);
    }

    @Test
    public void beforeAfterTest() {
        RunnableExt s = RunnableExt.of(this::doSomething).before(() -> {
            System.out.println("ready to execute doSomething()");
        }).after(() -> System.out.println("doSomething() completed "));
        s.run();
    }

}