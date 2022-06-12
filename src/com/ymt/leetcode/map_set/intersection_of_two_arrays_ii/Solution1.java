package com.ymt.leetcode.map_set.intersection_of_two_arrays_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 思路:使用HashMap
 *
 * @author yumingtao
 * @date 2022/3/1 10:11
 */
public class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //先统计nums1中每个数字出现的次数
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        //遍历nums2，判断是否在map1中出现，如果出现，则放入list，同时map1中的计数-1
        for (int num : nums2) {
            if (map1.containsKey(num) && map1.get(num) > 0) {
                list.add(num);
                map1.put(num, map1.get(num) - 1);;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
