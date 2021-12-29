package com.ymt.leetcode.two_pointers.minimum_number_of_k_consecutive_bit_flips;

/**
 * 思路：暴力解法，遇到0就翻转后边的k个数字，超出时间限制
 *
 * @author yumingtao
 * @date 2021/12/29 10:38
 */
public class Solution1 {
    public int minKBitFlips(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int count = 0;
        //len-1-left+1=k -> left=len-k
        while (left <= len - k) {
            if(nums[left] > 0){
                ++left;
                continue;
            }
            //开始翻转left后边的k个数字
            right = left;
            while (right < left + k) {
                nums[right] ^= 1;
                ++right;
            }
            if (right > len) {
                return -1;
            }
            ++count;
            //开始下一轮翻转
        }

        for(int i = left; i < len; ++i){
            if(nums[i] == 0){
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 0, 1, 1, 0};
        int k = 3;
        /*int[] nums = {1,1,0};
        int k = 2;*/
        /*int[] nums = {1,1};
        int k = 1;*/
        Solution1 solution1 = new Solution1();
        int count = solution1.minKBitFlips(nums, k);
        System.out.println("count:" + count);
    }
}
