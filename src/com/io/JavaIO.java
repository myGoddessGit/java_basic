package com.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author by MyGoddess on 2020/10/28
 * java IO流
 *
 * 区分同步或者异步
 * 区分阻塞或者非阻塞
 *
 * BIO => 阻塞IO (传统的java.io包中) (java.net包中部分API Socket ServerSocket HttpURLConnection 也归纳到同步阻塞IO类库中
 * 网络通信同样是IO行为)
 *
 * NIO => 非阻塞IO (java.nio : Channel  Selector Buffer  提供更接近操作系统底层的高性能数据操作方式)
 *
 * AIO => 异步非阻塞式IO (基于事件和回调机制)
 *
 * 流有输出和输入  输出时是流从数据源流向程序
 * 输出时是流从程序传向数据源
 * 数据源 可以是内存 文件 网络 或 程序
 *
 * 输入流  和  输出流
 *
 * 输入流 : 只能从中读取数据  而不能向其写入数据 (只读不写)
 * 输出流 : 只能向其写入数据  而不能从中读取数据 (只写不读)
 *
 */
public class JavaIO {

    /**
     * 字节流 和 字符流
     * 1. 读写单位不同
     * 字节流 以字节(8bit)为单位 字符流以字符为单位 根据码表映射符 一次可能读多个字节
     * 2. 处理对象不同
     * 字节流能处理所有类型的数据  而字符流只能处理字符类型的数据
     * (只要是处理纯文本数据 就优先考虑使用字符流  除此之外都使用字节流)
     *
     * 节点流 和 处理流
     * 可以从/向一个特定的IO设备读/写 数据的流 称为节点流 节点流也被称为低级流
     * 处理流是对一个已经存在的流进行连接或封装  通过封装后流来实现数据读/写功能
     * 处理流被称为高级流
     *
     * java使用处理流来包装节点流是一种典型的装饰者模式
     */
    // 节点流  直接传入的参数是IO设备
    FileInputStream fis = new FileInputStream("文件地址");
    // 处理流  直接传入的是流对象
    BufferedInputStream bis = new BufferedInputStream(fis);

    public JavaIO() throws FileNotFoundException {

    }
    /**
     * IO流的四种基本类型
     * 字符流 : Reader(字符输入流)  和  Writer(字符输出流)
     * 字节流 : InputStream(字节输入流)  和  outputStream(字节输出流)
     *
     *
     *
     * ObjectInputStream 和 ObjectOutputStream 是对象的输入输出流  一般用于对象序列化
     *
     * 字符流 => Reader 和  Writer
     * Reader => {
     *     BufferedReader 缓冲区
     *     PipedReader 管道数据
     *     StringReader 字符串
     *     CharArrayReader 字符数组
     *     InputStreamReader 字节流转为字符流
     *     FilterReader 自定义过滤输入字符流
     * }
     *
     * Writer => {
     *     BufferedWriter 缓冲区
     *     PipedWriter 管道数据
     *     StringWriter 字符串
     *     CharArrayWriter 字符数组
     *     OutputStreamWriter 字节流转为字符流
     *     FilterWriter 自定义过滤输出字符流
     *     PrintWriter 打印流
     * }
     *
     *
     * 字节流 和 字符流
     * 相同点 : 字节流和字符流有有read() write() flush() close()
     * 不同点 :
     * 数据类型 => {字节流的数据是字节(二进制对象) 核心类 是 InputStream 和 OutputStream
     *              字符流的数据是字符 一个字符等于两个字节 核心类是 Reader类 和 Writer类}
     * 缓冲区 字节流在操作时本身不会用到缓存区(内存) 是文件直接操作的
     *        字符流在操作时是使用了缓冲区 通过缓冲区再操作文件
     */
}
