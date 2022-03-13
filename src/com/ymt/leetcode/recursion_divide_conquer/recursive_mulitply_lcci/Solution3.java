package com.ymt.leetcode.recursion_divide_conquer.recursive_mulitply_lcci;

/**
 * @Description 移位运算加递归
 * @author yumingtao
 * @date 2022-03-13 15:50
 */
public class Solution3 {
    public int multiply(int A, int B) {
        int a = A > 0 ? A : -A;
        int b = B > 0 ? B : -B;
        int ans = absMultiply(a, b);
        if ((A ^ B) < 0) {
            return -ans;
        }
        return ans;
    }

    private int absMultiply(int a, int b) {
        if (a < b) {
            return absMultiply(b, a);
        }
        if (b == 1) {
            return a;
        }
        if ((b & 1) == 0) {
            return absMultiply(a, b >> 1) << 1;
        }
        return (absMultiply(a, b >> 1) << 1) + a;
    }
}
