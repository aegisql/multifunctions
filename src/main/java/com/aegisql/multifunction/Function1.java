package com.aegisql.multifunction;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.*;

public interface Function1 <A1,R> extends Function<A1,R> {

    @FunctionalInterface
    interface Throwing<A1,R>{ R apply(A1 a1) throws Exception; }

    default Function1<A1,R> beforeApply(Consumer1<A1> consumer){
        return a->{
            consumer.accept(a);
            return apply(a);
        };
    }

    default Function1<A1,R> afterApply(Consumer1<A1> consumer){
        return a->{
            R r = apply(a);
            consumer.accept(a);
            return r;
        };
    }

    default Supplier<R> applyArg1(final A1 a1) {
        return ()->this.apply(a1);
    }

    default Function1<A1, Optional<R>> optional() {
        return optional(()->null);
    }

    default Function1<A1, Optional<R>> optional(R defaultValue) {
        return optional(()->defaultValue);
    }

    default Function1<A1, Optional<R>> optional(Supplier<R> defaultValue) {
        return a->{
            try {
                return Optional.ofNullable(apply(a));
            } catch (Exception e) {
                return Optional.ofNullable(defaultValue.get());
            }
        };
    }

    static Function1<Object,String> toString = (a1)->"(%s)".formatted(a1);

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
                throw new RuntimeException("Function1 dispatch function returned wrong index="+pos+"; expected range 0.."+(finalFunctions.length-1)+ toString.apply(arg1));
            }
            return finalFunctions[pos].apply(arg1);
        };
    }

    static <A1,R> Function1<A1,R> dispatch(Predicate<? super A1> dispatchPredicate, Function<? super A1,R> function1, Function<? super A1,R> function2) {
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

    static <A1,R> Function1<A1,R> of(Function<A1,R>  f) {
        return a1->f.apply(a1);
    }

    static <A1,R> Function1<A1,R> throwing(Throwing<A1,R>  f) {
        return throwing(f,"{0}; arg:({1})");
    }

    static <A1,R> Function1<A1,R> throwing(Throwing<A1,R>  f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,R> Function1<A1,R> throwing(Throwing<A1,R>  f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return a1->{
            try {
                return f.apply(a1);
            } catch (Exception e) {
                String message = e.getMessage();
                if(message == null || message.isBlank()) {
                    message = e.getClass().getSimpleName();
                }
                MessageFormat messageFormat = new MessageFormat(format);
                throw exceptionFactory.apply(messageFormat.format(new Object[]{message,a1}),e);
            }
        };
    }

}
