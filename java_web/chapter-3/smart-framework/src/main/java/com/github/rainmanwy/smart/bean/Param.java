package com.github.rainmanwy.smart.bean;

import com.github.rainmanwy.smart.util.CastUtil;
import com.github.rainmanwy.smart.util.CollectionUtil;

import java.util.Map;

public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }

    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    public boolean isEmpty() {
        return CollectionUtil.isEmpty(this.paramMap);
    }
}
