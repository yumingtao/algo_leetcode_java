package com.ymt.leetcode.map_set.design_hashmap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路：使用LinedList数组
 *
 * @author yumingtao
 * @date 2022/2/25 14:56
 */
public class MyHashMap1 {
    private final int size = 1001;
    private List<Node>[] data;

    public MyHashMap1() {
        data = new LinkedList[size];
        for (int i = 0; i < size; ++i) {
            data[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int hashIndex = calculateHashValue(key);
        List<Node> nodeList = data[hashIndex];
        for (int i = 0; i < nodeList.size(); ++i) {
            if (nodeList.get(i).getKey() == key) {
                nodeList.get(i).setValue(value);
                return;
            }
        }
        data[hashIndex].add(new Node(key, value));
    }

    public int get(int key) {
        int hashIndex = calculateHashValue(key);
        Iterator<Node> it = data[hashIndex].iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.getKey() == key) {
                return node.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashIndex = calculateHashValue(key);
        List<Node> nodeList = data[hashIndex];
        for (int i = 0; i < nodeList.size(); ++i) {
            if (nodeList.get(i).getKey() == key) {
                data[hashIndex].remove(i);
                return;
            }
        }
    }

    private int calculateHashValue(int key) {
        return key % size;
    }

    class Node {
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
