package com.designing.factory.abstract_f;

import com.designing.factory.WaterImpl;

public class Water_Factory extends AbstractFactory{


    @Override
    public WaterImpl.YiBao getYiBao() {
        return new WaterImpl.YiBao();
    }

    @Override
    public WaterImpl.NongFu getNongFu() {
        return new WaterImpl.NongFu();
    }

    @Override
    public WaterImpl.IceDew getIceDew() {
        return new WaterImpl.IceDew();
    }
}
