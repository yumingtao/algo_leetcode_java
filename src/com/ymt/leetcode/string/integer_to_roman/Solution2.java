package com.ymt.leetcode.string.integer_to_roman;

/**
 * @description 参考题解方法
 * @author yumingtao
 * @date 2022-09-14 14:19
 */
public class Solution2 {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            while (num >= values[i]) {
                num -= values[i];
                ans.append(roman[i]);
            }
            if (num == 0) {
                break;
            }
        }
        return ans.toString();
    }
}
