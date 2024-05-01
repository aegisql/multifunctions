/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

import static com.aegisql.multifunction.Utils.*;

public interface Function10 <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R>{ R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) throws Exception; }

    R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10);

    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4).applyArg1(a5).applyArg1(a6).applyArg1(a7).applyArg1(a8).applyArg1(a9).applyArg1(a10);
    }
    default Function9<A2,A3,A4,A5,A6,A7,A8,A9,A10,R> applyArg1(A1 a1) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A2,A3,A4,A5,A6,A7,A8,A9,A10,R> applyArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1Supplier.get(),a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A3,A4,A5,A6,A7,A8,A9,A10,R> applyArg2(A2 a2) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A3,A4,A5,A6,A7,A8,A9,A10,R> applyArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2Supplier.get(),a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A4,A5,A6,A7,A8,A9,A10,R> applyArg3(A3 a3) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A4,A5,A6,A7,A8,A9,A10,R> applyArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3Supplier.get(),a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A5,A6,A7,A8,A9,A10,R> applyArg4(A4 a4) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A5,A6,A7,A8,A9,A10,R> applyArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4Supplier.get(),a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A6,A7,A8,A9,A10,R> applyArg5(A5 a5) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A6,A7,A8,A9,A10,R> applyArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5Supplier.get(),a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A5,A7,A8,A9,A10,R> applyArg6(A6 a6) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A5,A7,A8,A9,A10,R> applyArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6Supplier.get(),a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A5,A6,A8,A9,A10,R> applyArg7(A7 a7) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A5,A6,A8,A9,A10,R> applyArg7(Supplier<A7> a7Supplier) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7Supplier.get(),a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A5,A6,A7,A9,A10,R> applyArg8(A8 a8) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A5,A6,A7,A9,A10,R> applyArg8(Supplier<A8> a8Supplier) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A9 a9,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8Supplier.get(),a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A5,A6,A7,A8,A10,R> applyArg9(A9 a9) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A5,A6,A7,A8,A10,R> applyArg9(Supplier<A9> a9Supplier) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A10 a10) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9Supplier.get(),a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> applyArg10(A10 a10) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}
default Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> applyArg10(Supplier<A10> a10Supplier) {
    var f = this;
    return new Function9<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
            return f;
        }
    };
}

    /*
    default <X> Function11<X,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    */
    default Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,Optional<R>> optional() {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)->{
            try {
                return apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    default Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> before(Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> before) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)-> {
            before.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            return apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        };
    }
    /*
    default Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> after(Consumer11<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> after) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)-> {
            var result = apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            after.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,result);
            return result;
        };
    }
    */
    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> dispatch(ToInt10Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10> dispatchFunction, Function10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function10 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function10");
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10),finalFunctions).apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> dispatch(Predicate10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10> dispatchPredicate, Function10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10,R> function1, Function10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function10");
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)) {
                return function1.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            } else {
                return function2.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            }
        };
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> of(Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> f) {
        return f::apply;
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7},{8},{9},{10})");
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10),e);
            }
        };
    }
    /*
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> Function10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> f, Function11<? super Exception,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,R> errorProcessor) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            } catch (Exception e) {
                return errorProcessor.apply(e,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            }
        };
    }
    */
}
