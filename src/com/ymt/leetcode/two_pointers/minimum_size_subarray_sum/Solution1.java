package com.ymt.leetcode.two_pointers.minimum_size_subarray_sum;

/**
 * 思路：双指针
 *
 * @author yumingtao
 * @date 2021/12/1 09:43
 */
public class Solution1 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = 1000000000;
        while (left < len) {
            while (sum < target && right < len) {
                sum += nums[right++];
            }

            if (sum >= target) {
                //更新minLen, 因为while中right加了1，此处是right-1-left+1
                minLen = Math.min(minLen, right - left);
            }

            //如果sum>=target，right继续增加肯定会大于target，得到的不是最小的minLen
            //所以left需要收缩，然后再判断新的sum和target比较
            sum -= nums[left];
        }
        return minLen == 1000000000 ? 0 : minLen;
    }
}
