package com.ymt.leetcode.two_pointers.find_k_closest_elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：官方题解思路理解
 *
 * @author yumingtao
 * @date 2022/2/11 10:43
 */
public class Solution4 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int left = 0;
        int right = 0;
        if (x <= arr[0]) {
            //直接去从0去k个数
            left = 0;
            right = k - 1;
        } else if (x >= arr[len - 1]) {
            left = len - k;
            right = len - 1;
        } else {
            //二分找到数组中>=x的最小的数的索引，当数组中不存在大于等于x的数时，lowBound返回的是数组的长度
            //但因为在前两个分支中已经排除了x==arr[0]和x==arr[len-1]的情况，该分支中lowBound一定是在（0，len-1）区间
            int lowBound = binarySearch(arr, x);
            //lowBound-1是小于x的数中最大的一个数的索引, 找到lowBound和lowBound-1中离x最近的索引
            int closestIndex = x - arr[lowBound - 1] <= arr[lowBound] - x ? lowBound - 1 : lowBound;
            //以closestIndex为起始点，分别向左和向右取k长区间，缩小判断范围
            //左侧不够k个元素，则从0开始
            left = Math.max(0, closestIndex - k - 1);
            //右侧不够k个元素，则到len-1结束
            right = Math.min(len - 1, closestIndex + k + 1);
            //通过上边操作，索引范围被缩小到了[left, right]区间，双指针相向移动，找到k个元素时结束
            while (right - left + 1 > k) {
                if (x - arr[left] <= arr[right] - x) {
                    //left更接近x，保留，向左移动right
                    --right;
                } else {
                    //right更接近x，保留，向右移动left
                    ++left;
                }
            }
            //当循环结束，[left, right]确定了k个元素
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            ans.add(arr[i]);
        }
        return ans;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                //解可能还在左边
                right = mid;
            } else {
                //解一定在右边
                left = mid + 1;
            }
        }
        return left;
    }
}
