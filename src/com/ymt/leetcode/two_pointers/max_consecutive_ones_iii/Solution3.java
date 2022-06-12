package com.ymt.leetcode.two_pointers.max_consecutive_ones_iii;

/**
 * 思路：滑动窗口+前缀和变化
 * 1. 将0转换成1，将1转换成0，变相求区间和<=k的最大区间长度
 * 2. rSum-lSum<=k
 *
 * @author yumingtao
 * @date 2021/12/15 09:43
 */
public class Solution3 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int lSum = 0;
        int rSum = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            //将0转换成1，将1转换成0，求和
            rSum += 1 - nums[right];
            if (rSum - lSum <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                //收缩left
                while(nums[left] == 1){
                    ++left;
                }
                //找到left指向0的位置，更新lSum
                lSum += 1 - nums[left];
                //left移动到0后的位置
                ++left;
            }
        }
        return maxLen;
    }
}
