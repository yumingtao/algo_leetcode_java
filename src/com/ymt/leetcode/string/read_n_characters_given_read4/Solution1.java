package com.ymt.leetcode.string.read_n_characters_given_read4;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-16 15:33
 */
public class Solution1 {
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int count = n / 4;
        int mod = n % 4;
        int ans = 0;
        while (count > 0) {
            int size = read4(temp);
            for (int i = 0; i < size; i++) {
                buf[ans++] = temp[i];
            }
            --count;
        }

        if (mod > 0) {
            int size = read4(temp);
            int l = mod > size ? size : mod;
            for (int i = 0; i < l; i++) {
                buf[ans++] = temp[i];
            }
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
