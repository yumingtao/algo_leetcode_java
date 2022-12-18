package com.ymt.leetcode.string.day_of_the_year;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @author yumingtao
 * @date 2022-12-18 18:02
 */
public class Solution1 {
    private static final Set<Integer> DAY_31_SET = new HashSet<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
    private static final Set<Integer> DAY_30_SET = new HashSet<>(Arrays.asList(4, 6, 9, 11));

    public int dayOfYear(String date) {
        String[] s = date.split("-");
        int month = Integer.parseInt(s[1]);
        int ans = Integer.parseInt(s[2]);
        for (int i = 1; i < month; ++i) {
            if (DAY_31_SET.contains(i)) {
                ans += 31;
            } else if (DAY_30_SET.contains(i)) {
                ans += 30;
            } else {
                int year = Integer.parseInt(s[0]);
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    ans += 29;
                } else {
                    ans += 28;
                }
            }
        }
        return ans;
    }
}
