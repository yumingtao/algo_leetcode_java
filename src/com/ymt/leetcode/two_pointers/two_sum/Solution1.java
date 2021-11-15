package com.ymt.leetcode.two_pointers.two_sum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 思路：使用自定义结构+双指针
 *
 * @author yumingtao
 * @date 2021/11/10 09:57
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(i, nums[i]);
        }
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.value - o2.value;
            }
        });

        int j = n - 1;
        for (int i = 0; i < j; i++) {
            while (i < j && items[i].value + items[j].value > target) {
                j--;
            }
            if (i < j && items[i].value + items[j].value == target) {
                return new int[]{items[i].index, items[j].index};
            }
        }

        return new int[]{};
    }

    class Item {
        int index;
        int value;

        public Item(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
