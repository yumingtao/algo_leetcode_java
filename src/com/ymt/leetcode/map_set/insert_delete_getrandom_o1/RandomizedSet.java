package com.ymt.leetcode.map_set.insert_delete_getrandom_o1;

import java.util.*;

/**
 * @Description 使用Map和List
 * @author yumingtao
 * @date 2022-03-10 20:07
 */
public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> data;
    private Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.data = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        data.add(val);
        map.put(val, data.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        if (data.size() > 1) {
            //将链表尾部元素移动到当前元素位置
            int lastVal = data.get(data.size() - 1);
            data.set(map.get(val), lastVal);
            //更新尾部元素在map中的新索引
            map.put(lastVal, map.get(val));
        }
        //移除链表尾部元素
        data.remove(data.size() - 1);
        //从map中移除该元素
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }
}
