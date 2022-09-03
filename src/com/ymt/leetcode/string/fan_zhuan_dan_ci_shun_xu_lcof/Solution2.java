package com.ymt.leetcode.string.fan_zhuan_dan_ci_shun_xu_lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-03 12:37
 */
public class Solution2 {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            if (chs[i] == ' ') {
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(chs[i]);
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
            sb.delete(0, sb.length());
        }
        for (int i = list.size() - 1; i >= 0; --i) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        return sb.length() < 1 ? sb.toString() : sb.toString().substring(0, sb.length() - 1);
    }
}
