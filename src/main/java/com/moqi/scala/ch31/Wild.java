package com.moqi.scala.ch31;

import java.util.Collection;
import java.util.Vector;

/**
 * 带通配类型的 Java 类
 *
 * @author moqi On 11/27/20 16:10
 */
public class Wild {

    public Collection<?> contents() {
        Collection<String> stuff = new Vector<>();
        stuff.add("a");
        stuff.add("b");
        stuff.add("see");
        return stuff;
    }

}
