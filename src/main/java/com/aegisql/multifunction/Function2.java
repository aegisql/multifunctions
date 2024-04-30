/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

import static com.aegisql.multifunction.Utils.*;

@FunctionalInterface
public interface Function2 <A1,A2,R> extends BiFunction<A1,A2,R> {

    @FunctionalInterface
    interface Throwing<A1,A2,R>{ R apply(A1 a1, A2 a2) throws Exception; }

    default SupplierExt<R> lazyApply(A1 a1, A2 a2) {
        return applyArg1(a1).applyArg1(a2);
    }
    default Function1<A2,R> applyArg1(A1 a1) {
        return (a2)->apply(a1,a2);
    }
    default Function1<A2,R> applyArg1(Supplier<A1> a1Supplier) {
        return (a2)->apply(a1Supplier.get(),a2);
    }
    default Function1<A1,R> applyArg2(final A2 a2) {
        return a1->this.apply(a1,a2);
    }
    default Function1<A1,R> applyArg2(Supplier<A2> a2Supplier) {
        return (a1)->apply(a1,a2Supplier.get());
    }
    default <X> Function3<X,A1,A2,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    default Function2<A1,A2,Optional<R>> optional() {
        return (a1,a2)->{
            try {
                return Optional.ofNullable(apply(a1,a2));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function2<A1,A2,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function2<A1,A2,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2)->{
            try {
                return apply(a1,a2);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    @SafeVarargs
    static <A1,A2,R> Function2<A1,A2,R> dispatch(ToIntBiFunction<? super A1,? super A2> dispatchFunction, Function2<? super A1,? super A2,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function2 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function2");
        return (a1,a2) -> arrayValue(dispatchFunction.applyAsInt(a1,a2),finalFunctions).apply(a1,a2);
    }

    static <A1,A2,R> Function2<A1,A2,R> dispatch(BiPredicate<? super A1,? super A2> dispatchPredicate, Function2<? super A1,? super A2,R> function1, Function2<? super A1,? super A2,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function2");
        return (a1,a2) -> {
            if(dispatchPredicate.test(a1,a2)) {
                return function1.apply(a1, a2);
            } else {
                return function2.apply(a1, a2);
            }
        };
    }

    static <A1,A2,R> Function2<A1,A2,R> of(BiFunction<A1,A2,R> f) {
        return f::apply;
    }

    static <A1,A2,R> Function2<A1,A2,R> throwing(Throwing<A1,A2,R> f) {
        return throwing(f,"{0}; args:({1},{2})");
    }

    static <A1,A2,R> Function2<A1,A2,R> throwing(Throwing<A1,A2,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,A2,R> Function2<A1,A2,R> throwing(Throwing<A1,A2,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2)->{
            try {
                return f.apply(a1,a2);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2),e);
            }
        };
    }

    static <A1,A2,R> Function2<A1,A2,R> throwing(Throwing<A1,A2,R> f, Function3<? super Exception,A1,A2,R> errorProcessor) {
        return (a1,a2)->{
            try {
                return f.apply(a1,a2);
            } catch (Exception e) {
                return errorProcessor.apply(e,a1,a2);
            }
        };
    }
}
