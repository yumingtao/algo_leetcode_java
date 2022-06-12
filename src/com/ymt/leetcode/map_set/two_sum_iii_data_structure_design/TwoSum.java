package com.ymt.leetcode.map_set.two_sum_iii_data_structure_design;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 使用HashMap
 * @author yumingtao
 * @date 2022-03-06 12:28
 */
public class TwoSum {
    private Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (int k : map.keySet()) {
            //确定要寻找的目标值
            int target = value - k;
            if (!map.containsKey(target)) {
                //如果不包含，继续便利
                continue;
            } else {
                //如果包含，需要判断target和k
                if (target == k && map.get(k) < 2) {
                    //如果target==k, 但是k的个数小于2，继续遍历
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
