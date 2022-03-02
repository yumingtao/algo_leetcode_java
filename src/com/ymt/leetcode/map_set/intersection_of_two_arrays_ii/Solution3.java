package com.ymt.leetcode.map_set.intersection_of_two_arrays_ii;

import java.util.Arrays;

/**
 * @Description 排序+双指针
 * @author yumingtao
 * @date 2022-03-02 20:22
 */
public class Solution3 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //先对数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        int[] ans = new int[nums1.length];
        int index = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                ans[index++] = nums1[p1];
                ++p1;
                ++p2;
            } else if (nums1[p1] < nums2[p2]) {
                ++p1;
            } else {
                ++p2;
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}
