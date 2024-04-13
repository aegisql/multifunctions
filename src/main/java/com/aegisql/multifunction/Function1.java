package com.aegisql.multifunction;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public interface Function1 <A1,R> extends Function<A1,R> {

    static <A1,R> Function<A1,R> dispatch(ToIntFunction<? super A1> dispatchFunction, Function<? super A1,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function1 expects a not null dispatch function");
        Objects.requireNonNull(functions,"Function1 expects a collection of single argument functions");
        final Function<A1,R>[] finalFunctions = (Function<A1,R>[]) functions.clone();
        if(Arrays.stream(finalFunctions).anyMatch(Objects::isNull)) {
            throw new RuntimeException("Function1 expects not null functions");
        }
        return arg1 -> {
            int pos = dispatchFunction.applyAsInt(arg1);
            if(pos < 0 || pos >= finalFunctions.length) {
                throw new RuntimeException("Function1 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalFunctions.length-1)+"; arg1="+arg1);
            }
            return finalFunctions[pos].apply(arg1);
        };
    }

    static <A1,R> Function<A1,R> dispatch(Predicate<? super A1> dispatchPredicate, Function<? super A1,R> function1, Function<? super A1,R> function2) {
        Objects.requireNonNull(dispatchPredicate,"Function1 dispatch predicate is null");
        Objects.requireNonNull(function1,"Function1 first function is null");
        Objects.requireNonNull(function2,"Function1 second function is null");
        return (arg1) -> {
            if(dispatchPredicate.test(arg1)) {
                return function1.apply(arg1);
            } else {
                return function2.apply(arg1);
            }
        };
    }

    static <A1,R> Function1<A1,R> of(Function<A1,R> f) {
        return a1->f.apply(a1);
    }

}
