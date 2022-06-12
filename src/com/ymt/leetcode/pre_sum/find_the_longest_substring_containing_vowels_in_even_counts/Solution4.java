package com.ymt.leetcode.pre_sum.find_the_longest_substring_containing_vowels_in_even_counts;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：
 * 1.分别用二进制表示元音字母，其中0表示偶数，1表示奇数
 * 'a' - 00001
 * 'b' - 00010
 * 'c' - 00100
 * 'd' - 01000
 * 'e' - 10000
 * 2.利用^运算符相同为0，不同为1的特性，是当前状态和当前字母^操作得到最新状态
 * 3.将最新状态二进制转换为10进制做为数组索引
 * 4.一共是5个元音字母，一共有2^5个组合，所以数组的长度是2^5=32
 *
 * @author yumingtao
 * @date 2021/10/15 16:02
 */
public class Solution4 {
    private static final Map<Character, Integer> vowelsIntMapping = new HashMap<Character, Integer>() {{
        put('a', 1);  //00001
        put('e', 2);  //00010
        put('i', 4);  //00100
        put('o', 8);  //01000
        put('u', 16); //10000
    }};

    public int findTheLongestSubstring(String s) {
        //默认值是0，此时字符串中不包含元音字母
        int ans = 0;
        //当前元音字母的个数都是0个，默认初始状态是00000
        int currentStatus = 0;
        //定义长度32的数组，存储每种状态的初始索引
        int[] statusIndex = new int[32];
        for (int i = 1; i < 32; i++) {
            statusIndex[i] = Integer.MIN_VALUE;
        }
        //初始时所有元音字母都是0，此时索引为-1
        statusIndex[0] = -1;

        for (int i = 0; i < s.length(); i++) {
            int vowels = vowelsIntMapping.getOrDefault(s.charAt(i), -1);
            if (vowels != -1) {
                //如果是元音字母，当前状态和元音字母^操作，得到最新状态
                currentStatus ^= vowels;
                //如果当前索引没有在数组中出现过，更新
                if (statusIndex[currentStatus] == Integer.MIN_VALUE) {
                    statusIndex[currentStatus] = i;
                }
            }

            //如果出现过，计算并更新ans
            ans = Math.max(ans, i - statusIndex[currentStatus]);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        //String s = "leetcodeisgreat";
        //String s = "bcbcbc";
        Solution4 solution4 = new Solution4();
        int ans = solution4.findTheLongestSubstring(s);
        System.out.println(ans);
    }
}

