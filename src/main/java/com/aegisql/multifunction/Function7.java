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

public interface Function7 <A1,A2,A3,A4,A5,A6,A7,R> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7,R>{ R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) throws Exception; }

    R apply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7);

    default SupplierExt<R> lazyApply(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
        return applyArg1(a1).applyArg1(a2).applyArg1(a3).applyArg1(a4).applyArg1(a5).applyArg1(a6).applyArg1(a7);
    }
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

    
    default <X> Function8<X,A1,A2,A3,A4,A5,A6,A7,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Function7<A1,A2,A3,A4,A5,A6,A7,Optional<R>> optional() {
        return (a1,a2,a3,a4,a5,a6,a7)->{
            try {
                return Optional.ofNullable(apply(a1,a2,a3,a4,a5,a6,a7));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function7<A1,A2,A3,A4,A5,A6,A7,R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function7<A1,A2,A3,A4,A5,A6,A7,R> orElse(Supplier<R> defaultValue) {
        return (a1,a2,a3,a4,a5,a6,a7)->{
            try {
                return apply(a1,a2,a3,a4,a5,a6,a7);
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    default Function7<A1,A2,A3,A4,A5,A6,A7,R> before(Consumer7<A1,A2,A3,A4,A5,A6,A7> before) {
        return (a1,a2,a3,a4,a5,a6,a7)-> {
            before.accept(a1,a2,a3,a4,a5,a6,a7);
            return apply(a1,a2,a3,a4,a5,a6,a7);
        };
    }
    
    default Function7<A1,A2,A3,A4,A5,A6,A7,R> after(Consumer8<A1,A2,A3,A4,A5,A6,A7,R> after) {
        return (a1,a2,a3,a4,a5,a6,a7)-> {
            var result = apply(a1,a2,a3,a4,a5,a6,a7);
            after.accept(a1,a2,a3,a4,a5,a6,a7,result);
            return result;
        };
    }
    
    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> dispatch(ToInt7Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> dispatchFunction, Function7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function7 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function7");
        return (a1,a2,a3,a4,a5,a6,a7) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7),finalFunctions).apply(a1,a2,a3,a4,a5,a6,a7);
    }

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

    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> of(Function7<A1,A2,A3,A4,A5,A6,A7,R> f) {
        return f::apply;
    }

    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,R> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7})");
    }

    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,A6,A7,R> Function7<A1,A2,A3,A4,A5,A6,A7,R> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7)->{
            try {
                return f.apply(a1,a2,a3,a4,a5,a6,a7);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7),e);
            }
        };
    }
    
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
