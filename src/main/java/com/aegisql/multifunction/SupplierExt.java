package com.aegisql.multifunction;

import java.text.MessageFormat;
import java.util.Optional;
import java.util.function.Supplier;

public interface SupplierExt <A> extends Supplier<A> {

    @FunctionalInterface
    interface Throwing<A>{ A get() throws Exception; }

    default <X> SupplierExt<X> transform(Function1<? super A,? extends X> f) {
        return ()->f.apply(get());
    }

    default SupplierExt<Optional<A>> optional() {
        return optional(()->null);
    }

    default SupplierExt<Optional<A>> optional(A defaultValue) {
        return optional(()->defaultValue);
    }

    default SupplierExt<Optional<A>> optional(Supplier<A> defaultValue) {
        return ()->{
            try {
                return Optional.ofNullable(get());
            } catch (Exception e) {
                return Optional.ofNullable(defaultValue.get());
            }
        };
    }

    static <A> SupplierExt<A> of(Supplier<A> supplier) {
        return ()->supplier.get();
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
                String message = e.getMessage();
                if(message == null || message.isBlank()) {
                    message = e.getClass().getSimpleName();
                }
                MessageFormat messageFormat = new MessageFormat(format);
                throw exceptionFactory.apply(messageFormat.format(new Object[]{message}),e);
            }
        };
    }

}
