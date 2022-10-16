package com.ymt.leetcode.string.student_attendance_record_i;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-16 15:10
 */
public class Solution1 {
    public boolean checkRecord(String s) {
        char[] chs = s.toCharArray();
        int countA = 0;
        for (char c : chs) {
            if (c == 'A') {
                ++countA;
            }
        }
        return countA < 2 && !s.contains("LLL");
    }
}
