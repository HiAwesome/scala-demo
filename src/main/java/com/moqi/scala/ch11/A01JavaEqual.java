package com.moqi.scala.ch11;

/**
 * Java 比较
 *
 * @author moqi On 11/5/20 16:04
 */

public class A01JavaEqual {

    public static void main(String[] args) {

        System.out.println("isEqual1(421, 421) = " + isEqual1(421, 421));
        System.out.println("isEqual2(421, 421) = " + isEqual2(421, 421));

    }

    private static boolean isEqual1(int x, int y) {
        return x == y;
    }

    private static boolean isEqual2(Integer x, Integer y) {
        return x == y;
    }

}
