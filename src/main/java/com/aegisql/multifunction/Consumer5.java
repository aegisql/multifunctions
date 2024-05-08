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
 * The interface Consumer 5.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 */
@FunctionalInterface
public interface Consumer5 <A1,A2,A3,A4,A5> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5>{
        /**
         * Accept.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @param a3 the a 3
         * @param a4 the a 4
         * @param a5 the a 5
         * @throws Exception the exception
         */
        void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) throws Exception; }

    /**
     * Accept.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     */
    void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5);

    /**
     * Lazy accept runnable ext.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @return the runnable ext
     */
    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4).acceptArg1(a5);
    }

    /**
     * Accept arg 1 consumer 4.
     *
     * @param a1 the a 1
     * @return the consumer 4
     */
    default Consumer4<A2,A3,A4,A5> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5) {
            f.accept(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 1 consumer 4.
     *
     * @param a1Supplier the a 1 supplier
     * @return the consumer 4
     */
    default Consumer4<A2,A3,A4,A5> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5) {
            f.accept(a1Supplier.get(),a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 2 consumer 4.
     *
     * @param a2 the a 2
     * @return the consumer 4
     */
    default Consumer4<A1,A3,A4,A5> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5) {
            f.accept(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 2 consumer 4.
     *
     * @param a2Supplier the a 2 supplier
     * @return the consumer 4
     */
    default Consumer4<A1,A3,A4,A5> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5) {
            f.accept(a1,a2Supplier.get(),a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 3 consumer 4.
     *
     * @param a3 the a 3
     * @return the consumer 4
     */
    default Consumer4<A1,A2,A4,A5> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5) {
            f.accept(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 3 consumer 4.
     *
     * @param a3Supplier the a 3 supplier
     * @return the consumer 4
     */
    default Consumer4<A1,A2,A4,A5> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5) {
            f.accept(a1,a2,a3Supplier.get(),a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 4 consumer 4.
     *
     * @param a4 the a 4
     * @return the consumer 4
     */
    default Consumer4<A1,A2,A3,A5> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5) {
            f.accept(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 4 consumer 4.
     *
     * @param a4Supplier the a 4 supplier
     * @return the consumer 4
     */
    default Consumer4<A1,A2,A3,A5> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5) {
            f.accept(a1,a2,a3,a4Supplier.get(),a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 5 consumer 4.
     *
     * @param a5 the a 5
     * @return the consumer 4
     */
    default Consumer4<A1,A2,A3,A4> acceptArg5(A5 a5) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4) {
            f.accept(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 5 consumer 4.
     *
     * @param a5Supplier the a 5 supplier
     * @return the consumer 4
     */
    default Consumer4<A1,A2,A3,A4> acceptArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4) {
            f.accept(a1,a2,a3,a4,a5Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry consumer 6.
     *
     * @param <X> the type parameter
     * @return the consumer 6
     */
    default <X> Consumer6<X,A1,A2,A3,A4,A5> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Before consumer 5.
     *
     * @param before the before
     * @return the consumer 5
     */
    default Consumer5<A1,A2,A3,A4,A5> before(Consumer5<? super A1,? super A2,? super A3,? super A4,? super A5> before) {
        return (a1,a2,a3,a4,a5)-> {
            before.accept(a1,a2,a3,a4,a5);
            this.accept(a1,a2,a3,a4,a5);
        };
    }

    /**
     * After consumer 5.
     *
     * @param after the after
     * @return the consumer 5
     */
    default Consumer5<A1,A2,A3,A4,A5>  after(Consumer5<? super A1,? super A2,? super A3,? super A4,? super A5> after) {
        return (a1,a2,a3,a4,a5)-> {
            this.accept(a1,a2,a3,a4,a5);
            after.accept(a1,a2,a3,a4,a5);
        };
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 5; }

    /**
     * Dispatch consumer 5.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the consumer 5
     */
    @SafeVarargs
    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> dispatch(ToInt5Function<? super A1,? super A2,? super A3,? super A4,? super A5> dispatchFunction, Consumer5<? super A1,? super A2,? super A3,? super A4,? super A5>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer5 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer5");
        return (a1,a2,a3,a4,a5) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5),finalFunctions).accept(a1,a2,a3,a4,a5);
    }

    /**
     * Dispatch consumer 5.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param <A4>              the type parameter
     * @param <A5>              the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the consumer 5
     */
    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> dispatch(Predicate5<? super A1,? super A2,? super A3,? super A4,? super A5> dispatchPredicate, Consumer5<? super A1,? super A2,? super A3,? super A4,? super A5> function1, Consumer5<? super A1,? super A2,? super A3,? super A4,? super A5> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer5");
        return (a1,a2,a3,a4,a5) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5)) {
                function1.accept(a1,a2,a3,a4,a5);
            } else {
                function2.accept(a1,a2,a3,a4,a5);
            }
        };
    }

    /**
     * Of consumer 5.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param f    the f
     * @return the consumer 5
     */
    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> of(Consumer5<A1,A2,A3,A4,A5> f) {
        return f::accept;
    }

    /**
     * Throwing consumer 5.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param f    the f
     * @return the consumer 5
     */
    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> throwing(Throwing<A1,A2,A3,A4,A5> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5})");
    }

    /**
     * Throwing consumer 5.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param <A4>   the type parameter
     * @param <A5>   the type parameter
     * @param f      the f
     * @param format the format
     * @return the consumer 5
     */
    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> throwing(Throwing<A1,A2,A3,A4,A5> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    /**
     * Throwing consumer 5.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the consumer 5
     */
    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> throwing(Throwing<A1,A2,A3,A4,A5> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5)->{
            try {
                f.accept(a1,a2,a3,a4,a5);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5),e);
            }
        };
    }

    /**
     * Throwing consumer 5.
     *
     * @param <A1>          the type parameter
     * @param <A2>          the type parameter
     * @param <A3>          the type parameter
     * @param <A4>          the type parameter
     * @param <A5>          the type parameter
     * @param f             the f
     * @param errorConsumer the error consumer
     * @return the consumer 5
     */
    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> throwing(Throwing<A1,A2,A3,A4,A5> f, Consumer6<A1,A2,A3,A4,A5,? super Exception> errorConsumer) {
        return (a1,a2,a3,a4,a5)->{
            try {
                f.accept(a1,a2,a3,a4,a5);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,a4,a5,e);
            }
        };
    }
    
}
