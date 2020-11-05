package com.annotation;

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
}
