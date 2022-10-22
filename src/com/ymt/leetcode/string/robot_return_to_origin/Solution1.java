package com.ymt.leetcode.string.robot_return_to_origin;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-22 12:44
 */
public class Solution1 {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        char[] steps = moves.toCharArray();
        for (char c : steps) {
            switch (c) {
                case 'L':
                    --x;
                    break;
                case 'R':
                    ++x;
                    break;
                case 'U':
                    ++y;
                    break;
                case 'D':
                    --y;
                    break;
                default:
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
