package com.ymt.leetcode.string.read_n_characters_given_read4;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-09-16 15:35
 */
public class Solution2 {
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int size = read4(temp);
        int ans = 0;
        while (size > 0 && ans < n) {
            for (int i = 0; i < size && ans < n; i++) {
                buf[ans++] = temp[i];
            }
            size = read4(temp);
        }

        return ans;
    }

    /**
     * 只为编译能过
     * @param buf
     * @return
     */
    private int read4(char[] buf) {
        return 0;
    }
}
