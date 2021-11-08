package com.ymt.leetcode.pre_sum.find_pivot_index;

/**
 * @author yumingtao
 * @date 2021/9/18 11:30
 */
public class Solution4 {
    public int pivotIndex(int[] nums) {
        //每次比较前i项和lSum与后n-i项和rSum是否相等，即lSum==rSum，注意lSum、rSum都包含nums[i]

        //rSum初始是数组元素之和
        int rSum = 0;
        for (int n : nums) {
            rSum += n;
        }

        int lSum = 0;
        for (int i = 0; i < nums.length; i++) {
            lSum += nums[i];
            if (lSum == rSum) {
                return i;
            }

            //注意，下标移动时，要减去当前nums
            rSum -= nums[i];
        }

        return -1;
    }
}
