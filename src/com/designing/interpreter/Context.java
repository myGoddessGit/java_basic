package com.designing.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境类Context 类定义出从变量到布尔值的一个映射
 */
public class Context {
    private Map<Variable, Boolean> map = new HashMap<>();

    public void assign(Variable var, boolean value){
        map.put(var, new Boolean(value));
    }

    public boolean lookUp(Variable var) throws IllegalArgumentException {
        Boolean value = map.get(var);
        if (value == null){
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}
