package com.ymt.leetcode.string.positions_of_large_groups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2022-11-05 16:21
 */
public class Solution1 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length();
        int start = 0;
        int end = 0;
        while (end < n) {
            while (end < n && s.charAt(end) == s.charAt(start)) {
                ++end;
            }
            if (end - start >= 3) {
                ans.add(Arrays.asList(start, end - 1));
            }
            start = end;
        }
        return ans;
    }
}
