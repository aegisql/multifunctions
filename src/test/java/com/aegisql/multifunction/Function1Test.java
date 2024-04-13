package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertThrows;

class Function1Test {

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

    @Test
    public void function1Test() {

        Function<String, String> dispatch = Function1.dispatch(
                arg1 -> arg1.matches(russianCyrillicPattern),
                this::greetRus,
                this::greetEng).andThen(s->s+"!");

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