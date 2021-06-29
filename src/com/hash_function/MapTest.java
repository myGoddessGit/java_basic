package com.hash_function;

import java.util.*;

/**
 * @Author by chenYl on 2021/6/8 15:54
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class MapTest {

    public static void main(String[] args) {
        User user = new User("UZI", 24);
        User user1 = new User("FAKER", 34);
        User user2 = new User("SMEB", 26);
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, user);
        userMap.put(2, user1);
        userMap.put(3, user2);
        List<Map.Entry<Integer, User>> entryList = new ArrayList<>(userMap.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().getAge().compareTo(o1.getValue().getAge()));
        //entryList.forEach(item -> System.out.println(item.getKey() + " : " + item.getValue()));
        List<User> linkedUser = new LinkedList<>();
        linkedUser.add(new User("smlz", 34));
        linkedUser.add(new User("smlz1", 34));
        linkedUser.add(0, new User("smlz3", 34));
        System.out.println(linkedUser.get(1));
//        for (User user3 : linkedUser){
//            System.out.println(user3);
//        }
    }


    private static class User {

        private String name;

        private Integer age;

        public User(){

        }

        public User(String name, Integer age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
