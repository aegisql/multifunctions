package com.aegisql.multifunction;

import java.util.Arrays;
import java.util.Objects;

@FunctionalInterface
public interface Consumer3<A1,A2,A3> {

    void accept(A1 arg1, A2 arg2, A3 arg3);

    default Consumer3<A1, A2, A3> andThen(Consumer3<? super A1, ? super A2, ? super A3> after) {
        Objects.requireNonNull(after);

        return (a1,a2,a3) -> {
            accept(a1,a2,a3);
            after.accept(a1,a2,a3);
        };
    }

    static <A1,A2,A3> Consumer3<A1,A2,A3> dispatch(ToInt3Function<? super A1,? super A2,? super A3> dispatchFunction, Consumer3<? super A1,? super A2,? super A3>... consumers) {
        Objects.requireNonNull(dispatchFunction,"Consumer3 dispatch function is null");
        Objects.requireNonNull(consumers,"Consumer3 expects a collection of triple argument consumers");
        final Consumer3<A1,A2,A3>[] finalConsumers = (Consumer3<A1,A2,A3>[]) consumers.clone();
        if(Arrays.stream(finalConsumers).anyMatch(Objects::isNull)) {
            throw new RuntimeException("Consumer3 expects not null consumers");
        }
        return (arg1,arg2,arg3) -> {
            int pos = dispatchFunction.applyAsInt(arg1,arg2,arg3);
            if(pos < 0 || pos >= finalConsumers.length) {
                throw new RuntimeException("Consumer3 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalConsumers.length-1)+"; arg1="+arg1+"; arg2="+arg2+"; arg3="+arg3);
            }
            finalConsumers[pos].accept(arg1,arg2,arg3);
        };
    }

    static <A1,A2,A3> Consumer3<A1,A2,A3> dispatch(Predicate3<? super A1,? super A2,? super A3> dispatchPredicate, Consumer3<? super A1,? super A2,? super A3> consumer1, Consumer3<? super A1,? super A2,? super A3> consumer2) {
        Objects.requireNonNull(dispatchPredicate,"Consumer3 dispatch predicate3 is null");
        Objects.requireNonNull(consumer1,"Consumer3 first consumer3 is null");
        Objects.requireNonNull(consumer2,"Consumer3 second consumer3 is null");
        return (arg1,arg2,arg3) -> {
            if(dispatchPredicate.test(arg1,arg2,arg3)) {
                consumer1.accept(arg1, arg2,arg3);
            } else {
                consumer2.accept(arg1, arg2, arg3);
            }
        };
    }

}
