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
 * The interface Function 7.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 * @param <A6> the type parameter
 * @param <A7> the type parameter
 * @param <R>  the type parameter
 */
@FunctionalInterface
public interface Function7 <A1,A2,A3,A4,A5,A6,A7,R> {

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
     * @param <R>  the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7,R>{
        /**
         * Apply r.
         *
         * @param a1 the a 1
         * @param a2 the a 2
         * @param a3 the a 3
         * @param a4 the a 4
         * @param a5 the a 5
         * @param a6 the a 6
         * @param a7 the a 7
         * @return the r
         * @throws Exception the exception
         */
        R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) throws Exception; }

    /**
     * Apply r.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     * @param a7 the a 7
     * @return the r
     */
    R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7);

    /**
     * Lazy apply supplier ext.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @param a3 the a 3
     * @param a4 the a 4
     * @param a5 the a 5
     * @param a6 the a 6
     * @param a7 the a 7
     * @return the supplier ext
     */
    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4).applyArg1(a5).applyArg1(a6).applyArg1(a7);
    }

    /**
     * Apply arg 1 function 6.
     *
     * @param a1 the a 1
     * @return the function 6
     */
    default Function6<A2,A3,A4,A5,A6,A7,R> applyArg1(A1 a1) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 1 function 6.
     *
     * @param a1Supplier the a 1 supplier
     * @return the function 6
     */
    default Function6<A2,A3,A4,A5,A6,A7,R> applyArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            return f.apply(a1Supplier.get(),a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 6.
     *
     * @param a2 the a 2
     * @return the function 6
     */
    default Function6<A1,A3,A4,A5,A6,A7,R> applyArg2(A2 a2) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 6.
     *
     * @param a2Supplier the a 2 supplier
     * @return the function 6
     */
    default Function6<A1,A3,A4,A5,A6,A7,R> applyArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            return f.apply(a1,a2Supplier.get(),a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 6.
     *
     * @param a3 the a 3
     * @return the function 6
     */
    default Function6<A1,A2,A4,A5,A6,A7,R> applyArg3(A3 a3) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 6.
     *
     * @param a3Supplier the a 3 supplier
     * @return the function 6
     */
    default Function6<A1,A2,A4,A5,A6,A7,R> applyArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7) {
            return f.apply(a1,a2,a3Supplier.get(),a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 4 function 6.
     *
     * @param a4 the a 4
     * @return the function 6
     */
    default Function6<A1,A2,A3,A5,A6,A7,R> applyArg4(A4 a4) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 4 function 6.
     *
     * @param a4Supplier the a 4 supplier
     * @return the function 6
     */
    default Function6<A1,A2,A3,A5,A6,A7,R> applyArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7) {
            return f.apply(a1,a2,a3,a4Supplier.get(),a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 5 function 6.
     *
     * @param a5 the a 5
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A6,A7,R> applyArg5(A5 a5) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 5 function 6.
     *
     * @param a5Supplier the a 5 supplier
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A6,A7,R> applyArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7) {
            return f.apply(a1,a2,a3,a4,a5Supplier.get(),a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 6 function 6.
     *
     * @param a6 the a 6
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A5,A7,R> applyArg6(A6 a6) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 6 function 6.
     *
     * @param a6Supplier the a 6 supplier
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A5,A7,R> applyArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7) {
            return f.apply(a1,a2,a3,a4,a5,a6Supplier.get(),a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 7 function 6.
     *
     * @param a7 the a 7
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A5,A6,R> applyArg7(A7 a7) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 7 function 6.
     *
     * @param a7Supplier the a 7 supplier
     * @return the function 6
     */
    default Function6<A1,A2,A3,A4,A5,A6,R> applyArg7(Supplier<A7> a7Supplier) {
    var f = this;
    return new Function6<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function7<A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry function 8.
     *
     * @param <X> the type parameter
     * @return the function 8
     */
    default <X> Function8<X,A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Optional function 7.
     *
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A6,A7,Optional<R>> optional() {
        return (a1,a2,a3,a4,a5,a6,a7)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4,a5,a6,a7));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    /**
     * Or else function 7.
     *
     * @param defaultValue the default value
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A6,A7,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    /**
     * Or else function 7.
     *
     * @param defaultValue the default value
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A6,A7,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4,a5,a6,a7)->{
            try {
                return apply(a1,a2,a3,a4,a5,a6,a7);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    /**
     * Before function 7.
     *
     * @param before the before
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A6,A7,R> before(Consumer7<A1,A2,A3,A4,A5,A6,A7> before) {
        return (a1,a2,a3,a4,a5,a6,a7)-> {
            before.accept(a1,a2,a3,a4,a5,a6,a7);
            return apply(a1,a2,a3,a4,a5,a6,a7);
        };
    }

    /**
     * After function 7.
     *
     * @param after the after
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A6,A7,R> after(Consumer8<A1,A2,A3,A4,A5,A6,A7,R> after) {
        return (a1,a2,a3,a4,a5,a6,a7)-> {
            var result = apply(a1,a2,a3,a4,a5,a6,a7);
            after.accept(a1,a2,a3,a4,a5,a6,a7,result);
            return result;
        };
    }

    /**
     * And then function 7.
     *
     * @param <R2>  the type parameter
     * @param after the after
     * @return the function 7
     */
    default <R2> Function7<A1,A2,A3,A4,A5,A6,A7,R2> andThen(Function<? super R, ? extends R2> after) {
        Objects.requireNonNull(after);
        return (a1,a2,a3,a4,a5,a6,a7) -> after.apply(apply(a1,a2,a3,a4,a5,a6,a7));
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 7; }

    /**
     * Dispatch function 7.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <A6>             the type parameter
     * @param <A7>             the type parameter
     * @param <R>              the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the function 7
     */
    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> dispatch(ToInt7Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> dispatchFunction, Function7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function7 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function7");
        return (a1,a2,a3,a4,a5,a6,a7) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7),finalFunctions).apply(a1,a2,a3,a4,a5,a6,a7);
    }

    /**
     * Dispatch function 7.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param <A4>              the type parameter
     * @param <A5>              the type parameter
     * @param <A6>              the type parameter
     * @param <A7>              the type parameter
     * @param <R>               the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the function 7
     */
    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> dispatch(Predicate7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> dispatchPredicate, Function7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,R> function1, Function7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function7");
        return (a1,a2,a3,a4,a5,a6,a7) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6,a7)) {
                return function1.apply(a1,a2,a3,a4,a5,a6,a7);
            } else {
                return function2.apply(a1,a2,a3,a4,a5,a6,a7);
            }
        };
    }

    /**
     * Of function 7.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param <A7> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 7
     */
    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> of(Function7<A1,A2,A3,A4,A5,A6,A7,R> f) {
        return f::apply;
    }

    /**
     * Throwing function 7.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param <A7> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 7
     */
    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7})");
    }

    /**
     * Throwing function 7.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param <A4>   the type parameter
     * @param <A5>   the type parameter
     * @param <A6>   the type parameter
     * @param <A7>   the type parameter
     * @param <R>    the type parameter
     * @param f      the f
     * @param format the format
     * @return the function 7
     */
    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing function 7.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <A6>             the type parameter
     * @param <A7>             the type parameter
     * @param <R>              the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the function 7
     */
    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6,a7);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7),e);
            }
        };
    }

    /**
     * Throwing function 7.
     *
     * @param <A1>           the type parameter
     * @param <A2>           the type parameter
     * @param <A3>           the type parameter
     * @param <A4>           the type parameter
     * @param <A5>           the type parameter
     * @param <A6>           the type parameter
     * @param <A7>           the type parameter
     * @param <R>            the type parameter
     * @param f              the f
     * @param errorProcessor the error processor
     * @return the function 7
     */
    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,R> f, Function8<? super Exception,A1,A2,A3,A4,A5,A6,A7,R> errorProcessor) {
        return (a1,a2,a3,a4,a5,a6,a7)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6,a7);
            } catch (Exception e) {
                return errorProcessor.apply(e,a1,a2,a3,a4,a5,a6,a7);
            }
        };
    }
    
}
