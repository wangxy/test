package main.java;

/**
 * Created by xwang on 9/9/16.
 */
public class NestedClass {

    public static Nested build(int val1, int val2) {
        Nested n = new Nested();
        n.val1 = val1;
        n.val2 = val2;
        return n;
    }

    public static class Nested{
        private int val1;
        private int val2;
    }
}
