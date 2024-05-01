/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

/**
 * The interface Function 6.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 * @param <A6> the type parameter
 * @param <R>  the type parameter
 */
public interface Function6 <A1,A2,A3,A4,A5,A6,R> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param <R>  the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,R>{
        /**
         * Apply r.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @param a3 the a 3
         * @param a4 the a 4
         * @param a5 the a 5
         * @param a6 the a 6
         * @return the r
         * @throws Exception the exception
         */
        R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) throws Exception; }

    /**
     * Apply r.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     * @return the r
     */
    R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6);

    /**
     * Lazy apply supplier ext.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     * @return the supplier ext
     */
    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4).applyArg1(a5).applyArg1(a6);
    }

    /**
     * Apply arg 1 function 5.
     *
     * @param a1 the a 1
     * @return the function 5
     */
    default Function5<A2,A3,A4,A5,A6,R> applyArg1(A1 a1) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 1 function 5.
     *
     * @param a1Supplier the a 1 supplier
     * @return the function 5
     */
    default Function5<A2,A3,A4,A5,A6,R> applyArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1Supplier.get(),a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 5.
     *
     * @param a2 the a 2
     * @return the function 5
     */
    default Function5<A1,A3,A4,A5,A6,R> applyArg2(A2 a2) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 5.
     *
     * @param a2Supplier the a 2 supplier
     * @return the function 5
     */
    default Function5<A1,A3,A4,A5,A6,R> applyArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2Supplier.get(),a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 5.
     *
     * @param a3 the a 3
     * @return the function 5
     */
    default Function5<A1,A2,A4,A5,A6,R> applyArg3(A3 a3) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 5.
     *
     * @param a3Supplier the a 3 supplier
     * @return the function 5
     */
    default Function5<A1,A2,A4,A5,A6,R> applyArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3Supplier.get(),a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 4 function 5.
     *
     * @param a4 the a 4
     * @return the function 5
     */
    default Function5<A1,A2,A3,A5,A6,R> applyArg4(A4 a4) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 4 function 5.
     *
     * @param a4Supplier the a 4 supplier
     * @return the function 5
     */
    default Function5<A1,A2,A3,A5,A6,R> applyArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4Supplier.get(),a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 5 function 5.
     *
     * @param a5 the a 5
     * @return the function 5
     */
    default Function5<A1,A2,A3,A4,A6,R> applyArg5(A5 a5) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 5 function 5.
     *
     * @param a5Supplier the a 5 supplier
     * @return the function 5
     */
    default Function5<A1,A2,A3,A4,A6,R> applyArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5Supplier.get(),a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 6 function 5.
     *
     * @param a6 the a 6
     * @return the function 5
     */
    default Function5<A1,A2,A3,A4,A5,R> applyArg6(A6 a6) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 6 function 5.
     *
     * @param a6Supplier the a 6 supplier
     * @return the function 5
     */
    default Function5<A1,A2,A3,A4,A5,R> applyArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
            return f.apply(a1,a2,a3,a4,a5,a6Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry function 7.
     *
     * @param <X> the type parameter
     * @return the function 7
     */
    default <X> Function7<X,A1,A2,A3,A4,A5,A6,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Optional function 6.
     *
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A5,A6,Optional<R>> optional() {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4,a5,a6));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    /**
     * Or else function 6.
     *
     * @param defaultValue the default value
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A5,A6,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    /**
     * Or else function 6.
     *
     * @param defaultValue the default value
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A5,A6,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                return apply(a1,a2,a3,a4,a5,a6);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    /**
     * Before function 6.
     *
     * @param before the before
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A5,A6,R> before(Consumer6<A1,A2,A3,A4,A5,A6> before) {
        return (a1,a2,a3,a4,a5,a6)-> {
            before.accept(a1,a2,a3,a4,a5,a6);
            return apply(a1,a2,a3,a4,a5,a6);
        };
    }

    /**
     * After function 6.
     *
     * @param after the after
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A5,A6,R> after(Consumer7<A1,A2,A3,A4,A5,A6,R> after) {
        return (a1,a2,a3,a4,a5,a6)-> {
            var result = apply(a1,a2,a3,a4,a5,a6);
            after.accept(a1,a2,a3,a4,a5,a6,result);
            return result;
        };
    }

    /**
     * Dispatch function 6.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <A6>             the type parameter
     * @param <R>              the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the function 6
     */
    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> dispatch(ToInt6Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> dispatchFunction, Function6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function6 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function6");
        return (a1,a2,a3,a4,a5,a6) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6),finalFunctions).apply(a1,a2,a3,a4,a5,a6);
    }

    /**
     * Dispatch function 6.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param <A4>              the type parameter
     * @param <A5>              the type parameter
     * @param <A6>              the type parameter
     * @param <R>               the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the function 6
     */
    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> dispatch(Predicate6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> dispatchPredicate, Function6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,R> function1, Function6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function6");
        return (a1,a2,a3,a4,a5,a6) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6)) {
                return function1.apply(a1,a2,a3,a4,a5,a6);
            } else {
                return function2.apply(a1,a2,a3,a4,a5,a6);
            }
        };
    }

    /**
     * Of function 6.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 6
     */
    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> of(Function6<A1,A2,A3,A4,A5,A6,R> f) {
        return f::apply;
    }

    /**
     * Throwing function 6.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 6
     */
    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6})");
    }

    /**
     * Throwing function 6.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param <A4>   the type parameter
     * @param <A5>   the type parameter
     * @param <A6>   the type parameter
     * @param <R>    the type parameter
     * @param f      the f
     * @param format the format
     * @return the function 6
     */
    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing function 6.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <A6>             the type parameter
     * @param <R>              the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the function 6
     */
    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6),e);
            }
        };
    }

    /**
     * Throwing function 6.
     *
     * @param <A1>           the type parameter
     * @param <A2>           the type parameter
     * @param <A3>           the type parameter
     * @param <A4>           the type parameter
     * @param <A5>           the type parameter
     * @param <A6>           the type parameter
     * @param <R>            the type parameter
     * @param f              the f
     * @param errorProcessor the error processor
     * @return the function 6
     */
    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,R> f, Function7<? super Exception,A1,A2,A3,A4,A5,A6,R> errorProcessor) {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6);
            } catch (Exception e) {
                return errorProcessor.apply(e,a1,a2,a3,a4,a5,a6);
            }
        };
    }
    
}
