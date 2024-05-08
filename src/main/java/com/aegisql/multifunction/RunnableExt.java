/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import static com.aegisql.multifunction.Utils.handleException;

/**
 * The interface Runnable ext.
 */
@FunctionalInterface
public interface RunnableExt extends Runnable {
    /**
     * The interface Throwing.
     */
    @FunctionalInterface
    interface Throwing {
        /**
         * Run.
         *
         * @throws Exception the exception
         */
        void run() throws Exception; }

    /**
     * Uncurry consumer 1.
     *
     * @param <X> the type parameter
     * @return the consumer 1
     */
    default <X> Consumer1<X> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    /**
     * Before runnable ext.
     *
     * @param before the before
     * @return the runnable ext
     */
    default RunnableExt before(RunnableExt before) {
        return ()-> {
            before.run();
            this.run();
        };
    }

    /**
     * After runnable ext.
     *
     * @param after the after
     * @return the runnable ext
     */
    default RunnableExt after(RunnableExt after) {
        return ()-> {
            this.run();
            after.run();
        };
    }

    /**
     * Arity int.
     *
     * @return the int
     */
    default int arity() { return 0; }

    /**
     * Of runnable ext.
     *
     * @param runnable the runnable
     * @return the runnable ext
     */
    static RunnableExt of(Runnable runnable) {
        return runnable::run;
    }

    /**
     * Throwing runnable ext.
     *
     * @param f the f
     * @return the runnable ext
     */
    static RunnableExt throwing(Throwing f) {
        return throwing(f,"{0}");
    }

    /**
     * Throwing runnable ext.
     *
     * @param f      the f
     * @param format the format
     * @return the runnable ext
     */
    static RunnableExt throwing(Throwing f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    /**
     * Throwing runnable ext.
     *
     * @param f                the f
     * @param format           the format
     * @param exceptionFactory the exception factory
     * @return the runnable ext
     */
    static RunnableExt throwing(Throwing f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return ()->{
            try {
                f.run();
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format),e);
            }
        };
    }

    /**
     * Throwing runnable ext.
     *
     * @param f             the f
     * @param errorConsumer the error consumer
     * @return the runnable ext
     */
    static RunnableExt throwing(Throwing f, Consumer1<? super Exception> errorConsumer) {
        return ()->{
            try {
                f.run();
            } catch (Exception e) {
                errorConsumer.accept(e);
            }
        };
    }
}
