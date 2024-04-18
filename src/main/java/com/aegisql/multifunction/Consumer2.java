package com.aegisql.multifunction;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.ToIntBiFunction;

public interface Consumer2<A1,A2> extends BiConsumer<A1,A2> {

    @FunctionalInterface
    interface Throwing<A1,A2>{ void accept(A1 a1, A2 a2) throws Exception; }

    static <A1,A2> Consumer2<A1,A2> dispatch(ToIntBiFunction<? super A1,? super A2> dispatchFunction, Consumer2<? super A1,? super A1>... consumers) {
        Objects.requireNonNull(dispatchFunction,"Consumer2 expects a not null dispatch bi-function");
        Objects.requireNonNull(consumers,"Consumer2 expects a collection of single argument bi-consumers");
        final BiConsumer<A1,A2>[] finalConsumers = (BiConsumer<A1,A2>[]) consumers.clone();
        if(Arrays.stream(finalConsumers).anyMatch(Objects::isNull)) {
            throw new RuntimeException("Consumer2 expects not null bi-consumers");
        }
        return (arg1,arg2) -> {
            int pos = dispatchFunction.applyAsInt(arg1,arg2);
            if(pos < 0 || pos >= finalConsumers.length) {
                throw new RuntimeException("Consumer2 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalConsumers.length-1)+"; arg1="+arg1);
            }
            finalConsumers[pos].accept(arg1,arg2);
        };
    }

    static <A1,A2> Consumer2<A1,A2> dispatch(BiPredicate<? super A1,? super A2> dispatchPredicate, Consumer2<? super A1,? super A2> consumer1, Consumer2<? super A1,? super A2> consumer2) {
        Objects.requireNonNull(dispatchPredicate,"Consumer2 dispatch bi-predicate is null");
        Objects.requireNonNull(consumer1,"Consumer2 first bi-consumer is null");
        Objects.requireNonNull(consumer2,"Consumer2 second bi-consumer is null");
        return (arg1,arg2) -> {
            if(dispatchPredicate.test(arg1,arg2)) {
                consumer1.accept(arg1,arg2);
            } else {
                consumer2.accept(arg1,arg2);
            }
        };
    }

    static <A1,A2> Consumer2<A1,A2> of(BiConsumer<A1,A2> f) {
        return (a1,a2)->f.accept(a1,a2);
    }

}
