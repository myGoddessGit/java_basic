package com.designing.prototype;

import java.io.*;

/**
 *
 * 设计模式 -> 原型模式
 *
 * 通过复制现有的实例来创建新的实例
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private String string;

    private SerializableObject obj;

    /**
     * 浅复制
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    /**
     * 深复制
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        /**
         * 写入当前的二进制流
         */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /**
         * 读出二进制产生的新对象
         */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString(){
        return string;
    }

    public void setString(String string){
        this.string = string;
    }

    public SerializableObject getObj(){
        return obj;
    }

    public void setObj(SerializableObject obj){
        this.obj = obj;
    }

    private static class SerializableObject implements Serializable {
        private static final long serialVersionUID = 1L;
    }

}
