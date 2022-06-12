package com.ymt.leetcode.map_set.intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description TODO
 * @author yumingtao
 * @date 2022-02-26 17:33
 */
public class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            if (!set1.contains(num)) {
                set1.add(num);
            }
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num) && !set2.contains(num)) {
                set2.add(num);
            }
        }

        int[] ans = new int[set2.size()];
        Iterator<Integer> it = set2.iterator();
        int i = 0;
        while (it.hasNext()) {
            ans[i++] = it.next();
        }
        return ans;
    }
}
