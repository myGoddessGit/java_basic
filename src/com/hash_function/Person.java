package com.hash_function;

/**
 * Author by MyGoddess on 2020/11/11
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 重写hashCode
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * 重写equals
     * 重写该方法时必须重写hashCode方法 => 要确保一个对象映射到同一个存储地址
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }

        Person other = (Person) obj;
        if (age != other.age){
            if (other.name != null){
                return false;
            }
        } else if (!name.equals(other.name)){
            return false;
        }
        return true;
    }
}
