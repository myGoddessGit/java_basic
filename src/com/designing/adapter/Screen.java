package com.designing.adapter;

public class Screen {
    public static void main(String[] args) {
        System.out.println("---------第一种适配器--------");
        Vga vga = new TypeCToVga_Class();
        vga.getInterface(); // 适配器将typeC转换成Vga
        System.out.println("显示器对接适配器, 手机成功投影到显示屏!");

        System.out.println("---------第二种适配器--------");
        TypeCToVga_Object typeCToVga_object = new TypeCToVga_Object(new Phone());
        typeCToVga_object.getInterface(); // 适配器将typeC转换成Vga
        System.out.println("显示器对接适配器, 手机成功投影到显示屏!");

        System.out.println("---------第三种适配器--------");
        VgaAdapter adapter = new VgaAdapter();
        adapter.typeC();
        adapter.typeCToVga(); // 适配器将typeC转换成Vga
        System.out.println("显示器对接适配器, 手机成功投影到显示屏!");
    }
}
