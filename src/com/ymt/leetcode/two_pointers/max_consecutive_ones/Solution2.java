package com.ymt.leetcode.two_pointers.max_consecutive_ones;

/**
 * Description
 *
 * @author yumingtao
 * @date 2021/12/6 15:49
 */
public class Solution2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxLen = 0;
        for(int num : nums){
            if(num == 0){
                maxLen = Math.max(maxLen, count);
                count = 0;
                continue;
            }
            ++count;
        }
        maxLen = Math.max(maxLen, count);
        return maxLen;
    }
}
