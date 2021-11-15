package com.ymt.leetcode.two_pointers.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路: 利用两数之和
 * 1. i<j<k, nums[i]+nums[j]+nums[k]=0
 * 2. 固定一端i，则有nums[j]+nums[k]=-nums[i]，对数组在[j,k]，求满足两数之和等于-nums[i]的所有组合
 * 3. 注意排重
 *
 * @author yumingtao
 * @date 2021/11/11 09:17
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        //首先对数组排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //防止元素重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> results = twoSum(nums, i + 1, 0 - nums[i]);
            for (List<Integer> res : results) {
                ans.add(res);
            }
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int j = nums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = start; i < j; i++) {
            //防止元素重复
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            while (i < j && nums[i] + nums[j] > target) {
                j--;
            }

            if (i < j && nums[i] + nums[j] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(0 - target);
                list.add(nums[i]);
                list.add(nums[j]);
                ans.add(list);
            }
        }

        return ans;
    }
}
