package com.ymt.leetcode.two_pointers.k_empty_slots;

import java.util.TreeSet;

/**
 * @Description 参考题解:使用TreeSet
 * 1. 将灯泡亮起的位置存放到TreeSet
 * 2. 灯泡当前亮起的位置currentSlot，TreeSet是有序的，每次查找恰好大于和恰好小于当前灯泡亮起的位置，记做justLargerSlot和justLessSlot，分别判断
 *    justLargerSlot和justLessSlot到currentSlot是否等于k+1
 * @author yumingtao
 * @date 2022-01-22 15:47
 */
public class Solution1 {
    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < bulbs.length; ++i) {
            int currentSlot = bulbs[i];
            Integer justLargerSlot = treeSet.higher(currentSlot);
            if (justLargerSlot != null && justLargerSlot.intValue() - currentSlot == k + 1) {
                return i + 1;
            }

            Integer justLessSlot = treeSet.lower(currentSlot);
            if (justLessSlot != null && currentSlot - justLessSlot.intValue() == k + 1) {
                return i + 1;
            }
            treeSet.add(currentSlot);
        }

        return -1;
    }
}
