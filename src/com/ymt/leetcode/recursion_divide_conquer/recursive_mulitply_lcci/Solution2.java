package com.ymt.leetcode.recursion_divide_conquer.recursive_mulitply_lcci;

/**
 * @Description 将乘法转换成加法，使用递归
 * @author yumingtao
 * @date 2022-03-13 15:16
 */
public class Solution2 {
    public int multiply(int A, int B) {
        if (B == 0) {
            return 0;
        }
        //1. 先计算绝对值的乘积
        //乘法可以转换成加法，b个a相加，另b是A、B中较小的，减少循环的次数
        int a = A > 0 ? A : -A;
        int b = B > 0 ? B : -B;
        if (a < b) {
            int temp = b;
            b = a;
            a = temp;
        }
        int sum = a + multiply(a, b - 1);
        //2. 确定符号
        if ((A > 0 && B > 0) || (A < 0 && B < 0)) {
            return sum;
        }
        return -sum;
    }
}
