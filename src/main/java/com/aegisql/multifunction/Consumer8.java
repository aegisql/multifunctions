/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

public interface Consumer8 <A1,A2,A3,A4,A5,A6,A7,A8> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7,A8>{ void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) throws Exception; }

    void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8);

    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4).acceptArg1(a5).acceptArg1(a6).acceptArg1(a7).acceptArg1(a8);
    }
    default Consumer7<A2,A3,A4,A5,A6,A7,A8> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A2,A3,A4,A5,A6,A7,A8> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1Supplier.get(),a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A3,A4,A5,A6,A7,A8> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A3,A4,A5,A6,A7,A8> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2Supplier.get(),a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A4,A5,A6,A7,A8> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A4,A5,A6,A7,A8> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3Supplier.get(),a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A3,A5,A6,A7,A8> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A3,A5,A6,A7,A8> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4Supplier.get(),a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A3,A4,A6,A7,A8> acceptArg5(A5 a5) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A3,A4,A6,A7,A8> acceptArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5Supplier.get(),a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A3,A4,A5,A7,A8> acceptArg6(A6 a6) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A3,A4,A5,A7,A8> acceptArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6Supplier.get(),a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A3,A4,A5,A6,A8> acceptArg7(A7 a7) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A3,A4,A5,A6,A8> acceptArg7(Supplier<A7> a7Supplier) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7Supplier.get(),a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A3,A4,A5,A6,A7> acceptArg8(A8 a8) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}
default Consumer7<A1,A2,A3,A4,A5,A6,A7> acceptArg8(Supplier<A8> a8Supplier) {
    var f = this;
    return new Consumer7<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
            return f;
        }
    };
}

    
    default <X> Consumer9<X,A1,A2,A3,A4,A5,A6,A7,A8> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> before(Consumer8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8> before) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)-> {
            before.accept(a1,a2,a3,a4,a5,a6,a7,a8);
            this.accept(a1,a2,a3,a4,a5,a6,a7,a8);
        };
    }

    default Consumer8<A1,A2,A3,A4,A5,A6,A7,A8>  after(Consumer8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8> after) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)-> {
            this.accept(a1,a2,a3,a4,a5,a6,a7,a8);
            after.accept(a1,a2,a3,a4,a5,a6,a7,a8);
        };
    }

    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7,A8> Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> dispatch(ToInt8Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8> dispatchFunction, Consumer8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer8 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer8");
        return (a1,a2,a3,a4,a5,a6,a7,a8) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7,a8),finalFunctions).accept(a1,a2,a3,a4,a5,a6,a7,a8);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8> Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> dispatch(Predicate8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8> dispatchPredicate, Consumer8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8> function1, Consumer8<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer8");
        return (a1,a2,a3,a4,a5,a6,a7,a8) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6,a7,a8)) {
                function1.accept(a1,a2,a3,a4,a5,a6,a7,a8);
            } else {
                function2.accept(a1,a2,a3,a4,a5,a6,a7,a8);
            }
        };
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8> Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> of(Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> f) {
        return f::accept;
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8> Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7},{8})");
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8> Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8> Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6,a7,a8);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7,a8),e);
            }
        };
    }
    
    static <A1,A2,A3,A4,A5,A6,A7,A8> Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8> f, Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,? super Exception> errorConsumer) {
        return (a1,a2,a3,a4,a5,a6,a7,a8)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6,a7,a8);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,a4,a5,a6,a7,a8,e);
            }
        };
    }
    
}
