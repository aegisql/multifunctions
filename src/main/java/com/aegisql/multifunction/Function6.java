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

public interface Function6 <A1,A2,A3,A4,A5,A6,R> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,R>{ R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) throws Exception; }

    R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6);

    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4).applyArg1(a5).applyArg1(a6);
    }
    default Function5<A2,A3,A4,A5,A6,R> applyArg1(A1 a1) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A2,A3,A4,A5,A6,R> applyArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1Supplier.get(),a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A1,A3,A4,A5,A6,R> applyArg2(A2 a2) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A1,A3,A4,A5,A6,R> applyArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2Supplier.get(),a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A1,A2,A4,A5,A6,R> applyArg3(A3 a3) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A1,A2,A4,A5,A6,R> applyArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3Supplier.get(),a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A1,A2,A3,A5,A6,R> applyArg4(A4 a4) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A1,A2,A3,A5,A6,R> applyArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6) {
            return f.apply(a1,a2,a3,a4Supplier.get(),a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A1,A2,A3,A4,A6,R> applyArg5(A5 a5) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A1,A2,A3,A4,A6,R> applyArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6) {
            return f.apply(a1,a2,a3,a4,a5Supplier.get(),a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A1,A2,A3,A4,A5,R> applyArg6(A6 a6) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
            return f.apply(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}
default Function5<A1,A2,A3,A4,A5,R> applyArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Function5<>() {
        @Override
        public R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
            return f.apply(a1,a2,a3,a4,a5,a6Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Function6<A1,A2,A3,A4,A5,A6,R> uncurry() {
            return f;
        }
    };
}

    
    default <X> Function7<X,A1,A2,A3,A4,A5,A6,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Function6<A1,A2,A3,A4,A5,A6,Optional<R>> optional() {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4,a5,a6));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function6<A1,A2,A3,A4,A5,A6,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function6<A1,A2,A3,A4,A5,A6,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                return apply(a1,a2,a3,a4,a5,a6);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    default Function6<A1,A2,A3,A4,A5,A6,R> before(Consumer6<A1,A2,A3,A4,A5,A6> before) {
        return (a1,a2,a3,a4,a5,a6)-> {
            before.accept(a1,a2,a3,a4,a5,a6);
            return apply(a1,a2,a3,a4,a5,a6);
        };
    }
    
    default Function6<A1,A2,A3,A4,A5,A6,R> after(Consumer7<A1,A2,A3,A4,A5,A6,R> after) {
        return (a1,a2,a3,a4,a5,a6)-> {
            var result = apply(a1,a2,a3,a4,a5,a6);
            after.accept(a1,a2,a3,a4,a5,a6,result);
            return result;
        };
    }
    
    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> dispatch(ToInt6Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> dispatchFunction, Function6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function6 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function6");
        return (a1,a2,a3,a4,a5,a6) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6),finalFunctions).apply(a1,a2,a3,a4,a5,a6);
    }

    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> dispatch(Predicate6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> dispatchPredicate, Function6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,R> function1, Function6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function6");
        return (a1,a2,a3,a4,a5,a6) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6)) {
                return function1.apply(a1,a2,a3,a4,a5,a6);
            } else {
                return function2.apply(a1,a2,a3,a4,a5,a6);
            }
        };
    }

    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> of(Function6<A1,A2,A3,A4,A5,A6,R> f) {
        return f::apply;
    }

    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6})");
    }

    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6),e);
            }
        };
    }
    
    static <A1,A2,A3,A4,A5,A6,R> Function6<A1,A2,A3,A4,A5,A6,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,R> f, Function7<? super Exception,A1,A2,A3,A4,A5,A6,R> errorProcessor) {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6);
            } catch (Exception e) {
                return errorProcessor.apply(e,a1,a2,a3,a4,a5,a6);
            }
        };
    }
    
}
