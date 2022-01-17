package com.ymt.leetcode.two_pointers.contains_duplicate_iii;

/**
 * 思路：暴力
 * 1. 时间复杂度O(n^2)，会超时
 * 2. 注意，求差的绝对值时，可能会超出整数范围，需要做处理
 *
 * @author yumingtao
 * @date 2022/1/17 09:30
 */
public class Solution1 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        for(int i = 0; i < len; ++ i){
            for (int j = i + 1; j < len; ++j){
                if(j - i <= k && Math.abs(nums[j] - nums[i]) <= t){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Math.abs(2147483647 * 1.0 - (-2147483648)));
    }
}

