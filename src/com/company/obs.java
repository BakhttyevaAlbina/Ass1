package com.company;

import java.util.*;
import java.util.stream.Stream;

public class obs<T> {
    protected int c;
    protected Set<Vert<T>> flag;
    protected Map<Vert<T>, Vert<T>> vertVertMap;
    protected final Vert<T> s;

    public obs(Vert<T> s) {
        this.s = s;
        flag = new HashSet<>();
        vertVertMap = new HashMap<>();
    }

    public boolean toBPoint(Vert<T> v) {
        return flag.contains(v);
    }

    public Iterable<Vert<T>> toB(T v) {
        Iterable<Vert<T>> result = null;
        if (toBPoint(new Vert<T>(v))) {
            LinkedList<Vert<T>> linkedList = new LinkedList<>();
            Stream.iterate(new Vert<>(v), i -> i != s, i -> vertVertMap.get(i)).forEachOrdered(linkedList::push);
            linkedList.push(s);
            result = linkedList;
        }

        return result;
    }
}
