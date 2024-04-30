package com.aegisql.multifunction;

import static com.aegisql.multifunction.Utils.handleException;

@FunctionalInterface
public interface RunnableExt extends Runnable {
    @FunctionalInterface
    interface Throwing { void run() throws Exception; }

    default <X> Consumer1<X> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }

    default RunnableExt before(RunnableExt before) {
        return ()-> {
            before.run();
            this.run();
        };
    }

    default RunnableExt after(RunnableExt after) {
        return ()-> {
            this.run();
            after.run();
        };
    }

    static RunnableExt of(Runnable runnable) {
        return runnable::run;
    }

    static RunnableExt throwing(Throwing f) {
        return throwing(f,"{0}");
    }

    static RunnableExt throwing(Throwing f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static RunnableExt throwing(Throwing f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return ()->{
            try {
                f.run();
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format),e);
            }
        };
    }

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
