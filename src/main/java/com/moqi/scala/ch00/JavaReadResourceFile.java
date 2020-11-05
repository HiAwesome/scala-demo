package com.moqi.scala.ch00;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Java 代码读取 Resource 文件
 *
 * @author moqi On 11/2/20 11:34
 */

public class JavaReadResourceFile {

    public static void main(String[] args) throws IOException {
        File[] files = new File("./src/main/resources").listFiles();

        assert files != null;
        for (File file : files) {
            System.out.println("file = " + file);

            if (file.getName().equals("input.txt")) {
                byte[] bytes = Files.readAllBytes(file.toPath());
                System.out.println("new String(bytes, Charset.defaultCharset()) = " + new String(bytes, Charset.defaultCharset()));
            }
        }
    }

}
