package com.ymt.leetcode.string.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 参考题解1
 * @author yumingtao
 * @date 2022-09-14 16:59
 */
public class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] chs = new char[2 * n];
        generateAll(chs, 0, ans);
        return ans;
    }

    private void generateAll(char[] chs, int pos, List<String> ans) {
        if (pos == chs.length) {
            if (isValid(chs)) {
                ans.add(new String(chs));
            }
        } else {
            chs[pos] = '(';
            generateAll(chs, pos + 1, ans);
            chs[pos] = ')';
            generateAll(chs, pos + 1, ans);
        }
    }

    private boolean isValid(char[] chs) {
        int balance = 0;
        for (char ch : chs) {
            if (ch == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
