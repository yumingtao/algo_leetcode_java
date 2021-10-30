package com.ymt.leetcode.array.sum_of_all_odd_length_subarrays;

/**
 * 思路：参考官方题解-暴力，时间复杂度O(n^3)
 * 1.子数组下标范围[start, end], 0<=start<end<n(数组长度)
 * 2.子数组长度length=end-start+1
 * 3.length是奇数，满足奇数步长1，3，5....
 *
 * @author yumingtao
 * @date 2021/10/29 11:08
 */
public class Solution2 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for (int start = 0; start < n; start++) {
            //length长度满足奇数步长，length可以是整个数组的长度，所以length+start<=n
            for (int length = 1; length + start <= n; length += 2) {
                //length=end-start+1 -> end=length+start-1
                int end = length + start - 1;

                //计算[start,end]范围的sum
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }
}
