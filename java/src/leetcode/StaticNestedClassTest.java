package main.java.algorithms;

/**
 * There is public static class. java only has nested static class
 * Created by xwang on 6/29/16.
 */
public class StaticNestedClassTest {
    public static class InnerClass {
        InnerClass(){
            System.out.println("I am an inner class");
        }
    }

    StaticNestedClassTest(){
        System.out.println("I am static class");
    }

    public static void main(String[] args) {
        StaticNestedClassTest t = new StaticNestedClassTest();
       StaticNestedClassTest.InnerClass i = new StaticNestedClassTest.InnerClass();
    }
}
