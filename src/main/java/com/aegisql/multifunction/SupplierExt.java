package com.aegisql.multifunction;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.handleException;

public interface SupplierExt<R> extends Supplier<R> {

    @FunctionalInterface
    interface Throwing<A>{ A get() throws Exception; }

    default <X> SupplierExt<X> transform(Function1<? super R,? extends X> f) {
        return ()->f.apply(get());
    }

    default <X> Function1<X,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    default SupplierExt<Optional<R>> optional() {
        return ()->{
            try {
                return Optional.ofNullable(get());
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default SupplierExt<R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default SupplierExt<R> orElse(Supplier<R> defaultValue) {
        return ()->{
            try {
                return get();
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    static <A> SupplierExt<A> of(Supplier<A> supplier) {
        return supplier::get;
    }

    static <A> SupplierExt<A> ofConst(A value) {
        return ()->value;
    }

    static <A> SupplierExt<A> throwing(Throwing<A> f) {
        return throwing(f,"{0}");
    }

    static <A> SupplierExt<A> throwing(Throwing<A> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <A> SupplierExt<A> throwing(Throwing<A> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return ()->{
            try {
                return f.get();
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format),e);
            }
        };
    }

}
