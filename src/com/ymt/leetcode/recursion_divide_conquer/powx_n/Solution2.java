package com.ymt.leetcode.recursion_divide_conquer.powx_n;

/**
 * @Description 快速幂加递归
 * @author yumingtao
 * @date 2022-03-13 11:46
 */
public class Solution2 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1 / pow(x, -n);
        }
        return pow(x, n);
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double ans = pow(x, n / 2);
        if (n % 2 == 0) {
            //如果是偶数
            ans *= ans;
        } else {
            //如果n是奇数，需要多乘一个x
            ans *= ans * x;
        }
        return ans;
    }
}
