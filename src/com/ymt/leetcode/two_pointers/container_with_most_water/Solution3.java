package com.ymt.leetcode.two_pointers.container_with_most_water;

/**
 * @Description 代码优化
 * @author yumingtao
 * @date 2022-01-25 21:27
 */
public class Solution3 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            //面积是右最小的高度决定的，谁的值小谁向前走一步
            //因为如果小的不动，大的动，长度变小，高度没变甚至更小，得到的面积也会更小
            if (height[left] < height[right]) {
                area = Math.max(area, height[left] * (right - left));
                ++left;
            } else {
                area = Math.max(area, height[right] * (right - left));
                --right;
            }
        }
        return area;
    }
}
