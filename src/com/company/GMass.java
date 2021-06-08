package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class GMass<T> {
    private final boolean aBoolean;
    public ArrayList<Vert<T>> vertArrayList;

    {
        vertArrayList = new ArrayList<>();
    }

    public GMass() {
        this.aBoolean = true;
    }

    public GMass(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public void add(T v) {
        vertArrayList.add(new Vert<T>(v));
    }

    public void add1(T t, T bPoint, double mass) {
        if (!ifVer(t)) {
            add(t);
            if (!ifVer(bPoint))
                add(bPoint);
            if (ifEdge(t, bPoint)
                    || t.equals(bPoint))
                return;
            if(!vertArrayList.contains(new Vert<T>(t))){
                return;
            }
        } else {
            if (!ifVer(bPoint))
                add(bPoint);
            if (ifEdge(t, bPoint)
                    || t.equals(bPoint))
                return;
            if(!vertArrayList.contains(new Vert<T>(t))){
                return;
            }
        }

        vertArrayList.get(vertArrayList.indexOf(new Vert<T>(t))).ADJadd(new Vert<T>(bPoint), mass);


        if (aBoolean) {
            vertArrayList.get(vertArrayList.indexOf(new Vert<T>(bPoint))).ADJadd(new Vert<T>(t), mass);
        }
    }

    public int VerCountGet() {
        return vertArrayList.size();
    }

    public int EdgeCountGet() {
        int c = 0;

        for (Iterator<Vert<T>> iterator = vertArrayList.iterator(); iterator.hasNext(); ) {
            Vert<T> to = iterator.next();
            c += to.ADJget().size();
        }

        if (aBoolean)c /= 2;

        return c;
    }


    public boolean ifVer(T v) {
        return vertArrayList.contains(new Vert<T>(v));
    }

    public boolean ifEdge(T t, T dest) {
        if (!ifVer(t)) return false;
        return vertArrayList.get(vertArrayList.indexOf(new Vert<T>(t))).ADJget().containsKey(new Vert<T>(dest));
    }
}
