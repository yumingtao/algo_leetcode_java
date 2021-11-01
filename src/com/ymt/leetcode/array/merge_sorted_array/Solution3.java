package com.ymt.leetcode.array.merge_sorted_array;

import java.util.Arrays;

/**
 * @author yumingtao
 * @date 2021/11/1 20:32
 */
public class Solution3 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}
