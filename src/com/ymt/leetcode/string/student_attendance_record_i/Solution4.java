package com.ymt.leetcode.string.student_attendance_record_i;

/**
 * @description 题解回复
 * @author yumingtao
 * @date 2022-10-16 15:20
 */
public class Solution4 {
    public boolean checkRecord(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }
}
