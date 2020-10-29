package com.io;

import java.io.*;

/**
 * Author by MyGoddess on 2020/10/29
 *
 * 使用InputStreamReader 可以将输入字节流转化为输入字符流
 * 使用OutputStreamWriter 可以将输出字节流转化为输出字符流
 *
 * InputStreamReader 示例:
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        File f = new File("temp.log");
        Reader reader = new InputStreamReader(new FileInputStream(f));
        char[] c = new char[1024];
        int len = reader.read(c);
        reader.close();
        System.out.println(new String(c, 0, len));
    }
}
