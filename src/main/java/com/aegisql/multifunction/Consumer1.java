package com.aegisql.multifunction;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public interface Consumer1 {

    static <A1> Consumer<A1> dispatch(ToIntFunction<? super A1> dispatchFunction, Consumer<? super A1>... consumers) {
        Objects.requireNonNull(dispatchFunction,"Consumer1 expects a not null dispatch function");
        Objects.requireNonNull(consumers,"Consumer1 expects a collection of single argument consumers");
        final Consumer<A1>[] finalConsumers = (Consumer<A1>[]) consumers.clone();
        if(Arrays.stream(finalConsumers).anyMatch(Objects::isNull)) {
            throw new RuntimeException("Consumer1 expects not null consumers");
        }
        return arg1 -> {
            int pos = dispatchFunction.applyAsInt(arg1);
            if(pos < 0 || pos >= finalConsumers.length) {
                throw new RuntimeException("Consumer1 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalConsumers.length-1)+"; arg1="+arg1);
            }
            finalConsumers[pos].accept(arg1);
        };
    }

    static <A1> Consumer<A1> dispatch(Predicate<? super A1> dispatchPredicate, Consumer<? super A1> consumer1, Consumer<? super A1> consumer2) {
        Objects.requireNonNull(dispatchPredicate,"Consumer1 dispatch predicate is null");
        Objects.requireNonNull(consumer1,"Consumer1 first consumer is null");
        Objects.requireNonNull(consumer2,"Consumer1 second consumer is null");
        return arg1 -> {
            if(dispatchPredicate.test(arg1)) {
                consumer1.accept(arg1);
            } else {
                consumer2.accept(arg1);
            }
        };
    }

}
