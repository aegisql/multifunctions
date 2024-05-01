/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Objects;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

public interface Consumer4 <A1,A2,A3,A4> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4>{ void accept(A1 a1,A2 a2,A3 a3,A4 a4) throws Exception; }

    void accept(A1 a1,A2 a2,A3 a3,A4 a4);

    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4);
    }
    default Consumer3<A2,A3,A4> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4) {
            f.accept(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}
default Consumer3<A2,A3,A4> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4) {
            f.accept(a1Supplier.get(),a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}
default Consumer3<A1,A3,A4> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4) {
            f.accept(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}
default Consumer3<A1,A3,A4> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4) {
            f.accept(a1,a2Supplier.get(),a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}
default Consumer3<A1,A2,A4> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4) {
            f.accept(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}
default Consumer3<A1,A2,A4> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4) {
            f.accept(a1,a2,a3Supplier.get(),a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}
default Consumer3<A1,A2,A3> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3) {
            f.accept(a1,a2,a3,a4);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}
default Consumer3<A1,A2,A3> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer3<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3) {
            f.accept(a1,a2,a3,a4Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer4<A1,A2,A3,A4> uncurry() {
            return f;
        }
    };
}

    
    default <X> Consumer5<X,A1,A2,A3,A4> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Consumer4<A1,A2,A3,A4> before(Consumer4<? super A1,? super A2,? super A3,? super A4> before) {
        return (a1,a2,a3,a4)-> {
            before.accept(a1,a2,a3,a4);
            this.accept(a1,a2,a3,a4);
        };
    }

    default Consumer4<A1,A2,A3,A4>  after(Consumer4<? super A1,? super A2,? super A3,? super A4> after) {
        return (a1,a2,a3,a4)-> {
            this.accept(a1,a2,a3,a4);
            after.accept(a1,a2,a3,a4);
        };
    }

    @SafeVarargs
    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> dispatch(ToInt4Function<? super A1,? super A2,? super A3,? super A4> dispatchFunction, Consumer4<? super A1,? super A2,? super A3,? super A4>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer4 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer4");
        return (a1,a2,a3,a4) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4),finalFunctions).accept(a1,a2,a3,a4);
    }

    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> dispatch(Predicate4<? super A1,? super A2,? super A3,? super A4> dispatchPredicate, Consumer4<? super A1,? super A2,? super A3,? super A4> function1, Consumer4<? super A1,? super A2,? super A3,? super A4> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer4");
        return (a1,a2,a3,a4) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4)) {
                function1.accept(a1,a2,a3,a4);
            } else {
                function2.accept(a1,a2,a3,a4);
            }
        };
    }

    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> of(Consumer4<A1,A2,A3,A4> f) {
        return f::accept;
    }

    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> throwing(Throwing<A1,A2,A3,A4> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4})");
    }

    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> throwing(Throwing<A1,A2,A3,A4> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> throwing(Throwing<A1,A2,A3,A4> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4)->{
            try {
                f.accept(a1,a2,a3,a4);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4),e);
            }
        };
    }
    
    static <A1,A2,A3,A4> Consumer4<A1,A2,A3,A4> throwing(Throwing<A1,A2,A3,A4> f, Consumer5<A1,A2,A3,A4,? super Exception> errorConsumer) {
        return (a1,a2,a3,a4)->{
            try {
                f.accept(a1,a2,a3,a4);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,a4,e);
            }
        };
    }
    
}
