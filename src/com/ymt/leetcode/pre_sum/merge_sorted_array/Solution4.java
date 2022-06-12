package com.ymt.leetcode.pre_sum.merge_sorted_array;

/**
 * @author yumingtao
 * @date 2021/11/1 20:48
 */
public class Solution4 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums2[p2] < nums1[p1]) {
                cur = nums2[p2++];
            } else {
                cur = nums1[p1++];
            }

            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }
}
