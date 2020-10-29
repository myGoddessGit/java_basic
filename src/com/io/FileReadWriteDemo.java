package com.io;

import java.io.*;

/**
 * Author by MyGoddess on 2020/10/28
 */
public class FileReadWriteDemo {
    private static final String FILEPATH = "temp.log";

    public static void main(String[] args) throws IOException {
        write(FILEPATH);
        read(FILEPATH);
    }

    private static void write(String filepath) throws IOException {
        File f = new File(filepath);

        Writer out = new FileWriter(f);

        //Writer out = new FileWriter(f, true); 追加内容方式

        String str  = "Hello World!!!\r\n";
        out.write(str);

        out.flush();
        out.close();
    }
    private static char[] read(String filepath) throws IOException {
        File f = new File(filepath);

        Reader input = new FileReader(f);

        int temp = 0;
        int len = 0;
        char[] c = new char[1024];
        while ((temp = input.read()) != -1){
            c[len] = (char) temp;
            len++;
        }
        System.out.println("文件字符数为: " + len);

        input.close();

        return c;
    }
}
