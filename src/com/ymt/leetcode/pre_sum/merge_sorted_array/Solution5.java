package com.ymt.leetcode.pre_sum.merge_sorted_array;

/**
 * @author yumingtao
 * @date 2021/11/1 20:47
 */
public class Solution5 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur;
        int k = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                cur = nums2[p2--];
            } else if (p2 < 0) {
                cur = nums1[p1--];
            } else if (nums2[p2] > nums1[p1]) {
                cur = nums2[p2--];
            } else {
                cur = nums1[p1--];
            }

            nums1[k--] = cur;
        }
    }
}
