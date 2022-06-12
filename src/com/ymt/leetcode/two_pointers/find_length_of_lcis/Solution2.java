package com.ymt.leetcode.two_pointers.find_length_of_lcis;

/**
 * @author yumingtao
 * @date 2021/11/15 10:09
 */
public class Solution2 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int slow = 0;
        int fast = 1;
        int ans = 0;
        while (fast < nums.length) {
            if (nums[fast - 1] >= nums[fast]) {
                slow = fast;
            }
            fast++;
            ans = Math.max(ans, fast - slow);
        }
        return ans;
    }
}
