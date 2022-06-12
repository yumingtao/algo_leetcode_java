package com.ymt.leetcode.map_set.contains_duplicate;

import java.util.Arrays;

/**
 * 思路：数组排序
 *
 * @author yumingtao
 * @date 2022/2/25 20:07
 */
public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }
}
