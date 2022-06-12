package com.ymt.leetcode.two_pointers.four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 利用三数之和和两数之和
 * @author yumingtao
 * @date 2022-02-16 19:47
 */
public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //先对数组排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4) {
            return ans;
        }
        for (int i = 0; i < n; ++i) {
            //排重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            ans.addAll(threeSum(nums, i, target - nums[i]));
        }
        return ans;
    }

    private List<List<Integer>> threeSum(int[] nums, int start, int target) {
        //a+b+c=target
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start + 1; i < nums.length; ++i) {
            //排重
            if (i > start + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> twoSumRes = twoSum(nums, start, i, target - nums[i]);
            for (List<Integer> l : twoSumRes) {
                res.add(l);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int firstIndex, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start + 1;
        int right = nums.length - 1;
        while (left < right) {
            //排重
            if (left > start + 1 && nums[left] == nums[left - 1]) {
                ++left;
                continue;
            }
            if (nums[left] + nums[right] > target) {
                --right;
            } else if (nums[left] + nums[right] < target) {
                ++left;
            } else {
                res.add(Arrays.asList(nums[firstIndex], nums[start], nums[left], nums[right]));
                ++left;
                --right;
            }
        }
        return res;
    }
}
