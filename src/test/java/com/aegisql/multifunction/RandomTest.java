package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomTest {

    public static String hello(String greet, String user) {
        return greet+", "+user+"!";
    }

    public String hello3(String greet, String pref, String user) {
        return greet+" "+pref+" "+user+"!";
    }

    public static double div(double x, double y) {
        return x/y;
    }

    @Test
    public void minmaxTest() {

        Function2<Integer,Integer,Integer> min = Math::min;
        Integer minVal = min.apply(10, 100);
        assertEquals(10,minVal);

        Function3<Double,Double,Double,Double> min3 = (x,y,z)->Math.min(x,Math.min(y,z));
        double minVal2 = min3.apply(1.3, 3.2, 0.87);
        assertEquals(0.87,minVal2);

        var greet = Function2.of(RandomTest::hello);
        var greetThrowing = Function2.throwing(RandomTest::hello);

        String greet1 = greet.apply("Hi", "man");
        assertEquals("Hi, man!",greet1);

        SupplierExt<String> helloWorldGreet = greet.lazyApply("Hello", "World");
        assertEquals("Hello, World!",helloWorldGreet.get());

        var greet3 = Function3.of(this::hello3);
        var maleGreet = greet3.applyArg2("Mr.");
        var femaleGreet = greet3.applyArg2("Mrs.");

        String smithGreet = maleGreet.apply("To:", "Smith");
        String leeGreet = femaleGreet.apply("Dear", "Lee");
        assertEquals("To: Mr. Smith!",smithGreet);
        assertEquals("Dear Mrs. Lee!",leeGreet);

        var toMaleGreet = maleGreet.applyArg1("To:");
        String smithGreet2 = toMaleGreet.apply("Smith");

        Function3<String, String, String, String> uncurry = maleGreet.uncurry();

        var mrGreet = Function2.of(greet3.applyArg2("Mr."));
        //mrGreet.uncurry(); // throws exception

        var div = Function2.of(RandomTest::div);

        var intercepted = div.before((x, y) -> {
                    if (x < 0 || y < 0) throw new RuntimeException("arguments must be positive");
                    if (y == 0) throw new RuntimeException("y cannot be zero");
                })
                .after((x, y, res) -> {
                    System.out.println(x + "/" + y + "=" + res);
                })
                .andThen(res->"%.1f%%".formatted(100*res));

//        intercepted.apply(1d,0d);

        String res = intercepted.apply(11.0, 37.0);
        System.out.println(res);

    }

}
