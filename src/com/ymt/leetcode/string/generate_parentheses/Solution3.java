package com.ymt.leetcode.string.generate_parentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description 参考回复题解
 * 0(1)2(3)4
 * 将()插入到0，1，2，3，4的位置，并去重
 * @author yumingtao
 * @date 2022-09-15 12:48
 */
public class Solution3 {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }

        Set<String> set = new HashSet<>();
        for (String s : generateParenthesis(n - 1)) {
            for (int i = 0; i <= s.length() / 2; ++i) {
                set.add(s.substring(0, i) + "()" + s.substring(i));
            }
        }
        return new ArrayList<>(set);
    }
}
