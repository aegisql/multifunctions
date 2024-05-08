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
 * The interface Consumer 4.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 */
@FunctionalInterface
public interface Consumer4 <A1,A2,A3,A4> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4>{
        /**
         * Accept.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @param a3 the a 3
         * @param a4 the a 4
         * @throws Exception the exception
         */
        void accept(A1 a1,A2 a2,A3 a3,A4 a4) throws Exception; }

    /**
     * Accept.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     */
    void accept(A1 a1,A2 a2,A3 a3,A4 a4);

    /**
     * Lazy accept runnable ext.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @return the runnable ext
     */
    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4);
    }

    /**
     * Accept arg 1 consumer 3.
     *
     * @param a1 the a 1
     * @return the consumer 3
     */
    default Consumer3<A2,A3,A4> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4) {
            f.accept(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 1 consumer 3.
     *
     * @param a1Supplier the a 1 supplier
     * @return the consumer 3
     */
    default Consumer3<A2,A3,A4> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4) {
            f.accept(a1Supplier.get(),a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 2 consumer 3.
     *
     * @param a2 the a 2
     * @return the consumer 3
     */
    default Consumer3<A1,A3,A4> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4) {
            f.accept(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 2 consumer 3.
     *
     * @param a2Supplier the a 2 supplier
     * @return the consumer 3
     */
    default Consumer3<A1,A3,A4> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4) {
            f.accept(a1,a2Supplier.get(),a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 3 consumer 3.
     *
     * @param a3 the a 3
     * @return the consumer 3
     */
    default Consumer3<A1,A2,A4> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4) {
            f.accept(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 3 consumer 3.
     *
     * @param a3Supplier the a 3 supplier
     * @return the consumer 3
     */
    default Consumer3<A1,A2,A4> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4) {
            f.accept(a1,a2,a3Supplier.get(),a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 4 consumer 3.
     *
     * @param a4 the a 4
     * @return the consumer 3
     */
    default Consumer3<A1,A2,A3> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3) {
            f.accept(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 4 consumer 3.
     *
     * @param a4Supplier the a 4 supplier
     * @return the consumer 3
     */
    default Consumer3<A1,A2,A3> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3) {
            f.accept(a1,a2,a3,a4Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry consumer 5.
     *
     * @param <X> the type parameter
     * @return the consumer 5
     */
    default <X> Consumer5<X,A1,A2,A3,A4> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Before consumer 4.
     *
     * @param before the before
     * @return the consumer 4
     */
    default Consumer4<A1,A2,A3,A4> before(Consumer4<? super A1,? super A2,? super A3,? super A4> before) {
        return (a1,a2,a3,a4)-> {
            before.accept(a1,a2,a3,a4);
            this.accept(a1,a2,a3,a4);
        };
    }

    /**
     * After consumer 4.
     *
     * @param after the after
     * @return the consumer 4
     */
    default Consumer4<A1,A2,A3,A4>  after(Consumer4<? super A1,? super A2,? super A3,? super A4> after) {
        return (a1,a2,a3,a4)-> {
            this.accept(a1,a2,a3,a4);
            after.accept(a1,a2,a3,a4);
        };
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 4; }

    /**
     * Dispatch consumer 4.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the consumer 4
     */
    @SafeVarargs
    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> dispatch(ToInt4Function<? super A1,? super A2,? super A3,? super A4> dispatchFunction, Consumer4<? super A1,? super A2,? super A3,? super A4>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer4 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer4");
        return (a1,a2,a3,a4) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4),finalFunctions).accept(a1,a2,a3,a4);
    }

    /**
     * Dispatch consumer 4.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param <A4>              the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the consumer 4
     */
    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> dispatch(Predicate4<? super A1,? super A2,? super A3,? super A4> dispatchPredicate, Consumer4<? super A1,? super A2,? super A3,? super A4> function1, Consumer4<? super A1,? super A2,? super A3,? super A4> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer4");
        return (a1,a2,a3,a4) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4)) {
                function1.accept(a1,a2,a3,a4);
            } else {
                function2.accept(a1,a2,a3,a4);
            }
        };
    }

    /**
     * Of consumer 4.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param f    the f
     * @return the consumer 4
     */
    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> of(Consumer4<A1,A2,A3,A4> f) {
        return f::accept;
    }

    /**
     * Throwing consumer 4.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param f    the f
     * @return the consumer 4
     */
    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> throwing(Throwing<A1,A2,A3,A4> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4})");
    }

    /**
     * Throwing consumer 4.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param <A4>   the type parameter
     * @param f      the f
     * @param format the format
     * @return the consumer 4
     */
    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> throwing(Throwing<A1,A2,A3,A4> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    /**
     * Throwing consumer 4.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the consumer 4
     */
    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> throwing(Throwing<A1,A2,A3,A4> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4)->{
            try {
                f.accept(a1,a2,a3,a4);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4),e);
            }
        };
    }

    /**
     * Throwing consumer 4.
     *
     * @param <A1>          the type parameter
     * @param <A2>          the type parameter
     * @param <A3>          the type parameter
     * @param <A4>          the type parameter
     * @param f             the f
     * @param errorConsumer the error consumer
     * @return the consumer 4
     */
    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> throwing(Throwing<A1,A2,A3,A4> f, Consumer5<A1,A2,A3,A4,? super Exception> errorConsumer) {
        return (a1,a2,a3,a4)->{
            try {
                f.accept(a1,a2,a3,a4);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,a4,e);
            }
        };
    }
    
}
