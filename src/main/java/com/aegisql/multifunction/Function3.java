package com.aegisql.multifunction;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Function3<A1,A2,A3,R> {

    R apply(A1 arg1, A2 arg2, A3 arg3);

    default <V> Function3<A1, A2, A3, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (a1,a2,a3) -> after.apply(apply(a1, a2, a3));
    }

    static <A1,A2,A3,R> Function3<A1,A2,A3,R> dispatch(ToInt3Function<? super A1,? super A2,? super A3> dispatchFunction, Function3<? super A1,? super A2,? super A3, R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function3 dispatch function is null");
        Objects.requireNonNull(functions,"Function3 expects a collection of triple argument functions");
        final Function3<A1,A2,A3,R>[] finalFunctions = (Function3<A1,A2,A3,R>[]) functions.clone();
        if(Arrays.stream(finalFunctions).anyMatch(Objects::isNull)) {
            throw new RuntimeException("Function3 expects not null functions");
        }
        return (arg1,arg2,arg3) -> {
            int pos = dispatchFunction.applyAsInt(arg1,arg2,arg3);
            if(pos < 0 || pos >= finalFunctions.length) {
                throw new RuntimeException("Function3 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalFunctions.length-1)+"; arg1="+arg1+"; arg2="+arg2+"; arg3="+arg3);
            }
            return finalFunctions[pos].apply(arg1,arg2,arg3);
        };
    }

    static <A1,A2,A3,R> Function3<A1,A2,A3,R> dispatch(Predicate3<? super A1,? super A2,? super A3> dispatchPredicate, Function3<? super A1,? super A2,? super A3,R> function1, Function3<? super A1,? super A2,? super A3,R> function2) {
        Objects.requireNonNull(dispatchPredicate,"Function3 dispatch predicate3 is null");
        Objects.requireNonNull(function1,"Function3 first function3 is null");
        Objects.requireNonNull(function2,"Function3 second function3 is null");
        return (arg1,arg2,arg3) -> {
            if(dispatchPredicate.test(arg1,arg2,arg3)) {
                return function1.apply(arg1, arg2,arg3);
            } else {
                return function2.apply(arg1, arg2, arg3);
            }
        };
    }

}
