package main.java;

import java.lang.reflect.Field;

/**
 * Created by xwang on 9/9/16.
 */
public class Reflection {
    public static void main(String[] args) throws IllegalAccessException {
        NestedClass.Nested nc = NestedClass.build(1, 2);
        Field[] fs = nc.getClass().getDeclaredFields();
        for (Field f : fs) {
            System.out.println(f.getName());
            f.setAccessible(true);
            System.out.println((String.valueOf(f.get(nc))));
        }
    }
}
