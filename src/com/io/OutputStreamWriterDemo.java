package com.io;

import java.io.*;

/**
 * Author by MyGoddess on 2020/10/29
 * 使用InputStreamReader 可以将输入字节流转化为输入字符流  (读)
 * 使用OutputStreamWriter 可以将输出字节流转化为输出字符流 (写)
 *
 * OutputStreamWriter示例:
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        File f = new File("temp.log");
        Writer out = new OutputStreamWriter(new FileOutputStream(f));
        out.write("hello world!!");
        out.close();
    }
}
