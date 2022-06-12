package com.ymt.leetcode.two_pointers.minimum_number_of_k_consecutive_bit_flips;

/**
 * @Description 官方题解-滑窗
 * @author yumingtao
 * @date 2021-12-31 19:43
 */
public class Solution5 {
    public int minKBitFlips(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        int revertCount = 0;
        for (int i = 0; i < len; ++i) {
            if (i >= k && nums[i - k] > 1) {
                //说明当前的i在一i-k为起始元素的子数组发生了翻转，累积翻转的次数
                revertCount ^= 1;
                //还原数组的值
                nums[i - k] -= 2;
            }
            //相同的数字异或==0
            if (revertCount == nums[i]) {
                //超出数组范围，说明不能完成全部翻转
                if (i + k > len) {
                    return -1;
                }
                ++ans;
                nums[i] += 2;
                revertCount ^= 1;
            }
        }
        return ans;
    }
}
