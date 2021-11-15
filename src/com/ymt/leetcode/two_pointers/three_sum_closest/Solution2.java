package com.ymt.leetcode.two_pointers.three_sum_closest;

import java.util.Arrays;

/**
 * 思路：双指针
 * 1.排序数组
 * 2.固定一端i，[i+1,n)递增数组中使用对撞指针，每次循环判断sum-target的绝对值
 *
 * @author yumingtao
 * @date 2021/11/12 10:10
 */
public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        //此处不能Integer.MAX_VALUE,因为-10^4<=target<=10^4，在ans-target时回超出范围
        int ans = 1000000000;
        //固定一端i
        for (int i = 0; i < n; i++) {
            //剪枝去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                ans = Math.abs(ans - target) > Math.abs(sum - target) ? sum : ans;
                if (sum > target) {
                    //nums排序后是递增的，不断缩小right
                    right--;
                    //剪枝去重
                    int r = right;
                    while (left < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                    right = r;
                } else if (sum < target) {
                    //nums排序后是递增的，不增加left
                    left++;
                    //剪枝去重
                    int l = left;
                    while (l < right && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    left = l;
                } else {
                    return target;
                }
            }
        }

        return ans;
    }
}
