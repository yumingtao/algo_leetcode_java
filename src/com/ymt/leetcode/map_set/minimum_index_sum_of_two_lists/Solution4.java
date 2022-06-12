package com.ymt.leetcode.map_set.minimum_index_sum_of_two_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 思路：Solution1更改为使用List
 *
 * @author yumingtao
 * @date 2022/3/1 09:09
 */
public class Solution4 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        //先将list1中元素放入map
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; ++i) {
            map1.put(list1[i], i);
        }
        int minSum = 2001;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; ++i) {
            if (map1.containsKey(list2[i])) {
                int sum = map1.get(list2[i]) + i;
                if (sum < minSum) {
                    minSum = sum;
                    list.clear();
                    list.add(list2[i]);
                } else if (sum == minSum) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
