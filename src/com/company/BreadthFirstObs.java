package com.company;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstObs<T> extends obs<T> {

    public BreadthFirstObs(GMass<T> g, T t) {
        super(new Vert<T>(t));
        bfo(g, t);
    }

    private void bfo(GMass<T> g, T t) {
        flag.add(new Vert<T>(t));
        Queue<Vert<T>> list = new LinkedList<>();
        list.add(new Vert<T>(t));
        while (!list.isEmpty()) {
            Vert<T> v = list.remove();
            g.vertArrayList.get(g.vertArrayList.indexOf(v)).ADJget().keySet().stream().filter(vert -> !flag.contains(vert)).forEachOrdered(vert -> {
                flag.add(vert);
                vertVertMap.put(vert, v);
                list.add(vert);
            });
        }
    }
}
