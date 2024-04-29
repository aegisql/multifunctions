package com.aegisql.multifunction;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

public interface Function3 <A1,A2,A3,R> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,R>{ R apply(A1 a1,A2 a2,A3 a3) throws Exception; }

    R apply(A1 a1,A2 a2,A3 a3);

    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3);
    }
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

    
    default <X> Function4<X,A1,A2,A3,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Function3<A1,A2,A3,Optional<R>> optional() {
        return (a1,a2,a3)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function3<A1,A2,A3,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function3<A1,A2,A3,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3)->{
            try {
                return apply(a1,a2,a3);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    @SafeVarargs
    static <A1,A2,A3,R> Function3<A1,A2,A3,R> dispatch(ToInt3Function<? super A1,? super A2,? super A3> dispatchFunction, Function3<? super A1,? super A2,? super A3,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function3 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function3");
        return (a1,a2,a3) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3),finalFunctions).apply(a1,a2,a3);
    }

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

    static <A1,A2,A3,R> Function3<A1,A2,A3,R> of(Function3<A1,A2,A3,R> f) {
        return f::apply;
    }

    static <A1,A2,A3,R> Function3<A1,A2,A3,R> throwing(Throwing<A1,A2,A3,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3})");
    }

    static <A1,A2,A3,R> Function3<A1,A2,A3,R> throwing(Throwing<A1,A2,A3,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,A2,A3,R> Function3<A1,A2,A3,R> throwing(Throwing<A1,A2,A3,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3)->{
            try {
                return f.apply(a1,a2,a3);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3),e);
            }
        };
    }

}
