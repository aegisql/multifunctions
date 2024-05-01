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
 * The interface Consumer 6.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 * @param <A6> the type parameter
 */
public interface Consumer6 <A1,A2,A3,A4,A5,A6> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6>{
        /**
         * Accept.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @param a3 the a 3
         * @param a4 the a 4
         * @param a5 the a 5
         * @param a6 the a 6
         * @throws Exception the exception
         */
        void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) throws Exception; }

    /**
     * Accept.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     */
    void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6);

    /**
     * Lazy accept runnable ext.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     * @return the runnable ext
     */
    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4).acceptArg1(a5).acceptArg1(a6);
    }

    /**
     * Accept arg 1 consumer 5.
     *
     * @param a1 the a 1
     * @return the consumer 5
     */
    default Consumer5<A2,A3,A4,A5,A6> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 1 consumer 5.
     *
     * @param a1Supplier the a 1 supplier
     * @return the consumer 5
     */
    default Consumer5<A2,A3,A4,A5,A6> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            f.accept(a1Supplier.get(),a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 2 consumer 5.
     *
     * @param a2 the a 2
     * @return the consumer 5
     */
    default Consumer5<A1,A3,A4,A5,A6> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 2 consumer 5.
     *
     * @param a2Supplier the a 2 supplier
     * @return the consumer 5
     */
    default Consumer5<A1,A3,A4,A5,A6> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2Supplier.get(),a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 3 consumer 5.
     *
     * @param a3 the a 3
     * @return the consumer 5
     */
    default Consumer5<A1,A2,A4,A5,A6> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 3 consumer 5.
     *
     * @param a3Supplier the a 3 supplier
     * @return the consumer 5
     */
    default Consumer5<A1,A2,A4,A5,A6> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2,a3Supplier.get(),a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 4 consumer 5.
     *
     * @param a4 the a 4
     * @return the consumer 5
     */
    default Consumer5<A1,A2,A3,A5,A6> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 4 consumer 5.
     *
     * @param a4Supplier the a 4 supplier
     * @return the consumer 5
     */
    default Consumer5<A1,A2,A3,A5,A6> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4Supplier.get(),a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 5 consumer 5.
     *
     * @param a5 the a 5
     * @return the consumer 5
     */
    default Consumer5<A1,A2,A3,A4,A6> acceptArg5(A5 a5) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 5 consumer 5.
     *
     * @param a5Supplier the a 5 supplier
     * @return the consumer 5
     */
    default Consumer5<A1,A2,A3,A4,A6> acceptArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6) {
            f.accept(a1,a2,a3,a4,a5Supplier.get(),a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 6 consumer 5.
     *
     * @param a6 the a 6
     * @return the consumer 5
     */
    default Consumer5<A1,A2,A3,A4,A5> acceptArg6(A6 a6) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 6 consumer 5.
     *
     * @param a6Supplier the a 6 supplier
     * @return the consumer 5
     */
    default Consumer5<A1,A2,A3,A4,A5> acceptArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
            f.accept(a1,a2,a3,a4,a5,a6Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry consumer 7.
     *
     * @param <X> the type parameter
     * @return the consumer 7
     */
    default <X> Consumer7<X,A1,A2,A3,A4,A5,A6> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Before consumer 6.
     *
     * @param before the before
     * @return the consumer 6
     */
    default Consumer6<A1,A2,A3,A4,A5,A6> before(Consumer6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> before) {
        return (a1,a2,a3,a4,a5,a6)-> {
            before.accept(a1,a2,a3,a4,a5,a6);
            this.accept(a1,a2,a3,a4,a5,a6);
        };
    }

    /**
     * After consumer 6.
     *
     * @param after the after
     * @return the consumer 6
     */
    default Consumer6<A1,A2,A3,A4,A5,A6>  after(Consumer6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> after) {
        return (a1,a2,a3,a4,a5,a6)-> {
            this.accept(a1,a2,a3,a4,a5,a6);
            after.accept(a1,a2,a3,a4,a5,a6);
        };
    }

    /**
     * Dispatch consumer 6.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <A6>             the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the consumer 6
     */
    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> dispatch(ToInt6Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> dispatchFunction, Consumer6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer6 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer6");
        return (a1,a2,a3,a4,a5,a6) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6),finalFunctions).accept(a1,a2,a3,a4,a5,a6);
    }

    /**
     * Dispatch consumer 6.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param <A4>              the type parameter
     * @param <A5>              the type parameter
     * @param <A6>              the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the consumer 6
     */
    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> dispatch(Predicate6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> dispatchPredicate, Consumer6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> function1, Consumer6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer6");
        return (a1,a2,a3,a4,a5,a6) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6)) {
                function1.accept(a1,a2,a3,a4,a5,a6);
            } else {
                function2.accept(a1,a2,a3,a4,a5,a6);
            }
        };
    }

    /**
     * Of consumer 6.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param f    the f
     * @return the consumer 6
     */
    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> of(Consumer6<A1,A2,A3,A4,A5,A6> f) {
        return f::accept;
    }

    /**
     * Throwing consumer 6.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param f    the f
     * @return the consumer 6
     */
    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> throwing(Throwing<A1,A2,A3,A4,A5,A6> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6})");
    }

    /**
     * Throwing consumer 6.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param <A4>   the type parameter
     * @param <A5>   the type parameter
     * @param <A6>   the type parameter
     * @param f      the f
     * @param format the format
     * @return the consumer 6
     */
    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> throwing(Throwing<A1,A2,A3,A4,A5,A6> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    /**
     * Throwing consumer 6.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <A6>             the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the consumer 6
     */
    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> throwing(Throwing<A1,A2,A3,A4,A5,A6> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6),e);
            }
        };
    }

    /**
     * Throwing consumer 6.
     *
     * @param <A1>          the type parameter
     * @param <A2>          the type parameter
     * @param <A3>          the type parameter
     * @param <A4>          the type parameter
     * @param <A5>          the type parameter
     * @param <A6>          the type parameter
     * @param f             the f
     * @param errorConsumer the error consumer
     * @return the consumer 6
     */
    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> throwing(Throwing<A1,A2,A3,A4,A5,A6> f, Consumer7<A1,A2,A3,A4,A5,A6,? super Exception> errorConsumer) {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,a4,a5,a6,e);
            }
        };
    }
    
}
