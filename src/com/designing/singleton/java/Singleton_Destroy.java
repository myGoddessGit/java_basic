package com.designing.singleton.java;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 破坏单例方式
 *  反射
 *  序列化
 *  克隆
 */
public class Singleton_Destroy {

    public static void main(String[] args) throws Exception{
        System.out.println("--------序列化--------");
        Singleton originSingleton = Singleton.getInstance();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(Singleton.getInstance());
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Singleton serializeSingleton = (Singleton)ois.readObject();
        System.out.println(originSingleton == serializeSingleton);

        System.out.println("---------反射----------");
        Constructor<Singleton> cons = Singleton.class.getDeclaredConstructor();
        cons.setAccessible(true);
        Singleton reflectSingleton = cons.newInstance();
        System.out.println(reflectSingleton == originSingleton);

        System.out.println("---------克隆----------");
        Singleton cloneSingleton = (Singleton)originSingleton.clone();
        System.out.println(cloneSingleton == originSingleton);
        bos.close();
        oos.close();
        bis.close();
        ois.close();
    }

    private static class Singleton implements Serializable, Cloneable {
        /**
         * 私有构造方法  外部不能new
         */
        private Singleton(){}

        /**
         * 本类内部创建对象实例
         */
        private static volatile Singleton instance = null;

        /**
         * 提供一个公共的静态方法 返回实例对象
         * @return
         * 双重校验锁 -> 线程安全 能延时加载 以时间换空间
         */
        public static Singleton getInstance(){
            if (instance == null){
                synchronized (Singleton.class){
                    if (instance == null){
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
