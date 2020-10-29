package com.io;



import java.io.*;

/**
 * Author by MyGoddess on 2020/10/28
 *
 * 数据操作流 DataInputStream 和 DataOutputStream
 * 提供了格式化写入和输出数据的方法
 */
public class DataStreamDemo {
    public static final String FILEPATH = "temp.txt";

    public static void main(String[] args) throws IOException{
        write(FILEPATH);
        read(FILEPATH);
    }

    private static void write(String filePath) throws IOException {
        File f = new File(filePath);

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));

        String[] names = {"衬衣", "手套", "围巾"};
        float[] prices = {32.2f, 88.0f, 90.8f};
        int[] nums = {3, 2, 1};
        for (int i = 0; i < names.length; i++){
            dos.writeChars(names[i]);
            dos.writeChar('\t');
            dos.writeFloat(prices[i]);
            dos.writeChar('\t');
            dos.writeInt(nums[i]);
            dos.writeChar('\n');
        }
        // 关闭流
        dos.close();
    }

    private static void read(String filePath) throws IOException {
        File f = new File(filePath);

        DataInputStream dis = new DataInputStream(new FileInputStream(f));

        String name = null; // 名称
        float price = 0.0f; // 价格
        int num = 0; // 数量
        char[] temp = null;  // 接收商品名称
        int len = 0; // 保存读取数据个数
        char c = 0;
        try {
            while (true){
                temp = new char[200]; // 开辟空间
                len = 0;
                while ((c = dis.readChar()) != '\t'){
                    temp[len] = c;
                    len++; // 读取长度加1
                }
                name = new String(temp, 0, len);
                price = dis.readFloat();
                dis.readChar();
                num = dis.readInt();
                dis.readChar();
                System.out.printf("名称: %s; 价格: %5.2f; 数量: %d\n", name, price, num);
            }
        } catch (EOFException e){
            System.out.println("over");
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            dis.close();
        }
    }
}
