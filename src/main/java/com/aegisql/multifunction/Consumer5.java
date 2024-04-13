package com.aegisql.multifunction;

import java.util.Arrays;
import java.util.Objects;

@FunctionalInterface
public interface Consumer5<A1,A2,A3,A4,A5> {

    void accept(A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5);

    default Consumer5<A1, A2, A3, A4, A5> andThen(Consumer5<? super A1, ? super A2, ? super A3, ? super A4, ? super A5> after) {
        Objects.requireNonNull(after);

        return (a1,a2,a3,a4,a5) -> {
            accept(a1,a2,a3,a4,a5);
            after.accept(a1,a2,a3,a4,a5);
        };
    }

    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> dispatch(ToInt5Function<? super A1,? super A2,? super A3, ? super A4, ? super A5> dispatchFunction, Consumer5<? super A1,? super A2,? super A3, ? super A4, ? super A5>... consumers) {
        Objects.requireNonNull(dispatchFunction,"Consumer5 dispatch function is null");
        Objects.requireNonNull(consumers,"Consumer5 expects a collection of five argument consumers");
        final Consumer5<A1,A2,A3,A4,A5>[] finalConsumers = (Consumer5<A1,A2,A3,A4,A5>[]) consumers.clone();
        if(Arrays.stream(finalConsumers).anyMatch(Objects::isNull)) {
            throw new RuntimeException("Consumer5 expects not null consumers");
        }
        return (arg1,arg2,arg3,arg4,arg5) -> {
            int pos = dispatchFunction.applyAsInt(arg1,arg2,arg3,arg4,arg5);
            if(pos < 0 || pos >= finalConsumers.length) {
                throw new RuntimeException("Consumer5 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalConsumers.length-1)+"; arg1="+arg1+"; arg2="+arg2+"; arg3="+arg3+"; arg4="+arg4+"; arg5="+arg5);
            }
            finalConsumers[pos].accept(arg1,arg2,arg3,arg4,arg5);
        };
    }

    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> dispatch(Predicate5<? super A1,? super A2,? super A3, ? super A4, ? super A5> dispatchPredicate, Consumer5<? super A1,? super A2,? super A3, ? super A4, ? super A5> consumer1, Consumer5<? super A1,? super A2,? super A3, ? super A4, ? super A5> consumer2) {
        Objects.requireNonNull(dispatchPredicate,"Consumer5 dispatch predicate5 is null");
        Objects.requireNonNull(consumer1,"Consumer5 first consumer5 is null");
        Objects.requireNonNull(consumer2,"Consumer5 second consumer5 is null");
        return (arg1,arg2,arg3,arg4,arg5) -> {
            if(dispatchPredicate.test(arg1,arg2,arg3,arg4,arg5)) {
                consumer1.accept(arg1, arg2,arg3,arg4,arg5);
            } else {
                consumer2.accept(arg1, arg2, arg3,arg4,arg5);
            }
        };
    }

}
