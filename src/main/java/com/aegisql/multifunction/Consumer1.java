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

/**
 * The interface Consumer 1.
 *
 * @param <A1> the type parameter
 */
public interface Consumer1<A1> extends Consumer<A1> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1>{
        /**
         * Accept.
         *
         * @param a1 the a 1
         * @throws Exception the exception
         */
        void accept(A1 a1) throws Exception; }

    /**
     * Lazy accept runnable ext.
     *
     * @param a1 the a 1
     * @return the runnable ext
     */
    default RunnableExt lazyAccept(A1 a1) {
        return acceptArg1(a1);
    }

    /**
     * Accept arg 1 runnable ext.
     *
     * @param a1 the a 1
     * @return the runnable ext
     */
    default RunnableExt acceptArg1(A1 a1) {
        var f = this;
        return new RunnableExt() {
            @Override
            public void run() {
                accept(a1);
            }
            @SuppressWarnings("unchecked")
            @Override
            public Consumer1<A1> uncurry() {
                return f;
            }
        };
    }

    /**
     * Accept arg 1 runnable ext.
     *
     * @param a1Supplier the a 1 supplier
     * @return the runnable ext
     */
    default RunnableExt acceptArg1(Supplier<A1> a1Supplier) {
        var f = this;
        return new RunnableExt() {
            @Override
            public void run() {
                accept(a1Supplier.get());
            }
            @SuppressWarnings("unchecked")
            @Override
            public Consumer1<A1> uncurry() {
                return f;
            }
        };
    }

    /**
     * Uncurry consumer 2.
     *
     * @param <X> the type parameter
     * @return the consumer 2
     */
    default <X> Consumer2<X,A1> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Before consumer 1.
     *
     * @param before the before
     * @return the consumer 1
     */
    default Consumer1<A1> before(Consumer1<? super A1> before) {
        return (a1)-> {
            before.accept(a1);
            this.accept(a1);
        };
    }

    /**
     * After consumer 1.
     *
     * @param after the after
     * @return the consumer 1
     */
    default Consumer1<A1>  after(Consumer1<? super A1>  after) {
        return (a1)-> {
            this.accept(a1);
            after.accept(a1);
        };
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 1; }

    /**
     * Dispatch consumer 1.
     *
     * @param <A1>             the type parameter
     * @param dispatchFunction the dispatch function
     * @param consumers        the consumers
     * @return the consumer 1
     */
    @SafeVarargs
    static <A1> Consumer1<A1> dispatch(ToIntFunction<? super A1> dispatchFunction, Consumer1<? super A1>... consumers) {
        requireNonNull(dispatchFunction,"Consumer1 expects a dispatch function");
        var finalConsumers = validatedArrayCopy(consumers,"Consumer1");
        return (a1) -> arrayValue(dispatchFunction.applyAsInt(a1),finalConsumers).accept(a1);
    }

    /**
     * Dispatch consumer 1.
     *
     * @param <A1>              the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param consumer1         the consumer 1
     * @param consumer2         the consumer 2
     * @return the consumer 1
     */
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

    /**
     * Of consumer 1.
     *
     * @param <A1> the type parameter
     * @param f    the f
     * @return the consumer 1
     */
    static <A1> Consumer1<A1> of(Consumer<A1> f) {
        return f::accept;
    }

    /**
     * Throwing consumer 1.
     *
     * @param <A1> the type parameter
     * @param f    the f
     * @return the consumer 1
     */
    static <A1> Consumer1<A1> throwing(Throwing<A1> f) {
        return throwing(f,"{0}; args:({1})");
    }

    /**
     * Throwing consumer 1.
     *
     * @param <A1>   the type parameter
     * @param f      the f
     * @param format the format
     * @return the consumer 1
     */
    static <A1> Consumer1<A1> throwing(Throwing<A1> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing consumer 1.
     *
     * @param <A1>             the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the consumer 1
     */
    static <A1> Consumer1<A1> throwing(Throwing<A1> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return a1->{
            try {
                f.accept(a1);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1),e);
            }
        };
    }

    /**
     * Throwing consumer 1.
     *
     * @param <A1>          the type parameter
     * @param f             the f
     * @param errorConsumer the error consumer
     * @return the consumer 1
     */
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
