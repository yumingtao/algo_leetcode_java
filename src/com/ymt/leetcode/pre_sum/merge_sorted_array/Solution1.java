package com.ymt.leetcode.pre_sum.merge_sorted_array;

/**
 * @author yumingtao
 * @date 2021/11/1 10:50
 */
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            //取出较大的放入到nums1的最后
            if (index1 < 0) {
                //将nums2剩余的存入到num1
                while (index2 >= 0) {
                    nums1[i] = nums2[index2];
                    index2--;
                    i--;
                }
            } else if (index2 < 0) {
                //nums1值不用动
                break;
            } else {
                if (nums2[index2] >= nums1[index1]) {
                    nums1[i] = nums2[index2];
                    index2--;
                } else {
                    nums1[i] = nums1[index1];
                    index1--;
                }
            }
        }
    }
}
