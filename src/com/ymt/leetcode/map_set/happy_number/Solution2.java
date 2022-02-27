package com.ymt.leetcode.map_set.happy_number;

import java.util.HashSet;

/**
 * @Description 题解理解
 * @author yumingtao
 * @date 2022-02-27 10:42
 */
public class Solution2 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    private int getNext(int n) {
        int squareSum = 0;
        while (n != 0) {
            int d = n % 10;
            n = n / 10;
            squareSum += d * d;
        }
        return squareSum;
    }
}
