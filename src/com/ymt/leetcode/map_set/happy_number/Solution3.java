package com.ymt.leetcode.map_set.happy_number;

/**
 * @Description 快慢指针
 * @author yumingtao
 * @date 2022-02-27 11:03
 */
public class Solution3 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
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
