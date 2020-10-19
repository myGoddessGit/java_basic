package com.designing.adapter;


/**
 * 实现一个VGA适配器 同理也可以实现HDMI适配器
 * 接口实现的适配器模式
 */
public class VgaAdapter extends Adapter {
    @Override
    public void typeC() {
        System.out.println("信息从TypeC口的手机输出");
    }

    @Override
    public void typeCToVga() {
        System.out.println("接收到Type-c口信息, 信息转换长VGA接口中.....");
        System.out.println("信息已转换VGA接口, 显示屏可以对接");
    }
}
