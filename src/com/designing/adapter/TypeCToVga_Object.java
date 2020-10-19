package com.designing.adapter;

/**
 * TypeC转Vga适配器
 * 对象的适配器模式
 */
public class TypeCToVga_Object implements Vga{
    private Phone phone;
    public TypeCToVga_Object(Phone phone){
        this.phone = phone;
    }
    @Override
    public void getInterface() {
        if (phone != null){
            phone.typePhone();
            System.out.println("接收到Type-c口信息, 信息转换长VGA接口中.....");
            System.out.println("信息已转换VGA接口, 显示屏可以对接");
        }
    }
}
