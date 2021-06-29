package com.os;

import com.designing.factory.WaterImpl;
import com.hash_function.Person;
import org.omg.SendingContext.RunTime;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Author by MyGoddess on 2020/11/9
 */
public class OSystem {
    /**
     * 操作系统的设计
     * 1. 以多进程形式 允许多个任务分为不同的部分运行
     * 2. 以多进程形式 允许单个任务分为不同的部分运行
     * 3. 提供协调机制 一方面防止进程之间和线程之间产生冲突 另一方面允许进程之间和线程之间共享资源
     */

    public static void main(String[] args) throws Exception {
//        User user = new User();
//        SoftReference<User> softReference = new SoftReference<>(user);
//        System.gc();
//        System.out.println(softReference.get());
        Date startTime = new Date(1622131200000L);
        Date endTime = new Date(1622476799000L);

        System.out.println(isEffectiveDate(new Date(), startTime, endTime));
    }



    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }

    private static void test(){
        // 初始化对象数组
        User[] users = new User[]{new User(1,"admin","admin@qq.com"),new User(2,"maco","maco@qq,com"),new User(3,"kitty","kitty@qq,com")};
        User[] target = new User[users.length]; // 目标数组
        System.arraycopy(users, 0, target, 0, users.length); // 实现复制
        System.out.println("源对象与目标对象的物理地址是否一样: " + (users[0] == target[0] ? "浅复制" : "深复制"));
        target[0].setEmail("admin@sina.com");
        System.out.println("修改目标对象的属性值后源对象users: ");
        for (User user : users){
            System.out.println(user);
        }
    }


    static class User{
        private Integer id;

        private String userName;

        private String email;

        public User() {}

        private User(Integer id, String userName, String email){
            super();
            this.id = id;
            this.userName = userName;
            this.email = email;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", userName='" + userName + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}
