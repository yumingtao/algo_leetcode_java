package com.ymt.leetcode.two_pointers.find_length_of_lcis;

/**
 * @author yumingtao
 * @date 2021/11/15 10:08
 */
public class Solution1 {
    public int findLengthOfLCIS(int[] nums) {
        int slow = 0;
        int fast = 0;
        int ans = 0;
        while (fast < nums.length) {
            if (fast > 0 && nums[fast - 1] >= nums[fast]) {
                slow = fast;
            }
            fast++;
            ans = Math.max(ans, fast - slow);
        }
        return ans;
    }
}
