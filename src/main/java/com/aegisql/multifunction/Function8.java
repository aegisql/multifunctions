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
 * The interface Function 8.
 *
 * @param <A1> the type parameter
 * @param <A2> the type parameter
 * @param <A3> the type parameter
 * @param <A4> the type parameter
 * @param <A5> the type parameter
 * @param <A6> the type parameter
 * @param <A7> the type parameter
 * @param <A8> the type parameter
 * @param <R>  the type parameter
 */
@FunctionalInterface
public interface Function8 <A1,A2,A3,A4,A5,A6,A7,A8,R> {

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
     * @param <R>  the type parameter
     */
    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7,A8,R>{
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
         * @param a8 the a 8
         * @return the r
         * @throws Exception the exception
         */
        R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) throws Exception; }

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
     * @param a8 the a 8
     * @return the r
     */
    R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8);

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
     * @param a8 the a 8
     * @return the supplier ext
     */
    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4).applyArg1(a5).applyArg1(a6).applyArg1(a7).applyArg1(a8);
    }

    /**
     * Apply arg 1 function 7.
     *
     * @param a1 the a 1
     * @return the function 7
     */
    default Function7<A2,A3,A4,A5,A6,A7,A8,R> applyArg1(A1 a1) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 1 function 7.
     *
     * @param a1Supplier the a 1 supplier
     * @return the function 7
     */
    default Function7<A2,A3,A4,A5,A6,A7,A8,R> applyArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1Supplier.get(),a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 7.
     *
     * @param a2 the a 2
     * @return the function 7
     */
    default Function7<A1,A3,A4,A5,A6,A7,A8,R> applyArg2(A2 a2) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 2 function 7.
     *
     * @param a2Supplier the a 2 supplier
     * @return the function 7
     */
    default Function7<A1,A3,A4,A5,A6,A7,A8,R> applyArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2Supplier.get(),a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 7.
     *
     * @param a3 the a 3
     * @return the function 7
     */
    default Function7<A1,A2,A4,A5,A6,A7,A8,R> applyArg3(A3 a3) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 3 function 7.
     *
     * @param a3Supplier the a 3 supplier
     * @return the function 7
     */
    default Function7<A1,A2,A4,A5,A6,A7,A8,R> applyArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3Supplier.get(),a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 4 function 7.
     *
     * @param a4 the a 4
     * @return the function 7
     */
    default Function7<A1,A2,A3,A5,A6,A7,A8,R> applyArg4(A4 a4) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 4 function 7.
     *
     * @param a4Supplier the a 4 supplier
     * @return the function 7
     */
    default Function7<A1,A2,A3,A5,A6,A7,A8,R> applyArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4Supplier.get(),a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 5 function 7.
     *
     * @param a5 the a 5
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A6,A7,A8,R> applyArg5(A5 a5) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 5 function 7.
     *
     * @param a5Supplier the a 5 supplier
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A6,A7,A8,R> applyArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5Supplier.get(),a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 6 function 7.
     *
     * @param a6 the a 6
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A7,A8,R> applyArg6(A6 a6) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 6 function 7.
     *
     * @param a6Supplier the a 6 supplier
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A7,A8,R> applyArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6Supplier.get(),a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 7 function 7.
     *
     * @param a7 the a 7
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A6,A8,R> applyArg7(A7 a7) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 7 function 7.
     *
     * @param a7Supplier the a 7 supplier
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A6,A8,R> applyArg7(Supplier<A7> a7Supplier) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7Supplier.get(),a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 8 function 7.
     *
     * @param a8 the a 8
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A6,A7,R> applyArg8(A8 a8) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}

    /**
     * Apply arg 8 function 7.
     *
     * @param a8Supplier the a 8 supplier
     * @return the function 7
     */
    default Function7<A1,A2,A3,A4,A5,A6,A7,R> applyArg8(Supplier<A8> a8Supplier) {
    var f = this;
    return new Function7<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
            return f;
        }
    };
}


    /**
     * Uncurry function 9.
     *
     * @param <X> the type parameter
     * @return the function 9
     */
    default <X> Function9<X,A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Optional function 8.
     *
     * @return the function 8
     */
    default Function8<A1,A2,A3,A4,A5,A6,A7,A8,Optional<R>> optional() {
        return (a1,a2,a3,a4,a5,a6,a7,a8)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4,a5,a6,a7,a8));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    /**
     * Or else function 8.
     *
     * @param defaultValue the default value
     * @return the function 8
     */
    default Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    /**
     * Or else function 8.
     *
     * @param defaultValue the default value
     * @return the function 8
     */
    default Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)->{
            try {
                return apply(a1,a2,a3,a4,a5,a6,a7,a8);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    /**
     * Before function 8.
     *
     * @param before the before
     * @return the function 8
     */
    default Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> before(Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> before) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)-> {
            before.accept(a1,a2,a3,a4,a5,a6,a7,a8);
            return apply(a1,a2,a3,a4,a5,a6,a7,a8);
        };
    }

    /**
     * After function 8.
     *
     * @param after the after
     * @return the function 8
     */
    default Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> after(Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,R> after) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)-> {
            var result = apply(a1,a2,a3,a4,a5,a6,a7,a8);
            after.accept(a1,a2,a3,a4,a5,a6,a7,a8,result);
            return result;
        };
    }

    /**
     * And then function 8.
     *
     * @param <R2>  the type parameter
     * @param after the after
     * @return the function 8
     */
    default <R2> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R2> andThen(Function<? super R, ? extends R2> after) {
        Objects.requireNonNull(after);
        return (a1,a2,a3,a4,a5,a6,a7,a8) -> after.apply(apply(a1,a2,a3,a4,a5,a6,a7,a8));
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 8; }

    /**
     * Dispatch function 8.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <A6>             the type parameter
     * @param <A7>             the type parameter
     * @param <A8>             the type parameter
     * @param <R>              the type parameter
     * @param dispatchFunction the dispatch function
     * @param functions        the functions
     * @return the function 8
     */
    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> dispatch(ToInt8Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8> dispatchFunction, Function8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function8 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function8");
        return (a1,a2,a3,a4,a5,a6,a7,a8) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7,a8),finalFunctions).apply(a1,a2,a3,a4,a5,a6,a7,a8);
    }

    /**
     * Dispatch function 8.
     *
     * @param <A1>              the type parameter
     * @param <A2>              the type parameter
     * @param <A3>              the type parameter
     * @param <A4>              the type parameter
     * @param <A5>              the type parameter
     * @param <A6>              the type parameter
     * @param <A7>              the type parameter
     * @param <A8>              the type parameter
     * @param <R>               the type parameter
     * @param dispatchPredicate the dispatch predicate
     * @param function1         the function 1
     * @param function2         the function 2
     * @return the function 8
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> dispatch(Predicate8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8> dispatchPredicate, Function8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,R> function1, Function8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function8");
        return (a1,a2,a3,a4,a5,a6,a7,a8) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6,a7,a8)) {
                return function1.apply(a1,a2,a3,a4,a5,a6,a7,a8);
            } else {
                return function2.apply(a1,a2,a3,a4,a5,a6,a7,a8);
            }
        };
    }

    /**
     * Of function 8.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param <A7> the type parameter
     * @param <A8> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 8
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> of(Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> f) {
        return f::apply;
    }

    /**
     * Throwing function 8.
     *
     * @param <A1> the type parameter
     * @param <A2> the type parameter
     * @param <A3> the type parameter
     * @param <A4> the type parameter
     * @param <A5> the type parameter
     * @param <A6> the type parameter
     * @param <A7> the type parameter
     * @param <A8> the type parameter
     * @param <R>  the type parameter
     * @param f    the f
     * @return the function 8
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7},{8})");
    }

    /**
     * Throwing function 8.
     *
     * @param <A1>   the type parameter
     * @param <A2>   the type parameter
     * @param <A3>   the type parameter
     * @param <A4>   the type parameter
     * @param <A5>   the type parameter
     * @param <A6>   the type parameter
     * @param <A7>   the type parameter
     * @param <A8>   the type parameter
     * @param <R>    the type parameter
     * @param f      the f
     * @param format the format
     * @return the function 8
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing function 8.
     *
     * @param <A1>             the type parameter
     * @param <A2>             the type parameter
     * @param <A3>             the type parameter
     * @param <A4>             the type parameter
     * @param <A5>             the type parameter
     * @param <A6>             the type parameter
     * @param <A7>             the type parameter
     * @param <A8>             the type parameter
     * @param <R>              the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the function 8
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7,a8),e);
            }
        };
    }

    /**
     * Throwing function 8.
     *
     * @param <A1>           the type parameter
     * @param <A2>           the type parameter
     * @param <A3>           the type parameter
     * @param <A4>           the type parameter
     * @param <A5>           the type parameter
     * @param <A6>           the type parameter
     * @param <A7>           the type parameter
     * @param <A8>           the type parameter
     * @param <R>            the type parameter
     * @param f              the f
     * @param errorProcessor the error processor
     * @return the function 8
     */
    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,R> f, Function9<? super Exception,A1,A2,A3,A4,A5,A6,A7,A8,R> errorProcessor) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
            } catch (Exception e) {
                return errorProcessor.apply(e,a1,a2,a3,a4,a5,a6,a7,a8);
            }
        };
    }
    
}
