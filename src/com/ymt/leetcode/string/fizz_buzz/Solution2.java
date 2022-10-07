package com.ymt.leetcode.string.fizz_buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-07 11:59
 */
public class Solution2 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
