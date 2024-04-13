package com.aegisql.multifunction;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Function4<A1,A2,A3,A4,R> {

    R apply(A1 arg1, A2 arg2, A3 arg3, A4 arg4);

    default <V> Function4<A1, A2, A3, A4, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (a1,a2,a3,a4) -> after.apply(apply(a1, a2, a3, a4));
    }

    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> dispatch(ToInt4Function<? super A1,? super A2,? super A3, ? super A4> dispatchFunction, Function4<? super A1,? super A2,? super A3, ? super A4, R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function4 dispatch function is null");
        Objects.requireNonNull(functions,"Function4 expects a collection of four argument functions");
        final Function4<A1,A2,A3,A4,R>[] finalFunctions = (Function4<A1,A2,A3,A4,R>[]) functions.clone();
        if(Arrays.stream(finalFunctions).anyMatch(Objects::isNull)) {
            throw new RuntimeException("Function4 expects not null functions");
        }
        return (arg1,arg2,arg3,arg4) -> {
            int pos = dispatchFunction.applyAsInt(arg1,arg2,arg3,arg4);
            if(pos < 0 || pos >= finalFunctions.length) {
                throw new RuntimeException("Function4 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalFunctions.length-1)+"; arg1="+arg1+"; arg2="+arg2+"; arg3="+arg3+"; arg4="+arg4);
            }
            return finalFunctions[pos].apply(arg1,arg2,arg3,arg4);
        };
    }

    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> dispatch(Predicate4<? super A1,? super A2,? super A3,? super A4> dispatchPredicate, Function4<? super A1,? super A2,? super A3,? super A4,R> function1, Function4<? super A1,? super A2,? super A3,? super A4, R> function2) {
        Objects.requireNonNull(dispatchPredicate,"Function4 dispatch predicate4 is null");
        Objects.requireNonNull(function1,"Function4 first function4 is null");
        Objects.requireNonNull(function2,"Function4 second function4 is null");
        return (arg1,arg2,arg3,arg4) -> {
            if(dispatchPredicate.test(arg1,arg2,arg3,arg4)) {
                return function1.apply(arg1, arg2,arg3,arg4);
            } else {
                return function2.apply(arg1, arg2, arg3,arg4);
            }
        };
    }

}
