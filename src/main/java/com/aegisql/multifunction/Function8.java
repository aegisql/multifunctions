package com.aegisql.multifunction;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

public interface Function8 <A1,A2,A3,A4,A5,A6,A7,A8,R> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7,A8,R>{ R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) throws Exception; }

    R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8);

    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4).applyArg1(a5).applyArg1(a6).applyArg1(a7).applyArg1(a8);
    }
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

    
    default <X> Function9<X,A1,A2,A3,A4,A5,A6,A7,A8,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Function8<A1,A2,A3,A4,A5,A6,A7,A8,Optional<R>> optional() {
        return (a1,a2,a3,a4,a5,a6,a7,a8)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4,a5,a6,a7,a8));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)->{
            try {
                return apply(a1,a2,a3,a4,a5,a6,a7,a8);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> dispatch(ToInt8Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8> dispatchFunction, Function8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function8 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function8");
        return (a1,a2,a3,a4,a5,a6,a7,a8) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7,a8),finalFunctions).apply(a1,a2,a3,a4,a5,a6,a7,a8);
    }

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

    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> of(Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> f) {
        return f::apply;
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7},{8})");
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,R> Function8<A1,A2,A3,A4,A5,A6,A7,A8,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6,a7,a8);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7,a8),e);
            }
        };
    }

}
