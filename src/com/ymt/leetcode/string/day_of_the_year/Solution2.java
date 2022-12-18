package com.ymt.leetcode.string.day_of_the_year;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-12-18 18:22
 */
public class Solution2 {
    public int dayOfYear(String date) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] s = date.split("-");
        int year = Integer.parseInt(s[0]);
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            days[1] += 1;
        }
        int month = Integer.parseInt(s[1]);
        int ans = Integer.parseInt(s[2]);
        for (int i = 0; i < month - 1; ++i) {
            ans += days[i];
        }
        return ans;
    }
}
