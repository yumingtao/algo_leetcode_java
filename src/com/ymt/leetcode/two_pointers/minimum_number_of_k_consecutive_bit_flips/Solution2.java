package com.ymt.leetcode.two_pointers.minimum_number_of_k_consecutive_bit_flips;

/**
 * 思路：
 * 1. 基于贪心，遇到0都把后边k-1个元素翻转
 * 2. A[i]翻转偶数次还是A[i]，翻转奇数次是A[i]^1
 * 3. i当前的状态和前边k-1个元素翻转的次数奇偶性有关
 *
 * @author yumingtao
 * @date 2021/12/29 15:18
 */
public class Solution2 {
    public int minKBitFlips(int[] nums, int k) {


    }
}
