package com.ymt.leetcode.string.student_attendance_record_i;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-16 15:16
 */
public class Solution2 {
    public boolean checkRecord(String s) {
        char[] chs = s.toCharArray();
        int countA = 0;
        int countL = 0;
        for (char c : chs) {
            if (c == 'A') {
                ++countA;
                if (countA > 1) {
                    return false;
                }
            }
            if (c == 'L') {
                ++countL;
                if (countL >= 3) {
                    return false;
                }
            } else {
                countL = 0;
            }
        }
        return true;
    }
}
