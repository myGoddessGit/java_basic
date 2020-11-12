package com.hash_function;

import java.util.HashSet;

/**
 * Author by MyGoddess on 2020/11/11
 */
public class HashFunction {

    public static void main(String[] args) {
        Person person1 = new Person("uzi", 23);
        Person person2 = new Person("faker", 22);
        Person person3 = new Person("smlz", 21);
        Person person4 = new Person("jacklove", 19);
        Person person5 = new Person("a", 22);
        Person person6 = new Person("b", 22);

        /**
         * 输出a 和 b的hashCode值
         */
        System.out.println("a的hashCode值: " + person5.hashCode() + " b的hashCode的值: " + person6.hashCode());

        HashSet<Person> set = new HashSet<>();


        set.add(person6);
        set.add(person5);
        set.add(person4);
        set.add(person3);
        set.add(person2);
        set.add(person1);

        for (Person person : set){
            System.out.println(person);
        }
    }
}
