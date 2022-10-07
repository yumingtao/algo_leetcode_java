package com.ymt.leetcode.string.fizz_buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-07 11:54
 */
public class Solution1 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (i % 15 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
