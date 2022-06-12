package com.ymt.leetcode.two_pointers.fruit_into_baskets;

/**
 * 思路：滑窗
 * 1. 根据题意，就是求只包含两个元素的最长子数组长度
 *
 * @author yumingtao
 * @date 2022/1/10 09:52
 */
public class Solution1 {
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        int[] kindCount = new int[len + 1];
        int count = 0;
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < len){
            if(kindCount[fruits[right]] == 0){
                ++count;
            }
            ++kindCount[fruits[right]];
            while (count > 2){
                --kindCount[fruits[left]];
                if(kindCount[fruits[left]] == 0){
                    --count;
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
            ++right;
        }
        return ans;
    }
}
