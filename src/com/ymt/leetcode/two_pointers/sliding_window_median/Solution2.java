package com.ymt.leetcode.two_pointers.sliding_window_median;

import java.util.Arrays;

/**
 * @Description 二分+Arrays.sort
 * @author yumingtao
 * @date 2022-01-16 14:24
 */
public class Solution2 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        //滑动窗口数组
        int[] slideWindow = new int[k];
        double[] ans = new double[len - k + 1];
        //处理第一个滑窗
        for (int i = 0; i < k; ++i) {
            slideWindow[i] = nums[i];
        }
        //对数组进行排序
        Arrays.sort(slideWindow);
        ans[0] = getMedian(slideWindow);
        //滑动窗口向右移动
        for (int i = k; i < len; ++i) {
            //找到滑出窗口num在slideWindow中对应的索引
            int index = binarySearch(slideWindow, nums[i - k]);
            //用滑入的num替换滑出的num
            slideWindow[index] = nums[i];
            Arrays.sort(slideWindow);
            ans[i - k + 1] = getMedian(slideWindow);
        }
        return ans;
    }

    //二分查找索引
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private double getMedian(int[] nums) {
        int len = nums.length;
        if ((len & 1) == 1) {
            //奇数，直接返回 nums[len/2];
            return nums[len / 2];
        } else {
            //偶数，返回nums[len/2]和nums[len/2-1]的平均数
            return nums[len / 2] / 2.0 + nums[len / 2 - 1] / 2.0;
        }
    }
}
