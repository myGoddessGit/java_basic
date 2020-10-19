package com.designing.factory.abstract_f;

import com.designing.factory.WaterImpl;

public abstract class AbstractFactory {

    /**
     * 公共属性  容量
     */
    int volume;

    public abstract WaterImpl.YiBao getYiBao();

    public abstract WaterImpl.NongFu getNongFu();

    public abstract WaterImpl.IceDew getIceDew();
}
