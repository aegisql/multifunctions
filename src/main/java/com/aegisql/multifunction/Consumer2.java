package com.aegisql.multifunction;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

import static com.aegisql.multifunction.Utils.*;
import static java.util.Objects.requireNonNull;

public interface Consumer2<A1,A2> extends BiConsumer<A1,A2> {

    @FunctionalInterface
    interface Throwing<A1,A2>{ void accept(A1 a1, A2 a2) throws Exception; }

    default Runnable lazyAccept(A1 a1, A2 a2) {
        return acceptArg1(a1).acceptArg1(a2);
    }
    default Consumer1<A2> acceptArg1(A1 a1) {
        return (a2)->this.accept(a1,a2);
    }
    default Consumer1<A2> acceptArg1(Supplier<A1> a1Supplier) {
        return (a2)->this.accept(a1Supplier.get(),a2);
    }
    default Consumer1<A1> acceptArg2(A2 a2) {
        return (a1)->accept(a1,a2);
    }
    default Consumer1<A1> acceptArg2(Supplier<A2> a2Supplier) {
        return (a1)->this.accept(a1,a2Supplier.get());
    }
    default <X> Consumer3<X,A1,A2> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    @SafeVarargs
    static <A1,A2> Consumer2<A1,A2> dispatch(ToIntBiFunction<? super A1,? super A2> dispatchFunction, Consumer2<? super A1,? super A2>... consumers) {
        requireNonNull(dispatchFunction,"Consumer2 expects a dispatch function");
        var finalConsumers = validatedArrayCopy(consumers,"Consumer1");
        return (a1,a2) -> arrayValue(dispatchFunction.applyAsInt(a1,a2),finalConsumers).accept(a1,a2);
    }

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

    static <A1,A2> Consumer2<A1,A2> of(BiConsumer<A1,A2> f) {
        return f::accept;
    }

    static <A1,a2> Consumer2<A1,a2> throwing(Throwing<A1,a2> f) {
        return throwing(f,"{0}; args:({1},{2})");
    }

    static <A1,a2> Consumer2<A1,a2> throwing(Throwing<A1,a2> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,a2> Consumer2<A1,a2> throwing(Throwing<A1,a2> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2)->{
            try {
                f.accept(a1,a2);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2),e);
            }
        };
    }
}
