package com.company;

import java.util.Map;

public class DepthFirstObs<T> extends obs<T> {

    public DepthFirstObs(GMass<T> graph, T source) {
        super(new Vert<T>(source));
        dfs(graph, source);
    }

    private void dfs(GMass<T> g, T t) {
        flag.add(new Vert<T>(t));
        c++;

        Vert<T> cur = new Vert<T>(t);
        g.vertArrayList.get(g.vertArrayList.indexOf(cur)).ADJget().keySet().stream().filter(vert -> !flag.contains(vert)).forEachOrdered(vert -> {
            vertVertMap.put(vert, new Vert<>(t));
            dfs(g, vert.DATAget());
        });
    }

}
