package com.ymt.leetcode.two_pointers.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：利用两数之和
 *
 * @author yumingtao
 * @date 2022/2/15 09:32
 */
public class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            //防止重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (List<Integer> l : twoSum(nums, i)) {
                ans.add(l);
            }
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int target) {
        int left = target + 1;
        int right = nums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (left < right) {
            //防止重复，注意left要大于target+1
            if (left > target + 1 && nums[left] == nums[left - 1]) {
                ++left;
                continue;
            }
            if (nums[left] + nums[right] < -nums[target]) {
                ++left;
            } else if (nums[left] + nums[right] > -nums[target]) {
                --right;
            } else {
                ans.add(Arrays.asList(nums[target], nums[left], nums[right]));
                ++left;
                --right;
            }
        }
        return ans;
    }
}
