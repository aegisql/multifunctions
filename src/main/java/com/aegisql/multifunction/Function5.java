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

public interface Function5 <A1,A2,A3,A4,A5,R> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,R>{ R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) throws Exception; }

    R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5);

    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4).applyArg1(a5);
    }
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

    
    default <X> Function6<X,A1,A2,A3,A4,A5,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Function5<A1,A2,A3,A4,A5,Optional<R>> optional() {
        return (a1,a2,a3,a4,a5)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4,a5));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function5<A1,A2,A3,A4,A5,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function5<A1,A2,A3,A4,A5,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4,a5)->{
            try {
                return apply(a1,a2,a3,a4,a5);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    default Function5<A1,A2,A3,A4,A5,R> before(Consumer5<A1,A2,A3,A4,A5> before) {
        return (a1,a2,a3,a4,a5)-> {
            before.accept(a1,a2,a3,a4,a5);
            return apply(a1,a2,a3,a4,a5);
        };
    }
    
    default Function5<A1,A2,A3,A4,A5,R> after(Consumer6<A1,A2,A3,A4,A5,R> after) {
        return (a1,a2,a3,a4,a5)-> {
            var result = apply(a1,a2,a3,a4,a5);
            after.accept(a1,a2,a3,a4,a5,result);
            return result;
        };
    }
    
    @SafeVarargs
    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> dispatch(ToInt5Function<? super A1,? super A2,? super A3,? super A4,? super A5> dispatchFunction, Function5<? super A1,? super A2,? super A3,? super A4,? super A5,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function5 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function5");
        return (a1,a2,a3,a4,a5) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5),finalFunctions).apply(a1,a2,a3,a4,a5);
    }

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

    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> of(Function5<A1,A2,A3,A4,A5,R> f) {
        return f::apply;
    }

    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> throwing(Throwing<A1,A2,A3,A4,A5,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5})");
    }

    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> throwing(Throwing<A1,A2,A3,A4,A5,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,R> Function5<A1,A2,A3,A4,A5,R> throwing(Throwing<A1,A2,A3,A4,A5,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5)->{
            try {
                return f.apply(a1,a2,a3,a4,a5);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5),e);
            }
        };
    }
    
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
