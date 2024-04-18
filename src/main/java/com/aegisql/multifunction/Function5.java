package com.aegisql.multifunction;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
@FunctionalInterface
public interface Function5<A1,A2,A3,A4,A5,R> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,R>{ R apply(A1 a1, A2 a2, A3 a3, A4 a4, A5 a5) throws Exception; }

    R apply(A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5);

    default <V> Function5<A1, A2, A3, A4, A5, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (a1,a2,a3,a4,a5) -> after.apply(apply(a1, a2, a3, a4, a5));
    }

    static Function5<Object,Object,Object,Object,Object,String> toString = (a1,a2,a3,a4,a5)->"(%s, %s, %s, %s, %s)".formatted(a1,a2,a3,a4,a5);
    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> dispatch(ToInt5Function<? super A1,? super A2,? super A3, ? super A4, ? super A5> dispatchFunction, Function5<? super A1,? super A2,? super A3, ? super A4, ? super A5, R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function5 dispatch function is null");
        Objects.requireNonNull(functions,"Function5 expects a collection of five argument functions");
        final Function5<A1,A2,A3,A4,A5,R>[] finalFunctions = (Function5<A1,A2,A3,A4,A5,R>[]) functions.clone();
        if(Arrays.stream(finalFunctions).anyMatch(Objects::isNull)) {
            throw new RuntimeException("Function5 expects not null functions");
        }
        return (arg1,arg2,arg3,arg4,arg5) -> {
            int pos = dispatchFunction.applyAsInt(arg1,arg2,arg3,arg4,arg5);
            if(pos < 0 || pos >= finalFunctions.length) {
                throw new RuntimeException("Function5 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalFunctions.length-1)+"; arg1="+arg1+"; arg2="+arg2+"; arg3="+arg3+"; arg4="+arg4+"; arg5="+arg5);
            }
            return finalFunctions[pos].apply(arg1,arg2,arg3,arg4,arg5);
        };
    }

    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> dispatch(Predicate5<? super A1,? super A2,? super A3,? super A4, ? super A5> dispatchPredicate, Function5<? super A1,? super A2,? super A3,? super A4, ? super A5, R> function1, Function5<? super A1,? super A2,? super A3,? super A4, ? super A5, R> function2) {
        Objects.requireNonNull(dispatchPredicate,"Function5 dispatch predicate5 is null");
        Objects.requireNonNull(function1,"Function5 first function5 is null");
        Objects.requireNonNull(function2,"Function5 second function5 is null");
        return (arg1,arg2,arg3,arg4,arg5) -> {
            if(dispatchPredicate.test(arg1,arg2,arg3,arg4,arg5)) {
                return function1.apply(arg1, arg2,arg3,arg4,arg5);
            } else {
                return function2.apply(arg1, arg2, arg3,arg4,arg5);
            }
        };
    }

}
