package com.ymt.leetcode.string.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 讨论区题解
 * @author yumingtao
 * @date 2022-09-15 13:03
 */
public class Solution4 {
    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate("", n, n);
        return ans;
    }

    private void generate(String cur, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(cur);
            return;
        }

        if (left == right) {
            //剩余的左括号==剩余的右括号，只有放入左括号才有效
            generate(cur + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                generate(cur + "(", left - 1, right);
            }
            generate(cur + ")", left, right - 1);
        }
    }
}
