package com.aegisql.multifunction;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.ToIntBiFunction;

public interface Function2 <A1,A2,R> extends BiFunction<A1,A2,R> {

    static <A1,A2,R> BiFunction<A1,A2,R> dispatch(ToIntBiFunction<? super A1,? super A2> dispatchFunction, BiFunction<? super A1,? super A2,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function2 expects a not null dispatch function");
        Objects.requireNonNull(functions,"Function2 expects a collection of single argument functions");
        final BiFunction<A1,A2,R>[] finalFunctions = (BiFunction<A1,A2,R>[]) functions.clone();
        if(Arrays.stream(finalFunctions).anyMatch(Objects::isNull)) {
            throw new RuntimeException("Function2 expects not null functions");
        }
        return (arg1,arg2) -> {
            int pos = dispatchFunction.applyAsInt(arg1,arg2);
            if(pos < 0 || pos >= finalFunctions.length) {
                throw new RuntimeException("Function2 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalFunctions.length-1)+"; arg1="+arg1+"; arg2="+arg2);
            }
            return finalFunctions[pos].apply(arg1,arg2);
        };
    }

    static <A1,A2,R> BiFunction<A1,A2,R> dispatch(BiPredicate<? super A1,? super A2> dispatchPredicate, BiFunction<? super A1,? super A2,R> function1, BiFunction<? super A1,? super A2,R> function2) {
        Objects.requireNonNull(dispatchPredicate,"Function2 dispatch bi-predicate is null");
        Objects.requireNonNull(function1,"Function2 first bi-function is null");
        Objects.requireNonNull(function2,"Function2 second bi-function is null");
        return (arg1,arg2) -> {
            if(dispatchPredicate.test(arg1,arg2)) {
                return function1.apply(arg1, arg2);
            } else {
                return function2.apply(arg1, arg2);
            }
        };
    }

    default Function1<A2,R> curry1(final A1 a1) {
        return a2->this.apply(a1,a2);
    }

    default Function1<A1,R> curry2(final A2 a2) {
        return a1->this.apply(a1,a2);
    }

    static <A1,A2,R> Function2<A1,A2,R> of(BiFunction<A1,A2,R> f) {
        return (a1,a2)->f.apply(a1,a2);
    }

}
