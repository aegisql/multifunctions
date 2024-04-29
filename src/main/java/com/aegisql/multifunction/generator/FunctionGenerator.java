package com.aegisql.multifunction.generator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

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
package com.aegisql.multifunction.tmp;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

import static com.aegisql.multifunction.Utils.*;

public interface Function\{fN} <\{types(fN)},R> {

    @FunctionalInterface
    interface Throwing<\{types(fN)},R>{ R apply(\{typedArgs(fN)}) throws Exception; }

    R apply(\{typedArgs(fN)});

    default SupplierExt<R> lazyApply(\{typedArgs(fN)}) {
        return \{lazyArgs(fN)};
    }
    \{applyArgs}
    \{isLast ? "/*":""}
    default <X> Function\{nextFN}<X,\{types(fN)},R> uncurry() {
        throw new UnsupportedOperationException("Uncurrying is only possible for curryed functions");
    }
    \{isLast ? "*/":""}
    default Function\{fN}<\{types(fN)},Optional<R>> optional() {
        return (\{args(fN)})->{
            try {
                return Optional.ofNullable(apply(\{args(fN)}));
            } catch (Exception e) {
                return Optional.empty();
            }
        };
    }

    default Function\{fN}<\{types(fN)},R> orElse(R defaultValue) {
        return orElse(()->defaultValue);
    }

    default Function\{fN}<\{types(fN)},R> orElse(Supplier<R> defaultValue) {
        return (\{args(fN)})->{
            try {
                return apply(\{args(fN)});
            } catch (Exception e) {
                return defaultValue.get();
            }
        };
    }

    @SafeVarargs
    static <\{types(fN)},R> Function\{fN}<\{types(fN)},R> dispatch(ToInt\{fN}Function<\{superTypes(fN)}> dispatchFunction, Function\{fN}<\{superTypes(fN)},R>... functions) {
        Objects.requireNonNull(dispatchFunction,"Function\{fN} expects a dispatch function");
        var finalFunctions = validatedArrayCopy(functions,"Function\{fN}");
        return (\{args(fN)}) -> arrayValue(dispatchFunction.applyAsInt(\{args(fN)}),finalFunctions).apply(\{args(fN)});
    }

    static <\{types(fN)},R> Function\{fN}<\{types(fN)},R> dispatch(Predicate\{fN}<\{superTypes(fN)}> dispatchPredicate, Function\{fN}<\{superTypes(fN)},R> function1, Function\{fN}<\{superTypes(fN)},R> function2) {
        requiresNotNullArgs(dispatchPredicate,function1,function2,"Function\{fN}");
        return (\{args(fN)}) -> {
            if(dispatchPredicate.test(\{args(fN)})) {
                return function1.apply(\{args(fN)});
            } else {
                return function2.apply(\{args(fN)});
            }
        };
    }

    static <\{types(fN)},R> Function\{fN}<\{types(fN)},R> of(Function\{fN}<\{types(fN)},R> f) {
        return f::apply;
    }

    static <\{types(fN)},R> Function\{fN}<\{types(fN)},R> throwing(Throwing<\{types(fN)},R> f) {
        return throwing(f,"{0}; args:(\{argsTemplate(fN)})");
    }

    static <\{types(fN)},R> Function\{fN}<\{types(fN)},R> throwing(Throwing<\{types(fN)},R> f, String format) {
        return throwing(f,format,RuntimeException::new);
    }

    static <\{types(fN)},R> Function\{fN}<\{types(fN)},R> throwing(Throwing<\{types(fN)},R> f, String format, Function2<String,Exception,? extends RuntimeException> exceptionFactory) {
        return (\{args(fN)})->{
            try {
                return f.apply(\{args(fN)});
            } catch (Exception e) {
                throw exceptionFactory.apply(handleException(e,format,\{args(fN)}),e);
            }
        };
    }

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
