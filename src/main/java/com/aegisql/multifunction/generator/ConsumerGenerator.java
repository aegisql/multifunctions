/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction.generator;

import static com.aegisql.multifunction.generator.ArgUtils.*;

public class ConsumerGenerator {

    private static void generate(int fN, boolean isLast) {

        int prevFN = fN - 1;
        int nextFN = fN + 1;

        String className = STR."Consumer\{fN}";
        String prevClassName = STR."Consumer\{prevFN}"; //for accept arg
        String nextClassName = STR."Consumer\{nextFN}"; //for uncurry

        String acceptArgs = generateAcceptArgs(className, prevClassName, fN);

        String code = STR."""
/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction.tmp;

import java.util.Objects;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

@FunctionalInterface
public interface Consumer\{fN} <\{types(fN)}> {

    @FunctionalInterface
    interface Throwing<\{types(fN)}>{ void accept(\{typedArgs(fN)}) throws Exception; }

    void accept(\{typedArgs(fN)});

    default RunnableExt lazyAccept(\{typedArgs(fN)}) {
        return \{lazyAcceptArgs(fN)};
    }
    \{acceptArgs}
    \{isLast ? "/*":""}
    default <X> \{nextClassName}<X,\{types(fN)}> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    \{isLast ? "*/":""}
    default \{className}<\{types(fN)}> before(\{className}<\{superTypes(fN)}> before) {
        return (\{args(fN)})-> {
            before.accept(\{args(fN)});
            this.accept(\{args(fN)});
        };
    }

    default \{className}<\{types(fN)}>  after(\{className}<\{superTypes(fN)}> after) {
        return (\{args(fN)})-> {
            this.accept(\{args(fN)});
            after.accept(\{args(fN)});
        };
    }

    default int arity() { return \{fN}; }

    @SafeVarargs
    static <\{types(fN)}> \{className}<\{types(fN)}> dispatch(ToInt\{fN}Function<\{superTypes(fN)}> dispatchFunction, \{className}<\{superTypes(fN)}>... functions) {
        Objects.requireNonNull(dispatchFunction,"\{className} expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"\{className}");
        return (\{args(fN)}) -> arrayValue(dispatchFunction.applyAsInt(\{args(fN)}),finalFunctions).accept(\{args(fN)});
    }

    static <\{types(fN)}> \{className}<\{types(fN)}> dispatch(Predicate\{fN}<\{superTypes(fN)}> dispatchPredicate, \{className}<\{superTypes(fN)}> function1, \{className}<\{superTypes(fN)}> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"\{className}");
        return (\{args(fN)}) -> {
            if(dispatchPredicate.test(\{args(fN)})) {
                function1.accept(\{args(fN)});
            } else {
                function2.accept(\{args(fN)});
            }
        };
    }

    static <\{types(fN)}> \{className}<\{types(fN)}> of(\{className}<\{types(fN)}> f) {
        return f::accept;
    }

    static <\{types(fN)}> \{className}<\{types(fN)}> throwing(Throwing<\{types(fN)}> f) {
        return throwing(f,"{0}; args:(\{argsTemplate(fN)})");
    }

    static <\{types(fN)}> \{className}<\{types(fN)}> throwing(Throwing<\{types(fN)}> f, String format) {
        return throwing(f,format, RuntimeException::new);
    }

    static <\{types(fN)}> \{className}<\{types(fN)}> throwing(Throwing<\{types(fN)}> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (\{args(fN)})->{
            try {
                f.accept(\{args(fN)});
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,\{args(fN)}),e);
            }
        };
    }
    \{isLast ? "/*":""}
    static <\{types(fN)}> \{className}<\{types(fN)}> throwing(Throwing<\{types(fN)}> f, \{nextClassName}<\{types(fN)},? super Exception> errorConsumer) {
        return (\{args(fN)})->{
            try {
                f.accept(\{args(fN)});
            } catch (Exception e) {
                errorConsumer.accept(\{args(fN)},e);
            }
        };
    }
    \{isLast ? "*/":""}
}
                """;
        System.out.println(code);

        ArgUtils.saveClass(className,code);

    }

    private static String generateAcceptArgs(String currentClass, String prevClass, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(STR."""
    default \{prevClass}<\{applyedTypes(i,n)}> acceptArg\{i}(A\{i} a\{i}) {
        var f = this;
        return new \{prevClass}<>() {
            @Override
            public void accept(\{applyedTypedArgs(i,n)}) {
                f.accept(\{args(n)});
            }
            @SuppressWarnings("unchecked")
            @Override
            public \{currentClass}<\{types(n)}> uncurry() {
                return f;
            }
        };
    }
    default \{prevClass}<\{applyedTypes(i,n)}> acceptArg\{i}(Supplier<A\{i}> a\{i}Supplier) {
        var f = this;
        return new \{prevClass}<>() {
            @Override
            public void accept(\{applyedTypedArgs(i,n)}) {
                f.accept(\{applySupplierArg(i,n)});
            }
            @SuppressWarnings("unchecked")
            @Override
            public \{currentClass}<\{types(n)}> uncurry() {
                return f;
            }
        };
    }
                    """);
        }
        return sb.toString();
    }

    final static int MIN_FUNCTION_NUMBER = 3;
    final static int MAX_FUNCTION_NUMBER = 10;

    public static void main(String[] args) {

            for(int i = MIN_FUNCTION_NUMBER; i <=MAX_FUNCTION_NUMBER; i++) {
                generate(i,i==MAX_FUNCTION_NUMBER);
            }
    }

}
