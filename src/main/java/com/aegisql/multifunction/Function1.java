/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.aegisql.multifunction.Utils.*;
import static java.util.Objects.requireNonNull;

/**
 * The interface Function 1.
 *
 * @param <A1> the type parameter
 * @param <R>  the type parameter
 */
@FunctionalInterface
public interface Function1 <A1,R> extends Function<A1,R> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <R>  the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,R>{
        /**
         * Apply r.
         *
         * @param a1 the a 1
         * @return the r
         * @throws Exception the exception
         */
        R apply(A1 a1) throws Exception; }

    /**
     * Lazy apply supplier ext.
     *
     * @param a1 the a 1
     * @return the supplier ext
     */
    default SupplierExt<R> lazyApply(final A1 a1) {
        return applyArg1(a1);
    }

    /**
     * Apply arg 1 supplier ext.
     *
     * @param a1 the a 1
     * @return the supplier ext
     */
    default SupplierExt<R> applyArg1(final A1 a1) {
        var f = this;
        return new SupplierExt<>() {
            @Override
            public R get() {
                return apply(a1);
            }
            @SuppressWarnings("unchecked")
            @Override
            public Function1<A1,R> uncurry() {
                return f;
            }
        };
    }

    /**
     * Apply arg 1 supplier ext.
     *
     * @param a1Supplier the a 1 supplier
     * @return the supplier ext
     */
    default SupplierExt<R> applyArg1(final Supplier<A1> a1Supplier) {
        var f = this;
        return new SupplierExt<>() {
            @Override
            public R get() {
                return apply(a1Supplier.get());
            }
            @SuppressWarnings("unchecked")
            @Override
            public Function1<A1,R> uncurry() {
                return f;
            }
        };
    }

    /**
     * Uncurry function 2.
     *
     * @param <X> the type parameter
     * @return the function 2
     */
    default <X> Function2<X,A1,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Optional function 1.
     *
     * @return the function 1
     */
    default Function1<A1, Optional<R>> optional() {
        return a->{
            try {
                return Optional.ofNullable(apply(a));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    /**
     * Or else function 1.
     *
     * @param defaultValue the default value
     * @return the function 1
     */
    default Function1<A1,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    /**
     * Or else function 1.
     *
     * @param defaultValue the default value
     * @return the function 1
     */
    default Function1<A1,R> orElse(Supplier<R> defaultValue) {
        return a->{
            try {
                return apply(a);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    /**
     * Before function 1.
     *
     * @param before the before
     * @return the function 1
     */
    default Function1<A1,R> before(Consumer1<A1> before) {
        return (a1)-> {
            before.accept(a1);
            return apply(a1);
        };
    }

    /**
     * After function 1.
     *
     * @param after the after
     * @return the function 1
     */
    default Function1<A1,R> after(Consumer2<A1,R> after) {
        return (a1)-> {
            var result = apply(a1);
            after.accept(a1,result);
            return result;
        };
    }

    /**
     * Dispatch function.
     *
     * @param <A1>             the type parameter
     * @param <R>              the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the function
     */
    @SafeVarargs
    static <A1,R> Function<A1,R> dispatch(ToIntFunction<? super A1> dispatchFunction, Function<? super A1,R>... functions) {
        requireNonNull(dispatchFunction,"Function1 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function1");
        return a -> arrayValue(dispatchFunction.applyAsInt(a),finalFunctions).apply(a);
    }

    /**
     * Dispatch function 1.
     *
     * @param <A1>              the type parameter
     * @param <R>               the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the function 1
     */
    static <A1,R> Function1<A1,R> dispatch(Predicate<? super A1> dispatchPredicate, Function<? super A1,R> function1, Function<? super A1,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function1");
        return a -> {
            if(dispatchPredicate.test(a)) {
                return function1.apply(a);
            } else {
                return function2.apply(a);
            }
        };
    }

    /**
     * Of function 1.
     *
     * @param <A1> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 1
     */
    static <A1,R> Function1<A1,R> of(Function<A1,R>  f) {
        return f::apply;
    }

    /**
     * Throwing function 1.
     *
     * @param <A1> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 1
     */
    static <A1,R> Function1<A1,R> throwing(Throwing<A1,R>  f) {
        return throwing(f,"{0}; arg:({1})");
    }

    /**
     * Throwing function 1.
     *
     * @param <A1>   the type parameter
     * @param <R>    the type parameter
     * @param f      the f
     * @param format the format
     * @return the function 1
     */
    static <A1,R> Function1<A1,R> throwing(Throwing<A1,R>  f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing function 1.
     *
     * @param <A1>             the type parameter
     * @param <R>              the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the function 1
     */
    static <A1,R> Function1<A1,R> throwing(Throwing<A1,R>  f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return a->{
            try {
                return f.apply(a);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a),e);
            }
        };
    }

    /**
     * Throwing function 1.
     *
     * @param <A1>           the type parameter
     * @param <R>            the type parameter
     * @param f              the f
     * @param errorProcessor the error processor
     * @return the function 1
     */
    static <A1,R> Function1<A1,R> throwing(Throwing<A1,R>  f, Function2<? super Exception,A1,R> errorProcessor) {
        return a->{
            try {
                return f.apply(a);
            } catch (Exception e) {
                return errorProcessor.apply(e,a);
            }
        };
    }
}
