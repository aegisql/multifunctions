package com.aegisql.multifunction;

import static com.aegisql.multifunction.Utils.handleException;

@FunctionalInterface
public interface RunnableExt extends Runnable {
    @FunctionalInterface
    interface Throwing { void run() throws Exception; }

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

}
