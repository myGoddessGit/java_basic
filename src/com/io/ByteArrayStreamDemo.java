package com.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Author by MyGoddess on 2020/10/28
 *
 * 内存字节流
 * ByteArrayInputStream 和 ByteArrayOutStream 完成内存的输入与输出
 */
public class ByteArrayStreamDemo {

    public static void main(String[] args) {
        String str = "HELLOWORLD";
        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 准备从内存ByteArrayInputStream中读取内容
        int temp = 0;
        while ((temp = bis.read()) != -1){
            char c = (char) temp; // 读取的数字变为字符
            bos.write(Character.toLowerCase(c));
        }
        // 所有数据就全部都在ByteArrayOutputStream中
        String newStr = bos.toString(); // 取出内容
        try {
            bis.close();
            bos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(newStr);
    }
}
