package com.aegisql.multifunction;

import java.util.Arrays;
import java.util.Objects;

@FunctionalInterface
public interface Consumer4<A1,A2,A3,A4> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4>{ void accept(A1 a1, A2 a2, A3 a3, A4 a4) throws Exception; }

    void accept(A1 arg1, A2 arg2, A3 arg3, A4 arg4);

    default Consumer4<A1, A2, A3, A4> andThen(Consumer4<? super A1, ? super A2, ? super A3, ? super A4> after) {
        Objects.requireNonNull(after);

        return (a1,a2,a3,a4) -> {
            accept(a1,a2,a3,a4);
            after.accept(a1,a2,a3,a4);
        };
    }

    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> dispatch(ToInt4Function<? super A1,? super A2,? super A3, ? super A4> dispatchFunction, Consumer4<? super A1,? super A2,? super A3, ? super A4>... consumers) {
        Objects.requireNonNull(dispatchFunction,"Consumer4 dispatch function is null");
        Objects.requireNonNull(consumers,"Consumer4 expects a collection of four argument consumers");
        final Consumer4<A1,A2,A3,A4>[] finalConsumers = (Consumer4<A1,A2,A3,A4>[]) consumers.clone();
        if(Arrays.stream(finalConsumers).anyMatch(Objects::isNull)) {
            throw new RuntimeException("Consumer4 expects not null consumers");
        }
        return (arg1,arg2,arg3,arg4) -> {
            int pos = dispatchFunction.applyAsInt(arg1,arg2,arg3,arg4);
            if(pos < 0 || pos >= finalConsumers.length) {
                throw new RuntimeException("Consumer4 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalConsumers.length-1)+"; arg1="+arg1+"; arg2="+arg2+"; arg3="+arg3+"; arg4="+arg4);
            }
            finalConsumers[pos].accept(arg1,arg2,arg3,arg4);
        };
    }

    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> dispatch(Predicate4<? super A1,? super A2,? super A3, ? super A4> dispatchPredicate, Consumer4<? super A1,? super A2,? super A3, ? super A4> consumer1, Consumer4<? super A1,? super A2,? super A3, ? super A4> consumer2) {
        Objects.requireNonNull(dispatchPredicate,"Consumer4 dispatch predicate4 is null");
        Objects.requireNonNull(consumer1,"Consumer4 first consumer4 is null");
        Objects.requireNonNull(consumer2,"Consumer4 second consumer4 is null");
        return (arg1,arg2,arg3,arg4) -> {
            if(dispatchPredicate.test(arg1,arg2,arg3,arg4)) {
                consumer1.accept(arg1, arg2,arg3,arg4);
            } else {
                consumer2.accept(arg1, arg2, arg3,arg4);
            }
        };
    }

}
