/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.aegisql.multifunction.Utils.*;
import static java.util.Objects.requireNonNull;

public interface Consumer1<A1> extends Consumer<A1> {

    @FunctionalInterface
    interface Throwing<A1>{ void accept(A1 a1) throws Exception; }

    default RunnableExt lazyAccept(A1 a1) {
        return acceptArg1(a1);
    }
    default RunnableExt acceptArg1(A1 a1) {
        return ()->this.accept(a1);
    }
    default RunnableExt acceptArg1(Supplier<A1> a1Supplier) {
        return ()->this.accept(a1Supplier.get());
    }

    default <X> Consumer2<X,A1> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    default Consumer1<A1> before(Consumer1<? super A1> before) {
        return (a1)-> {
            before.accept(a1);
            this.accept(a1);
        };
    }

    default Consumer1<A1>  after(Consumer1<? super A1>  after) {
        return (a1)-> {
            this.accept(a1);
            after.accept(a1);
        };
    }

    @SafeVarargs
    static <A1> Consumer1<A1> dispatch(ToIntFunction<? super A1> dispatchFunction, Consumer1<? super A1>... consumers) {
        requireNonNull(dispatchFunction,"Consumer1 expects a dispatch function");
        var finalConsumers = validatedArrayCopy(consumers,"Consumer1");
        return (a1) -> arrayValue(dispatchFunction.applyAsInt(a1),finalConsumers).accept(a1);
    }

    static <A1> Consumer1<A1> dispatch(Predicate<? super A1> dispatchPredicate, Consumer1<? super A1> consumer1, Consumer1<? super A1> consumer2) {
        requiresNotNullArgs(dispatchPredicate,consumer1,consumer2,"Consumer1");
        return (a1) -> {
            if(dispatchPredicate.test(a1)) {
                consumer1.accept(a1);
            } else {
                consumer2.accept(a1);
            }
        };
    }

    static <A1> Consumer1<A1> of(Consumer<A1> f) {
        return f::accept;
    }

    static <A1> Consumer1<A1> throwing(Throwing<A1> f) {
        return throwing(f,"{0}; args:({1})");
    }

    static <A1> Consumer1<A1> throwing(Throwing<A1> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1> Consumer1<A1> throwing(Throwing<A1> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return a1->{
            try {
                f.accept(a1);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1),e);
            }
        };
    }

    static <A1> Consumer1<A1> throwing(Throwing<A1> f, Consumer2<A1,? super Exception> errorConsumer) {
        return (a1)->{
            try {
                f.accept(a1);
            } catch (Exception e) {
                errorConsumer.accept(a1,e);
            }
        };
    }
}
