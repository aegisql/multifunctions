package com.aegisql.multifunction;

import java.util.Objects;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

public interface Consumer3 <A1,A2,A3> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3>{ void accept(A1 a1,A2 a2,A3 a3) throws Exception; }

    void accept(A1 a1,A2 a2,A3 a3);

    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3);
    }
    default Consumer2<A2,A3> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A2 a2,A3 a3) {
            f.accept(a1,a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}
default Consumer2<A2,A3> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A2 a2,A3 a3) {
            f.accept(a1Supplier.get(),a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}
default Consumer2<A1,A3> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A1 a1,A3 a3) {
            f.accept(a1,a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}
default Consumer2<A1,A3> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A1 a1,A3 a3) {
            f.accept(a1,a2Supplier.get(),a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}
default Consumer2<A1,A2> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A1 a1,A2 a2) {
            f.accept(a1,a2,a3);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}
default Consumer2<A1,A2> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer2<>() {
        @Override
        public void accept(A1 a1,A2 a2) {
            f.accept(a1,a2,a3Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer3<A1,A2,A3> uncurry() {
            return f;
        }
    };
}

    
    default <X> Consumer4<X,A1,A2,A3> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    @SafeVarargs
    static <A1,A2,A3> Consumer3<A1,A2,A3> dispatch(ToInt3Function<? super A1,? super A2,? super A3> dispatchFunction, Consumer3<? super A1,? super A2,? super A3>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer3 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer3");
        return (a1,a2,a3) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3),finalFunctions).accept(a1,a2,a3);
    }

    static <A1,A2,A3> Consumer3<A1,A2,A3> dispatch(Predicate3<? super A1,? super A2,? super A3> dispatchPredicate, Consumer3<? super A1,? super A2,? super A3> function1, Consumer3<? super A1,? super A2,? super A3> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer3");
        return (a1,a2,a3) -> {
            if(dispatchPredicate.test(a1,a2,a3)) {
                function1.accept(a1,a2,a3);
            } else {
                function2.accept(a1,a2,a3);
            }
        };
    }

    static <A1,A2,A3> Consumer3<A1,A2,A3> of(Consumer3<A1,A2,A3> f) {
        return f::accept;
    }

    static <A1,A2,A3> Consumer3<A1,A2,A3> throwing(Throwing<A1,A2,A3> f) {
        return throwing(f,"{0}; args:({1},{2},{3})");
    }

    static <A1,A2,A3> Consumer3<A1,A2,A3> throwing(Throwing<A1,A2,A3> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    static <A1,A2,A3> Consumer3<A1,A2,A3> throwing(Throwing<A1,A2,A3> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3)->{
            try {
                f.accept(a1,a2,a3);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3),e);
            }
        };
    }

}
