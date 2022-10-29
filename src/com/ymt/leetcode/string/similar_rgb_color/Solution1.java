package com.ymt.leetcode.string.similar_rgb_color;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-29 16:33
 */
public class Solution1 {
    private final String HEX_CHARS = "0123456789abcdef";

    public String similarRGB(String color) {
        int a = calulateSimilarInt(color, 1, 3);
        int b = calulateSimilarInt(color, 3, 5);
        int c = calulateSimilarInt(color, 5, 7);
        StringBuilder ans = new StringBuilder("#");
        return ans.append(convertIntToHex(a)).append(convertIntToHex(b)).append(convertIntToHex(c)).toString();
    }

    private int calulateSimilarInt(String color, int start, int end) {
        int value = convertHexToInt(color.substring(start, end));
        value = ((value / 17) + (value % 17 > 8 ? 1 : 0)) * 17;
        return value;
    }

    private int convertHexToInt(String hexString) {
        int low = HEX_CHARS.indexOf(hexString.substring(1, 2));
        int high = HEX_CHARS.indexOf(hexString.substring(0, 1));
        return low + high * 16;
    }

    private String convertIntToHex(int value) {
        int low = value % 16;
        int high = value / 16;
        StringBuilder sb = new StringBuilder();
        return sb.append(HEX_CHARS.charAt(high)).append(HEX_CHARS.charAt(low)).toString();
    }
}
