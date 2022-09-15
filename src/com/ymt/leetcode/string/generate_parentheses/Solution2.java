package com.ymt.leetcode.string.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 参考题解2
 * @author yumingtao
 * @date 2022-09-15 12:22
 */
public class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(sb, 0, 0, n, ans);
        return ans;
    }

    private void generate(StringBuilder cur, int left, int right, int max, List<String> ans) {
        if (cur.length() == 2 * max) {
            ans.add(cur.toString());
            return;
        }

        if (left < max) {
            cur.append("(");
            generate(cur, left + 1, right, max, ans);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (right < left) {
            cur.append(")");
            generate(cur, left, right + 1, max, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
