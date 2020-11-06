package com.annotation;

import java.lang.annotation.*;

/**
 * Author by MyGoddess on 2020/11/5
 *
 * java 注解
 *
 * 注解是以@开始的修饰符
 *
 * 含义 : 注解是一种标签 一种特殊的注释 但是如果没有解析它的代码 => 跟注释没啥区别
 *
 * 解析注解的两种形式 :
 * 编译期直接的扫描 =>
 *
 * 运行期的反射 => 自定义注解  java编译器无法识别并处理这个注解 只能根据该注解的作用范围来选择是否
 * 编译进字节码文件 要处理注解  必须利用反射技术  识别该注解以及它所携带的信息 然后做相应的处理
 *
 * 注解的用途 :
 * 1. 编译器信息 -> 编译器可以使用注解来检测错误或者抑制警告
 * 2. 编译时和部署时的处理 -> 程序可以处理注解信息以生成代码 XML文件等
 * 3. 运行时处理 -> 可以在运行时检查某些注解并处理
 *
 * 注解的代价
 * 1. 侵入式编程 存在增加程序耦合度的问题
 * 2. 自定义注解的处理需要在运行时 通过反射来获取属性 如果注解所修饰的
 * 元素是类的非 public 成员 也可以通过反射获取 但这就违背了面向对象的封装性
 * 3. 注解所产生的问题 难以debug 或者 定位
 */
public class JavaAnnotation {

    /**
     * 类实例初始化表达式
     * new @Interned MyObject();
     *
     * 类型转换
     * myString = (@NonNull String) str;
     *
     * 实现接口的声明
     * class UnmodifiableList<T> implements
     *      @Readonly List<@Readonly T>{}
     *
     *  抛出异常声明 :
     *  void monitorTemperature()
     *      throws @Critical TemperatureException {}
     */

    /**
     * 内置注解
     * @Override
     * @Deprecated
     * @SuppressWarnnings
     * @SafeVarargs (JDK7 引入)
     * @FunctionalInterface (JDK8 引入)
     */

    /**
     * 1. @override 用于表明被修饰方法覆盖父类的方法
     *
     * 2. @Deprecated 用于标明被修饰的类或类成员 类方法已经废弃 过时 不建议使用
     *
     * 3. @SuppressWarnnings 用于关闭对类 方法 成员编译时产生的特定警告
     *      deprecation - 使用了不赞成使用的类或方法时的警告；
     *      unchecked - 执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型;
     *      fallthrough - 当 Switch 程序块直接通往下一种情况而没有 Break 时的警告;
     *      path - 在类路径、源文件路径等中有不存在的路径时的警告;
     *      serial - 当在可序列化的类上缺少 serialVersionUID 定义时的警告;
     *      finally - 任何 finally 子句不能正常完成时的警告;
     *      all - 所有的警告。
     *  4. @SafeVarargs 的作用是 : 通知编译器 在可变长参数中的泛型是类型安全的
     *      可变长参数是使用数组存储的 而数组和泛型不能很好的混合使用
     *
     *  5. @FunctionalInterface 用于指示被修饰的接口是函数式接口
     *      函数式接口就是有且仅有一个抽象方法 但是可以有多个非抽象方法的接口 (函数式接口可以被隐式转换为lambda表达式)
     */

    /**
     * 元注解
     * 1. @Retention 指明了注解的保留级别
     *      RetentionPolicy 是一个枚举类 定义被@Retention 修饰的注解所支持的保留级别
     *
     *      RetentionPolicy.SOURCE -> 仅在源文件中有效 编译器会忽略
     *      RetentionPolicy.CLASS -> 在Class文件中生效 JVM会忽略
     *      RetentionPolicy.RUNTIME -> 标记的注解在运行时有效
     */

    /**
     * 示例
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Column {
        public String name() default "fieldName";
        public String setFuncName() default "setField";
        public String getFuncName() default "getField";
        public boolean defaultDBValue() default false;
    }

    /**
     * 2. @Documented 表示无论何时使用指定的注解 都应该使用Javadoc (默认情况下 注释不包含在Javadoc中)
     */

    /**
     * 示例
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Columns {
        public String name() default "fieldName";
        public String setFuncName() default "setField";
        public String getFuncName() default "getField";
        public boolean defaultDBValue() default false;
    }

    /**
     * 3. @Target 指定注解可以修饰的元素类型
     *
     *      ElementType 是一个枚举类型，它定义了被 @Target 修饰的注解可以应用的范围：
     *
     *      ElementType.ANNOTATION_TYPE - 标记的注解可以应用于注解类型。
     *      ElementType.CONSTRUCTOR - 标记的注解可以应用于构造函数。
     *      ElementType.FIELD - 标记的注解可以应用于字段或属性。
     *      ElementType.LOCAL_VARIABLE - 标记的注解可以应用于局部变量。
     *      ElementType.METHOD - 标记的注解可以应用于方法。
     *      ElementType.PACKAGE - 标记的注解可以应用于包声明。
     *      ElementType.PARAMETER - 标记的注解可以应用于方法的参数。
     *      ElementType.TYPE - 标记的注解可以应用于类的任何元素。
     */

    /**
     * Target 示例
     */
    @Target(ElementType.TYPE)
    public @interface Table {

        public String tableName() default "className";
    }

    @Target(ElementType.FIELD)
    public @interface NoDBColumn {}

    /**
     * 4. @Inherited 表示注解类型可以被继承
     */
    /**
     * 示例
     */
    @Inherited
    public @interface Greeting {
        public enum FontColor {A, B, C}
        String name();
        FontColor fontColor() default FontColor.A;
    }

    /**
     * 5. @Repeatable 表示注解可以重复使用
     */
}
