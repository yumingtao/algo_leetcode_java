package com.ymt.leetcode.recursion_divide_conquer.powx_n;

/**
 * @Description 采用递推
 *
 * @author yumingtao
 * @date 2022-03-11 20:09
 */
public class Solution1 {
    public double myPow(double x, int n) {
        //需要使用long，否则-2147483648在取绝对值的时候会超出int范围
        long times = Math.abs((long) n);
        double ans = 1;
        while (times > 0) {
            if (times % 2 == 1) {
                //如果二进制表示的最低位是1，将x和ans相乘
                ans *= x;
            }
            //不断的对x进行平方
            x *= x;
            //舍弃当前times的最低位
            times /= 2;
        }
        return n > 0 ? ans : 1 / ans;
    }
}
