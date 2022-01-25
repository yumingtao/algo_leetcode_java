package com.ymt.leetcode.two_pointers.container_with_most_water;

/**
 * @Description 题解
 * @author yumingtao
 * @date 2022-01-25 21:21
 */
public class Solution2 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            //面积是右最小的高度决定的，谁的值小谁向前走一步
            //因为如果小的不动，大的动，长度变小，高度没变甚至更小，得到的面积也会更小
            area = Math.max(area, min * (right - left));
            //移动小的
            if (min == height[left]) {
                //移动left
                ++left;
            } else {
                //移动right
                --right;
            }
        }
        return area;
    }
}
