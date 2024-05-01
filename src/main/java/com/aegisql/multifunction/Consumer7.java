/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

public interface Consumer7 <A1,A2,A3,A4,A5,A6,A7> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6,A7>{ void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) throws Exception; }

    void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7);

    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4).acceptArg1(a5).acceptArg1(a6).acceptArg1(a7);
    }
    default Consumer6<A2,A3,A4,A5,A6,A7> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            f.accept(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A2,A3,A4,A5,A6,A7> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            f.accept(a1Supplier.get(),a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A3,A4,A5,A6,A7> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            f.accept(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A3,A4,A5,A6,A7> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6,A7 a7) {
            f.accept(a1,a2Supplier.get(),a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A2,A4,A5,A6,A7> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7) {
            f.accept(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A2,A4,A5,A6,A7> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6,A7 a7) {
            f.accept(a1,a2,a3Supplier.get(),a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A2,A3,A5,A6,A7> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7) {
            f.accept(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A2,A3,A5,A6,A7> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6,A7 a7) {
            f.accept(a1,a2,a3,a4Supplier.get(),a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A2,A3,A4,A6,A7> acceptArg5(A5 a5) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7) {
            f.accept(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A2,A3,A4,A6,A7> acceptArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6,A7 a7) {
            f.accept(a1,a2,a3,a4,a5Supplier.get(),a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A2,A3,A4,A5,A7> acceptArg6(A6 a6) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7) {
            f.accept(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A2,A3,A4,A5,A7> acceptArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A7 a7) {
            f.accept(a1,a2,a3,a4,a5,a6Supplier.get(),a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A2,A3,A4,A5,A6> acceptArg7(A7 a7) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6,a7);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}
default Consumer6<A1,A2,A3,A4,A5,A6> acceptArg7(Supplier<A7> a7Supplier) {
    var f = this;
    return new Consumer6<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6,a7Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer7<A1,A2,A3,A4,A5,A6,A7> uncurry() {
            return f;
        }
    };
}

    
    default <X> Consumer8<X,A1,A2,A3,A4,A5,A6,A7> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Consumer7<A1,A2,A3,A4,A5,A6,A7> before(Consumer7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> before) {
        return (a1,a2,a3,a4,a5,a6,a7)-> {
            before.accept(a1,a2,a3,a4,a5,a6,a7);
            this.accept(a1,a2,a3,a4,a5,a6,a7);
        };
    }

    default Consumer7<A1,A2,A3,A4,A5,A6,A7>  after(Consumer7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> after) {
        return (a1,a2,a3,a4,a5,a6,a7)-> {
            this.accept(a1,a2,a3,a4,a5,a6,a7);
            after.accept(a1,a2,a3,a4,a5,a6,a7);
        };
    }

    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6,A7> Consumer7<A1,A2,A3,A4,A5,A6,A7> dispatch(ToInt7Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> dispatchFunction, Consumer7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer7 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer7");
        return (a1,a2,a3,a4,a5,a6,a7) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6,a7),finalFunctions).accept(a1,a2,a3,a4,a5,a6,a7);
    }

    static <A1,A2,A3,A4,A5,A6,A7> Consumer7<A1,A2,A3,A4,A5,A6,A7> dispatch(Predicate7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> dispatchPredicate, Consumer7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> function1, Consumer7<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6,? super A7> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer7");
        return (a1,a2,a3,a4,a5,a6,a7) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6,a7)) {
                function1.accept(a1,a2,a3,a4,a5,a6,a7);
            } else {
                function2.accept(a1,a2,a3,a4,a5,a6,a7);
            }
        };
    }

    static <A1,A2,A3,A4,A5,A6,A7> Consumer7<A1,A2,A3,A4,A5,A6,A7> of(Consumer7<A1,A2,A3,A4,A5,A6,A7> f) {
        return f::accept;
    }

    static <A1,A2,A3,A4,A5,A6,A7> Consumer7<A1,A2,A3,A4,A5,A6,A7> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6},{7})");
    }

    static <A1,A2,A3,A4,A5,A6,A7> Consumer7<A1,A2,A3,A4,A5,A6,A7> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,A6,A7> Consumer7<A1,A2,A3,A4,A5,A6,A7> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6,a7)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6,a7);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6,a7),e);
            }
        };
    }
    
    static <A1,A2,A3,A4,A5,A6,A7> Consumer7<A1,A2,A3,A4,A5,A6,A7> throwing(Throwing<A1,A2,A3,A4,A5,A6,A7> f, Consumer8<A1,A2,A3,A4,A5,A6,A7,? super Exception> errorConsumer) {
        return (a1,a2,a3,a4,a5,a6,a7)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6,a7);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,a4,a5,a6,a7,e);
            }
        };
    }
    
}
