//package com.reflex.dynamicproxy;
//
//import com.designing.chain_of_resp.Handler;
//import com.reflex.staticproxy.RealSubject;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
///**
// * Author by MyGoddess on 2020/11/5
// *
// * JDK动态代理
// *
// * 在运行状态 需要代理的地方 根据Subject 和 RealSubject
// * 动态创建一个Proxy 用完之后就会销毁
// * 避免Proxy角色的class在系统中冗杂的问题
// *
// * 优点 : 相对于静态代理模式 不需要硬编码接口 代码复用率高
// *
// * 缺点 : 强制要求代理类实现InvocationHandler接口
// */
//public class DynamicProxy {
//
//    /**
//     * copy from java.lang.reflect.InvocationHandler
//     */
//    interface InvocationHandlers {
//        /**
//         *
//         * @param proxy  代理的真实对象
//         * @param method 所要调用真实对象的某个方法的Method对象
//         * @param args 所要调用真实对象某个方法时接收的参数
//         * @return
//         * @throws Throwable
//         */
//        Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
//    }
//
//    /**
//     * copy from java.lang.reflect.Proxy.newProxyInstance
//     *
//     * @param loader
//     * @param interfaces
//     * @param h
//     * @return
//     * @throws IllegalArgumentException
//     */
//    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,  InvocationHandler h)  throws IllegalArgumentException{
//        return null;
//    }
//
//    public static void main(String[] args) {
//        // 需要代理的真实对象
//        Subject realSubject = new RealSubject();
//
//        // 需要代理哪个真实对象 就将该对象传进去 最后是通过该真实对象来调用其方法的
//        InvocationHandler handler = new InvocationHandlerDemo(realSubject);
//
//        /**
//         *  第一个参数 : handler.getClass().getClassLoader  这里使用handler这个类ClassLoader对象来加载我们的代理对象
//         *  第二个参数 : realSubject.getClass().getInterfaces  这里为代理对象提供的接口是真实对象所实行的接口 表示要代理的对象
//         *  是该真实对象 这样就能调用这组接口中的方法
//         *  第三个参数 : handler : 这里将这个代理对象关联到上方的 InvocationHandler 这个对象上
//         */
//        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
//
//        System.out.println(subject.getClass().getName());
//        subject.hello("World");
//        String result = subject.bye();
//        System.out.println("Result is: " + result);
//    }
//}
