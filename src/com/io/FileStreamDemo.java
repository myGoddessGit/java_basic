package com.io;
import java.io.*;

/**
 * Author by MyGoddess on 2020/10/28
 *
 *
 * 文件字节流 : FileInputStream FileOutputStream
 * 提供读写字节到文件的能力
 */
public class FileStreamDemo {

    private static final String FILEPATH = "temp.log";
    public static void main(String[] args) throws IOException {
        write(FILEPATH);
        read(FILEPATH);
    }
    public static void write(String filePath) throws IOException {
        // 使用File类找到一个文件
        File f = new File(filePath);
        // 通过子类实例化父类对象
        OutputStream out = new FileOutputStream(f);
        // 实例化时 默认为覆盖原文件内容方式 如果添加true参数 则表示对原文件的追加
        String string = "Hello World\n";
        byte[] bytes = string.getBytes();
        // 写操作
        out.write(bytes);
        // 关闭流
        out.close();
    }

    public static void read(String filePath) throws IOException {
        File f = new File(filePath);

        InputStream input = new FileInputStream(f);

        byte[] bytes = new byte[(int)f.length()];
        int len = input.read(bytes);
        System.out.println("读取文件的长度: " + len);

        input.close();
        System.out.println("内容为: \n" + new String(bytes));
    }

}
