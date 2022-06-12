package com.ymt.leetcode.pre_sum.sum_of_all_odd_length_subarrays;

/**
 * 思路：参考官方题解-前缀和优化掉最内层的遍历求和，时间复杂度O(n^2)
 * 1.子数组下标范围[start, end], 0<=start<end<n(数组长度)
 * 2.子数组长度length=end-start+1
 * 3.length是奇数，满足奇数步长1，3，5....
 *
 * @author yumingtao
 * @date 2021/10/29 11:24
 */
public class Solution3 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        //计算前缀和
        int[] pSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pSum[i] = pSum[i - 1] + arr[i - 1];
        }

        int sum = 0;
        for (int start = 0; start < n; start++) {
            //length长度满足奇数步长，length可以是整个数组的长度，所以length+start<=n
            for (int length = 1; length + start <= n; length += 2) {
                //length=end-start+1 -> end=length+start-1
                int end = length + start - 1;

                //计算[start,end]范围的sum,注意start从0开始，区间和pSum[end+1]-pSum[start]
                sum += pSum[end + 1] - pSum[start];
            }
        }
        return sum;
    }
}
