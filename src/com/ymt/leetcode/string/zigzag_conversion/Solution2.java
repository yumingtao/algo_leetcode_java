package com.ymt.leetcode.string.zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-04 17:38
 */
public class Solution2 {
    public String convert(String s, int numRows) {
        int len = s.length();
        //当numRows为1或numRows是s长度整数倍的时候直接返回
        if (numRows == 1 || numRows % len == 0) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            list.add(new StringBuilder());
        }
        int flag = -1;
        char[] chs = s.toCharArray();
        int index = 0;
        for (char ch : chs) {
            list.get(index).append(ch);
            if (index == numRows - 1 || index == 0) {
                flag = -flag;
            }
            index += flag;
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(ls -> sb.append(ls));
        return sb.toString();
    }
}
