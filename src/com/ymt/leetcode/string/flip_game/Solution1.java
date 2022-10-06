package com.ymt.leetcode.string.flip_game;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-06 11:52
 */
public class Solution1 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        char[] chs = currentState.toCharArray();
        for (int i = 1; i < currentState.length(); ++i) {
            if (chs[i - 1] == '+' && chs[i] == '+') {
                chs[i - 1] = '-';
                chs[i] = '-';
                ans.add(new String(chs));
                chs[i] = '+';
                chs[i - 1] = '+';
            }
        }
        return ans;
    }
}
