package com.ymt.leetcode.array.sum_of_all_odd_length_subarrays;

/**
 * 思路：
 * 1.j<i,区间和pSum[i]-pSum[j]
 * 2.只有
 * >>2.1 偶数-奇数=奇数
 * >>2.2 奇数-偶数=奇数
 * 3.判断i的奇偶性，找到i之前和i奇偶性相反的下标计算区间和
 *
 * @author yumingtao
 * @date 2021/10/27 10:24
 */
public class Solution1 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] pSum = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            pSum[i] = pSum[i - 1] + arr[i - 1];

            for (int j = 0; j < i; j++) {
                if (((i & 1) == 1 && (j & 1) == 0) || ((i & 1) == 0 && (j & 1) == 1)) {
                    ans += pSum[i] - pSum[j];
                }
            }
        }

        return ans;
    }
}