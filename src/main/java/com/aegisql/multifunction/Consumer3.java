/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

/**
 * The interface Consumer 3.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 */
public interface Consumer3 <A1,A2,A3> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3>{
        /**
         * Accept.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @param a3 the a 3
         * @throws Exception the exception
         */
        void accept(A1 a1,A2 a2,A3 a3) throws Exception; }

    /**
     * Accept.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     */
    void accept(A1 a1,A2 a2,A3 a3);

    /**
     * Lazy accept runnable ext.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @return the runnable ext
     */
    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3);
    }

    /**
     * Accept arg 1 consumer 2.
     *
     * @param a1 the a 1
     * @return the consumer 2
     */
    default Consumer2<A2,A3> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A2 a2,A3 a3) {
            f.accept(a1,a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 1 consumer 2.
     *
     * @param a1Supplier the a 1 supplier
     * @return the consumer 2
     */
    default Consumer2<A2,A3> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A2 a2,A3 a3) {
            f.accept(a1Supplier.get(),a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 2 consumer 2.
     *
     * @param a2 the a 2
     * @return the consumer 2
     */
    default Consumer2<A1,A3> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A1 a1,A3 a3) {
            f.accept(a1,a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 2 consumer 2.
     *
     * @param a2Supplier the a 2 supplier
     * @return the consumer 2
     */
    default Consumer2<A1,A3> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A1 a1,A3 a3) {
            f.accept(a1,a2Supplier.get(),a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 3 consumer 2.
     *
     * @param a3 the a 3
     * @return the consumer 2
     */
    default Consumer2<A1,A2> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A1 a1,A2 a2) {
            f.accept(a1,a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 3 consumer 2.
     *
     * @param a3Supplier the a 3 supplier
     * @return the consumer 2
     */
    default Consumer2<A1,A2> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A1 a1,A2 a2) {
            f.accept(a1,a2,a3Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry consumer 4.
     *
     * @param <X> the type parameter
     * @return the consumer 4
     */
    default <X> Consumer4<X,A1,A2,A3> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Before consumer 3.
     *
     * @param before the before
     * @return the consumer 3
     */
    default Consumer3<A1,A2,A3> before(Consumer3<? super A1,? super A2,? super A3> before) {
        return (a1,a2,a3)-> {
            before.accept(a1,a2,a3);
            this.accept(a1,a2,a3);
        };
    }

    /**
     * After consumer 3.
     *
     * @param after the after
     * @return the consumer 3
     */
    default Consumer3<A1,A2,A3>  after(Consumer3<? super A1,? super A2,? super A3> after) {
        return (a1,a2,a3)-> {
            this.accept(a1,a2,a3);
            after.accept(a1,a2,a3);
        };
    }

    /**
     * Dispatch consumer 3.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the consumer 3
     */
    @SafeVarargs
    static <A1,A2,A3> Consumer3<A1,A2,A3> dispatch(ToInt3Function<? super A1,? super A2,? super A3> dispatchFunction, Consumer3<? super A1,? super A2,? super A3>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer3 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer3");
        return (a1,a2,a3) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3),finalFunctions).accept(a1,a2,a3);
    }

    /**
     * Dispatch consumer 3.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the consumer 3
     */
    static <A1,A2,A3> Consumer3<A1,A2,A3> dispatch(Predicate3<? super A1,? super A2,? super A3> dispatchPredicate, Consumer3<? super A1,? super A2,? super A3> function1, Consumer3<? super A1,? super A2,? super A3> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer3");
        return (a1,a2,a3) -> {
            if(dispatchPredicate.test(a1,a2,a3)) {
                function1.accept(a1,a2,a3);
            } else {
                function2.accept(a1,a2,a3);
            }
        };
    }

    /**
     * Of consumer 3.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param f    the f
     * @return the consumer 3
     */
    static <A1,A2,A3> Consumer3<A1,A2,A3> of(Consumer3<A1,A2,A3> f) {
        return f::accept;
    }

    /**
     * Throwing consumer 3.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param f    the f
     * @return the consumer 3
     */
    static <A1,A2,A3> Consumer3<A1,A2,A3> throwing(Throwing<A1,A2,A3> f) {
        return throwing(f,"{0}; args:({1},{2},{3})");
    }

    /**
     * Throwing consumer 3.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param f      the f
     * @param format the format
     * @return the consumer 3
     */
    static <A1,A2,A3> Consumer3<A1,A2,A3> throwing(Throwing<A1,A2,A3> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    /**
     * Throwing consumer 3.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the consumer 3
     */
    static <A1,A2,A3> Consumer3<A1,A2,A3> throwing(Throwing<A1,A2,A3> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3)->{
            try {
                f.accept(a1,a2,a3);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3),e);
            }
        };
    }

    /**
     * Throwing consumer 3.
     *
     * @param <A1>          the type parameter
     * @param <A2>          the type parameter
     * @param <A3>          the type parameter
     * @param f             the f
     * @param errorConsumer the error consumer
     * @return the consumer 3
     */
    static <A1,A2,A3> Consumer3<A1,A2,A3> throwing(Throwing<A1,A2,A3> f, Consumer4<A1,A2,A3,? super Exception> errorConsumer) {
        return (a1,a2,a3)->{
            try {
                f.accept(a1,a2,a3);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,e);
            }
        };
    }
    
}
