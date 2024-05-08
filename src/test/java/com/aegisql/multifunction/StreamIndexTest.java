package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StreamIndexTest {

    @Test
    public void streamTest() {
        Stream.of(10,20,30,40,50,60,70,80,90,100)
                .forEach(Consumer2.of((Integer i,Integer x)->{
                    System.out.println(i+"*"+x+"="+(i*x));
                }).acceptArg1(SupplierExt.ofConst(new AtomicInteger(1))
                  .transform(AtomicInteger::getAndIncrement))
                );
    }
}
