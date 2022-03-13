package com.ymt.leetcode.recursion_divide_conquer.bu_yong_jia_jian_cheng_chu_zuo_jia_fa_lcof;

/**
 * @Description 使用递归
 * 1. 异或运算：相同为0，不同为1
 * 2. 与运算：都为1时才为1，否则为0
 * 3. 将问题转换为：非进位和+进位和，其中非进位和与"异或运算"相同，进位和与"与运算后再左移一位"相同
 * @author yumingtao
 * @date 2022-03-13 12:28
 */
public class Solution1 {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a ^ b, a & b << 1);
    }
}
