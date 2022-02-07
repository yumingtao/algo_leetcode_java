package com.ymt.leetcode.two_pointers.backspace_string_compare;

/**
 * 思路：Solution3重构
 *
 * @author yumingtao
 * @date 2022/2/7 15:49
 */
public class Solution4 {
    public boolean backspaceCompare(String s, String t) {
        int sRight = s.length() - 1;
        int tRight = t.length() - 1;

        while (sRight >= 0 || tRight >= 0) {
            sRight = getValidIndex(sRight, s);
            tRight = getValidIndex(tRight, t);
            if (sRight >= 0 && tRight >= 0) {
                if (s.charAt(sRight) != t.charAt(tRight)) {
                    return false;
                }
            } else {
                //一个遍历完，另一个还没有遍历完，肯定不相当，直接返回false
                if (sRight >= 0 || tRight >= 0) {
                    return false;
                }
            }
            --sRight;
            --tRight;
        }
        return true;
    }

    private int getValidIndex(int current, String str){
        int backspaceCount = 0;
        while (current >= 0) {
            if (str.charAt(current) == '#') {
                --current;
                ++backspaceCount;
            } else {
                if (backspaceCount > 0) {
                    --current;
                    --backspaceCount;
                } else {
                    return current;
                }
            }
        }
        return current;
    }
}
