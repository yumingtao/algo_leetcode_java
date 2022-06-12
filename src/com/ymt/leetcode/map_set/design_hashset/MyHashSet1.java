package com.ymt.leetcode.map_set.design_hashset;

import java.util.LinkedList;
import java.util.List;

/**
 * 思路：使用数组+LinkedList
 *
 * @author yumingtao
 * @date 2022/2/25 11:20
 */
public class MyHashSet1 {
    private final int size = 1001;
    private final int mod= 1000;
    private List<Integer>[] buckets;
    public MyHashSet1() {
        buckets = new LinkedList[size];
        for(int i = 0; i < size; ++i){
            buckets[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int hashIndex = calculateHashValue(key);
        if(!contains(key)){
            buckets[hashIndex].add(key);
        }
    }

    public void remove(int key) {
        int hashIndex = calculateHashValue(key);
        if(contains(key)){
            buckets[hashIndex].remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int hashIndex = calculateHashValue(key);
        return buckets[hashIndex].contains(key);
    }

    private int calculateHashValue(int value){
        return value % mod;
    }
}