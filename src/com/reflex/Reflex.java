package com.reflex;

import com.designing.medium.UserImpl;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author by MyGoddess on 2020/11/4
 *
 * java 反射
 * 通过反射机制 可以在运行时访问java 对象属性 方法 构造方法等
 *
 * 应用场景 => 开发通用框架  动态代理  注解  可扩展性功能
 *
 * 缺点 => 性能开销  破坏性封装  内部曝光
 * 性能开销的主要原因 => 变长参数方法导致的Object数组  基本类型的自动装箱 拆箱 还有最重要的方法内联
 * Class.forName 会调用本地方法 Class.getMethod
 *
 * 反射的本质 在运行时 把java类中的各种成分映射成一个个的java 对象
 *
 * java.lang.reflect 包的核心接口和类如下:
 * Member 接口 : 反映关于单个成员(字段或方法)或构造函数的标识信息
 * Field 类 : 提供一个类的域的信息以及访问类的域的接口
 * Method 类 : 提供一个类的方法的信息以及访问类的方法的接口
 * Constructor 类 : 提供一个类的构造函数的信息以及访问类的构造函数的接口
 * Array类 : 该类提供动态地生成和访问java数组的方法
 * Modifier 类 : 提供了static方法和常量 对类和成员访问修饰符进行解码
 * Proxy 类 : 提供动态地生成代理类和类实例的静态方法
 */
public class Reflex {


    public static void main(String[] args) throws Exception, IllegalAccessException, InstantiationException
            , NoSuchMethodException, InvocationTargetException {
//        Class<?> clazz = Class.forName("com.reflex.Reflex");
//        Method method = clazz.getMethod("target", int.class);
//        for (int i = 0; i < 20; i++){
//            method.invoke(null, i);
//        }
        //test1();
        //test2();
        //test3();
        //instance();
        //newInstance();
        //reflectArray();
        //fieldSpy();
        //reflectMethod();
        //constructor();
        testList();
    }


    public static void target(int i){
        new Exception("#" + i).printStackTrace();
    }

    /**
     * 获取Class对象的三种方法
     */

    /**
     *
     * 1. 使用Class.forName 静态方法获取Class对象
     * @throws Exception
     */
    static void test1() throws Exception{
        Class c1 = Class.forName("com.reflex.Reflex");
        System.out.println(c1.getCanonicalName());

        Class c2 = Class.forName("[D");
        System.out.println(c2.getCanonicalName());

        Class c3 = Class.forName("[[Ljava.lang.String;");
        System.out.println(c3.getCanonicalName());
    }
    /**
     * 使用类的完全限定名来反射对象的类 JDBC开发中常用此方法加载数据库驱动
     *
     * 2. 类名 + .class
     */
    static void test2(){
        Class c1 = boolean.class;
        System.out.println(c1.getCanonicalName());

        Class c2 = java.io.PrintStream.class;
        System.out.println(c2.getCanonicalName());

        Class c3 = int[][][].class;
        System.out.println(c3.getCanonicalName());
    }

    /**
     * 3. Object 的getClass 方法
     *
     * Object 类中有getClass方法 因为所有类 都继承Object类  从而调用Object类来获取Class对象
     */
    enum E {
        A,
        B
    }

    static void test3(){
        Class c = "a".getClass();
        System.out.println(c.getCanonicalName());

        Class c2 = Reflex.E.A.getClass();
        System.out.println(c2.getCanonicalName());

        byte[] bytes= new byte[1024];
        Class c3 = bytes.getClass();
        System.out.println(c3.getCanonicalName());

        Set<String> set = new HashSet<>();
        Class c4 = set.getClass();
        System.out.println(c4.getCanonicalName());
    }

    /**
     * 判断是否为某个类的实例
     * 1. 使用 instanceof 关键字
     * 2. 用Class 对象的isInstance 方法 (native方法)
     */

    static void instance(){
        ArrayList arrayList = new ArrayList();
        if (arrayList instanceof List){
            System.out.println("ArrayList is List");
        }
        if (List.class.isInstance(arrayList)){
            System.out.println("ArrayList is List");
        }
    }

    /**
     * 创建实例
     * 通过反射来创建实例对象主要的两种方式
     * 用Class 对象的 newInstance 方法
     * 用Constructor 对象的 newInstance 方法
     */
    static void newInstance() throws IllegalAccessException, InstantiationException
    , NoSuchMethodException, InvocationTargetException {
        Class cl = StringBuilder.class;
        StringBuilder sb = (StringBuilder)cl.newInstance();
        sb.append("aaa");
        System.out.println(sb.toString());

        // 获取String所对应的Class对象
        Class c2 = String.class;
        // 获取String类带一个String参数的构造器
        Constructor constructor = c2.getConstructor(String.class);
        // 根据构造器创建实例
        String str2 = (String)constructor.newInstance("bvv");
        System.out.println(str2);
    }

    /**
     * 创建数组实例
     *
     * 可以通过Array.newInstance 创建数组实例
     *
     */
    static void reflectArray() throws ClassNotFoundException{
        Class<?> clz = Class.forName("java.lang.String");
        Object array = Array.newInstance(clz, 25);
        // 往数组里添加内容
        Array.set(array, 0, "Scala");
        Array.set(array, 1, "Java");
        Array.set(array, 2, "Groovy");
        Array.set(array, 3, "kotlin");
        Array.set(array, 4, "C++");
        // 获取某一项的内容
        System.out.println(Array.get(array, 4));
    }

    /**
     * Field
     * Class 对象提供以下方法获取对象的成员 (Field)
     *
     * getField -> 根据名称获取公有的 (public) 类成员
     * getDeclaredField -> 根据名称获取已经声明的类成员 (得不到其父类的类成员)
     * getFields -> 获取所有公有的 (public)类成员
     * getDeclaredFields -> 获取所有已经声明的类成员
     */

    static class FieldSpy<T> {
        public boolean[][] b = {{false, false}, {true, true}};
        public String name = "ShowMaker";
        public List<Integer> list;
        public T val;
    }
    static void fieldSpy() throws NoSuchFieldException{
        Field f1 = FieldSpy.class.getField("b");
        System.out.format("Type: %s%n", f1.getType());

        Field f2 = FieldSpy.class.getField("name");
        System.out.format("Type: %s%n", f2.getType());

        Field f3 = FieldSpy.class.getField("list");
        System.out.format("Type: %s%n", f3.getType());

        Field f4 = FieldSpy.class.getField("val");
        System.out.format("Type: %s%n", f4.getType());
    }

    /**
     * Method
     * Class 对象提供以下方法获取对象的方法 (Method)
     *
     * getMethod -> 返回类或接口的特定方法  其中第一个参数为方法名称 后面的参数为方法参数对应Class的对象
     * getDeclaredMethod -> 返回或者接口的特定声明方法 其中第一个参数为方法名称  后面的参数为方法参数对应Class的对象
     * getMethods -> 返回类或者接口的所有的public 方法 包括其父类的public方法
     * getDeclaredMethods -> 返回类或接口声明的所有方法 包括public protected 默认(包) 访问 和 private方法  但不包括继承的方法
     *
     * 获取一个Method对象后 可以用 invoke 方法类调用这个方法
     */
    static void reflectMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{

        // 返回所有的方法
        Method[] methods1 = System.class.getDeclaredMethods();
        System.out.println("System getDeclaredMethods 清单 (数量 = " +  methods1.length + "): ");
        for (Method m : methods1){
            System.out.println(m);
        }

        Method[] methods2 = System.class.getMethods();
        System.out.println("System getMethods 清单 (数量 = " + methods2.length + "): ");
        for (Method m : methods2){
            System.out.println(m);
        }
        // 利用Method 的 invoke 方法调用 System.currentTimeMillis
        Method method = System.class.getMethod("currentTimeMillis");
        System.out.println(method);
        System.out.println(method.invoke(null));
    }

    /**
     * Constructor
     *
     * Class对象提供了以下方法获取对象的构方法 (Constructor)
     *
     * getConstructor -> 返回类的特定public构造方法 参数为方法参数对应的Class对象
     * getDeclaredConstructors -> 返回类的特定构造方法 参数为方法参数对应Class对象
     * getConstructors -> 返回类的所有public构造方法
     * getDeclaredConstructors -> 返回类的所有构造方法
     *
     */

    static void constructor() throws IllegalAccessException, InstantiationException
            , NoSuchMethodException, InvocationTargetException {
        Constructor<?>[] constructors1 = String.class.getDeclaredConstructors();
        System.out.println("String getDeclaredConstructors 清单 (数量 = " + constructors1.length + ")");
        for (Constructor c : constructors1){
            System.out.println(c);
        }

        Constructor<?>[] constructors2 = String.class.getConstructors();
        System.out.println("String getConstructors 清单 (数量 = " + constructors2.length + ")");
        for (Constructor c : constructors2){
            System.out.println(c);
        }

        System.out.println("----------------");
        Constructor constructor = String.class.getConstructor(String.class);
        System.out.println(constructor);
        String str = (String) constructor.newInstance("abc");
        System.out.println(str);
    }

    /**
     * 通过反射越过泛型检查
     */
    static void testList() throws Exception{
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaaa");
        strList.add("bbbb");

        Class listClass = strList.getClass(); // 得到strList对象的字节码对象
        Method m = listClass.getMethod("add", Object.class);
        m.invoke(strList, 100);
        for (Object obj : strList){
            System.out.println(obj);
        }
    }

    /**
     * 绕开访问限制
     * 可以使用 Constructor/Field/Method.setAccessible(true) 来绕开语言的访问限制
     */

    /**
     * 动态代理
     *
     * 动态代理是一种方便运行时动态构建代理 动态处理代理方法调用的机制 例子 : 包装RPC调用 面向切面的编程(AOP)
     */
}
