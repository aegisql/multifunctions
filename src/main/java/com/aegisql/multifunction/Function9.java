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

public interface Function9 <A1,A2,A3,A4,A5,A6,A7,A8,A9,R> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,R>{ R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) throws Exception; }

    R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9);

    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4).applyArg1(a5).applyArg1(a6).applyArg1(a7).applyArg1(a8).applyArg1(a9);
    }
    default Function8<A2,A3,A4,A5,A6,A7,A8,A9,R> applyArg1(A1 a1) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A2,A3,A4,A5,A6,A7,A8,A9,R> applyArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1Supplier.get(),a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A3,A4,A5,A6,A7,A8,A9,R> applyArg2(A2 a2) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A3,A4,A5,A6,A7,A8,A9,R> applyArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2Supplier.get(),a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A4,A5,A6,A7,A8,A9,R> applyArg3(A3 a3) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A4,A5,A6,A7,A8,A9,R> applyArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3Supplier.get(),a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A5,A6,A7,A8,A9,R> applyArg4(A4 a4) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A5,A6,A7,A8,A9,R> applyArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4Supplier.get(),a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A4,A6,A7,A8,A9,R> applyArg5(A5 a5) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A4,A6,A7,A8,A9,R> applyArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5Supplier.get(),a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A4,A5,A7,A8,A9,R> applyArg6(A6 a6) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A4,A5,A7,A8,A9,R> applyArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6Supplier.get(),a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A4,A5,A6,A8,A9,R> applyArg7(A7 a7) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A4,A5,A6,A8,A9,R> applyArg7(Supplier<A7> a7Supplier) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7Supplier.get(),a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A4,A5,A6,A7,A9,R> applyArg8(A8 a8) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A4,A5,A6,A7,A9,R> applyArg8(Supplier<A8> a8Supplier) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A9 a9) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8Supplier.get(),a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> applyArg9(A9 a9) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}
default Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> applyArg9(Supplier<A9> a9Supplier) {
    var f = this;
    return new Function8<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
            return f;
        }
    };
}

    
    default <X> Function10<X,A1,A2,A3,A4,A5,A6,A7,A8,A9,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,Optional<R>> optional() {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4,a5,a6,a7,a8,a9));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)->{
            try {
                return apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    default Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> before(Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> before) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)-> {
            before.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            return apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        };
    }
    
    default Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> after(Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> after) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)-> {
            var result = apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            after.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,result);
            return result;
        };
    }
    
    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,R> Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> dispatch(ToInt9Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> dispatchFunction, Function9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function9 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function9");
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7,a8,a9),finalFunctions).apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,R> Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> dispatch(Predicate9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> dispatchPredicate, Function9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,R> function1, Function9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function9");
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6,a7,a8,a9)) {
                return function1.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            } else {
                return function2.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            }
        };
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,R> Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> of(Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> f) {
        return f::apply;
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,R> Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7},{8},{9})");
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,R> Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,R> Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7,a8,a9),e);
            }
        };
    }
    
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,R> Function9<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,R> f, Function10<? super Exception,A1,A2,A3,A4,A5,A6,A7,A8,A9,R> errorProcessor) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            } catch (Exception e) {
                return errorProcessor.apply(e,a1,a2,a3,a4,a5,a6,a7,a8,a9);
            }
        };
    }
    
}
