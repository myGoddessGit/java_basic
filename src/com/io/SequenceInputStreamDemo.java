package com.io;

import java.io.*;

/**
 * Author by MyGoddess on 2020/10/28
 *
 * 合并流 SequenceInputStream
 * 将多个InputStream 合并为一个
 */
public class SequenceInputStreamDemo {

    public static void main(String[] args) throws IOException {
        InputStream is1 = new FileInputStream("temp1.log");
        InputStream is2 = new FileInputStream("temp2.log");
        SequenceInputStream sis = new SequenceInputStream(is1, is2);
        int temp = 0;
        OutputStream os = new FileOutputStream("temp3.log");
        while ((temp = sis.read()) != -1){ // 循环输出
            os.write(temp);  // 保存内容
        }
        sis.close(); // 关闭合并流
        is1.close(); // 关闭输入流1
        is2.close(); //
        os.close();
    }
}
