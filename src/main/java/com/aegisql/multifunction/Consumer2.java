/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

import static com.aegisql.multifunction.Utils.*;
import static java.util.Objects.requireNonNull;

/**
 * The interface Consumer 2.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 */
public interface Consumer2<A1,A2> extends BiConsumer<A1,A2> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2>{
        /**
         * Accept.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @throws Exception the exception
         */
        void accept(A1 a1, A2 a2) throws Exception; }

    /**
     * Lazy accept runnable.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @return the runnable
     */
    default Runnable lazyAccept(A1 a1, A2 a2) {
        return acceptArg1(a1).acceptArg1(a2);
    }

    /**
     * Accept arg 1 consumer 1.
     *
     * @param a1 the a 1
     * @return the consumer 1
     */
    default Consumer1<A2> acceptArg1(A1 a1) {
        var f = this;
        return new Consumer1<>() {
            @Override
            public void accept(A2 a2) {
                f.accept(a1,a2);
            }
            @SuppressWarnings("unchecked")
            @Override
            public Consumer2<A1,A2> uncurry() {
                return f;
            }
        };
    }

    /**
     * Accept arg 1 consumer 1.
     *
     * @param a1Supplier the a 1 supplier
     * @return the consumer 1
     */
    default Consumer1<A2> acceptArg1(Supplier<A1> a1Supplier) {
        var f = this;
        return new Consumer1<>() {
            @Override
            public void accept(A2 a2) {
                f.accept(a1Supplier.get(),a2);
            }
            @SuppressWarnings("unchecked")
            @Override
            public Consumer2<A1,A2> uncurry() {
                return f;
            }
        };
    }

    /**
     * Accept arg 2 consumer 1.
     *
     * @param a2 the a 2
     * @return the consumer 1
     */
    default Consumer1<A1> acceptArg2(A2 a2) {
        var f = this;
        return new Consumer1<>() {
            @Override
            public void accept(A1 a1) {
                f.accept(a1,a2);
            }
            @SuppressWarnings("unchecked")
            @Override
            public Consumer2<A1,A2> uncurry() {
                return f;
            }
        };
    }

    /**
     * Accept arg 2 consumer 1.
     *
     * @param a2Supplier the a 2 supplier
     * @return the consumer 1
     */
    default Consumer1<A1> acceptArg2(Supplier<A2> a2Supplier) {
        var f = this;
        return new Consumer1<>() {
            @Override
            public void accept(A1 a1) {
                f.accept(a1,a2Supplier.get());
            }
            @SuppressWarnings("unchecked")
            @Override
            public Consumer2<A1,A2> uncurry() {
                return f;
            }
        };
    }

    /**
     * Uncurry consumer 3.
     *
     * @param <X> the type parameter
     * @return the consumer 3
     */
    default <X> Consumer3<X,A1,A2> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Before consumer 2.
     *
     * @param before the before
     * @return the consumer 2
     */
    default Consumer2<A1,A2> before(Consumer2<? super A1,? super A2> before) {
        return (a1,a2)-> {
            before.accept(a1,a2);
            this.accept(a1,a2);
        };
    }

    /**
     * After consumer 2.
     *
     * @param after the after
     * @return the consumer 2
     */
    default Consumer2<A1,A2>  after(Consumer2<? super A1,? super A2>  after) {
        return (a1,a2)-> {
            this.accept(a1,a2);
            after.accept(a1,a2);
        };
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 2; }

    /**
     * Dispatch consumer 2.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param dispatchFunction the dispatch function
     * @param consumers        the consumers
     * @return the consumer 2
     */
    @SafeVarargs
    static <A1,A2> Consumer2<A1,A2> dispatch(ToIntBiFunction<? super A1,? super A2> dispatchFunction, Consumer2<? super A1,? super A2>... consumers) {
        requireNonNull(dispatchFunction,"Consumer2 expects a dispatch function");
        var finalConsumers = validatedArrayCopy(consumers,"Consumer1");
        return (a1,a2) -> arrayValue(dispatchFunction.applyAsInt(a1,a2),finalConsumers).accept(a1,a2);
    }

    /**
     * Dispatch consumer 2.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param consumer1         the consumer 1
     * @param consumer2         the consumer 2
     * @return the consumer 2
     */
    static <A1,A2> Consumer2<A1,A2> dispatch(BiPredicate<? super A1,? super A2> dispatchPredicate, Consumer2<? super A1,? super A2> consumer1, Consumer2<? super A1,? super A2> consumer2) {
        requiresNotNullArgs(dispatchPredicate,consumer1,consumer2,"Consumer2");
        return (a1,a2) -> {
            if(dispatchPredicate.test(a1,a2)) {
                consumer1.accept(a1,a2);
            } else {
                consumer2.accept(a1,a2);
            }
        };
    }

    /**
     * Of consumer 2.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param f    the f
     * @return the consumer 2
     */
    static <A1,A2> Consumer2<A1,A2> of(BiConsumer<A1,A2> f) {
        return f::accept;
    }

    /**
     * Throwing consumer 2.
     *
     * @param <A1> the type parameter
     * @param <a2> the type parameter
     * @param f    the f
     * @return the consumer 2
     */
    static <A1,a2> Consumer2<A1,a2> throwing(Throwing<A1,a2> f) {
        return throwing(f,"{0}; args:({1},{2})");
    }

    /**
     * Throwing consumer 2.
     *
     * @param <A1>   the type parameter
     * @param <a2>   the type parameter
     * @param f      the f
     * @param format the format
     * @return the consumer 2
     */
    static <A1,a2> Consumer2<A1,a2> throwing(Throwing<A1,a2> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing consumer 2.
     *
     * @param <A1>             the type parameter
     * @param <a2>             the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the consumer 2
     */
    static <A1,a2> Consumer2<A1,a2> throwing(Throwing<A1,a2> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2)->{
            try {
                f.accept(a1,a2);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2),e);
            }
        };
    }

    /**
     * Throwing consumer 2.
     *
     * @param <A1>          the type parameter
     * @param <A2>          the type parameter
     * @param f             the f
     * @param errorConsumer the error consumer
     * @return the consumer 2
     */
    static <A1,A2> Consumer2<A1,A2> throwing(Throwing<A1,A2> f, Consumer3<A1,A2,? super Exception> errorConsumer) {
        return (a1,a2)->{
            try {
                f.accept(a1,a2);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,e);
            }
        };
    }
}
