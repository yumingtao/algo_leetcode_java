package com.ymt.leetcode.map_set.contains_duplicate;

import java.util.HashSet;

/**
 * 思路：使用HashSet
 *
 * @author yumingtao
 * @date 2022/2/25 20:00
 */
public class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
