package com.designing.adapter;

/**
 * 实现一个TypeC 转 VGA 适配器
 * 类的适配器模式
 */
public class TypeCToVga_Class extends Phone implements Vga{
    @Override
    public void getInterface() {
        typePhone();
        System.out.println("接收到Type-c口信息, 信息转换长VGA接口中.....");
        System.out.println("信息已转换VGA接口, 显示屏可以对接");
    }
}
