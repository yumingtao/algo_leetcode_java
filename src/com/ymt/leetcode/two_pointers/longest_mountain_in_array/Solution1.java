package com.ymt.leetcode.two_pointers.longest_mountain_in_array;

/**
 * @Description 动态规划+枚举山顶
 * @author yumingtao
 * @date 2022-02-07 19:22
 */
public class Solution1 {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return 0;
        }
        int[] left = new int[n];
        left[0] = 0;
        for (int i = 1; i < n; ++i) {
            left[i] = arr[i] > arr[i - 1] ? left[i - 1] + 1 : 0;
        }

        int[] right = new int[n];
        right[n - 1] = 0;
        for (int i = n - 2; i >= 0; --i) {
            right[i] = arr[i] > arr[i + 1] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
