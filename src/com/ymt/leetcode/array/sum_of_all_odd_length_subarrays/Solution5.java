package com.ymt.leetcode.array.sum_of_all_odd_length_subarrays;

/**
 * 思路：参考题解-暴力
 *
 * @author yumingtao
 * @date 2021/10/29 16:27
 */
public class Solution5 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int end = i; end < n; end++) {
                sum += arr[end];
                //如果个数是奇数个，更新答案
                if (((end - i + 1) & 1) == 1) {
                    ans += sum;
                }
            }
        }

        return ans;
    }
}
