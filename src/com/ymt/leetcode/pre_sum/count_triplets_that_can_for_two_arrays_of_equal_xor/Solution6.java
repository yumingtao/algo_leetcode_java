package com.ymt.leetcode.pre_sum.count_triplets_that_can_for_two_arrays_of_equal_xor;

/**
 * 思路：利用a==b -> a^b=0
 *
 * @author yumingtao
 * @date 2021/10/24 18:23
 */
public class Solution6 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;

        //第一冲循环遍历arr
        for (int i = 0; i < n; i++) {
            int pXor = arr[i];
            for (int k = i + 1; k < n; k++) {
                pXor ^= arr[k];
                if (pXor == 0) {
                    ans += k - i;
                }
            }
        }

        return ans;
    }
}
