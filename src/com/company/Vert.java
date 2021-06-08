package com.company;

import java.util.HashMap;
import java.util.Map;

public class Vert<V>{
    private final V data;
    private final Map<Vert<V>, Double> ADJvert = new HashMap<>();

    public Vert(V d) {
        this.data = d;
    }

    public void ADJadd(Vert<V> bPoint, double mass){
        ADJvert.put(bPoint, mass);
    }

    public Map<Vert<V>, Double> ADJget() {
        return ADJvert;
    }

    public V DATAget() {
        return data;
    }
}
