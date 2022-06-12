package com.ymt.leetcode.two_pointers.sorted_merge_lcci;

/**
 * @Description
 * @author yumingtao
 * @date 2022-04-01 21:23
 */
public class Solution1 {
    public void merge(int[] A, int m, int[] B, int n) {
        int pA = m - 1;
        int pB = n - 1;
        int index = m + n - 1;
        while (pA >= 0 && pB >= 0) {
            if (A[pA] >= B[pB]) {
                A[index--] = A[pA--];
            } else {
                A[index--] = B[pB--];
            }
        }
        while (pA >= 0) {
            A[index--] = A[pA--];
        }
        while (pB >= 0) {
            A[index--] = B[pB--];
        }
    }
}
