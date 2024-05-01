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

public interface Consumer6 <A1,A2,A3,A4,A5,A6> {

    @FunctionalInterface
    interface Throwing<A1,A2,A3,A4,A5,A6>{ void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) throws Exception; }

    void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6);

    default RunnableExt lazyAccept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
        return acceptArg1(a1).acceptArg1(a2).acceptArg1(a3).acceptArg1(a4).acceptArg1(a5).acceptArg1(a6);
    }
    default Consumer5<A2,A3,A4,A5,A6> acceptArg1(A1 a1) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A2,A3,A4,A5,A6> acceptArg1(Supplier<A1> a1Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A2 a2,A3 a3,A4 a4,A5 a5,A6 a6) {
            f.accept(a1Supplier.get(),a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A1,A3,A4,A5,A6> acceptArg2(A2 a2) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A1,A3,A4,A5,A6> acceptArg2(Supplier<A2> a2Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A3 a3,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2Supplier.get(),a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A1,A2,A4,A5,A6> acceptArg3(A3 a3) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A1,A2,A4,A5,A6> acceptArg3(Supplier<A3> a3Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A4 a4,A5 a5,A6 a6) {
            f.accept(a1,a2,a3Supplier.get(),a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A1,A2,A3,A5,A6> acceptArg4(A4 a4) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A1,A2,A3,A5,A6> acceptArg4(Supplier<A4> a4Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A5 a5,A6 a6) {
            f.accept(a1,a2,a3,a4Supplier.get(),a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A1,A2,A3,A4,A6> acceptArg5(A5 a5) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A1,A2,A3,A4,A6> acceptArg5(Supplier<A5> a5Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A6 a6) {
            f.accept(a1,a2,a3,a4,a5Supplier.get(),a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A1,A2,A3,A4,A5> acceptArg6(A6 a6) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
            f.accept(a1,a2,a3,a4,a5,a6);
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}
default Consumer5<A1,A2,A3,A4,A5> acceptArg6(Supplier<A6> a6Supplier) {
    var f = this;
    return new Consumer5<>() {
        @Override
        public void accept(A1 a1,A2 a2,A3 a3,A4 a4,A5 a5) {
            f.accept(a1,a2,a3,a4,a5,a6Supplier.get());
        }
        @SuppressWarnings("unchecked")
        @Override
        public Consumer6<A1,A2,A3,A4,A5,A6> uncurry() {
            return f;
        }
    };
}

    
    default <X> Consumer7<X,A1,A2,A3,A4,A5,A6> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    
    default Consumer6<A1,A2,A3,A4,A5,A6> before(Consumer6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> before) {
        return (a1,a2,a3,a4,a5,a6)-> {
            before.accept(a1,a2,a3,a4,a5,a6);
            this.accept(a1,a2,a3,a4,a5,a6);
        };
    }

    default Consumer6<A1,A2,A3,A4,A5,A6>  after(Consumer6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> after) {
        return (a1,a2,a3,a4,a5,a6)-> {
            this.accept(a1,a2,a3,a4,a5,a6);
            after.accept(a1,a2,a3,a4,a5,a6);
        };
    }

    @SafeVarargs
    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> dispatch(ToInt6Function<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> dispatchFunction, Consumer6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6>... functions) {
        Objects.requireNonNull(dispatchFunction,"Consumer6 expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Consumer6");
        return (a1,a2,a3,a4,a5,a6) -> arrayValue(dispatchFunction.applyAsInt(a1,a2,a3,a4,a5,a6),finalFunctions).accept(a1,a2,a3,a4,a5,a6);
    }

    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> dispatch(Predicate6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> dispatchPredicate, Consumer6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> function1, Consumer6<? super A1,? super A2,? super A3,? super A4,? super A5,? super A6> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Consumer6");
        return (a1,a2,a3,a4,a5,a6) -> {
            if(dispatchPredicate.test(a1,a2,a3,a4,a5,a6)) {
                function1.accept(a1,a2,a3,a4,a5,a6);
            } else {
                function2.accept(a1,a2,a3,a4,a5,a6);
            }
        };
    }

    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> of(Consumer6<A1,A2,A3,A4,A5,A6> f) {
        return f::accept;
    }

    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> throwing(Throwing<A1,A2,A3,A4,A5,A6> f) {
        return throwing(f,"{0}; args:({1},{2},{3},{4},{5},{6})");
    }

    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> throwing(Throwing<A1,A2,A3,A4,A5,A6> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> throwing(Throwing<A1,A2,A3,A4,A5,A6> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6);
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,a1,a2,a3,a4,a5,a6),e);
            }
        };
    }
    
    static <A1,A2,A3,A4,A5,A6> Consumer6<A1,A2,A3,A4,A5,A6> throwing(Throwing<A1,A2,A3,A4,A5,A6> f, Consumer7<A1,A2,A3,A4,A5,A6,? super Exception> errorConsumer) {
        return (a1,a2,a3,a4,a5,a6)->{
            try {
                f.accept(a1,a2,a3,a4,a5,a6);
            } catch (Exception e) {
                errorConsumer.accept(a1,a2,a3,a4,a5,a6,e);
            }
        };
    }
    
}
