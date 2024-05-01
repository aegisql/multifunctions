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
 * The interface Function 3.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <R>  the type parameter
 */
public interface Function3 <A1,A2,A3,R> {

    /**
     * The interface Throwing.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <R>  the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3,R>{
        /**
         * Apply r.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @param a3 the a 3
         * @return the r
         * @throws Exception the exception
         */
        R apply(A1 a1,A2 a2,A3 a3) throws Exception; }

    /**
     * Apply r.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @return the r
     */
    R apply(A1 a1,A2 a2,A3 a3);

    /**
     * Lazy apply supplier ext.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @return the supplier ext
     */
    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3);
    }

    /**
     * Apply arg 1 function 2.
     *
     * @param a1 the a 1
     * @return the function 2
     */
    default Function2<A2,A3,R> applyArg1(A1 a1) {
    var f = this;
    return new Function2<>() {
        @Override
        public R apply(A2 a2,A3 a3) {
            return f.apply(a1,a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function3<A1,A2,A3,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 1 function 2.
     *
     * @param a1Supplier the a 1 supplier
     * @return the function 2
     */
    default Function2<A2,A3,R> applyArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Function2<>() {
        @Override
        public R apply(A2 a2,A3 a3) {
            return f.apply(a1Supplier.get(),a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function3<A1,A2,A3,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 2.
     *
     * @param a2 the a 2
     * @return the function 2
     */
    default Function2<A1,A3,R> applyArg2(A2 a2) {
    var f = this;
    return new Function2<>() {
        @Override
        public R apply(A1 a1,A3 a3) {
            return f.apply(a1,a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function3<A1,A2,A3,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 2.
     *
     * @param a2Supplier the a 2 supplier
     * @return the function 2
     */
    default Function2<A1,A3,R> applyArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Function2<>() {
        @Override
        public R apply(A1 a1,A3 a3) {
            return f.apply(a1,a2Supplier.get(),a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function3<A1,A2,A3,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 2.
     *
     * @param a3 the a 3
     * @return the function 2
     */
    default Function2<A1,A2,R> applyArg3(A3 a3) {
    var f = this;
    return new Function2<>() {
        @Override
        public R apply(A1 a1,A2 a2) {
            return f.apply(a1,a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function3<A1,A2,A3,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 2.
     *
     * @param a3Supplier the a 3 supplier
     * @return the function 2
     */
    default Function2<A1,A2,R> applyArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Function2<>() {
        @Override
        public R apply(A1 a1,A2 a2) {
            return f.apply(a1,a2,a3Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function3<A1,A2,A3,R> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry function 4.
     *
     * @param <X> the type parameter
     * @return the function 4
     */
    default <X> Function4<X,A1,A2,A3,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Optional function 3.
     *
     * @return the function 3
     */
    default Function3<A1,A2,A3,Optional<R>> optional() {
        return (a1,a2,a3)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    /**
     * Or else function 3.
     *
     * @param defaultValue the default value
     * @return the function 3
     */
    default Function3<A1,A2,A3,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    /**
     * Or else function 3.
     *
     * @param defaultValue the default value
     * @return the function 3
     */
    default Function3<A1,A2,A3,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3)->{
            try {
                return apply(a1,a2,a3);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    /**
     * Before function 3.
     *
     * @param before the before
     * @return the function 3
     */
    default Function3<A1,A2,A3,R> before(Consumer3<A1,A2,A3> before) {
        return (a1,a2,a3)-> {
            before.accept(a1,a2,a3);
            return apply(a1,a2,a3);
        };
    }

    /**
     * After function 3.
     *
     * @param after the after
     * @return the function 3
     */
    default Function3<A1,A2,A3,R> after(Consumer4<A1,A2,A3,R> after) {
        return (a1,a2,a3)-> {
            var result = apply(a1,a2,a3);
            after.accept(a1,a2,a3,result);
            return result;
        };
    }

    /**
     * Dispatch function 3.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <R>              the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the function 3
     */
    @SafeVarargs
    static <A1,A2,A3,R> Function3<A1,A2,A3,R> dispatch(ToInt3Function<? super A1,? super A2,? super A3> dispatchFunction, Function3<? super A1,? super A2,? super A3,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function3 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function3");
        return (a1,a2,a3) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3),finalFunctions).apply(a1,a2,a3);
    }

    /**
     * Dispatch function 3.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param <R>               the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the function 3
     */
    static <A1,A2,A3,R> Function3<A1,A2,A3,R> dispatch(Predicate3<? super A1,? super A2,? super A3> dispatchPredicate, Function3<? super A1,? super A2,? super A3,R> function1, Function3<? super A1,? super A2,? super A3,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function3");
        return (a1,a2,a3) -> {
            if(dispatchPredicate.test(a1,a2,a3)) {
                return function1.apply(a1,a2,a3);
            } else {
                return function2.apply(a1,a2,a3);
            }
        };
    }

    /**
     * Of function 3.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 3
     */
    static <A1,A2,A3,R> Function3<A1,A2,A3,R> of(Function3<A1,A2,A3,R> f) {
        return f::apply;
    }

    /**
     * Throwing function 3.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 3
     */
    static <A1,A2,A3,R> Function3<A1,A2,A3,R> throwing(Throwing<A1,A2,A3,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3})");
    }

    /**
     * Throwing function 3.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param <R>    the type parameter
     * @param f      the f
     * @param format the format
     * @return the function 3
     */
    static <A1,A2,A3,R> Function3<A1,A2,A3,R> throwing(Throwing<A1,A2,A3,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing function 3.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <R>              the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the function 3
     */
    static <A1,A2,A3,R> Function3<A1,A2,A3,R> throwing(Throwing<A1,A2,A3,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3)->{
            try {
                return f.apply(a1,a2,a3);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3),e);
            }
        };
    }

    /**
     * Throwing function 3.
     *
     * @param <A1>           the type parameter
     * @param <A2>           the type parameter
     * @param <A3>           the type parameter
     * @param <R>            the type parameter
     * @param f              the f
     * @param errorProcessor the error processor
     * @return the function 3
     */
    static <A1,A2,A3,R> Function3<A1,A2,A3,R> throwing(Throwing<A1,A2,A3,R> f, Function4<? super Exception,A1,A2,A3,R> errorProcessor) {
        return (a1,a2,a3)->{
            try {
                return f.apply(a1,a2,a3);
            } catch (Exception e) {
                return errorProcessor.apply(e,a1,a2,a3);
            }
        };
    }
    
}
