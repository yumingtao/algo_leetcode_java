package com.ymt.leetcode.two_pointers.longest_mountain_in_array;

/**
 * @Description 动态规划+枚举山顶+优化状态转换方程为一趟扫描
 * @author yumingtao
 * @date 2022-02-07 20:12
 */
public class Solution2 {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return 0;
        }
        int[] left = new int[n];
        left[0] = 0;
        int[] right = new int[n];
        right[n - 1] = 0;
        for (int i = 1; i < n; ++i) {
            left[i] = arr[i] > arr[i - 1] ? left[i - 1] + 1 : 0;
            right[n - i - 1] = arr[n - i - 1] > arr[n - i] ? right[n - i] + 1 : 0;
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
