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
 * The interface Consumer 9.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 * @param <A6> the type parameter
 * @param <A7> the type parameter
 * @param <A8> the type parameter
 * @param <A9> the type parameter
 */
@FunctionalInterface
public interface Consumer9 <A1,A2,A3,A4,A5,A6,A7,A8,A9> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param <A7> the type parameter
     * @param <A8> the type parameter
     * @param <A9> the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9>{
        /**
         * Accept.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @param a3 the a 3
         * @param a4 the a 4
         * @param a5 the a 5
         * @param a6 the a 6
         * @param a7 the a 7
         * @param a8 the a 8
         * @param a9 the a 9
         * @throws Exception the exception
         */
        void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) throws Exception; }

    /**
     * Accept.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     * @param a7 the a 7
     * @param a8 the a 8
     * @param a9 the a 9
     */
    void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9);

    /**
     * Lazy accept runnable ext.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     * @param a7 the a 7
     * @param a8 the a 8
     * @param a9 the a 9
     * @return the runnable ext
     */
    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4).acceptArg1(a5).acceptArg1(a6).acceptArg1(a7).acceptArg1(a8).acceptArg1(a9);
    }

    /**
     * Accept arg 1 consumer 8.
     *
     * @param a1 the a 1
     * @return the consumer 8
     */
    default Consumer8<A2,A3,A4,A5,A6,A7,A8,A9> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 1 consumer 8.
     *
     * @param a1Supplier the a 1 supplier
     * @return the consumer 8
     */
    default Consumer8<A2,A3,A4,A5,A6,A7,A8,A9> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1Supplier.get(),a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 2 consumer 8.
     *
     * @param a2 the a 2
     * @return the consumer 8
     */
    default Consumer8<A1,A3,A4,A5,A6,A7,A8,A9> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 2 consumer 8.
     *
     * @param a2Supplier the a 2 supplier
     * @return the consumer 8
     */
    default Consumer8<A1,A3,A4,A5,A6,A7,A8,A9> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2Supplier.get(),a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 3 consumer 8.
     *
     * @param a3 the a 3
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A4,A5,A6,A7,A8,A9> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 3 consumer 8.
     *
     * @param a3Supplier the a 3 supplier
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A4,A5,A6,A7,A8,A9> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3Supplier.get(),a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 4 consumer 8.
     *
     * @param a4 the a 4
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A5,A6,A7,A8,A9> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 4 consumer 8.
     *
     * @param a4Supplier the a 4 supplier
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A5,A6,A7,A8,A9> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4Supplier.get(),a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 5 consumer 8.
     *
     * @param a5 the a 5
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A4,A6,A7,A8,A9> acceptArg5(A5 a5) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 5 consumer 8.
     *
     * @param a5Supplier the a 5 supplier
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A4,A6,A7,A8,A9> acceptArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5Supplier.get(),a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 6 consumer 8.
     *
     * @param a6 the a 6
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A4,A5,A7,A8,A9> acceptArg6(A6 a6) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 6 consumer 8.
     *
     * @param a6Supplier the a 6 supplier
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A4,A5,A7,A8,A9> acceptArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6Supplier.get(),a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 7 consumer 8.
     *
     * @param a7 the a 7
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A4,A5,A6,A8,A9> acceptArg7(A7 a7) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 7 consumer 8.
     *
     * @param a7Supplier the a 7 supplier
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A4,A5,A6,A8,A9> acceptArg7(Supplier<A7> a7Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7Supplier.get(),a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 8 consumer 8.
     *
     * @param a8 the a 8
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A4,A5,A6,A7,A9> acceptArg8(A8 a8) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 8 consumer 8.
     *
     * @param a8Supplier the a 8 supplier
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A4,A5,A6,A7,A9> acceptArg8(Supplier<A8> a8Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8Supplier.get(),a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 9 consumer 8.
     *
     * @param a9 the a 9
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> acceptArg9(A9 a9) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    /**
     * Accept arg 9 consumer 8.
     *
     * @param a9Supplier the a 9 supplier
     * @return the consumer 8
     */
    default Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> acceptArg9(Supplier<A9> a9Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry consumer 10.
     *
     * @param <X> the type parameter
     * @return the consumer 10
     */
    default <X> Consumer10<X,A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Before consumer 9.
     *
     * @param before the before
     * @return the consumer 9
     */
    default Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> before(Consumer9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> before) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)-> {
            before.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            this.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        };
    }

    /**
     * After consumer 9.
     *
     * @param after the after
     * @return the consumer 9
     */
    default Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9>  after(Consumer9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> after) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)-> {
            this.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            after.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        };
    }

    /**
     * Dispatch consumer 9.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <A6>             the type parameter
     * @param <A7>             the type parameter
     * @param <A8>             the type parameter
     * @param <A9>             the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the consumer 9
     */
    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> dispatch(ToInt9Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> dispatchFunction, Consumer9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer9 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer9");
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7,a8,a9),finalFunctions).accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
    }

    /**
     * Dispatch consumer 9.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param <A4>              the type parameter
     * @param <A5>              the type parameter
     * @param <A6>              the type parameter
     * @param <A7>              the type parameter
     * @param <A8>              the type parameter
     * @param <A9>              the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the consumer 9
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> dispatch(Predicate9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> dispatchPredicate, Consumer9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> function1, Consumer9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer9");
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6,a7,a8,a9)) {
                function1.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            } else {
                function2.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            }
        };
    }

    /**
     * Of consumer 9.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param <A7> the type parameter
     * @param <A8> the type parameter
     * @param <A9> the type parameter
     * @param f    the f
     * @return the consumer 9
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> of(Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> f) {
        return f::accept;
    }

    /**
     * Throwing consumer 9.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param <A7> the type parameter
     * @param <A8> the type parameter
     * @param <A9> the type parameter
     * @param f    the f
     * @return the consumer 9
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7},{8},{9})");
    }

    /**
     * Throwing consumer 9.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param <A4>   the type parameter
     * @param <A5>   the type parameter
     * @param <A6>   the type parameter
     * @param <A7>   the type parameter
     * @param <A8>   the type parameter
     * @param <A9>   the type parameter
     * @param f      the f
     * @param format the format
     * @return the consumer 9
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    /**
     * Throwing consumer 9.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <A6>             the type parameter
     * @param <A7>             the type parameter
     * @param <A8>             the type parameter
     * @param <A9>             the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the consumer 9
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7,a8,a9),e);
            }
        };
    }

    /**
     * Throwing consumer 9.
     *
     * @param <A1>          the type parameter
     * @param <A2>          the type parameter
     * @param <A3>          the type parameter
     * @param <A4>          the type parameter
     * @param <A5>          the type parameter
     * @param <A6>          the type parameter
     * @param <A7>          the type parameter
     * @param <A8>          the type parameter
     * @param <A9>          the type parameter
     * @param f             the f
     * @param errorConsumer the error consumer
     * @return the consumer 9
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9> f, Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,? super Exception> errorConsumer) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,e);
            }
        };
    }
    
}
