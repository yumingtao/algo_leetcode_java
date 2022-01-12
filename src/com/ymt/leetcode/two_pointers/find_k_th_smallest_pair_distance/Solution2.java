package com.ymt.leetcode.two_pointers.find_k_th_smallest_pair_distance;

import java.util.Arrays;

/**
 * @Description 官方题解：二分+前缀和
 * 1.
 * @author yumingtao
 * @date 2022-01-12 20:00
 */
public class Solution2 {
    public int smallestDistancePair(int[] nums, int k) {
        //对数组升序排序
        Arrays.sort(nums);
        int len = nums.length;

        //以为数组已经按非递减拍好了顺序，相等的数字会连续的出现在一起，此处统计在索引i的位置时，前边有多少个数字和i位置的数字相等
        int[] equalsCount = new int[len];
        for (int i = 1; i < len; ++i) {
            if (nums[i - 1] == nums[i]) {
                equalsCount[i] = 1 + equalsCount[i - 1];
            }
        }

        int max = nums[len - 1];
        //此处为什么要用2倍？？？
        int width = 2 * max;
        //prefix[i]表示数组nums中小于等于i的个数
        int[] prefix = new int[width];
        int left = 0;
        for (int i = 0; i < width; ++i) {
            while (left < len && nums[left] <= i) {
                ++left;
            }
            prefix[i] = left - 1;
        }
        /* 关于计算距离<=mid的公式
         * 对于固定的i，满足i<j，nums[j]-nums[i]<=mid的所有nums[j]的个数应该是
         * 1. nums[j]-nums[i]<=mid -> prefix[nums[i]+mid]-prefix[nums[i]]
         *    可以这样理解，[i,j]区间，如果两个边界之差<=mid，那么这个区间上任意一个nums[k]-nums[i]都是满足条件的，求有多少个这样的数
         * 2. 由于排序后，相等的数是连续的，如果当前i有相同的数，需要知道i之后右边有多少个nums[i], 即count[i]-equalsCount[i]
         *    而索引i在向后移动过程中，假设nums[i]=nums[i+1]=nums[i+n]，那么
         *    count[i]-equalsCount[i] + count[i]-equalsCount[i+1] + ... + count[i]-equalsCount[i+n]
         *    (n+1)count[i]-(equalsCount[i]+...+equalsCount[i+n])
         *    (n+1)count[i]=(n+1)n
         *    equalsCount[i]+...+equalsCount[i+n]=(n+i+1)n/2
         *    (n+1)*n-(n+i+1)*n/2=n(n+1-i)/2
         *
         */
        //二分查找
        left = 0;
        int right = max - nums[0];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            //统计距离小于mid的所有
            int count = 0;
            for (int i = 0; i < len; ++i) {
                count += prefix[nums[i] + mid] - prefix[nums[i]] + equalsCount[i];
            }

            if (count >= k) {
                //说明mid取大了，还在小于mid的一侧
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
