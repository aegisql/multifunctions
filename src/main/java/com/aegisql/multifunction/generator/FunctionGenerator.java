/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction.generator;

import static com.aegisql.multifunction.generator.ArgUtils.*;

public class FunctionGenerator {

    private static void generate(int fN, boolean isLast) {

        int prevFN = fN - 1;
        int nextFN = fN + 1;

        String className = STR."Function\{fN}";
        String prevClassName = STR."Function\{prevFN}"; //for apply arg
        String nextClassName = STR."Function\{nextFN}"; //for uncurry

        String applyArgs = generateApplyArgs(className, prevClassName, fN);

        String code = STR."""
/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction.tmp;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import static com.aegisql.multifunction.Utils.*;

public interface Function\{fN} <\{types(fN)},R> {

    @FunctionalInterface
    interface Throwing<\{types(fN)},R>{ R apply(\{typedArgs(fN)}) throws Exception; }

    R apply(\{typedArgs(fN)});

    default SupplierExt<R> lazyApply(\{typedArgs(fN)}) {
        return \{lazyApplyArgs(fN)};
    }
    \{applyArgs}
    \{isLast ? "/*":""}
    default <X> \{nextClassName}<X,\{types(fN)},R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    \{isLast ? "*/":""}
    default \{className}<\{types(fN)},Optional<R>> optional() {
        return (\{args(fN)})->{
            try {
                return Optional.ofNullable(apply(\{args(fN)}));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default \{className}<\{types(fN)},R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default \{className}<\{types(fN)},R> orElse(Supplier<R> defaultValue) {
        return (\{args(fN)})->{
            try {
                return apply(\{args(fN)});
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    default \{className}<\{types(fN)},R> before(Consumer\{fN}<\{types(fN)}> before) {
        return (\{args(fN)})-> {
            before.accept(\{args(fN)});
            return apply(\{args(fN)});
        };
    }
    \{isLast ? "/*":""}
    default \{className}<\{types(fN)},R> after(Consumer\{nextFN}<\{types(fN)},R> after) {
        return (\{args(fN)})-> {
            var result = apply(\{args(fN)});
            after.accept(\{args(fN)},result);
            return result;
        };
    }
    \{isLast ? "*/":""}
    @SafeVarargs
    static <\{types(fN)},R> \{className}<\{types(fN)},R> dispatch(ToInt\{fN}Function<\{superTypes(fN)}> dispatchFunction, \{className}<\{superTypes(fN)},R>... functions) {
        Objects.requireNonNull(dispatchFunction,"\{className} expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"\{className}");
        return (\{args(fN)}) -> arrayValue(dispatchFunction.applyAsInt(\{args(fN)}),finalFunctions).apply(\{args(fN)});
    }

    static <\{types(fN)},R> \{className}<\{types(fN)},R> dispatch(Predicate\{fN}<\{superTypes(fN)}> dispatchPredicate, \{className}<\{superTypes(fN)},R> function1, \{className}<\{superTypes(fN)},R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function\{fN}");
        return (\{args(fN)}) -> {
            if(dispatchPredicate.test(\{args(fN)})) {
                return function1.apply(\{args(fN)});
            } else {
                return function2.apply(\{args(fN)});
            }
        };
    }

    static <\{types(fN)},R> \{className}<\{types(fN)},R> of(\{className}<\{types(fN)},R> f) {
        return f::apply;
    }

    static <\{types(fN)},R> \{className}<\{types(fN)},R> throwing(Throwing<\{types(fN)},R> f) {
        return throwing(f,"{0}; args:(\{argsTemplate(fN)})");
    }

    static <\{types(fN)},R> \{className}<\{types(fN)},R> throwing(Throwing<\{types(fN)},R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <\{types(fN)},R> \{className}<\{types(fN)},R> throwing(Throwing<\{types(fN)},R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (\{args(fN)})->{
            try {
                return f.apply(\{args(fN)});
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,\{args(fN)}),e);
            }
        };
    }
    \{isLast ? "/*":""}
    static <\{types(fN)},R> \{className}<\{types(fN)},R> throwing(Throwing<\{types(fN)},R> f, \{nextClassName}<? super Exception,\{types(fN)},R> errorProcessor) {
        return (\{args(fN)})->{
            try {
                return f.apply(\{args(fN)});
            } catch (Exception e) {
                return errorProcessor.apply(e,\{args(fN)});
            }
        };
    }
    \{isLast ? "*/":""}
}
                """;
        System.out.println(code);

        ArgUtils.saveClass(className,code);

    }

    private static String generateApplyArgs(String currentClass, String prevClass, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(STR."""
    default \{prevClass}<\{applyedTypes(i,n)},R> applyArg\{i}(A\{i} a\{i}) {
        var f = this;
        return new \{prevClass}<>() {
            @Override
            public R apply(\{applyedTypedArgs(i,n)}) {
                return f.apply(\{args(n)});
            }
            @SuppressWarnings("unchecked")
            @Override
            public \{currentClass}<\{types(n)},R> uncurry() {
                return f;
            }
        };
    }
    default \{prevClass}<\{applyedTypes(i,n)},R> applyArg\{i}(Supplier<A\{i}> a\{i}Supplier) {
        var f = this;
        return new \{prevClass}<>() {
            @Override
            public R apply(\{applyedTypedArgs(i,n)}) {
                return f.apply(\{applySupplierArg(i,n)});
            }
            @SuppressWarnings("unchecked")
            @Override
            public \{currentClass}<\{types(n)},R> uncurry() {
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
