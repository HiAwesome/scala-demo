package com.moqi.scala.ch19;

/**
 * Java 测试协变
 *
 * @author moqi On 11/12/20 09:58
 */

public class A03VarianceAnnotationsJava {

    /**
     * 可以编译通过，但执行时会发生 java.lang.ArrayStoreException: java.lang.Integer
     * 说明了 Java 是协变的
     */
    public static void main(String[] args) {

        String[] a1 = {"abc"};
        Object[] a2 = a1;
        a2[0] = new Integer(17);
        String s = a1[0];

    }

}
