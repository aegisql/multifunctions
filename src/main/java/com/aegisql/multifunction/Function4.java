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
 * The interface Function 4.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <R>  the type parameter
 */
@FunctionalInterface
public interface Function4 <A1,A2,A3,A4,R> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <R>  the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,R>{
        /**
         * Apply r.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @param a3 the a 3
         * @param a4 the a 4
         * @return the r
         * @throws Exception the exception
         */
        R apply(A1 a1,A2 a2,A3 a3,A4 a4) throws Exception; }

    /**
     * Apply r.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @return the r
     */
    R apply(A1 a1,A2 a2,A3 a3,A4 a4);

    /**
     * Lazy apply supplier ext.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @return the supplier ext
     */
    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4);
    }

    /**
     * Apply arg 1 function 3.
     *
     * @param a1 the a 1
     * @return the function 3
     */
    default Function3<A2,A3,A4,R> applyArg1(A1 a1) {
    var f = this;
    return new Function3<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4) {
            return f.apply(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function4<A1,A2,A3,A4,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 1 function 3.
     *
     * @param a1Supplier the a 1 supplier
     * @return the function 3
     */
    default Function3<A2,A3,A4,R> applyArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Function3<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4) {
            return f.apply(a1Supplier.get(),a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function4<A1,A2,A3,A4,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 3.
     *
     * @param a2 the a 2
     * @return the function 3
     */
    default Function3<A1,A3,A4,R> applyArg2(A2 a2) {
    var f = this;
    return new Function3<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4) {
            return f.apply(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function4<A1,A2,A3,A4,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 3.
     *
     * @param a2Supplier the a 2 supplier
     * @return the function 3
     */
    default Function3<A1,A3,A4,R> applyArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Function3<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4) {
            return f.apply(a1,a2Supplier.get(),a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function4<A1,A2,A3,A4,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 3.
     *
     * @param a3 the a 3
     * @return the function 3
     */
    default Function3<A1,A2,A4,R> applyArg3(A3 a3) {
    var f = this;
    return new Function3<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4) {
            return f.apply(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function4<A1,A2,A3,A4,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 3.
     *
     * @param a3Supplier the a 3 supplier
     * @return the function 3
     */
    default Function3<A1,A2,A4,R> applyArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Function3<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4) {
            return f.apply(a1,a2,a3Supplier.get(),a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function4<A1,A2,A3,A4,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 4 function 3.
     *
     * @param a4 the a 4
     * @return the function 3
     */
    default Function3<A1,A2,A3,R> applyArg4(A4 a4) {
    var f = this;
    return new Function3<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3) {
            return f.apply(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function4<A1,A2,A3,A4,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 4 function 3.
     *
     * @param a4Supplier the a 4 supplier
     * @return the function 3
     */
    default Function3<A1,A2,A3,R> applyArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Function3<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3) {
            return f.apply(a1,a2,a3,a4Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function4<A1,A2,A3,A4,R> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry function 5.
     *
     * @param <X> the type parameter
     * @return the function 5
     */
    default <X> Function5<X,A1,A2,A3,A4,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Optional function 4.
     *
     * @return the function 4
     */
    default Function4<A1,A2,A3,A4,Optional<R>> optional() {
        return (a1,a2,a3,a4)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    /**
     * Or else function 4.
     *
     * @param defaultValue the default value
     * @return the function 4
     */
    default Function4<A1,A2,A3,A4,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    /**
     * Or else function 4.
     *
     * @param defaultValue the default value
     * @return the function 4
     */
    default Function4<A1,A2,A3,A4,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4)->{
            try {
                return apply(a1,a2,a3,a4);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    /**
     * Before function 4.
     *
     * @param before the before
     * @return the function 4
     */
    default Function4<A1,A2,A3,A4,R> before(Consumer4<A1,A2,A3,A4> before) {
        return (a1,a2,a3,a4)-> {
            before.accept(a1,a2,a3,a4);
            return apply(a1,a2,a3,a4);
        };
    }

    /**
     * After function 4.
     *
     * @param after the after
     * @return the function 4
     */
    default Function4<A1,A2,A3,A4,R> after(Consumer5<A1,A2,A3,A4,R> after) {
        return (a1,a2,a3,a4)-> {
            var result = apply(a1,a2,a3,a4);
            after.accept(a1,a2,a3,a4,result);
            return result;
        };
    }

    /**
     * And then function 4.
     *
     * @param <R2>  the type parameter
     * @param after the after
     * @return the function 4
     */
    default <R2> Function4<A1,A2,A3,A4,R2> andThen(Function<? super R, ? extends R2> after) {
        Objects.requireNonNull(after);
        return (a1,a2,a3,a4) -> after.apply(apply(a1,a2,a3,a4));
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 4; }

    /**
     * Dispatch function 4.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <R>              the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the function 4
     */
    @SafeVarargs
    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> dispatch(ToInt4Function<? super A1,? super A2,? super A3,? super A4> dispatchFunction, Function4<? super A1,? super A2,? super A3,? super A4,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function4 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function4");
        return (a1,a2,a3,a4) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4),finalFunctions).apply(a1,a2,a3,a4);
    }

    /**
     * Dispatch function 4.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param <A4>              the type parameter
     * @param <R>               the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the function 4
     */
    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> dispatch(Predicate4<? super A1,? super A2,? super A3,? super A4> dispatchPredicate, Function4<? super A1,? super A2,? super A3,? super A4,R> function1, Function4<? super A1,? super A2,? super A3,? super A4,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function4");
        return (a1,a2,a3,a4) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4)) {
                return function1.apply(a1,a2,a3,a4);
            } else {
                return function2.apply(a1,a2,a3,a4);
            }
        };
    }

    /**
     * Of function 4.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 4
     */
    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> of(Function4<A1,A2,A3,A4,R> f) {
        return f::apply;
    }

    /**
     * Throwing function 4.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 4
     */
    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> throwing(Throwing<A1,A2,A3,A4,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4})");
    }

    /**
     * Throwing function 4.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param <A4>   the type parameter
     * @param <R>    the type parameter
     * @param f      the f
     * @param format the format
     * @return the function 4
     */
    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> throwing(Throwing<A1,A2,A3,A4,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing function 4.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <R>              the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the function 4
     */
    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> throwing(Throwing<A1,A2,A3,A4,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4)->{
            try {
                return f.apply(a1,a2,a3,a4);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4),e);
            }
        };
    }

    /**
     * Throwing function 4.
     *
     * @param <A1>           the type parameter
     * @param <A2>           the type parameter
     * @param <A3>           the type parameter
     * @param <A4>           the type parameter
     * @param <R>            the type parameter
     * @param f              the f
     * @param errorProcessor the error processor
     * @return the function 4
     */
    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> throwing(Throwing<A1,A2,A3,A4,R> f, Function5<? super Exception,A1,A2,A3,A4,R> errorProcessor) {
        return (a1,a2,a3,a4)->{
            try {
                return f.apply(a1,a2,a3,a4);
            } catch (Exception e) {
                return errorProcessor.apply(e,a1,a2,a3,a4);
            }
        };
    }
    
}
