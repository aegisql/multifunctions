package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class Function1Test {

    public class MyRuntimeException extends RuntimeException {
        public MyRuntimeException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public class IsNull extends Exception{ }
    public class IsZero extends Exception{
        public IsZero(String argIsZero) {
            super(argIsZero);
        }
    }

    public class NotANumber extends Exception{
        public NotANumber(String notANumber) {
            super(notANumber);
        }
    }

    public String greetEng(String name) {
        return "Hello, "+name;
    }

    public String greetRus(String name) {
        return "Привет, "+name;
    }

    public String mapSize(Map map) {
        return "Map size ="+map.size();
    }

    public String listSize(List list) {
        return "List size ="+list.size();
    }

    public String stringSize(String str) {
        return "String size ="+str.length();
    }

    public static final String russianCyrillicPattern = "[\\u0410-\\u044F\\u0401\\u0451]+";

    public String div(String num) throws IsNull, IsZero, NotANumber {
        if(num==null) throw new IsNull();
        int x=0;
        try {
            x = Integer.parseInt(num);
        } catch (Exception e) {
            throw new NotANumber("not a number");
        }
        if(x==0) {
            throw new IsZero("arg is zero");
        }
        return ""+(100/x);
    }

    @Test
    public void testThrowing() {
        Function1<String, String> div = Function1.throwing(this::div);
        Function1<String, Optional<String>> divOptional = div.optional();
        String s = div.apply("10");
        System.out.println(s);
        try {
            div.apply("0");
            fail();
        } catch (RuntimeException e){
            assertEquals("arg is zero; arg:(0)",e.getMessage());
        }

        try {
            div.apply(null);
            fail();
        } catch (RuntimeException e){
            assertEquals("IsNull; arg:(null)",e.getMessage());
        }


        assertThrows(RuntimeException.class,()->div.apply(null));
        assertThrows(RuntimeException.class,()->div.apply("0"));
        assertThrows(RuntimeException.class,()->div.apply("test"));

        Optional<String> optional = divOptional.apply("20");
        assertFalse(optional.isEmpty());
        assertEquals("5",optional.get());
        assertTrue(divOptional.apply(null).isEmpty());
        assertTrue(divOptional.apply("0").isEmpty());
        assertTrue(divOptional.apply("NAN").isEmpty());

        Function1<String, Optional<String>> optional2 = div.optional("ERROR");
        Optional<String> failed = optional2.apply("fail");
        assertEquals("ERROR",failed.get());

    }

    @Test
    public void testThrowingWithMessage() {

        Function1<String, String> div = Function1.throwing(this::div,"division failed: arg=({1}) message: {0}",MyRuntimeException::new);

        String s = div.apply("10");
        System.out.println(s);
        try {
            div.apply("0");
            fail();
        } catch (RuntimeException e){
            assertEquals("division failed: arg=(0) message: arg is zero",e.getMessage());
        }

        assertThrows(MyRuntimeException.class,()->div.apply(null));
        assertThrows(MyRuntimeException.class,()->div.apply("0"));
        assertThrows(MyRuntimeException.class,()->div.apply("test"));

    }

    @Test
    public void function1Test() {

        Function<String, String> dispatch = Function1.dispatch(
                arg1 -> arg1.matches(russianCyrillicPattern),
                this::greetRus,
                this::greetEng).beforeApply(s->System.out.println("Before: "+s)).afterApply(s->System.out.println("complete")).andThen(s->s+"!");

        System.out.println(dispatch.apply("Mike"));
        System.out.println(dispatch.apply("Миша"));

    }
    @Test
    public void function1Size1Test() {

        HashMap map = new HashMap();
        ArrayList list = new ArrayList();
        LinkedList list2 = new LinkedList();

        Function<? super Object, String> dispatch = Function1.dispatch(arg1 -> switch (arg1) {
                    case null -> Integer.MAX_VALUE;
                    case List o -> 0;
                    case Map o -> 1;
                    case String o -> 2;
                    default -> -1;
        }
                ,o->this.listSize((List)o)
                ,o->this.mapSize((Map)o)
                ,o->this.stringSize((String)o)
        );

        System.out.println(dispatch.apply(map));
        System.out.println(dispatch.apply(list));
        System.out.println(dispatch.apply(list2));
        System.out.println(dispatch.apply("test"));
        assertThrows(RuntimeException.class,()->dispatch.apply(null));

    }

    @Test
    public void partialApplyTest() {
        Optional<String> optional = Function1.of(this::greetEng).applyArg1("Mike").optional().get();
        assertNotNull(optional);
        assertEquals("Hello, Mike",optional.get());
    }

    @Test
    public void function1Size2Test() {

        HashMap map = new HashMap();
        ArrayList list = new ArrayList();
        List list2 = List.of(1,2,3);

        Function<Object, Integer> dispatch = Function1.dispatch(arg1 -> switch (arg1) {
                    case null -> Integer.MAX_VALUE;
                    case List l -> 0;
                    case Map m -> 1;
                    case String s -> 2;
                    default -> -1;
                }
                ,l->((List)l).size()
                ,m->((Map)m).size()
                ,s->((String)s).length()
        );

        System.out.println(dispatch.apply(map));
        System.out.println(dispatch.apply(list));
        System.out.println(dispatch.apply(list2));
        System.out.println(dispatch.apply("test"));
        assertThrows(RuntimeException.class,()->dispatch.apply(null));
        assertThrows(RuntimeException.class,()->dispatch.apply(Integer.valueOf(1)));

    }

}