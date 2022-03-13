package com.ymt.leetcode.recursion_divide_conquer.recursive_mulitply_lcci;

/**
 * @Description 利用位运算加法
 * @author yumingtao
 * @date 2022-03-13 14:42
 */
public class Solution1 {
    public int multiply(int A, int B) {
        //A*B可以看成是B个A相加
        //1. 先求|A|*|B|
        //负数可以看成是反码+1
        int a = A < 0 ? add(~A, 1) : A;
        int b = B < 0 ? add(~B, 1) : B;
        int sum = 0;
        //一共有b个a相加
        while (b > 0) {
            //sum = sum + a
            sum = add(a, sum);
            //--b
            b = add(b, -1);
        }
        //2. 判断相乘的符号
        if ((A ^ B) < 0) {
            //只考虑最高位，根据异或特性，相同为0，不同为1，如果A和B的最高位符号不同，异或后的结果是1，即是负, 否则是正
            sum = add(~sum, 1);
        }
        return sum;
    }

    private int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }
}
