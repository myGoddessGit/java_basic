package com.io;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.*;
import com.sun.org.apache.regexp.internal.RE;
import okhttp3.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

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
 * 流有输出和输入
 * 当程序需要读数据的时候就需要使用输入流读取数据, 当需要往外写数据的时候就需要输出流。
 * 数据源 可以是内存 文件 网络 或 程序
 *
 * 输入流  和  输出流
 *
 * 输入流 : 只能从中读取数据  而不能向其写入数据 (只读不写) 从文件读取到程序
 * 输出流 : 只能向其写入数据  而不能从中读取数据 (只写不读) 从程序写入到文件
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

    public static void main(String[] args) throws IOException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < 5 ;i++){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", "theShy");
                jsonObject.put("email", "128399@qq.com");
                jsonArray.add(jsonObject);
            }
            json.put("users", jsonArray);
        } catch (JSONException e) {
            System.out.println("异常1");
            e.printStackTrace();
        }
        //1 . 拿到OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        //创建一个RequestBody(参数1：数据类型 参数2传递的json串)
        RequestBody requestBody = RequestBody.create(JSON, String.valueOf(json));
        //3 . 构建Request,将FormBody作为Post方法的参数传入
        Request request = new Request.Builder()
                .url("http://localhost:8080/test/addUser")
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        final String[] str = {null};
//        try {
////            Response response = client.newCall(request).execute();
////            returnSome = response.body().string();
////        } catch (IOException e) {
////            System.out.println("异常2");
////        }

        final Response[] response1 = {null};
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("请求失败");
            }
            @Override
            public void onResponse(Call call, Response response) {
                response1[0] = response;
                countDownLatch.countDown();
            }
        });
        System.out.println("等待请求成功");
        try {
            countDownLatch.await();
            System.out.println("请求成功！！！");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        if (response1[0] == null){
            System.out.println("没有返回结果");
            return;
        }
        str[0] = response1[0].body().string();
        JSONArray jsonArray = JSONArray.parseArray(str[0]);
        if (jsonArray == null || jsonArray.size() <= 0){
            System.out.println("请求返回参数为空");
            return;
        }
        for (Object o : jsonArray){
            System.out.println(o);
        }
    }

    static void guavaTest(){

    }

    static void stringTest(){

    }

    static void test(){
        A a = new A();
        a.setName("aaa");
        A b = new A();
        b.setName("aaa");
        boolean test = Objects.equals(a, b);
        System.out.println(test);
    }

    static class A {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
