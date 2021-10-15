package com.ymt.leetcode.array.xor_queries_of_a_subarray;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author yumingtao
 * @date 2021/10/15 10:38
 */
public class Solution1 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        //预处理前缀XOR
        int[] pXOR = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pXOR[i] = pXOR[i - 1] ^ arr[i - 1];
        }

        int len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            //利用a^b^a=b的特性,区间XOR，subXOR=pXOR[i]-[j-1], j<=i
            //注意queries中下标是从0～n-1，所以pXOR下标+1
            ans[i] = pXOR[queries[i][1] + 1] ^ pXOR[queries[i][0] + 1 - 1];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0^1:" + (0 ^ 1));
        System.out.println("0^3:" + (0 ^ 3));
        System.out.println("1^3:" + (1 ^ 3));
        System.out.println("1^3^4^8:" + (1 ^ 3 ^ 4 ^ 8));
        System.out.println("1^3^4^1:" + (1 ^ 3 ^ 4 ^ 1));
        System.out.println("1^3^4^8&4:" + (1 ^ 3 ^ 4 ^ 8 & 4));
        System.out.println("8^8:" + (8 ^ 8));
        System.out.println("1^3^4^8^6:" + (1 ^ 3 ^ 4 ^ 8 ^ 6));
        Solution1 solution1 = new Solution1();
        int[] ans = solution1.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
        System.out.println(Arrays.stream(ans).boxed().collect(Collectors.toList()));
    }
}
