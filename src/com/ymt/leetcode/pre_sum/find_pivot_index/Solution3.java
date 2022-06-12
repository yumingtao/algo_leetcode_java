package com.ymt.leetcode.pre_sum.find_pivot_index;

/**
 * @author yumingtao
 * @date 2021/9/18 11:14
 */
public class Solution3 {
    public int pivotIndex(int[] nums) {
        //int total = Arrays.stream(nums).sum();
        int total = 0;
        for(int n : nums){
            total += n;
        }

        //数组元素i左侧和lSum，右侧和rSum=total-nums[i]-lSum
        //lSum = total-nums[i]-lSum => 2*lSum = total - nums[i] => 2*sum[i - 1] = sum[n] - nums[i]
        //注意i从1开始,获取nums时要-1
        //因为只用到了sum[i-1]，所以不需要使用前缀和数组，直接用变量preSum
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * preSum == total - nums[i]) {
                return i;
            }
            preSum += nums[i];
        }

        return -1;
    }
}
