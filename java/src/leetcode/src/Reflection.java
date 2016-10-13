package main.java.algorithms.src;

import java.lang.reflect.Constructor;

/**
 * Created by xwang on 7/8/16.
 */
public class Reflection {
    public static void main(String[] args) {
        try {

            Class claz = Class.forName("main.java.java_test.src.StaticClass");
            Constructor constructor = claz.getConstructor(new Class[]{String.class});
            constructor.newInstance("name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
