package com.ymt.leetcode.two_pointers.find_k_closest_elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Solution1的优化
 *
 * @author yumingtao
 * @date 2022-02-09 19:18
 */
public class Solution2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //首先二分找到数组中>=x的最小的数的索引
        int lowBound = binarrySearch(arr, x);
        //left向左移动
        int left = 0;
        //right向右移动
        int right = 0;
        if (lowBound == arr.length) {
            //说明结果不存在，所有的数都是小于x的，从高到低直接取k个数即可
            right = lowBound - 1;
            left = lowBound - k;
        } else {
            //lowBound-1是小于x的数中最大的一个数的索引, 判断lowBound和lowBound-1中离x最近的做为left和right
            int closedIndex = lowBound > 0 && arr[lowBound] - x >= x - arr[lowBound - 1] ? lowBound - 1 : lowBound;
            left = closedIndex;
            right = closedIndex;
            while (right - left + 1 < k) {
                if (left == 0) {
                    //如果left已经移到了数组头，或right在数组头，只向右移动right
                    ++right;
                } else if (right == arr.length - 1) {
                    //如果right已经移动到数组尾，只想左移动left
                    --left;
                } else {
                    //如果left没有移动到数组头，right也没有移动到数组尾，判断left和right的下一步谁更接近x, 更接近x的移动一步
                    if (x - arr[left - 1] <= arr[right + 1] - x) {
                        //由于left<right,将left放入结果，然后向左移动left
                        --left;
                    } else {
                        //此时arr[right]更接近x
                        ++right;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            ans.add(arr[i]);
        }
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
