package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class Function2Test {

    public String greet(String s, Integer i) {
        return s+"="+i;
    }

    public String sum(int x, int y) {
        return "Summa "+x+"+"+y+"="+(x+y);
    }

    public String mul(int x, int y) {
        return "Prod "+x+"*"+y+"="+(x*y);
    }

    public String pow(int x, int y) {
        return "Pow "+x+"^"+y+"="+Math.pow(x,y);
    }

    @Test
    public void function2Test() {

        BiFunction<Integer, Integer, String> dispatch = Function2.dispatch(
                (x, y) -> x % 3,
                this::sum,
                this::mul,
                this::pow
        );

        System.out.println(dispatch.apply(5,5));
        System.out.println(dispatch.apply(6,6));
        System.out.println(dispatch.apply(7,7));

    }

    @Test
    public void function2PredTest() {

        BiFunction<Integer, Integer, String> dispatch = Function2.dispatch(
                (x, y) -> x % 2 == 0 ? true:false,
                this::sum,
                this::mul
        );

        System.out.println(dispatch.apply(5,5));
        System.out.println(dispatch.apply(6,6));
        System.out.println(dispatch.apply(7,7));

    }

    private String test = "field value";

    @Test
    public void universalGetterTest() {

        var dispatch = Function2.dispatch(
                (id, obj) -> switch (obj) {
                    case null -> throw new NullPointerException();
                    case Map m -> 0;
                    case List l -> 1;
                    default -> 2;
                },
                (id, obj) -> ((Map) obj).get(id),
                (id, obj) -> ((List) obj).get((Integer) id),
                (id, obj) -> {
                    try {
                        Field field = obj.getClass().getDeclaredField(id.toString());
                        return field.get(obj);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        Map<String,String> m = new HashMap<>();
        m.put("test","map value");
        List<String> l = new ArrayList<>();
        l.add("list value");

        System.out.println(dispatch.apply("test",m));
        System.out.println(dispatch.apply(0,l));
        System.out.println(dispatch.apply("test",this));

    }

    @Test
    public void understandCurring() {
        Function2<String, Integer, String> greet = Function2.of(this::greet);
        System.out.println(greet.apply("X",5));
        Function<String,Function<Integer,String>> partialGreet = s->i->greet(s,i);
        Function<Integer, String> xEq = partialGreet.apply("X");
        String val = xEq.apply(100);
        System.out.println(val);
        assertEquals("X=100",val);
    }

    @Test
    public void testCurry1() {
        Function2<String, Integer, String> greet = Function2.of(this::greet);
        System.out.println(greet.apply("X",5));
        Function1<Integer, String> xEq = greet.applyArg1("X");
        String val = xEq.apply(100);
        System.out.println(val);
        assertEquals("X=100",val);

        Function1<String, String> yEq = greet.applyArg2(200);
        String y = yEq.apply("Y");
        System.out.println(y);
        assertEquals("Y=200",y);
    }

    @Test
    void dispatch() {
    }

    @Test
    void testDispatch() {
    }
}