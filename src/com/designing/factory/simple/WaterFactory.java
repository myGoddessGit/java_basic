package com.designing.factory.simple;

import com.designing.factory.WaterImpl;

public class WaterFactory {

    public Water getWater(String brand){
        if (brand.equals("冰露")){
            return new WaterImpl.IceDew();
        }

        if (brand.equals("农夫山泉")){
            return new WaterImpl.NongFu();
        }

        if (brand.equals("怡宝")){
            return new WaterImpl.YiBao();
        }

        return null;
    }
}
