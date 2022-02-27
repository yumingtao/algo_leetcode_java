package com.ymt.leetcode.map_set.happy_number;

import java.util.HashSet;

/**
 * @Description 使用HashSet和递归
 * @author yumingtao
 * @date 2022-02-27 10:31
 */
public class Solution1 {
    HashSet<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (set.contains(n)) {
            //如果n在之前计算过，说明出现了循环，直接返回false
            return false;
        }
        //如果n之前没有出现过，加入到集合
        set.add(n);
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();
        int squareSum = 0;
        for (char ch : arr) {
            int x = ch - 48;
            squareSum += x * x;
        }
        if (squareSum == 1) {
            return true;
        }
        //如果平方和squareSum不等于1，递归计算squareSum
        return isHappy(squareSum);
    }
}
