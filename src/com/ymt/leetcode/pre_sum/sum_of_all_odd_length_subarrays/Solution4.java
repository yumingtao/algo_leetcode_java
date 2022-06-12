package com.ymt.leetcode.pre_sum.sum_of_all_odd_length_subarrays;

/**
 * 思路：参考题解
 * 1.如果arr[i]在一个奇数个元素的子数组中，那么在arr[i]左右两边元素个数奇偶性是相同的,左边[0,leftCount],右边[0,rightCount]
 * 2.如果arr[i]左右两边是奇数个元素，那么arr[i]左边奇数的个数是leftOddCount=(leftCount+1)/2，arr[i]右边奇数的个数是
 * rightOddCount=(rightOddCount+1)/2，能够组合的包含arr[i]的奇数长度数组的个数是leftOddCount*rightOddCount
 * 3.如果arr[i]左右两边是偶数个元素，那么arr[i]左边奇数的个数是leftEvenCount=(leftEvenCount)/2+1，arr[i]右边奇数的个数是
 * rightEvenCount=(rightEvenCount)/2+1，能够组合的包含arr[i]的奇数长度数组的个数是leftEvenCount*rightEvenCount
 * 4.元素arr[i]对解的贡献值为arr[i]*(leftOddCount*rightOddCount+leftEvenCount*rightEvenCount)
 *
 * @author yumingtao
 * @date 2021/10/29 13:48
 */
public class Solution4 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            //0~i-1 -> i-1-0+1=i
            int leftCount = i;
            //i+1~n-i -> n-1-(i+1)+1=n-i-1
            int rightCount = n - i - 1;
            int leftOddCount = (leftCount + 1) / 2;
            int rightOddCount = (rightCount + 1) / 2;
            int leftEvenCount = leftCount / 2 + 1;
            int rightEvenCount = rightCount / 2 + 1;

            ans += arr[i] * (leftOddCount * rightOddCount + leftEvenCount * rightEvenCount);
        }

        return ans;
    }
}
