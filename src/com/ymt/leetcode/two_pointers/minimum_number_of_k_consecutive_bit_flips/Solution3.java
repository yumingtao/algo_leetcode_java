package com.ymt.leetcode.two_pointers.minimum_number_of_k_consecutive_bit_flips;

/**
 * 思路：差分数组
 * 1. 对一个区间做翻转，利用差分的思想，[l,r]多次操作产生的影响是diff[l]+1,diff[r]-1
 *
 * @author yumingtao
 * @date 2021/12/30 16:19
 */
public class Solution3 {
    public int minKBitFlips(int[] nums, int k) {
        int len = nums.length;
        int[] diff = new int[len + 1];
        //当前位置翻转的次数
        int revertCount = 0;
        int ans =0;
        for(int i = 0; i < len; ++i){
            revertCount += diff[i];
        }
    }
}
