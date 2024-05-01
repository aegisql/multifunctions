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

public interface Function4 <A1,A2,A3,A4,R> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,R>{ R apply(A1 a1,A2 a2,A3 a3,A4 a4) throws Exception; }

    R apply(A1 a1,A2 a2,A3 a3,A4 a4);

    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4);
    }
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

    
    default <X> Function5<X,A1,A2,A3,A4,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Function4<A1,A2,A3,A4,Optional<R>> optional() {
        return (a1,a2,a3,a4)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function4<A1,A2,A3,A4,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function4<A1,A2,A3,A4,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4)->{
            try {
                return apply(a1,a2,a3,a4);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    default Function4<A1,A2,A3,A4,R> before(Consumer4<A1,A2,A3,A4> before) {
        return (a1,a2,a3,a4)-> {
            before.accept(a1,a2,a3,a4);
            return apply(a1,a2,a3,a4);
        };
    }
    
    default Function4<A1,A2,A3,A4,R> after(Consumer5<A1,A2,A3,A4,R> after) {
        return (a1,a2,a3,a4)-> {
            var result = apply(a1,a2,a3,a4);
            after.accept(a1,a2,a3,a4,result);
            return result;
        };
    }
    
    @SafeVarargs
    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> dispatch(ToInt4Function<? super A1,? super A2,? super A3,? super A4> dispatchFunction, Function4<? super A1,? super A2,? super A3,? super A4,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function4 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function4");
        return (a1,a2,a3,a4) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4),finalFunctions).apply(a1,a2,a3,a4);
    }

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

    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> of(Function4<A1,A2,A3,A4,R> f) {
        return f::apply;
    }

    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> throwing(Throwing<A1,A2,A3,A4,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4})");
    }

    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> throwing(Throwing<A1,A2,A3,A4,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,A2,A3,A4,R> Function4<A1,A2,A3,A4,R> throwing(Throwing<A1,A2,A3,A4,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4)->{
            try {
                return f.apply(a1,a2,a3,a4);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4),e);
            }
        };
    }
    
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
