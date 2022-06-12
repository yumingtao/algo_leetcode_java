package com.ymt.leetcode.pre_sum.find_pivot_index;

/**
 * @author yumingtao
 * @date 2021/9/18 11:06
 */
public class Solution2 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        //先计算前缀和数组
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        //数组元素i左侧和lSum，右侧和rSum=total-nums[i]-lSum
        //lSum = total-nums[i]-lSum => 2*lSum = total - nums[i] => 2*sum[i - 1] = sum[n] - nums[i]
        //注意i从1开始,获取nums时要-1
        for (int i = 1; i <= n; i++) {
            if (2 * sum[i - 1] == sum[n] - nums[i - 1]) {
                return i - 1;
            }
        }

        return -1;
    }
}
