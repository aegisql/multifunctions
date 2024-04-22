package com.aegisql.multifunction;

import java.util.Objects;
import java.util.Optional;
import java.util.function.*;

import static com.aegisql.multifunction.Utils.*;

public interface Function1 <A1,R> extends Function<A1,R> {

    @FunctionalInterface
    interface Throwing<A1,R>{ R apply(A1 a1) throws Exception; }

    default SupplierExt<R> lazyApply(final A1 a1) {
        return applyArg1(a1);
    }

    default SupplierExt<R> applyArg1(final A1 a1) {
        return ()->this.apply(a1);
    }

    default SupplierExt<R> applyArg1(final Supplier<A1> a1Supplier) {
        return ()->this.apply(a1Supplier.get());
    }

    default Function1<A1, Optional<R>> optional() {
        return a->{
            try {
                return Optional.ofNullable(apply(a));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function1<A1,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function1<A1,R> orElse(Supplier<R> defaultValue) {
        return a->{
            try {
                return apply(a);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    @SafeVarargs
    static <A1,R> Function<A1,R> dispatch(ToIntFunction<? super A1> dispatchFunction, Function<? super A1,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function1 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function1");
        return arg1 -> arrayValue(dispatchFunction.applyAsInt(arg1),finalFunctions).apply(arg1);
    }

    static <A1,R> Function1<A1,R> dispatch(Predicate<? super A1> dispatchPredicate, Function<? super A1,R> function1, Function<? super A1,R> function2) {
        Utils.requiresNotNullArgs(dispatchPredicate,function1,function2,"Function1");
        return arg1 -> {
            if(dispatchPredicate.test(arg1)) {
                return function1.apply(arg1);
            } else {
                return function2.apply(arg1);
            }
        };
    }

    static <A1,R> Function1<A1,R> of(Function<A1,R>  f) {
        return f::apply;
    }

    static <A1,R> Function1<A1,R> throwing(Throwing<A1,R>  f) {
        return throwing(f,"{0}; arg:({1})");
    }

    static <A1,R> Function1<A1,R> throwing(Throwing<A1,R>  f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,R> Function1<A1,R> throwing(Throwing<A1,R>  f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return a1->{
            try {
                return f.apply(a1);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1),e);
            }
        };
    }

}
