package main.java.algorithms;

/**
 * Created by xwang on 6/29/16.
 */
public class NestedClassTest {
    public class InnerClass{
        InnerClass() {
            System.out.println("I am inner");
        }
    }

    NestedClassTest() {
        System.out.println("I am outer");
    }

    public static void main(String[] args) {
        NestedClassTest t = new NestedClassTest();
        NestedClassTest.InnerClass c = t.new InnerClass();
    }

}
