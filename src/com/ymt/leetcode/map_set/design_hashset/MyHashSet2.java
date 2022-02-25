package com.ymt.leetcode.map_set.design_hashset;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路：使用LinkedList数组
 * 1. 注意取模的时候使用较大质数
 *
 * @author yumingtao
 * @date 2022/2/25 13:57
 */
public class MyHashSet2 {
    private final int size = 1001;
    private List<Integer>[] buckets;

    public MyHashSet2() {
        buckets = new LinkedList[size];
        for(int i = 0; i < size; ++i){
            buckets[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int hashIndex = calculateHashValue(key);
        if (!contains(key)) {
            buckets[hashIndex].add(key);
        }
    }

    public void remove(int key) {
        int hashIndex = calculateHashValue(key);
        Iterator<Integer> it = buckets[hashIndex].iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            if (element == key) {
                buckets[hashIndex].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hashIndex = calculateHashValue(key);
        Iterator<Integer> it = buckets[hashIndex].iterator();
        while (it.hasNext()) {
            if (it.next() == key) {
                return true;
            }
        }
        return false;
    }

    private int calculateHashValue(int key) {
        return key % size;
    }
}
