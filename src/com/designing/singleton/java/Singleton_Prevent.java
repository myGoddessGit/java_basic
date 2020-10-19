package com.designing.singleton.java;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 防止单例被破坏
 */
public class Singleton_Prevent {

    public static void main(String[] args) throws Exception {

        System.out.println("--------序列化----------");
        Singletons originSingleton = Singletons.getInstance();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(Singletons.getInstance());
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Singletons serializeSingleton = (Singletons)ois.readObject();
        System.out.println(originSingleton == serializeSingleton);
        System.out.println("---------反射----------");
        Constructor<Singletons> cons = Singletons.class.getDeclaredConstructor();
        cons.setAccessible(true);
        Singletons reflectSingleton = cons.newInstance();
        System.out.println(reflectSingleton == originSingleton);
        System.out.println("---------克隆----------");
        Singletons cloneSingleton = (Singletons)originSingleton.clone();
        System.out.println(cloneSingleton == originSingleton);
        bos.close();
        oos.close();
        bis.close();
        ois.close();
    }

    private static class Singletons implements Serializable, Cloneable {

        private static volatile boolean isCreate = false; // 默认第一次创建

        /**
         * 构造方法私有化 外部不能new
         */
        private Singletons(){
            if (isCreate){
                throw new RuntimeException("已经被实例化");
            }
            isCreate = true;
        }

        /**
         * 本类内部创建对象实例
         */
        private static volatile Singletons instance;

        /**
         * 双重校验锁 -> 线程安全 能延时加载 以时间换空间
         * 提供一个公有的静态方法 返回实例对象
         * @return
         */
        public static Singletons getInstance(){
            if (instance == null){
                synchronized (Singletons.class){
                    if (instance == null){
                        instance = new Singletons();
                    }
                }
            }
            return instance;
        }

        /**
         * 重写clone 方法
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return instance;
        }

        /**
         * 防止序列化破坏
         * @return
         */
        private Object readResolve(){
            return instance;
        }
    }
}
