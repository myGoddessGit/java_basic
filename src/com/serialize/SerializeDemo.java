package com.serialize;

import java.io.*;

/**
 * Author by MyGoddess on 2020/11/2
 *
 * 序列化
 * ObjectOutputStream.writeObject() 可以实现序列化
 * ObjectInputStream.readObject() 可以实现反序列化
 */
public class SerializeDemo {
    enum Sex{
        MALE,
        FEMALE
    }
    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private Integer age;
        private Sex sex;
        public Person(){}

        public Person(String name, Integer age, Sex sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }
    }

    /**
     * 序列化
     * @param fileName
     * @throws IOException
     */
    private static void serialize(String fileName) throws IOException {
        File f = new File(fileName);
        OutputStream out = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(new Person2("Demo", 30, Sex.MALE));
        oos.close();
        out.close();
    }

    private static void deSerialize(String fileName) throws IOException, ClassNotFoundException{
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object obj = ois.readObject();
        ois.close();
        in.close();
        System.out.println(obj);
    }

    static class Person2 implements Externalizable {


        private static final long serialVersionUID = 1L;
        private String name;
        transient private Integer age;
        private Sex sex;
        public Person2(){}

        public Person2(String name, Integer age, Sex sex){
            this.age = age;
            this.name = name;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Person2{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeInt(age);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            age = in.readInt();
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(name);
            out.writeInt(age);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            name = (String)in.readObject();
            age = in.readInt();
        }
    }

    public static void main(String[] args)throws IOException, ClassNotFoundException {
        String fileName = "temp.log";
        serialize(fileName);
        deSerialize(fileName);
    }

}
