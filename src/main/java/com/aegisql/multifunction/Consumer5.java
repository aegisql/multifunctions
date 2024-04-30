package com.aegisql.multifunction;

import java.util.Objects;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

public interface Consumer5 <A1,A2,A3,A4,A5> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5>{ void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) throws Exception; }

    void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5);

    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4).acceptArg1(a5);
    }
    default Consumer4<A2,A3,A4,A5> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5) {
            f.accept(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}
default Consumer4<A2,A3,A4,A5> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5) {
            f.accept(a1Supplier.get(),a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}
default Consumer4<A1,A3,A4,A5> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5) {
            f.accept(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}
default Consumer4<A1,A3,A4,A5> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5) {
            f.accept(a1,a2Supplier.get(),a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}
default Consumer4<A1,A2,A4,A5> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5) {
            f.accept(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}
default Consumer4<A1,A2,A4,A5> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5) {
            f.accept(a1,a2,a3Supplier.get(),a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}
default Consumer4<A1,A2,A3,A5> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5) {
            f.accept(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}
default Consumer4<A1,A2,A3,A5> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5) {
            f.accept(a1,a2,a3,a4Supplier.get(),a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}
default Consumer4<A1,A2,A3,A4> acceptArg5(A5 a5) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4) {
            f.accept(a1,a2,a3,a4,a5);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}
default Consumer4<A1,A2,A3,A4> acceptArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Consumer4<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4) {
            f.accept(a1,a2,a3,a4,a5Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer5<A1,A2,A3,A4,A5> uncurry() {
            return f;
        }
    };
}

    
    default <X> Consumer6<X,A1,A2,A3,A4,A5> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    @SafeVarargs
    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> dispatch(ToInt5Function<? super A1,? super A2,? super A3,? super A4,? super A5> dispatchFunction, Consumer5<? super A1,? super A2,? super A3,? super A4,? super A5>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer5 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer5");
        return (a1,a2,a3,a4,a5) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5),finalFunctions).accept(a1,a2,a3,a4,a5);
    }

    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> dispatch(Predicate5<? super A1,? super A2,? super A3,? super A4,? super A5> dispatchPredicate, Consumer5<? super A1,? super A2,? super A3,? super A4,? super A5> function1, Consumer5<? super A1,? super A2,? super A3,? super A4,? super A5> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer5");
        return (a1,a2,a3,a4,a5) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5)) {
                function1.accept(a1,a2,a3,a4,a5);
            } else {
                function2.accept(a1,a2,a3,a4,a5);
            }
        };
    }

    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> of(Consumer5<A1,A2,A3,A4,A5> f) {
        return f::accept;
    }

    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> throwing(Throwing<A1,A2,A3,A4,A5> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5})");
    }

    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> throwing(Throwing<A1,A2,A3,A4,A5> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5> Consumer5<A1,A2,A3,A4,A5> throwing(Throwing<A1,A2,A3,A4,A5> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5)->{
            try {
                f.accept(a1,a2,a3,a4,a5);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5),e);
            }
        };
    }

}
