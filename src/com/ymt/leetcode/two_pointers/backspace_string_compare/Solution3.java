package com.ymt.leetcode.two_pointers.backspace_string_compare;

/**
 * 思路：使用双指针
 *
 * @author yumingtao
 * @date 2022/2/7 17:39
 */
public class Solution3 {
    public boolean backspaceCompare(String s, String t) {
        int sRight = s.length() - 1;
        int sBackspaceCount = 0;
        int tRight = t.length() - 1;
        int tBackspaceCount = 0;

        while (sRight >= 0 || tRight >= 0) {
            while (sRight >= 0) {
                if (s.charAt(sRight) == '#') {
                    --sRight;
                    ++sBackspaceCount;
                } else {
                    if (sBackspaceCount > 0) {
                        --sRight;
                        --sBackspaceCount;
                    } else {
                        break;
                    }
                }
            }

            while (tRight >= 0) {
                if (t.charAt(tRight) == '#') {
                    --tRight;
                    ++tBackspaceCount;
                } else {
                    if (tBackspaceCount > 0) {
                        --tRight;
                        --tBackspaceCount;
                    } else {
                        break;
                    }
                }
            }

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
}
