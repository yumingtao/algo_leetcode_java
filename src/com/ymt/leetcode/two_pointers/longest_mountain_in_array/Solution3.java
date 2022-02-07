package com.ymt.leetcode.two_pointers.longest_mountain_in_array;

/**
 * @Description 官方题解双指针寻找左右山脚，未经优化版本
 * @author yumingtao
 * @date 2022-02-07 20:44
 */
public class Solution3 {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        /*
        if (n < 3) {
            return 0;
        }*/
        int ans = 0;
        int left = 0;
        //至少3个数才能形成山脉，所以left+2，之前n<3的特例判断可以去掉
        while (left + 2 < n) {
            //先找到满足条件的左侧山脚，山顶左侧单调递增
            while (left + 1 < n && arr[left] >= arr[left + 1]) {
                //不满足递增，继续右移left
                ++left;
            }
            //没有找到满足条件的左山脚，直接结束
            if (left + 1 >= n) {
                break;
            }
            //开始寻找右侧山脚，从left+1的位置开始找
            int right = left + 1;
            //先找到可能的山顶，山顶左侧满足递增，注意right+1要小于数组的长度
            while (right + 1 < n && arr[right] < arr[right + 1]) {
                ++right;
            }
            //如果right+1==n，已经到了数组的末尾，无法再形成山脉，直接结束
            if (right + 1 == n) {
                break;
            }
            //如果arr[right]==arr[right+1]，则right不是山顶，left从right+1的位置开始
            if (arr[right] == arr[right + 1]) {
                left = right + 1;
                continue;
            }
            //如果arr[right]>arr[right + 1]，right是要找的山顶，之后形成递减趋势，不断向右移动right直至找到右侧山脚
            while (right + 1 < n && arr[right] > arr[right + 1]) {
                ++right;
            }
            //找到山脚，更新ans，不管right是否到达数组的末尾，山脉的长度都是right-left+1
            ans = Math.max(ans, right - left + 1);
            //此时arr[right]<arr[right + 1]或arr[right]==arr[right + 1]，或right+1==n,还需要进一步判断
            //如果到达数组末尾，直接结束
            if (right + 1 == n) {
                break;
            }
            //如果没有到达数组的末尾
            if (arr[right] < arr[right + 1]) {
                //right直接做为下一次判断的左山脚
                left = right;
            } else {
                //如果相等，right+1做为下一次判断的左山脚
                left = right + 1;
            }
        }
        return ans;
    }
}
