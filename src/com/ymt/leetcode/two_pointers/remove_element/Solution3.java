package com.ymt.leetcode.two_pointers.remove_element;

/**
 * 思路：朴素解法
 *
 * @author yumingtao
 * @date 2021/11/12 16:50
 */
public class Solution3 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int num : nums){
            if(num != val){
                nums[i++] = num;
            }
        }
        return i;
    }
}
