package com.ymt.leetcode.string.similar_rgb_color;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-29 16:38
 */
public class Solution2 {
    public String similarRGB(String color) {
        return "#" + calulateSimilarInt(color, 1, 3) + calulateSimilarInt(color, 3, 5) + calulateSimilarInt(color, 5,
                7);
    }

    private String calulateSimilarInt(String color, int start, int end) {
        int value = Integer.parseInt(color.substring(start, end), 16);
        value = ((value / 17) + (value % 17 > 8 ? 1 : 0)) * 17;
        return String.format("%02x", value);
    }
}
