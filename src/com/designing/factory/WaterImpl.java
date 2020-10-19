package com.designing.factory;

import com.designing.factory.simple.Water;

public class WaterImpl{

    public static class IceDew implements Water {
        @Override
        public String getWater() {
            return "冰露";
        }
    }

    public static class NongFu implements Water {

        @Override
        public String getWater() {
            return "农夫山泉";
        }
    }

    public static class YiBao implements Water {

        @Override
        public String getWater() {
            return "怡宝";
        }
    }
}
