package com.ymt.leetcode.recursion_divide_conquer.maximum_subarray;

/**
 * @Description 采用分治的思想
 * @author yumingtao
 * @date 2022-04-04 14:00
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        return getMax(nums, 0, nums.length - 1).maxSum;
    }

    private SumStatus getMax(int[] nums, int left, int right) {
        //递归终止条件
        if (left == right) {
            return new SumStatus(nums[left], nums[left], nums[left], nums[left]);
        }

        int mid = (left + right) / 2;
        SumStatus lSumStatus = getMax(nums, left, mid);
        SumStatus rSumStatus = getMax(nums, mid + 1, right);
        return mergeCalculate(lSumStatus, rSumStatus);
    }

    private SumStatus mergeCalculate(SumStatus lSumStatus, SumStatus rSumStatus) {
        //[l,r]区间和等于[l,mid]的区间和+[mid+1,r]的区间和
        int sum = lSumStatus.sum + rSumStatus.sum;
        //以l为端点的最大值, 要么等于区间[l,mid]的以l为端点最大值; 要么是跨mid，等于左区间的区间和+右区间[mid+1,r]上1以l(mid+1)为端点的最大值
        int lMaxSum = Math.max(lSumStatus.lMaxSum, lSumStatus.sum + rSumStatus.lMaxSum);
        //以r为端点的最大值, 要么等于区间[mid+1,r]的以r为端点最大值; 要么是跨mid，等于右区间的区间和+左区间[l,mid]上1以r(mid)为端点的最大值
        int rMaxSum = Math.max(rSumStatus.rMaxSum, rSumStatus.sum + lSumStatus.rMaxSum);
        //[l,r]区间的最大值
        //如果不跨区间，可能是区间[l,mid]的最大值maxSum；也可能是区间[mid+1,r]的最大值maxSum
        //如果跨区间，可能是区间[l,mid]的rMaxSum + 区间[mid+1,r]的lMaxSum
        int maxSum = Math.max(Math.max(lSumStatus.maxSum, rSumStatus.maxSum), lSumStatus.rMaxSum + rSumStatus.lMaxSum);
        return new SumStatus(lMaxSum, rMaxSum, maxSum, sum);
    }

    class SumStatus {
        //区间[l,r]
        //以l为左端点的最大子段和
        public int lMaxSum;
        //以r为右端点的最大子段和
        public int rMaxSum;
        //[l,r]区间最大子段和
        public int maxSum;
        //[l,r]的区间和
        public int sum;

        public SumStatus(int lMaxSum, int rMaxSum, int maxSum, int sum) {
            this.lMaxSum = lMaxSum;
            this.rMaxSum = rMaxSum;
            this.maxSum = maxSum;
            this.sum = sum;
        }
    }
}
