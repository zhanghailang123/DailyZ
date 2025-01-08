package com.zhanghl.first.pattern.wrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/8/30 12:41
 */
public class Memoizer<A, V> implements Computable<A, V>{

    private final Map<A, V> cache = new HashMap<A, V>();

    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}