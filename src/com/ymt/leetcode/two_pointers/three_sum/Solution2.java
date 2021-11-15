package com.ymt.leetcode.two_pointers.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路:暴力解法（超时）
 *
 * @author yumingtao
 * @date 2021/11/11 10:25
 */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        //首先对数组排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        ans.add(temp);
                    }
                }
            }
        }
        return ans;
    }
}
