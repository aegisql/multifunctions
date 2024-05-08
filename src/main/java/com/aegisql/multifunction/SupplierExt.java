/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.util.Optional;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.handleException;

/**
 * The interface Supplier ext.
 *
 * @param <R> the type parameter
 */
public interface SupplierExt<R> extends Supplier<R> {

    /**
     * The interface Throwing.
     *
     * @param <A> the type parameter
     */
    @FunctionalInterface
    interface Throwing<A>{
        /**
         * Get a.
         *
         * @return the a
         * @throws Exception the exception
         */
        A get() throws Exception; }

    /**
     * Transform supplier ext.
     *
     * @param <X> the type parameter
     * @param f   the f
     * @return the supplier ext
     */
    default <X> SupplierExt<X> transform(Function1<? super R,? extends X> f) {
        return ()->f.apply(get());
    }

    /**
     * Uncurry function 1.
     *
     * @param <X> the type parameter
     * @return the function 1
     */
    default <X> Function1<X,R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Optional supplier ext.
     *
     * @return the supplier ext
     */
    default SupplierExt<Optional<R>> optional() {
        return ()->{
            try {
                return Optional.ofNullable(get());
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    /**
     * Or else supplier ext.
     *
     * @param defaultValue the default value
     * @return the supplier ext
     */
    default SupplierExt<R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    /**
     * Or else supplier ext.
     *
     * @param defaultValue the default value
     * @return the supplier ext
     */
    default SupplierExt<R> orElse(Supplier<R> defaultValue) {
        return ()->{
            try {
                return get();
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    /**
     * Before supplier ext.
     *
     * @param before the before
     * @return the supplier ext
     */
    default SupplierExt<R> before(RunnableExt before) {
        return ()-> {
            before.run();
            return this.get();
        };
    }

    /**
     * After supplier ext.
     *
     * @param after the after
     * @return the supplier ext
     */
    default SupplierExt<R> after(Consumer1<R> after) {
        return ()-> {
            var result = this.get();
            after.accept(result);
            return result;
        };
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 0; }

    /**
     * Of supplier ext.
     *
     * @param <A>      the type parameter
     * @param supplier the supplier
     * @return the supplier ext
     */
    static <A> SupplierExt<A> of(Supplier<A> supplier) {
        return supplier::get;
    }

    /**
     * Of const supplier ext.
     *
     * @param <A>   the type parameter
     * @param value the value
     * @return the supplier ext
     */
    static <A> SupplierExt<A> ofConst(A value) {
        return ()->value;
    }

    /**
     * Throwing supplier ext.
     *
     * @param <A> the type parameter
     * @param f   the f
     * @return the supplier ext
     */
    static <A> SupplierExt<A> throwing(Throwing<A> f) {
        return throwing(f,"{0}");
    }

    /**
     * Throwing supplier ext.
     *
     * @param <A>    the type parameter
     * @param f      the f
     * @param format the format
     * @return the supplier ext
     */
    static <A> SupplierExt<A> throwing(Throwing<A> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing supplier ext.
     *
     * @param <A>              the type parameter
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the supplier ext
     */
    static <A> SupplierExt<A> throwing(Throwing<A> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return ()->{
            try {
                return f.get();
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format),e);
            }
        };
    }

    /**
     * Throwing supplier ext.
     *
     * @param <A>           the type parameter
     * @param f             the f
     * @param errorConsumer the error consumer
     * @return the supplier ext
     */
    static <A> SupplierExt<A> throwing(Throwing<A> f, Function1<? super Exception,A> errorConsumer) {
        return ()->{
            try {
                return f.get();
            } catch (Exception e) {
                return errorConsumer.apply(e);
            }
        };
    }


}
