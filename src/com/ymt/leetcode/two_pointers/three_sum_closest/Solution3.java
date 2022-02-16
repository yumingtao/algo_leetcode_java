package com.ymt.leetcode.two_pointers.three_sum_closest;

import java.util.Arrays;

/**
 *
 *
 * @author yumingtao
 * @date 2022/2/16 10:00
 */
public class Solution3 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 1000000000;
        for (int i = 0; i < n; ++i){
            int j = i + 1;
            int k = n - 1;
            while (j < k){
                int sum = nums[i]+nums[j]+nums[k];
                ans = Math.abs(sum - target) > Math.abs(ans - target) ? ans : sum;
                if(sum > target){
                    --k;
                }else if(sum < target){
                    ++j;
                }else {
                    return sum;
                }
            }
        }
        return ans;
    }
}
