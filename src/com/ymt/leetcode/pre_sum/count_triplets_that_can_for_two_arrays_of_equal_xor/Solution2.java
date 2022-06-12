package com.ymt.leetcode.pre_sum.count_triplets_that_can_for_two_arrays_of_equal_xor;

/**
 * 思路：将pXor[i-1]=pXor[k](1<=i<k)的判断移到计算前缀xor的循环里
 * a = pXor[j-1]^pXor[i-1]
 * b = pXor[k]^pXor[j-1]
 * a=b -> pXor[j-1]^pXor[i-1]=pXor[k]^pXor[j-1]
 * pXor[i-1]=pXor[k]
 * i-1>=0 -> 1<=i<k
 *
 * @author yumingtao
 * @date 2021/10/24 16:54
 */
public class Solution2 {
    public int countTriplets(int[] arr) {
        int n = arr.length;

        //计算前缀xor
        int[] pXor = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            pXor[i] = pXor[i - 1] ^ arr[i - 1];

            for (int j = 1; j < i; j++) {
                if (pXor[j - 1] == pXor[i]) {
                    ans += i - j;
                }
            }
        }

        return ans;
    }
}
