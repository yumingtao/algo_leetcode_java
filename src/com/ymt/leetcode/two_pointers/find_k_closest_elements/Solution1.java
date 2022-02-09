package com.ymt.leetcode.two_pointers.find_k_closest_elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 二分查找+双指针
 * 1. 二分找到数组中>=x的最小的数的索引，做为right，right不断的向右移动
 * 2. right-1是小于x的数中最大的一个数的索引，做为left，left不断的向左移动
 * 3. 移动left和right，寻找满足条件的解
 *
 * @author yumingtao
 * @date 2022-02-09 20:22
 */
public class Solution1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        //首先二分找到数组中>=x的最小的数的索引,做为right,right不断的向右移动
        int right = binarrySearch(arr, x);
        //right-1是小于x的数中最大的一个数的索引，做为left，left不断的向左移动
        int left = right - 1;
        while (ans.size() < k) {
            if (left < 0) {
                //如果left已经移到了数组头，只向右移动right
                ans.add(arr[right]);
                ++right;
            } else if (right >= arr.length) {
                //如果right已经移动到数组尾，只想左移动left
                ans.add(arr[left]);
                --left;
            } else {
                //如果left没有移动到数组头，right也没有移动到数组尾，按照下边判断更接近x的数
                if (right < arr.length && Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    //由于left<right,将left放入结果，然后向左移动left
                    ans.add(arr[left]);
                    --left;
                } else if (right < arr.length) {
                    //此时arr[right]更接近x
                    ans.add(arr[right]);
                    ++right;
                }
            }
        }
        //对数组自然排序
        Collections.sort(ans);
        return ans;
    }

    private int binarrySearch(int[] arr, int target) {
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
