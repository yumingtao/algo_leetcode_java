package com.ymt.leetcode.two_pointers.longest_turbulent_subarray;

/**
 * @Description 滑窗
 * @author yumingtao
 * @date 2021-12-28 21:25
 */
public class Solution2 {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int right = 0;
        int maxLen = 1;
        while (right < arr.length - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    ++left;
                }
                ++right;
            } else {
                if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    ++right;
                } else if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    ++right;
                } else {
                    left = right;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
