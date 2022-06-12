package com.ymt.leetcode.two_pointers.minimum_number_of_k_consecutive_bit_flips;

/**
 * 思路：反正最后计算都是要取模之后来判断和当前元素的关系，索性将Solution3放到模2的情况下，可以提高一些性能
 *
 * @author yumingtao
 * @date 2021/12/31 14:52
 */
public class Solution4 {
    public int minKBitFlips(int[] nums, int k) {
        int len = nums.length;
        int[] diff = new int[len + 1];
        //当前位置翻转的次数
        int revertCount = 0;
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            //此处相当于对diff差分数组求前缀和的优化
            revertCount ^= diff[i];
            System.out.println("revertCount:" + revertCount);
            //相等的两个数异或才会是0，revertCount^nums[i]==0
            if (revertCount == nums[i]) {
                //剩下的长度无法完成一次翻转
                if (i + k > len) {
                    return -1;
                }
                revertCount ^= 1;
                diff[i + k] ^= 1;
                ++ans;
            }
        }
        return ans;
    }
}
