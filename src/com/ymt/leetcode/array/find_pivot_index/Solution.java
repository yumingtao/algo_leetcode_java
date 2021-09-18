package com.ymt.leetcode.array.find_pivot_index;

/**
 * @author yumingtao
 * @date 2021/9/18 09:36
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        //先计算前缀和数组
        int[] lSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            lSum[i] = lSum[i - 1] + nums[i - 1];
        }

        //再计算后缀和数组
        int[] rSum = new int[n + 2];
        for (int i = n; i >= 1; i--) {
            rSum[i] = rSum[i + 1] + nums[i - 1];
        }

        //如果前缀和==后缀和
        for (int i = 1; i <= n; i++) {
            if (lSum[i] == rSum[i]) {
                return i - 1;
            }
        }

        return -1;
    }
}

// 0  1      n  n + 1
//    2  1  -1
// 0  2  3   2
//    2  0  -1  0