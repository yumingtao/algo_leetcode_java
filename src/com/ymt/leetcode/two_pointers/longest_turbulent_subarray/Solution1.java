package com.ymt.leetcode.two_pointers.longest_turbulent_subarray;

/**
 * @Description 滑窗
 * @author yumingtao
 * @date 2021-12-28 19:52
 */
public class Solution1 {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return len;
        }

        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < len - 1) {
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
