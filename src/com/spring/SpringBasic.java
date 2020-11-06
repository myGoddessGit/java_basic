package com.spring;

/**
 * Author by MyGoddess on 2020/11/6
 *
 * SpringMVC 的工作流程
 */
public class SpringBasic {

    /**
     * 1. 向服务器发送HTTP请求 请求被前端控制器 DispatcherServlet 捕获
     *
     * 2. DispatcherServlet 根据-servlet.xml中的配置对请求的URL进行解析
     * 得到请求资源标识符(URI) 然后根据该URI 调用HandlerMapping 获得该Handler配置
     * 的所有相关的对象(包括Handler对象以及Handler对象对应的拦截器) 最后以HandlerExecutionChain 对象的形式返回
     *
     * 3. DispatcherServlet 根据获得的Handler 选择一个合适的HandlerAdapter (如果成功获得HandlerAdapter
     * 后 此时将开始执行拦截器preHandler()方法)
     *
     * 4.提取Request 中的模型数据 填充Handler 入参 开始执行Handler(Controller) 在填充Handler 的入参过程中
     * 根据个人配置 Spring 将做出额外的工作
     * 1>  HttpMessageConverter : 将请求消息 (如 Json xml 等数据) 转换成一个对象 将对象转换为指定的相应信息
     * 2> 数据转换 : 将请求的消息进行数据转换 如String 转成 Integer Double等
     * 3> 数据格式化 : 对请求消息进行数据格式化 => 将字符串转换成格式化数字或格式化日期等
     * 4> 数据验证 : 验证数据的有效性 (长度 格式) 验证结果存储到Binding 或 Error 中
     *
     * 5. Handler(Controller) 执行完成后 向DispatcherServlet 返回一个 ModelAndView对象
     *
     * 6. 根据返回的ModelAndView 选择一个合适的ViewResolver (这里必须是已经注册到Spring容器中的ViewResolver)返回给
     * DispatcherServlet
     *
     * 7. ViewResolver 结合 Model 和 View 来渲染视图
     *
     * 8. 视图负责将渲染结果返回给客户端
     */
}
