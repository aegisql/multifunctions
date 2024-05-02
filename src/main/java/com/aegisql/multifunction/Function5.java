/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

/**
 * The interface Function 5.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 * @param <R>  the type parameter
 */
public interface Function5 <A1,A2,A3,A4,A5,R> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <R>  the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,R>{
        /**
         * Apply r.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @param a3 the a 3
         * @param a4 the a 4
         * @param a5 the a 5
         * @return the r
         * @throws Exception the exception
         */
        R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) throws Exception; }

    /**
     * Apply r.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @return the r
     */
    R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5);

    /**
     * Lazy apply supplier ext.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @return the supplier ext
     */
    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4).applyArg1(a5);
    }

    /**
     * Apply arg 1 function 4.
     *
     * @param a1 the a 1
     * @return the function 4
     */
    default Function4<A2,A3,A4,A5,R> applyArg1(A1 a1) {
    var f = this;
    return new Function4<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5) {
            return f.apply(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function5<A1,A2,A3,A4,A5,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 1 function 4.
     *
     * @param a1Supplier the a 1 supplier
     * @return the function 4
     */
    default Function4<A2,A3,A4,A5,R> applyArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Function4<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5) {
            return f.apply(a1Supplier.get(),a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function5<A1,A2,A3,A4,A5,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 4.
     *
     * @param a2 the a 2
     * @return the function 4
     */
    default Function4<A1,A3,A4,A5,R> applyArg2(A2 a2) {
    var f = this;
    return new Function4<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5) {
            return f.apply(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function5<A1,A2,A3,A4,A5,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 4.
     *
     * @param a2Supplier the a 2 supplier
     * @return the function 4
     */
    default Function4<A1,A3,A4,A5,R> applyArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Function4<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5) {
            return f.apply(a1,a2Supplier.get(),a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function5<A1,A2,A3,A4,A5,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 4.
     *
     * @param a3 the a 3
     * @return the function 4
     */
    default Function4<A1,A2,A4,A5,R> applyArg3(A3 a3) {
    var f = this;
    return new Function4<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5) {
            return f.apply(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function5<A1,A2,A3,A4,A5,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 4.
     *
     * @param a3Supplier the a 3 supplier
     * @return the function 4
     */
    default Function4<A1,A2,A4,A5,R> applyArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Function4<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5) {
            return f.apply(a1,a2,a3Supplier.get(),a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function5<A1,A2,A3,A4,A5,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 4 function 4.
     *
     * @param a4 the a 4
     * @return the function 4
     */
    default Function4<A1,A2,A3,A5,R> applyArg4(A4 a4) {
    var f = this;
    return new Function4<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5) {
            return f.apply(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function5<A1,A2,A3,A4,A5,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 4 function 4.
     *
     * @param a4Supplier the a 4 supplier
     * @return the function 4
     */
    default Function4<A1,A2,A3,A5,R> applyArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Function4<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5) {
            return f.apply(a1,a2,a3,a4Supplier.get(),a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function5<A1,A2,A3,A4,A5,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 5 function 4.
     *
     * @param a5 the a 5
     * @return the function 4
     */
    default Function4<A1,A2,A3,A4,R> applyArg5(A5 a5) {
    var f = this;
    return new Function4<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4) {
            return f.apply(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function5<A1,A2,A3,A4,A5,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 5 function 4.
     *
     * @param a5Supplier the a 5 supplier
     * @return the function 4
     */
    default Function4<A1,A2,A3,A4,R> applyArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Function4<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4) {
            return f.apply(a1,a2,a3,a4,a5Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function5<A1,A2,A3,A4,A5,R> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry function 6.
     *
     * @param <X> the type parameter
     * @return the function 6
     */
    default <X> Function6<X,A1,A2,A3,A4,A5,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Optional function 5.
     *
     * @return the function 5
     */
    default Function5<A1,A2,A3,A4,A5,Optional<R>> optional() {
        return (a1,a2,a3,a4,a5)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4,a5));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    /**
     * Or else function 5.
     *
     * @param defaultValue the default value
     * @return the function 5
     */
    default Function5<A1,A2,A3,A4,A5,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    /**
     * Or else function 5.
     *
     * @param defaultValue the default value
     * @return the function 5
     */
    default Function5<A1,A2,A3,A4,A5,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4,a5)->{
            try {
                return apply(a1,a2,a3,a4,a5);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    /**
     * Before function 5.
     *
     * @param before the before
     * @return the function 5
     */
    default Function5<A1,A2,A3,A4,A5,R> before(Consumer5<A1,A2,A3,A4,A5> before) {
        return (a1,a2,a3,a4,a5)-> {
            before.accept(a1,a2,a3,a4,a5);
            return apply(a1,a2,a3,a4,a5);
        };
    }

    /**
     * After function 5.
     *
     * @param after the after
     * @return the function 5
     */
    default Function5<A1,A2,A3,A4,A5,R> after(Consumer6<A1,A2,A3,A4,A5,R> after) {
        return (a1,a2,a3,a4,a5)-> {
            var result = apply(a1,a2,a3,a4,a5);
            after.accept(a1,a2,a3,a4,a5,result);
            return result;
        };
    }

    /**
     * And then function 5.
     *
     * @param <R2>  the type parameter
     * @param after the after
     * @return the function 5
     */
    default <R2> Function5<A1,A2,A3,A4,A5,R2> andThen(Function<? super R, ? extends R2> after) {
        Objects.requireNonNull(after);
        return (a1,a2,a3,a4,a5) -> after.apply(apply(a1,a2,a3,a4,a5));
    }

    /**
     * Dispatch function 5.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <R>              the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the function 5
     */
    @SafeVarargs
    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> dispatch(ToInt5Function<? super A1,? super A2,? super A3,? super A4,? super A5> dispatchFunction, Function5<? super A1,? super A2,? super A3,? super A4,? super A5,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function5 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function5");
        return (a1,a2,a3,a4,a5) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5),finalFunctions).apply(a1,a2,a3,a4,a5);
    }

    /**
     * Dispatch function 5.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param <A4>              the type parameter
     * @param <A5>              the type parameter
     * @param <R>               the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the function 5
     */
    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> dispatch(Predicate5<? super A1,? super A2,? super A3,? super A4,? super A5> dispatchPredicate, Function5<? super A1,? super A2,? super A3,? super A4,? super A5,R> function1, Function5<? super A1,? super A2,? super A3,? super A4,? super A5,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function5");
        return (a1,a2,a3,a4,a5) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5)) {
                return function1.apply(a1,a2,a3,a4,a5);
            } else {
                return function2.apply(a1,a2,a3,a4,a5);
            }
        };
    }

    /**
     * Of function 5.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 5
     */
    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> of(Function5<A1,A2,A3,A4,A5,R> f) {
        return f::apply;
    }

    /**
     * Throwing function 5.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 5
     */
    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> throwing(Throwing<A1,A2,A3,A4,A5,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5})");
    }

    /**
     * Throwing function 5.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param <A4>   the type parameter
     * @param <A5>   the type parameter
     * @param <R>    the type parameter
     * @param f      the f
     * @param format the format
     * @return the function 5
     */
    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> throwing(Throwing<A1,A2,A3,A4,A5,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing function 5.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <R>              the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the function 5
     */
    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> throwing(Throwing<A1,A2,A3,A4,A5,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5)->{
            try {
                return f.apply(a1,a2,a3,a4,a5);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5),e);
            }
        };
    }

    /**
     * Throwing function 5.
     *
     * @param <A1>           the type parameter
     * @param <A2>           the type parameter
     * @param <A3>           the type parameter
     * @param <A4>           the type parameter
     * @param <A5>           the type parameter
     * @param <R>            the type parameter
     * @param f              the f
     * @param errorProcessor the error processor
     * @return the function 5
     */
    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> throwing(Throwing<A1,A2,A3,A4,A5,R> f, Function6<? super Exception,A1,A2,A3,A4,A5,R> errorProcessor) {
        return (a1,a2,a3,a4,a5)->{
            try {
                return f.apply(a1,a2,a3,a4,a5);
            } catch (Exception e) {
                return errorProcessor.apply(e,a1,a2,a3,a4,a5);
            }
        };
    }
    
}
