package com.ymt.leetcode.map_set.intersection_of_two_arrays_ii;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 思路：Solution1优化
 *
 * @author yumingtao
 * @date 2022/3/2 12:06
 */
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            if (map1.containsKey(num) && map1.get(num) > 0) {
                ans[index++] = num;
                map1.put(num, map1.get(num) - 1);
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}
