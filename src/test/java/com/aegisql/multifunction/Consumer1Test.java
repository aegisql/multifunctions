package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static com.aegisql.multifunction.Function1Test.russianCyrillicPattern;

class Consumer1Test {

    public void greetEng(String name) {
        System.out.println("Hello, "+name);
    }

    public void greetRus(String name) {
        System.out.println("Привет, "+name);
    }

    public void mul2(int x) {
        System.out.println(x+"*2="+(x*2));
    }

    public void mul3(int x) {
        System.out.println(x+"*3="+(x*3));
    }

    public void mul4(int x) {
        System.out.println(x+"*4="+(x*4));
    }


    @Test
    public void consumer1Test() {
        Consumer<String> dispatch = Consumer1.dispatch(name -> name.matches(russianCyrillicPattern),
                this::greetRus,
                this::greetEng);

        dispatch.accept("Mike");
        dispatch.accept("Миша");

    }

    @Test
    public void consumer1MulTest() {
        Consumer<Integer> dispatch = Consumer1.dispatch(x -> x % 3,
                this::mul2,
                this::mul3,
                this::mul4
        );

        dispatch.accept(3);
        dispatch.accept(4);
        dispatch.accept(5);

    }

}