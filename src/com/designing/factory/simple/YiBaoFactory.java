package com.designing.factory.simple;

import com.designing.factory.WaterImpl;

public class YiBaoFactory implements Factory {
    @Override
    public Water getWater() {
        return new WaterImpl.YiBao();
    }
}
