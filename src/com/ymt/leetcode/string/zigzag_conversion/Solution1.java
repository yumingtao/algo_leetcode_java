package com.ymt.leetcode.string.zigzag_conversion;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-04 17:07
 */
public class Solution1 {
    public String convert(String s, int numRows) {
        int len = s.length();
        //当numRows为1或numRows是s长度整数倍的时候直接返回
        if (numRows == 1 || numRows % len == 0) {
            return s;
        }
        //定义一个二维数组，行数是numRows，列数最大不会超过len/2+1(当numRows=2时)
        int m = len / 2 + 1;
        char[][] arr = new char[numRows][m];
        char[] chs = s.toCharArray();
        int col = 0;
        int index = 0;
        //将字符填入到对应的位置
        while (index < len) {
            //按列处理
            for (int j = 0; j < numRows; ++j) {
                if (index < len) {
                    arr[j][col] = chs[index++];
                }
            }
            if (index >= len) {
                break;
            }
            ++col;
            //按行处理
            for (int k = numRows - 2; k > 0; --k) {
                if (index < len) {
                    arr[k][col++] = chs[index++];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < m; ++j) {
                if (arr[i][j] != '\u0000') {
                    sb.append(arr[i][j]);
                }
            }
            if (sb.length() == len) {
                break;
            }
        }
        return sb.toString();
    }
}
