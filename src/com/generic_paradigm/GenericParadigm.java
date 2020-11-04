package com.generic_paradigm;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Author by MyGoddess on 2020/11/3
 *
 * 泛型
 *
 * E -> Element
 * K -> Key
 * N -> Number
 * T -> Type
 * V -> Value
 * S,U,V
 *
 * 使用泛型的建议
 * 1. 消除类型检查告警
 * 2. List优先数组
 * 3. 优先考虑使用泛型来提高代码通用性
 * 4. 优先考虑泛型方法来限定泛型的范围
 * 5. 利用限制通配符来提升API的灵活性
 * 6. 优先考虑类型安全的异构容器
 */
public class GenericParadigm {

    public static void main(String[] args) {
        MyMap<Integer, String> map = new MyMap<>(1 ,"test");
        System.out.println(map);
    }

    /**
     * 泛型类型是被参数化的类或接口
     *
     * 泛型中的类名称为原型 而将<> 指定的参数称为类型参数
     */

    static class MyMap<K, V>{
        private K key;
        private V value;

        public MyMap(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "MyMap{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    /**
     * 泛型接口
     */
    interface Content<T>{
        T text();
    }

    /**
     * 泛型方法
     *
     * public  <T> T func(T obj){}
     *
     * 是否拥有泛型方法 与其所在的类是否是泛型没有关系
     */


    /**
     * 由于泛型是基于类型擦除实现的 故 泛型类型无法向上转型
     *
     * 向上转型指的是用子类的实例去初始化父类(面向对象中多态的重要表现)
     */

    /**
     * 类型边界 <T extends xxx>
     *      <T extends A & B & C>
     *     extends 关键字后面的第一个类型参数可以是类或接口 其他类型参数只能是接口
     */
    static <T extends Comparable<T>> T max(T x, T y, T z){
        T max = x;  // 假设x是初始最大的值
        if (y.compareTo(max) > 0){
            max = y; // y 更大
        }
        if (z.compareTo(max) > 0){
            max = z;  // 此时 z最大
        }
        return max;  // 返回更大对象
    }

    /**
     * 类型通配符
     *
     * 上界通配符  => 来缩小类型参数的类型范围
     * 语法 <? extends Number>
     *
     * 下界通配符 => 将未知类型限制为该类型的特定类型或者超类类型
     * 语法 <? super Number>
     *
     * 无界通配符  => 可以使用Object 类中提供的功能来实现的方法 使用不依赖于类型参数的泛型类中的方法
     * 语法 <?>
     */

    /**
     * 上界通配符
     * 来缩小类型参数的类型范围
     * @param list
     * @return
     */
    static double sumOfList(List<? extends Number> list){
        double s = 0.0;
        for (Number n : list){
            s += n.doubleValue();
        }
        return s;
    }

    /**
     * 下界通配符
     *
     * 将未知类型限制为该类型的特定类型或者超类类型
     * @param list
     */
    static void addNumbers(List<? super Integer> list){
        for (int i = 1; i <= 5; i++){
            list.add(i);
        }
    }

    /**
     * 无界通配符
     *
     * 可以使用Object 类中提供的功能来实现的方法 使用不依赖于类型参数的泛型类中的方法
     */
    static void printList(List<?> list){
        for (Object elem : list){
            System.out.println(elem + " ");
        }
        System.out.println();
    }

    /**
     * 泛型的约束
     *
     * 1. 泛型类型的类型参数不能为基本数据类型
     */
    // Pair<int, char> p = new Pair<int, char>(8, 'a'); error
    /**
     * 2. 不能创建类型参数的实例
     */
//    static <E> void append(List<E> list){
//        E elem = new E(); error
//        list.add(elem)
//    }
    /**
     * 3. 不能创建类型参数的静态成员
     */
//    class MobileDevice<T> {
//        private static T os; // error
//    }

    /**
     * 4. 类型参数不能使用类型转换或 instanceof
     */
//    static <E> void test(List<E> list){
//        if (list instanceof ArrayList<Integer>) error
//    }
//    List<Integer> li = new ArrayList<>();
//    List<Number> ln = (List<Number>) li; // error

    /**
     * 5. 不能创建类型参数的数组
     */
    //List<Integer>[] arrayOfLists = new List<Integer>[2]; // error

    /**
     * 6. 不能创建 catch 或 throw 参数化类型对象
     */
    //class MathException<T> extends Exception{ } // error
    //class QueueFullException<T> extends Throwable{} // error

//    static <T extends Exception, J> void execute(List<J> jobs){
//        try {
//            for (J job : jobs){
//
//            }
//        }catch (T e){ //error
//
//        }
//    }
    /**
     * 7. 仅仅是泛型类相同 而类型参数不同的方法不能重载
     */
//    class Example {
//        void print(Set<String> strSet){}
//        void print(Set<Integer> intSet){} // error
//    }


}
