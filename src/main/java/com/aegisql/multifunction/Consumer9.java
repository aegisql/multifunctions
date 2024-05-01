/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

public interface Consumer9 <A1,A2,A3,A4,A5,A6,A7,A8,A9> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9>{ void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) throws Exception; }

    void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9);

    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4).acceptArg1(a5).acceptArg1(a6).acceptArg1(a7).acceptArg1(a8).acceptArg1(a9);
    }
    default Consumer8<A2,A3,A4,A5,A6,A7,A8,A9> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A2,A3,A4,A5,A6,A7,A8,A9> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1Supplier.get(),a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A3,A4,A5,A6,A7,A8,A9> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A3,A4,A5,A6,A7,A8,A9> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2Supplier.get(),a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A4,A5,A6,A7,A8,A9> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A4,A5,A6,A7,A8,A9> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3Supplier.get(),a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A5,A6,A7,A8,A9> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A5,A6,A7,A8,A9> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4Supplier.get(),a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A4,A6,A7,A8,A9> acceptArg5(A5 a5) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A4,A6,A7,A8,A9> acceptArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5Supplier.get(),a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A4,A5,A7,A8,A9> acceptArg6(A6 a6) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A4,A5,A7,A8,A9> acceptArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6Supplier.get(),a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A4,A5,A6,A8,A9> acceptArg7(A7 a7) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A4,A5,A6,A8,A9> acceptArg7(Supplier<A7> a7Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7Supplier.get(),a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A4,A5,A6,A7,A9> acceptArg8(A8 a8) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A4,A5,A6,A7,A9> acceptArg8(Supplier<A8> a8Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8Supplier.get(),a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> acceptArg9(A9 a9) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}
default Consumer8<A1,A2,A3,A4,A5,A6,A7,A8> acceptArg9(Supplier<A9> a9Supplier) {
    var f = this;
    return new Consumer8<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
            return f;
        }
    };
}

    
    default <X> Consumer10<X,A1,A2,A3,A4,A5,A6,A7,A8,A9> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> before(Consumer9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> before) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)-> {
            before.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            this.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        };
    }

    default Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9>  after(Consumer9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> after) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)-> {
            this.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            after.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
        };
    }

    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> dispatch(ToInt9Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> dispatchFunction, Consumer9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer9 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer9");
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7,a8,a9),finalFunctions).accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> dispatch(Predicate9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> dispatchPredicate, Consumer9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> function1, Consumer9<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer9");
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6,a7,a8,a9)) {
                function1.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            } else {
                function2.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            }
        };
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> of(Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> f) {
        return f::accept;
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7},{8},{9})");
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7,a8,a9),e);
            }
        };
    }
    
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9> Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9> f, Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,? super Exception> errorConsumer) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,e);
            }
        };
    }
    
}
