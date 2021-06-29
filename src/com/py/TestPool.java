package com.py;

import java.sql.*;
import java.util.*;

/**
 * @Author by chenYl on 2021/6/1 10:24
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class TestPool {

    private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
    public static void main(String[] args) {

        Set<User> users = new HashSet<>();

//        User user = new User();
//        user.setName("uzi");
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            User user1 = new User();
            user1.setName("uzi");
            users.add(user1);
        }
        System.out.println(users.toString());
    }

    private static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
