package com.ymt.leetcode.map_set.intersection_of_two_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 数组排序并使用双指针
 * @author yumingtao
 * @date 2022-02-26 18:07
 */
public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //先对两个数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //使用双指针，分别指向num1和num2，判读两个数字是否相等
        int p1 = 0;
        int p2 = 0;

        List<Integer> list = new ArrayList<>();
        int preNum = -1;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                ++p1;
            } else if (nums1[p1] > nums2[p2]) {
                ++p2;
            } else {
                if (nums1[p1] != preNum) {
                    preNum = nums1[p1];
                    list.add(preNum);
                }
                ++p1;
                ++p2;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
