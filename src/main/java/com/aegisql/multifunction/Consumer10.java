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

public interface Consumer10 <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10>{ void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) throws Exception; }

    void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10);

    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4).acceptArg1(a5).acceptArg1(a6).acceptArg1(a7).acceptArg1(a8).acceptArg1(a9).acceptArg1(a10);
    }
    default Consumer9<A2,A3,A4,A5,A6,A7,A8,A9,A10> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A2,A3,A4,A5,A6,A7,A8,A9,A10> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1Supplier.get(),a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A3,A4,A5,A6,A7,A8,A9,A10> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A3,A4,A5,A6,A7,A8,A9,A10> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2Supplier.get(),a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A4,A5,A6,A7,A8,A9,A10> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A4,A5,A6,A7,A8,A9,A10> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3Supplier.get(),a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A5,A6,A7,A8,A9,A10> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A5,A6,A7,A8,A9,A10> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4Supplier.get(),a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A6,A7,A8,A9,A10> acceptArg5(A5 a5) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A6,A7,A8,A9,A10> acceptArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5Supplier.get(),a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A5,A7,A8,A9,A10> acceptArg6(A6 a6) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A5,A7,A8,A9,A10> acceptArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6Supplier.get(),a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A5,A6,A8,A9,A10> acceptArg7(A7 a7) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A5,A6,A8,A9,A10> acceptArg7(Supplier<A7> a7Supplier) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A8 a8,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7Supplier.get(),a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A5,A6,A7,A9,A10> acceptArg8(A8 a8) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A5,A6,A7,A9,A10> acceptArg8(Supplier<A8> a8Supplier) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A9 a9,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8Supplier.get(),a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A10> acceptArg9(A9 a9) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A10> acceptArg9(Supplier<A9> a9Supplier) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A10 a10) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9Supplier.get(),a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> acceptArg10(A10 a10) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}
default Consumer9<A1,A2,A3,A4,A5,A6,A7,A8,A9> acceptArg10(Supplier<A10> a10Supplier) {
    var f = this;
    return new Consumer9<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7,A8 a8,A9 a9) {
            f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
            return f;
        }
    };
}

    /*
    default <X> Consumer11<X,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    */
    default Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> before(Consumer10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10> before) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)-> {
            before.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            this.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        };
    }

    default Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10>  after(Consumer10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10> after) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)-> {
            this.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            after.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        };
    }

    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> dispatch(ToInt10Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10> dispatchFunction, Consumer10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer10 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer10");
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10),finalFunctions).accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> dispatch(Predicate10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10> dispatchPredicate, Consumer10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10> function1, Consumer10<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7,? super A8,? super A9,? super A10> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer10");
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)) {
                function1.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            } else {
                function2.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            }
        };
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> of(Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> f) {
        return f::accept;
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7},{8},{9},{10})");
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10),e);
            }
        };
    }
    /*
    static <A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> Consumer10<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10> f, Consumer11<A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,? super Exception> errorConsumer) {
        return (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,e);
            }
        };
    }
    */
}
