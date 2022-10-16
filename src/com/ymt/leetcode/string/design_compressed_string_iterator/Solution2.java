package com.ymt.leetcode.string.design_compressed_string_iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description Solution1简单修改
 * @author yumingtao
 * @date 2022-10-16 17:24
 */
public class Solution2 {
    private final List<Character> letters;
    private final List<Integer> letterCount;
    private int index;
    private int indexCount;

    public Solution2(String compressedString) {
        index = 0;
        letters = new ArrayList();
        letterCount = new ArrayList();
        int len = compressedString.length();
        int i = 0;
        while (i < len) {
            char c = compressedString.charAt(i);
            letters.add(c);
            //处理字符出现的次数
            ++i;
            int start = i;
            while (i < len && Character.isDigit(compressedString.charAt(i))) {
                ++i;
            }
            String count = compressedString.substring(start, Math.min(i, len));
            letterCount.add(Integer.valueOf(count));
        }
        indexCount = letterCount.get(index);
    }

    public char next() {
        if (index >= letters.size()) {
            return ' ';
        }
        char c = letters.get(index);
        --indexCount;
        if (indexCount == 0) {
            ++index;
            if (index < letters.size()) {
                indexCount = letterCount.get(index);
            }
        }
        return c;
    }

    public boolean hasNext() {
        return index < letters.size();
    }
}
